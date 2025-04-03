package com.liberia.libreriaapi.services;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.liberia.libreriaapi.entities.Autor;
import com.liberia.libreriaapi.models.AutorCreateDTO;
import com.liberia.libreriaapi.models.AutorUpdateDTO;
import com.liberia.libreriaapi.repositories.AutorRepository;


@Service
public class AutorService {

    @Autowired
    private AutorRepository autorRepository;

    public void store(AutorCreateDTO autorCreateDTO) throws Exception {
        Autor autor = new Autor();

        autor.setNombreAutor(autorCreateDTO.getNombreAutor());
        autor.setAutorActivo(true);

        autorRepository.save(autor);
    }

    @Transactional
    public void update(UUID id, AutorUpdateDTO autorUpdateDTO) throws Exception {
        Autor a = findOne(id);
        a.setNombreAutor(autorUpdateDTO.getNombreAutor());

        autorRepository.save(a);
    }

    @Transactional(readOnly = true)
    public Autor findOne(UUID id) throws Exception {
        return autorRepository
                .findById(id)
                .orElseThrow(() -> new Exception("¡Autor no encontrado!"));
    }

    @Transactional(readOnly = true)
    public List<Autor> findAll() {
        return autorRepository.findAll();
    }

    public void delete(UUID id) throws Exception {
        Autor a = findOne(id);
        a.setAutorActivo(false);

        autorRepository.save(a);
    }
}
