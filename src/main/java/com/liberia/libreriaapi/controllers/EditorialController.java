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

import com.liberia.libreriaapi.entities.Editorial;
import com.liberia.libreriaapi.models.EditorialCreateDTO;
import com.liberia.libreriaapi.models.EditorialUpdateDTO;
import com.liberia.libreriaapi.services.EditorialService;

import jakarta.validation.ConstraintViolationException;
import jakarta.websocket.server.PathParam;

@RequestMapping("/publishers")
@RestController
public class EditorialController {

    protected EditorialService editorialService;

    public EditorialController(EditorialService editorialService) {
        this.editorialService = editorialService;
    }

    @PostMapping
    public ResponseEntity<Object> store(@RequestBody EditorialCreateDTO editorialCreateDTO) throws Exception {
        try {
            editorialService.store(editorialCreateDTO);

            return ResponseEntity.ok().body(editorialCreateDTO);
        } catch (ConstraintViolationException e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.UNPROCESSABLE_ENTITY);
        } catch (Exception e) {
            throw e;
        }
    }

    @PatchMapping("/{id}")
    public ResponseEntity<Object> update(@PathVariable String id, @RequestBody EditorialUpdateDTO editorialUpdateDTO) {
        try {
            editorialService.update(UUID.fromString(id), editorialUpdateDTO);
            return ResponseEntity.ok().body(editorialUpdateDTO);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return ResponseEntity.badRequest().build();
        }
    }

    @GetMapping
    public ResponseEntity<List<Editorial>> listAll() {
        try {
            return new ResponseEntity<>(editorialService.findAll(), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
