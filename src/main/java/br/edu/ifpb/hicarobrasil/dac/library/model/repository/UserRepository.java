package br.edu.ifpb.hicarobrasil.dac.library.model.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Repository;

import br.edu.ifpb.hicarobrasil.dac.library.model.entity.User;

@Repository
public interface UserRepository extends JpaRepository<User, String>{
    @Modifying 
	@Transactional(readOnly = false)
	@Query("SELECT u FROM users u WHERE u.login = ?1" )
    UserDetails findByLogin(String login);
    @Modifying
    @Transactional(readOnly = false)
    @Query("SELECT u FROM users u WHERE u.name = ?1" )
    UserDetails findByUsername(String name);
}
