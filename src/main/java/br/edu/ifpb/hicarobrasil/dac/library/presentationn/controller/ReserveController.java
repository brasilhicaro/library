package br.edu.ifpb.hicarobrasil.dac.library.presentationn.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
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
    public ResponseEntity<ReserveDTO> save(@RequestBody ReserveDTO reserveDTO){
        try {
            ReserveDTO reserve = reserveService.save(reserveDTO);
            return new ResponseEntity<>(reserve, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<ReserveDTO> update(@RequestBody ReserveDTO reserveDTO,@PathVariable Long id){
        try {
            ReserveDTO reserve = reserveService.update(reserveDTO, id);
            return new ResponseEntity<>(reserve, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @DeleteMapping
    public ResponseEntity<ReserveDTO> delete(@RequestBody ReserveDTO reserveDTO){
        try {
            ReserveDTO reserve = reserveService.delete(reserveDTO);
            return new ResponseEntity<>(reserve, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<ReserveDTO> deleteById(@PathVariable Long id){
        try {
            ReserveDTO reserve = reserveService.deleteById(id);
            return new ResponseEntity<>(reserve, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
    @GetMapping("/reserves")
    public ResponseEntity<List<ReserveDTO>> list(){
        try{
            List<ReserveDTO> reserves = reserveService.list();
            return new ResponseEntity<>(reserves, HttpStatus.OK);
        }catch(Exception e){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<ReserveDTO> get(@PathVariable Long id){
        try {
            ReserveDTO reserve = reserveService.findByID(id);
            return new ResponseEntity<>(reserve, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

}