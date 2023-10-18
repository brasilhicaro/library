package br.edu.ifpb.hicarobrasil.dac.library.business.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import br.edu.ifpb.hicarobrasil.dac.library.business.dto.UserDTO;
import br.edu.ifpb.hicarobrasil.dac.library.business.services.ConvertService;
import br.edu.ifpb.hicarobrasil.dac.library.business.services.UserService;
import br.edu.ifpb.hicarobrasil.dac.library.model.entity.User;
import br.edu.ifpb.hicarobrasil.dac.library.model.repository.UserRepository;

@Service
public class UserServiceImpl implements UserService, UserDetailsService{

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private ConvertService convertService;

    @Override
    public UserDTO create(UserDTO userDTO) {
        return convertService.convertToUserDTO(userRepository.save(
            convertService.convertToUser(userDTO)));
    }

    @Override
    public UserDTO update(UserDTO userDTO) {
        return convertService.convertToUserDTO(userRepository.save(
            convertService.convertToUser(userDTO)));
    }

    @Override
    public UserDTO delete(UserDTO userDTO) {
        User user = convertService.convertToUser(findByID(userDTO.id()));
        userRepository.delete(user);
        return userDTO;
    }    

    @Override
    public List<UserDTO> list() {
        return convertService.convertoUserDTOList(userRepository.findAll());
    }

    @Override
    public UserDTO findByID(String id) {
        return convertService.convertToUserDTO(userRepository.findById(id).get());
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        try {
            User user = userRepository.findByUsername(username);
            return user;
        } catch (Exception e) {
            throw new UsernameNotFoundException("User not found");
        }
    }
    
}
