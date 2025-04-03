package com.liberia.libreriaapi.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PositiveOrZero;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@Entity
public class Libro {
    @Id
    private Long idLibro;

    @NotNull(message = "Título no puede ser nulo")
    private String titulo;

    @NotNull(message = "Ejemplares no puede ser nulo")
    @PositiveOrZero(message = "Ejemplares debe ser igual o mayor a cero")
    private Integer ejemplares;

    @NotNull(message = "Activo no puede ser nulo")
    private Boolean libroActivo;

    @NotNull(message = "El Autor no puede ser nulo")
    @ManyToOne
    private Autor autor;

    @NotNull(message = "La Editorial no puede ser nula")
    @ManyToOne
    private Editorial editorial;
}
