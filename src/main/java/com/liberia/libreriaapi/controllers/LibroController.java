package com.liberia.libreriaapi.controllers;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.liberia.libreriaapi.models.LibroCreateDTO;
import com.liberia.libreriaapi.models.LibroListActiveDTO;
import com.liberia.libreriaapi.models.LibroShowDTO;
import com.liberia.libreriaapi.services.LibroService;

@RequestMapping("/books")
@RestController
public class LibroController {

    private LibroService libroService;

    public LibroController(LibroService libroService) {
        this.libroService = libroService;
    }

    @PostMapping
    public ResponseEntity<Object> store(@RequestBody LibroCreateDTO libroCreateDTO) {
        try {
            libroService.store(libroCreateDTO);
            return ResponseEntity.status(HttpStatus.CREATED).build();

        } catch (Exception e) {
            System.out.println(e.getMessage());
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<LibroShowDTO> findOne(@PathVariable Long id) {
        try {
            return new ResponseEntity<>(libroService.findOneDTO(id), HttpStatus.OK);

        } catch (Exception e) {
            System.out.println(e.getMessage());
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @GetMapping
    public List<LibroListActiveDTO> findOnlyActive() {
        return libroService.findOnlyActive();
    }
}
