package br.edu.ifpb.hicarobrasil.dac.library.presentationn.controller;

import static org.mockito.ArgumentMatchers.refEq;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.edu.ifpb.hicarobrasil.dac.library.business.dto.AutheticationDTO;
import br.edu.ifpb.hicarobrasil.dac.library.business.dto.LoginDTO;
import br.edu.ifpb.hicarobrasil.dac.library.business.dto.UserDTO;
import br.edu.ifpb.hicarobrasil.dac.library.business.services.UserService;
import br.edu.ifpb.hicarobrasil.dac.library.infra.security.TokenService;
import br.edu.ifpb.hicarobrasil.dac.library.model.entity.User;
import jakarta.validation.Valid;

@RestController
@RequestMapping("auth")
@CrossOrigin(origins = "http://localhost:3000")
public class UserController {

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private UserService userService;

    @Autowired
    private TokenService tokenService;

    @RequestMapping("/cadastrar")
    @PostMapping
    public ResponseEntity<LoginDTO> cadastraResponseEntity(@RequestBody @Valid UserDTO userDTO){
        if(userService.findByLogin(userDTO.login())!= null)
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        String encryptedPassword = new BCryptPasswordEncoder().encode(userDTO.password());    
        UserDTO cryptUserDTO = new UserDTO(userDTO.id(),userDTO.name(), userDTO.email() ,userDTO.login(), encryptedPassword, userDTO.role());
        userService.create(cryptUserDTO);
        return new ResponseEntity<>(HttpStatus.OK);
    } 

    @RequestMapping("/login")
    @PostMapping
    public ResponseEntity<LoginDTO> login(@RequestBody @Valid AutheticationDTO userDTO){
        UsernamePasswordAuthenticationToken usernamePassword = new UsernamePasswordAuthenticationToken(userDTO.login(), userDTO.password());
        Authentication auth = authenticationManager.authenticate(usernamePassword);
        String token = tokenService.generateToken((User) auth.getPrincipal());
        
        return new ResponseEntity<>(new LoginDTO(token), HttpStatus.OK);
    }


}
