package br.edu.ifpb.hicarobrasil.dac.library.business.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import br.edu.ifpb.hicarobrasil.dac.library.business.dto.BookDTO;
import br.edu.ifpb.hicarobrasil.dac.library.business.dto.ReserveDTO;
import br.edu.ifpb.hicarobrasil.dac.library.model.entity.Book;
import br.edu.ifpb.hicarobrasil.dac.library.model.entity.Reserve;

@Service
public class ConvertService {

    public Book convertToBook(BookDTO bookDTO) {
        Book book = new Book();
        book.setAuthor(bookDTO.author());
        book.setTitle(bookDTO.title());
        book.setPublisher(bookDTO.publisher());
        book.setYear(bookDTO.year());
        return book;
    }
    public BookDTO convertToBookDTO(Book book) {
        BookDTO bookDTO = new BookDTO(book.getId(),book.getTitle(), book.getAuthor(), book.getYear(), book.getPublisher());
        return bookDTO;
    }
    public Reserve convertToReserve(ReserveDTO reserveDTO) {
        Reserve reserve = new Reserve();
        reserve.setResponsible(reserveDTO.responsible());
        reserve.setLoan(reserveDTO.loan());
        reserve.setDevolution(reserveDTO.devolution());
        reserve.setBookID(reserveDTO.bookID());

        return reserve;
    }
    public ReserveDTO convertToReserveDTO(Reserve reserve) {
        ReserveDTO reserveDTO = new ReserveDTO(reserve.getId(), reserve.getResponsible(), reserve.getLoan(), reserve.getDevolution(), reserve.getBookID());
        return reserveDTO;
    }
    public List<ReserveDTO> convertToReserveDTOList(List<Reserve> reserves) {
        List<ReserveDTO> reserveDTOs = new ArrayList<>();
        for (Reserve reserve : reserves) {
            reserveDTOs.add(convertToReserveDTO(reserve));
        }
        return reserveDTOs;
    }
    public List<BookDTO> convertToBookDTOList(List<Book> books) {
        List<BookDTO> bookDTOs = new ArrayList<>();
        for (Book book : books) {
            bookDTOs.add(convertToBookDTO(book));
        }
        return bookDTOs;
    }
}