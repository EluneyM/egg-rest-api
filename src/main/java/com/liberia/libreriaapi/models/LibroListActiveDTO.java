package com.liberia.libreriaapi.models;

import lombok.Data;

@Data
public class LibroListActiveDTO {
    private Long idLibro;
    private String titulo;
    private int ejemplares;

    public LibroListActiveDTO(Long idLibro, String titulo, int ejemplares) {
        this.idLibro = idLibro;
        this.titulo = titulo;
        this.ejemplares = ejemplares;
    }

    public LibroListActiveDTO() {
    }
}
