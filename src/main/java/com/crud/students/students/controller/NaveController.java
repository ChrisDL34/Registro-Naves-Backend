package com.crud.students.students.controller;

import com.crud.students.students.model.Nave;
import com.crud.students.students.service.INaveService;
import com.crud.students.students.service.NaveService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("http://localhost:3000")
@RequestMapping("/naves")
@RequiredArgsConstructor
public class NaveController {

    private final NaveService naveService;


    @GetMapping
    public ResponseEntity<List<Nave>> getNaves(){
        return new ResponseEntity<>(naveService.obtenerNaves(), HttpStatus.FOUND);
    }

    @PostMapping
    public Nave addNave(@RequestBody Nave nave){
        return naveService.agregarNave(nave);
    }

    @PutMapping("/update/{id}")
    public Nave updateNave(@RequestBody Nave nave, @PathVariable Long id){
        return naveService.actualizarNave(nave, id);
    }
    @DeleteMapping("/delete/{id}")
    public void deleteNave(@PathVariable Long id){
        naveService.deleteNave(id);
    }
    @GetMapping("/nave/{id}")
    public Nave getNaveById(@PathVariable Long id){
        return naveService.obtenerNaveById(id);
    }

}
