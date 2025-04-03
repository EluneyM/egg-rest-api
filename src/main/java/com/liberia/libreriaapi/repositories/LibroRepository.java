package com.liberia.libreriaapi.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.liberia.libreriaapi.entities.Libro;
import com.liberia.libreriaapi.models.LibroListActiveDTO;

@Repository
public interface LibroRepository extends JpaRepository<Libro, Long> {

    @Query("SELECT new com.liberia.libreriaapi.models.LibroListActiveDTO(l.titulo, l.ejemplares) " +
            "FROM Libro l WHERE l.libroActivo = true")
    public List<LibroListActiveDTO> findOnlyActive();
}
