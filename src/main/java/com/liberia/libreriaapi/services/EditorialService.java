package com.liberia.libreriaapi.services;

import java.util.List;
import java.util.UUID;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.liberia.libreriaapi.entities.Editorial;
import com.liberia.libreriaapi.models.EditorialCreateDTO;
import com.liberia.libreriaapi.models.EditorialUpdateDTO;
import com.liberia.libreriaapi.repositories.EditorialRepository;

@Service
public class EditorialService {

    private EditorialRepository editorialRepository;

    public EditorialService(EditorialRepository editorialRepository) {
        this.editorialRepository = editorialRepository;
    }

    public void store(EditorialCreateDTO editorialCreateDTO) throws Exception {
        Editorial editorial = new Editorial();

        editorial.setNombreEditorial(editorialCreateDTO.getNombreEditorial());
        editorial.setEditorialActiva(true);

        editorialRepository.save(editorial);
    }

    @Transactional
    public void update(UUID id, EditorialUpdateDTO editorialUpdateDTO) throws Exception {
        Editorial e = findOne(id);
        e.setNombreEditorial(editorialUpdateDTO.getNombreEditorial());

        editorialRepository.save(e);
    }

    @Transactional(readOnly = true)
    public List<Editorial> findAll() {
        return editorialRepository.findAll();
    }

    @Transactional(readOnly = true)
    public Editorial findOne(UUID id) throws Exception {
        return editorialRepository
                .findById(id)
                .orElseThrow(() -> new Exception("¡Editorial no encontrada!"));
    }
}
