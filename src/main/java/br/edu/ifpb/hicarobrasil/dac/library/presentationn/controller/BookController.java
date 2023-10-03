package br.edu.ifpb.hicarobrasil.dac.library.presentationn.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import br.edu.ifpb.hicarobrasil.dac.library.business.dto.BookDTO;
import br.edu.ifpb.hicarobrasil.dac.library.business.services.BookService;


@RestController
@RequestMapping("/book")
@CrossOrigin(origins = "http://localhost:3000")
public class BookController {

    @Autowired
    private BookService bookService;

    @PostMapping
    public ResponseEntity<BookDTO> save(@RequestBody BookDTO bookDTO){
        try {
            BookDTO book =  bookService.save(bookDTO);
            return new ResponseEntity<>(book, HttpStatus.CREATED);
        } catch (Exception e) {
           return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }
    @GetMapping("/search/{title}")
    public ResponseEntity<List<BookDTO>> search(@PathVariable String title) {
        try {
            List<BookDTO> books = bookService.findByTitle(title);
            return new ResponseEntity<>(books, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
    
    @GetMapping("/find/{id}")
    public ResponseEntity<BookDTO> findByID(@PathVariable long id) {
        try {
            BookDTO book = bookService.findByID(id);
            return new ResponseEntity<>(book, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<BookDTO> update(@RequestBody BookDTO bookDTO, @PathVariable long id){
        try {
            BookDTO book =  bookService.update(bookDTO, id);
            return new ResponseEntity<>(book, HttpStatus.OK);
        } catch (Exception e) {
           return new ResponseEntity<>( HttpStatus.BAD_REQUEST);
        }
    }
    @DeleteMapping
    public ResponseEntity<BookDTO> delete(@RequestBody BookDTO bookDTO){
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
    public ResponseEntity<BookDTO> get(@PathVariable long id) {
        try {
            BookDTO book = bookService.findByID(id);
            return new ResponseEntity<>(book, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
    @GetMapping("/books")
    public ResponseEntity<List<BookDTO>> list() {
        try {
            List<BookDTO> books = bookService.list();
            return new ResponseEntity<>(books, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
    
}
