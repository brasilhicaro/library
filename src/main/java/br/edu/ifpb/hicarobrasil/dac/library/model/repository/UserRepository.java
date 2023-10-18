package br.edu.ifpb.hicarobrasil.dac.library.model.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Repository;

import br.edu.ifpb.hicarobrasil.dac.library.model.entity.User;

@Repository
public interface UserRepository extends JpaRepository<User, String>{
    UserDetails findByLogin(String login);

    User findByUsername(String username);
}
