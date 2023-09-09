package br.edu.ifpb.hicarobrasil.dac.library.presentationn.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import br.edu.ifpb.hicarobrasil.dac.library.business.dto.BookDTO;
import br.edu.ifpb.hicarobrasil.dac.library.business.services.BookService;

import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/book")
@CrossOrigin(origins = "http://localhost:3000")
public class BookController {

    @Autowired
    private BookService bookService;

    @PostMapping
    public ResponseEntity<BookDTO> save(BookDTO bookDTO){
        try {
            BookDTO book =  bookService.save(bookDTO);
            return new ResponseEntity<>(book, HttpStatus.CREATED);
        } catch (Exception e) {
           return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }
    @PutMapping("/{id}")
    public ResponseEntity<BookDTO> update(BookDTO bookDTO, @PathVariable long id){
        try {
            BookDTO book =  bookService.update(bookDTO, id);
            return new ResponseEntity<>(book, HttpStatus.OK);
        } catch (Exception e) {
           return new ResponseEntity<>( HttpStatus.BAD_REQUEST);
        }
    }
    @DeleteMapping
    public ResponseEntity<BookDTO> delete(BookDTO bookDTO){
        try {
            BookDTO book =  bookService.delete(bookDTO);
            return new ResponseEntity<>(book, HttpStatus.OK);
        } catch (Exception e) {
           return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<BookDTO> deleteById(@PathVariable long id){
        try {
            BookDTO book =  bookService.deleteById(id);
            return new ResponseEntity<>(book, HttpStatus.OK);
        } catch (Exception e) {
           return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
    @GetMapping("/{id}")
    public ResponseEntity<BookDTO> getMethodName(@PathVariable long id) {
        try {
            BookDTO book = bookService.findByID(id);
            return new ResponseEntity<>(book, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
    @GetMapping("/list")
    public ResponseEntity<List<BookDTO>> list() {
        try {
            List<BookDTO> books = bookService.list();
            return new ResponseEntity<>(books, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
    
}
