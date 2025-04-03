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
public class Editorial {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID idEditorial; // Identificador unico de la editorial.

    @NotNull(message = "Nombre no puede ser nulo")
    private String nombreEditorial; // Nombre de la editorial.

    @NotNull(message = "Activa no puede ser nula")
    private Boolean editorialActiva; // Indica si la editorial está activa o no.
}
