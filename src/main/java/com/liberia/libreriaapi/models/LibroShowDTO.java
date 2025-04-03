package com.liberia.libreriaapi.models;

import lombok.Data;

@Data
public class LibroShowDTO {

    private Long idLibro;
    private String titulo;
    private int ejemplares;

    public LibroShowDTO(Long idLibro, String titulo, int ejemplares) {
        this.idLibro = idLibro;
        this.titulo = titulo;
        this.ejemplares = ejemplares;
    }

    public LibroShowDTO() {
    }
}
