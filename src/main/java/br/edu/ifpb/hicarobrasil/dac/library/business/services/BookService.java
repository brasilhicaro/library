package br.edu.ifpb.hicarobrasil.dac.library.business.services;

import java.util.List;

import org.springframework.stereotype.Service;

import br.edu.ifpb.hicarobrasil.dac.library.business.dto.BookDTO;

@Service
public interface BookService {
    
    public BookDTO save(BookDTO bookDTO);
    public BookDTO update(BookDTO bookDTO, Long id);
    public BookDTO delete(BookDTO bookDTO);
    public BookDTO deleteById(Long id);
    public BookDTO findByID(Long id);
    public List<BookDTO> list();
    public List<BookDTO> findByTitle(String title);

}
