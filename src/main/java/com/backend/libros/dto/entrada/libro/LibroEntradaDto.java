package com.backend.libros.dto.entrada.libro;

import com.fasterxml.jackson.annotation.JsonFormat;

import javax.validation.Valid;
import javax.validation.constraints.*;

import java.time.LocalDate;

public class LibroEntradaDto {
    @NotNull(message = "el campo del titulo no puede ser nulo")
    @NotBlank(message = "el campo del titulo no puede esta en blanco")
    @Size(max = 200, message = "El campo del titulo debe tener hasta 200 caracteres")
    private String titulo;

    @NotNull(message = "el campo de año de publicacion no puede ser nulo")
    @NotBlank(message = "el campo de año de publicacion no puede esta en blanco")
    //@FutureOrPresent(message = "La fecha no puede ser anterior al día de hoy")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    private LocalDate fechaDePublicacion;
    @NotNull(message = "el campo de autor no puede ser nulo")
    @NotBlank(message = "el campo de autor no puede esta en blanco")
    @Size(max = 100, message = "El campo de autor debe tener hasta 100 caracteres")
    private String autor;
    @NotNull(message = "el campo del genero no puede ser nulo")
    @NotBlank(message = "el campo del genero no puede esta en blanco")
    @Size(max = 100, message = "El campo del genero solo puede tener hasta 100 caracteres")
    private String genero;

    @NotNull(message = "La editorial del libro no puede ser nulo")
    @Valid
    private EditorialEntradaDto editorialEntradaDto;

    public LibroEntradaDto() {
    }

    public LibroEntradaDto(String titulo, LocalDate fechaDePublicacion, String autor, String genero, EditorialEntradaDto editorialEntradaDto) {
        this.titulo = titulo;
        this.fechaDePublicacion = fechaDePublicacion;
        this.autor = autor;
        this.genero = genero;
        this.editorialEntradaDto = editorialEntradaDto;
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

    public EditorialEntradaDto getEditorialEntradaDto() {
        return editorialEntradaDto;
    }

    public void setEditorialEntradaDto(EditorialEntradaDto editorialEntradaDto) {
        this.editorialEntradaDto = editorialEntradaDto;
    }

    public void setFechaDePublicacion(LocalDate fechaDePublicacion) {
        this.fechaDePublicacion = fechaDePublicacion;
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

    @Override
    public String toString() {
        return "LibroEntradaDto{" +
                "titulo='" + titulo + '\'' +
                ", fechaDePublicacion=" + fechaDePublicacion +
                ", autor='" + autor + '\'' +
                ", genero='" + genero + '\'' +
                ", editorialEntradaDto=" + editorialEntradaDto +
                '}';
    }
}