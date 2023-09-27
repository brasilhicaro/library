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
        BookDTO resultBook = convertService.convertToBookDTO(book);
        return resultBook;

    }

    @Override
    public BookDTO update(BookDTO bookDTO, Long id) {
        Book book = bookRepository.findById(id).get();
        book.setAuthor(bookDTO.author());
        book.setTitle(bookDTO.title());
        book.setPublisher(bookDTO.publisher());
        book.setYear(bookDTO.year());
        BookDTO resultBook = convertService.convertToBookDTO(bookRepository.save(book));
        return resultBook;
       
    }

    @Override
    public BookDTO delete(BookDTO bookDTO) {
        bookRepository.delete(convertService.convertToBook(bookDTO));
        return bookDTO;
    }

    @Override
    public BookDTO deleteById(Long id) {
        Book book = bookRepository.findById(id).get();
        BookDTO bookDTO = convertService.convertToBookDTO(book);
        bookRepository.deleteById(id);
        return bookDTO;
    }

    @Override
    public BookDTO findByID(Long id) {
        Book book = bookRepository.findById(id).get();
        BookDTO findBook = convertService.convertToBookDTO(book);
        return findBook;
    }

    @Override
    public List<BookDTO> list() {
        List<Book> books = bookRepository.findAll();
        List<BookDTO> bookDTOs=convertService.convertToBookDTOList(books);
        for (BookDTO bookDTO : bookDTOs) {
            System.out.println(bookDTO.toString());
        }
        return bookDTOs;
    }
    
}
