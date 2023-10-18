package br.edu.ifpb.hicarobrasil.dac.library.presentationn.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.edu.ifpb.hicarobrasil.dac.library.business.dto.UserDTO;
import br.edu.ifpb.hicarobrasil.dac.library.business.services.UserService;

@RestController
@RequestMapping("/user")
@CrossOrigin(origins = "http://localhost:3000")
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping("/cadastrar")
    @PostMapping
    public ResponseEntity<UserDTO> create(@RequestBody UserDTO userDTO){
        try {
            UserDTO user = userService.create(userDTO);   
            return new ResponseEntity<>(user, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

    }

    @RequestMapping("/login")
    @PostMapping
    public ResponseEntity<UserDTO> login(@RequestBody UserDTO userDTO){
        try {
            UserDTO user = userService.findByID(userDTO.id());   
            return new ResponseEntity<>(user, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

}
