package com.backend.libros.dto.modificacion;

import com.fasterxml.jackson.annotation.JsonFormat;

import javax.validation.constraints.FutureOrPresent;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.time.LocalDate;

public class LibroModificacionEntradaDto {
    @NotNull(message = "Debe proveerse el id del libro que se desea modificar")
    private Long id;
    @NotNull(message = "el campo del titulo no puede ser nulo")
    @NotBlank(message = "el campo del titulo no puede esta en blanco")
    @Size(max = 200, message = "El campo del titulo debe tener hasta 200 caracteres")
    private String titulo;

    @NotNull(message = "el campo de año de publicacion no puede ser nulo")
    @NotBlank(message = "el campo de año de publicacion no puede esta en blanco")
    //@FutureOrPresent(message = "La fecha no puede ser anterior al día de hoy")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm")
    private LocalDate fechaDePublicacion;
    @NotNull(message = "el campo de autor no puede ser nulo")
    @NotBlank(message = "el campo de autor no puede esta en blanco")
    @Size(max = 100, message = "El campo de autor debe tener hasta 100 caracteres")
    private String autor;
    @NotNull(message = "el campo del genero no puede ser nulo")
    @NotBlank(message = "el campo del genero no puede esta en blanco")
    @Size(max = 100 , message ="El campo del genero solo puede tener hasta 100 caracteres")
    private String genero;
    @NotNull(message = "el campo de EditorialModificacionEntradaDto no puede ser nulo")
    private EditorialModificacionEntradaDto editorialModificacionEntradaDto;

    public LibroModificacionEntradaDto() {
    }

    public LibroModificacionEntradaDto(Long id, String titulo, LocalDate fechaDePublicacion, String autor, String genero, EditorialModificacionEntradaDto editorialModificacionEntradaDto) {
        this.id = id;
        this.titulo = titulo;
        this.fechaDePublicacion = fechaDePublicacion;
        this.autor = autor;
        this.genero = genero;
        this.editorialModificacionEntradaDto= editorialModificacionEntradaDto;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public LocalDate getFechaDePublicacion() {
        return fechaDePublicacion;
    }

    public void setFechaDePublicacion(LocalDate fechaDePublicacion) {
        this.fechaDePublicacion= fechaDePublicacion;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }
    public EditorialModificacionEntradaDto getEditorialModificacionEntradaDto() {
        return editorialModificacionEntradaDto;
    }

    public void setEditorialModificacionEntradaDto(EditorialModificacionEntradaDto editorialModificacionEntradaDto) {
        this.editorialModificacionEntradaDto = editorialModificacionEntradaDto;
    }

    @Override
    public String toString() {
        return "LibroModificacionEntradaDto{" +
                "id=" + id +
                ", titulo='" + titulo + '\'' +
                ", fechaDePublicacion=" + fechaDePublicacion +
                ", autor='" + autor + '\'' +
                ", genero='" + genero + '\'' +
                ", editorialModificacionEntradaDto=" + editorialModificacionEntradaDto +
                '}';
    }
}
