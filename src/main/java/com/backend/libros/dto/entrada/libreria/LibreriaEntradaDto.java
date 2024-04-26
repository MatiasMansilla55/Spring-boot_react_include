package com.backend.libros.dto.entrada.libreria;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

public class LibreriaEntradaDto {

    @NotBlank(message = "el campo nombre no puede estar en blanco")
    @NotNull(message = "el campo nombre no puede ser nulo")
    private String nombre;

    public LibreriaEntradaDto(String nombre) {
        this.nombre = nombre;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
}
