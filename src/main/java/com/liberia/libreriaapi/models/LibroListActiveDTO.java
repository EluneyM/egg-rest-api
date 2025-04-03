package com.liberia.libreriaapi.models;

import lombok.Data;

@Data
public class LibroListActiveDTO {
    private String titulo;
    private int ejemplares;

    public LibroListActiveDTO(String titulo, int ejemplares) {
        this.titulo = titulo;
        this.ejemplares = ejemplares;
    }

    public LibroListActiveDTO() {
    }
}
