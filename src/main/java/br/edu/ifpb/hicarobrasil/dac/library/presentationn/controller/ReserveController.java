package br.edu.ifpb.hicarobrasil.dac.library.presentationn.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.edu.ifpb.hicarobrasil.dac.library.business.dto.ReserveDTO;
import br.edu.ifpb.hicarobrasil.dac.library.business.services.ReserveService;

/**
 * ReserveController
 */
@RestController
@RequestMapping("/reserve")
@CrossOrigin(origins = "http://localhost:3000")
public class ReserveController {
    @Autowired
    private ReserveService reserveService;

    @PostMapping
    public ResponseEntity<ReserveDTO> save(ReserveDTO reserveDTO){
        try {
            ReserveDTO reserve = reserveService.save(reserveDTO);
            return new ResponseEntity<>(reserve, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<ReserveDTO> update(ReserveDTO reserveDTO, Long id){
        try {
            ReserveDTO reserve = reserveService.update(reserveDTO, id);
            return new ResponseEntity<>(reserve, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @DeleteMapping
    public ResponseEntity<ReserveDTO> delete(ReserveDTO reserveDTO){
        try {
            ReserveDTO reserve = reserveService.delete(reserveDTO);
            return new ResponseEntity<>(reserve, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<ReserveDTO> deleteById(Long id){
        try {
            ReserveDTO reserve = reserveService.deleteById(id);
            return new ResponseEntity<>(reserve, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<ReserveDTO> findByID(Long id){
        try {
            ReserveDTO reserve = reserveService.findByID(id);
            return new ResponseEntity<>(reserve, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

}