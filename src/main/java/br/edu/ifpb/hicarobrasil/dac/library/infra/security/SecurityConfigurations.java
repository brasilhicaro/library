package br.edu.ifpb.hicarobrasil.dac.library.infra.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
@EnableWebSecurity
public class SecurityConfigurations {
    
    @Autowired
    private SecurityFilter securityFilter;

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity httpSecurity) throws Exception {
        
        return  httpSecurity
                .csrf(csrf -> csrf.disable())
                .sessionManagement(session -> session.sessionCreationPolicy(
                    SessionCreationPolicy.STATELESS))
                .authorizeHttpRequests(authorize -> authorize
                        .requestMatchers(HttpMethod.GET, "/auth/login").permitAll()
                        .requestMatchers(HttpMethod.POST, "/auth/cadastrar").permitAll()
                        .requestMatchers(HttpMethod.GET, "/book/books").permitAll()
                        .requestMatchers(HttpMethod.GET, "/book/{id}").hasRole("ADMIN")
                        .requestMatchers(HttpMethod.POST, "/book").permitAll()
                        .requestMatchers(HttpMethod.DELETE, "/book").hasRole("ADMIN")
                        .requestMatchers(HttpMethod.PUT, "/book/{id}").hasRole("ADMIN")
                        .requestMatchers(HttpMethod.POST, "/reserve").hasRole("ADMIN")
                        .requestMatchers(HttpMethod.PUT, "/reserve/{id}").hasRole("ADMIN")
                        .requestMatchers(HttpMethod.DELETE, "/reserve").hasRole("ADMIN")
                        .requestMatchers(HttpMethod.GET, "/reserve/reserves").permitAll()
                        .requestMatchers(HttpMethod.GET, "/reserve/{id}").hasRole("ADMIN")
                        .anyRequest().authenticated()
                )
                .addFilterBefore(securityFilter, UsernamePasswordAuthenticationFilter.class)
                .build();
    }

    @Bean
    public AuthenticationManager autheticationManager(AuthenticationConfiguration authenticationConfiguration) throws Exception {
        return authenticationConfiguration.getAuthenticationManager();
    }

    @Bean
    public PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }
}
