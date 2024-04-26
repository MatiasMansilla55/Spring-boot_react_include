package com.backend.libros.dto.modificacion;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

public class LibreriaModificacionEntradaDto {

    @NotNull(message = "Debe proveerse el id de la libreria que se desea modificar")
    private Long id;
    @NotBlank(message = "El campo del nombre de la libreria no puede esta vacio")
    @NotNull(message = "Debe proveerse el nombre de la libreria que se desea modificar")
    private String nombre;

    public LibreriaModificacionEntradaDto() {
    }

    public LibreriaModificacionEntradaDto(Long id, String nombre) {
        this.id = id;
        this.nombre = nombre;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
}
