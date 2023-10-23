package br.edu.ifpb.hicarobrasil.dac.library.business.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import br.edu.ifpb.hicarobrasil.dac.library.business.dto.BookDTO;
import br.edu.ifpb.hicarobrasil.dac.library.business.dto.ReserveDTO;
import br.edu.ifpb.hicarobrasil.dac.library.business.dto.UserDTO;
import br.edu.ifpb.hicarobrasil.dac.library.model.entity.Book;
import br.edu.ifpb.hicarobrasil.dac.library.model.entity.Reserve;
import br.edu.ifpb.hicarobrasil.dac.library.model.entity.User;

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

    public UserDTO convertToUserDTO(User user){
        UserDTO userDTO = new UserDTO(user.getId(), user.getName(), user.getEmail(), user.getLogin(),user.getSenha(), user.getRole());
        return userDTO;
    }

    public User convertToUser(UserDTO userDTO){
        User user = new User();
        user.setId(userDTO.id());
        user.setEmail(userDTO.email());
        user.setName(userDTO.name());
        user.setLogin(userDTO.login());
        user.setSenha(userDTO.password());
        user.setRole(userDTO.role());

        return user;
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

    public List<UserDTO> convertoUserDTOList(List<User> users){

        List<UserDTO> userDTOs = new ArrayList<>();
        for (User user: users)
        userDTOs.add(convertToUserDTO(user));
        return userDTOs;
    }

    public List<User> converToUserList(List<UserDTO> userDTOs){
        List<User> users = new ArrayList<>();
        for(UserDTO userDTO: userDTOs){
            users.add( convertToUser(userDTO));
        }
        return users;
    }
}