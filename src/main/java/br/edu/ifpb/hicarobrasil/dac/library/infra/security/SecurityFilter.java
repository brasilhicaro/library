package br.edu.ifpb.hicarobrasil.dac.library.infra.security;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import br.edu.ifpb.hicarobrasil.dac.library.model.repository.UserRepository;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@Component
public class SecurityFilter extends OncePerRequestFilter{

    @Autowired
    private TokenService tokenService;

    @Autowired
    private UserRepository userRepository;

    protected void doFilterInternal(HttpServletRequest httpServletRequest,
     HttpServletResponse httpServletResponse,
      FilterChain filterChain) throws ServletException, IOException{
        String token = this.recoverToken(httpServletRequest);
        if (token != null) {
            String login = tokenService.validateToken(token);
            UserDetails user = userRepository.findByLogin(login);
            
            UsernamePasswordAuthenticationToken authentication = 
            new UsernamePasswordAuthenticationToken(user, null,
             user.getAuthorities());
            SecurityContextHolder.getContext().setAuthentication(authentication);
        }
        filterChain.doFilter(httpServletRequest, httpServletResponse);
    }

    private String recoverToken(HttpServletRequest httpServletRequest) {
        String token = httpServletRequest.getHeader("Authorization");
        return (token == null || token.isEmpty() || !token.startsWith("Bearer "))? 
        null : token.replace("Bearer", "");
    }

}
