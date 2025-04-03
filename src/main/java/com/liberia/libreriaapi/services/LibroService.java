package com.liberia.libreriaapi.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.liberia.libreriaapi.entities.Autor;
import com.liberia.libreriaapi.entities.Editorial;
import com.liberia.libreriaapi.entities.Libro;
import com.liberia.libreriaapi.models.LibroCreateDTO;
import com.liberia.libreriaapi.models.LibroListActiveDTO;
import com.liberia.libreriaapi.models.LibroShowDTO;
import com.liberia.libreriaapi.repositories.LibroRepository;

@Service
public class LibroService {

    @Autowired
    private LibroRepository libroRepository;

    @Autowired
    private AutorService autorService;

    @Autowired
    private EditorialService editorialService;

    @Transactional
    public void store(LibroCreateDTO libroCreateDTO) throws Exception {
        Libro libroNvo = new Libro();
        libroNvo.setIdLibro(libroCreateDTO.getIsbn());
        libroNvo.setTitulo(libroCreateDTO.getTitulo());
        libroNvo.setEjemplares(libroCreateDTO.getEjemplares());
        libroNvo.setLibroActivo(libroCreateDTO.isLibroActivo());

        Autor autor = autorService.findOne(libroCreateDTO.getIdAutor());
        libroNvo.setAutor(autor);

        Editorial editorial = editorialService.findOne(libroCreateDTO.getIdEditorial());
        libroNvo.setEditorial(editorial);

        libroRepository.save(libroNvo);
    }

    public LibroShowDTO findOneDTO(Long id) throws Exception {
        return libroRepository.findById(id)
                .map((Libro l) -> new LibroShowDTO(l.getIdLibro(), l.getTitulo(), l.getEjemplares()))
                .orElseThrow(() -> new Exception("¡Libro no encontrado!"));
    }

    public List<LibroListActiveDTO> findOnlyActive() {
        return libroRepository.findOnlyActive();
    }
}
