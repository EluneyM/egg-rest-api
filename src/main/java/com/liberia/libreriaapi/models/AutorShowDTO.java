package com.liberia.libreriaapi.models;

import java.util.UUID;

import lombok.Data;

@Data
public class AutorShowDTO {

    private UUID idAutor;
    private String nombreAutor;

    public AutorShowDTO() {
    }

    public AutorShowDTO(UUID idAutor, String nombreAutor) {
        this.idAutor = idAutor;
        this.nombreAutor = nombreAutor;
    }
}
