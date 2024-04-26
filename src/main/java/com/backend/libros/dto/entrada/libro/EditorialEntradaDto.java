package com.backend.libros.dto.entrada.libro;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

public class EditorialEntradaDto {

    @NotNull(message = "El campo nombre no puede ser nulo")
    @NotBlank(message = "El campo nombre no puede ser blanco")
    private String nombre;
    public EditorialEntradaDto() {
    }
    public EditorialEntradaDto(String nombre) {
        this.nombre = nombre;
    }



    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
}
