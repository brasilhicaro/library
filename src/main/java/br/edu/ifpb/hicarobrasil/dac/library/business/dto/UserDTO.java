package br.edu.ifpb.hicarobrasil.dac.library.business.dto;

import br.edu.ifpb.hicarobrasil.dac.library.model.entity.UserRoleEnum;

public record UserDTO(String id, String name, String email, String login, String password, UserRoleEnum role) {

}