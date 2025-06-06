package com.liberia.libreriaapi.repositories;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.liberia.libreriaapi.entities.Autor;

@Repository
public interface AutorRepository extends JpaRepository<Autor, UUID> {

}
