package br.edu.ifpb.hicarobrasil.dac.library.model.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.edu.ifpb.hicarobrasil.dac.library.model.entity.Reserve;

@Repository
public interface ReserveRepository extends JpaRepository<Reserve, Long>{
    
}
