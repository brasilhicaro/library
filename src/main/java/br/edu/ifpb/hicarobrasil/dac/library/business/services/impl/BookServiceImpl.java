package br.edu.ifpb.hicarobrasil.dac.library.business.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.edu.ifpb.hicarobrasil.dac.library.business.dto.BookDTO;
import br.edu.ifpb.hicarobrasil.dac.library.business.services.BookService;
import br.edu.ifpb.hicarobrasil.dac.library.business.services.ConvertService;
import br.edu.ifpb.hicarobrasil.dac.library.model.entity.Book;
import br.edu.ifpb.hicarobrasil.dac.library.model.repository.BookRepository;


@Service
public class BookServiceImpl implements BookService {

    @Autowired
    private ConvertService convertService;
    private BookRepository bookRepository;

    @Override
    public BookDTO save(BookDTO bookDTO) {
        Book book = convertService.convertToBook(bookDTO);
        return convertService.convertToBookDTO(bookRepository.save(book));
    }

    @Override
    public BookDTO update(BookDTO bookDTO, Long id) {
        Book book = bookRepository.findById(id).get();
        book.setAuthor(bookDTO.author());
        book.setTitle(bookDTO.title());
        book.setPublisher(bookDTO.publisher());
        book.setYear(bookDTO.year());
        return convertService.convertToBookDTO(bookRepository.save(book));
       
    }

    @Override
    public BookDTO delete(BookDTO bookDTO) {
        bookRepository.delete(convertService.convertToBook(bookDTO));
        return bookDTO;
    }

    @Override
    public BookDTO deleteById(Long id) {
        Book book = bookRepository.findById(id).get();
        bookRepository.deleteById(id);
        return convertService.convertToBookDTO(book);
    }

    @Override
    public BookDTO findByID(Long id) {
        Book book = bookRepository.findById(id).get();
        return convertService.convertToBookDTO(book);
    }

    @Override
    public List<BookDTO> list() {
        List<Book> books = bookRepository.findAll();
        return convertService.convertToBookDTOList(books);
    }
    
}
