package com.liberia.libreriaapi.entities;

import java.util.UUID;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@Entity
public class Autor {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID idAutor;

    @NotNull(message = "Nombre no puede ser nulo")
    private String nombreAutor;

    @NotNull(message = "Activo no puede ser nulo")
    private Boolean autorActivo;
}
