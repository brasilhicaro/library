package br.edu.ifpb.hicarobrasil.dac.library.business.services;

import java.util.List;

import org.springframework.stereotype.Service;

import br.edu.ifpb.hicarobrasil.dac.library.business.dto.UserDTO;

@Service
public interface UserService {
    public UserDTO create(UserDTO userDTO);
    public UserDTO update(UserDTO userDTO);
    public UserDTO delete(UserDTO userDTO);
    public List<UserDTO> list();
    public UserDTO findByID(String id);

}
