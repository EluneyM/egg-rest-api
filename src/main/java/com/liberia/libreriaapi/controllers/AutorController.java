package com.liberia.libreriaapi.controllers;

import java.util.List;
import java.util.UUID;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.liberia.libreriaapi.entities.Autor;
import com.liberia.libreriaapi.models.AutorCreateDTO;
import com.liberia.libreriaapi.models.AutorUpdateDTO;
import com.liberia.libreriaapi.services.AutorService;

import jakarta.validation.ConstraintViolationException;

@RestController
@RequestMapping("/autors")
public class AutorController {

    private AutorService autorService;

    public AutorController(AutorService autorService) {
        this.autorService = autorService;
    }

    @PostMapping
    public ResponseEntity<Object> store(@RequestBody AutorCreateDTO autorCreateDTO) throws Exception {
        try {
            autorService.store(autorCreateDTO);

            return ResponseEntity.ok().build();
        } catch (ConstraintViolationException e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.UNPROCESSABLE_ENTITY);
        } catch (Exception e) {
            throw e;
        }
    }

    @GetMapping
    public ResponseEntity<List<Autor>> listAll() {
        try {
            return new ResponseEntity<>(autorService.findAll(), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PatchMapping("/{id}")
    public ResponseEntity<Void> update(@PathVariable String id, @RequestBody AutorUpdateDTO autorUpdateDTO) {
        try {
            autorService.update(UUID.fromString(id), autorUpdateDTO);
            return ResponseEntity.ok().build();
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }
}
