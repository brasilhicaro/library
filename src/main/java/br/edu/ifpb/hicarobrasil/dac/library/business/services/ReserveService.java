package br.edu.ifpb.hicarobrasil.dac.library.business.services;

import java.util.List;

import org.springframework.stereotype.Service;

import br.edu.ifpb.hicarobrasil.dac.library.business.dto.ReserveDTO;

@Service
public interface ReserveService {
    
    public ReserveDTO save(ReserveDTO reserveDTO);
    public ReserveDTO update(ReserveDTO reserveDTO, Long id);
    public ReserveDTO delete(ReserveDTO reserveDTO);
    public ReserveDTO deleteById(Long id);
    public ReserveDTO findByID(Long id);
    public List<ReserveDTO> list();
}
