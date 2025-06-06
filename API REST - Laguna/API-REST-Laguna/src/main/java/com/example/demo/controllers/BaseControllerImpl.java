package com.example.demo.controllers;

import com.example.demo.entities.Base;
import com.example.demo.entities.Persona;
import com.example.demo.services.BaseService;
import lombok.extern.java.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.awt.print.Pageable;
import java.io.Serializable;

public abstract class BaseControllerImpl<E extends Base, S extends BaseService<E, Long>> implements BaseController<E, Long> {
    @Autowired
    protected S servicio;
    @GetMapping("")
    public ResponseEntity<?> getAll(){
        try {
            return ResponseEntity.status(HttpStatus.OK).body(servicio.findAll());

        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("\"error\":\"Error. Intente mas tarde.\"");
        }
    }
//    @GetMapping("/page")
//    public ResponseEntity<?> getAll(Pageable pageable){
//        try {
//            return ResponseEntity.status(HttpStatus.OK).body(servicio.findAll(pageable));
//
//        }catch (Exception e){
//            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("\"error\":\"Error. Intente mas tarde.\"");
//        }
//    }
    @GetMapping("/{id}")
    public ResponseEntity<?> getOne(@PathVariable Long id){
        try {
            return ResponseEntity.status(HttpStatus.OK).body(servicio.findById(id));

        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("\"error\":\"Error. Intente mas tarde.\"");
        }
    }

    @PostMapping("")
    public ResponseEntity<?> save(@RequestBody E entity){
        try {
            return ResponseEntity.status(HttpStatus.OK).body(servicio.save(entity));

        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("\"error\":\"Error. Intente mas tarde.\"");
        }
    }
    @PutMapping("/{id}")
    public ResponseEntity<?> update(@PathVariable Long id, @RequestBody E entity){
        try {
            return ResponseEntity.status(HttpStatus.OK).body(servicio.update(id, entity));

        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("\"error\":\"Error. Intente mas tarde.\"");
        }
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id){
        try {
            return ResponseEntity.status(HttpStatus.NO_CONTENT).body(servicio.delete(id));

        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("\"error\":\"Error. Intente mas tarde.\"");
        }
    }
}
