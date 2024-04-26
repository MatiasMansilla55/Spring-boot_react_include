package com.backend.libros.dto.salida.libro;



import com.fasterxml.jackson.annotation.JsonFormat;

import java.time.LocalDate;

public class LibroSalidaDto {
   private Long id;
   private String titulo;
   private LocalDate fechaDePublicacion;
   private String autor;
   private String genero;
   private EditorialSalidaDto editorialSalidaDto;

    public LibroSalidaDto() {
    }

    public LibroSalidaDto(Long id, String titulo, LocalDate fechaDePublicacion, String autor, String genero, EditorialSalidaDto editorialSalidaDto) {
        this.id = id;
        this.titulo = titulo;
        this.fechaDePublicacion = fechaDePublicacion;
        this.autor = autor;
        this.genero = genero;
        this.editorialSalidaDto = editorialSalidaDto;
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

    public EditorialSalidaDto getEditorialSalidaDto() {
        return editorialSalidaDto;
    }

    public void setEditorialSalidaDto(EditorialSalidaDto editorialSalidaDto) {
        this.editorialSalidaDto = editorialSalidaDto;
    }

    @Override
    public String toString() {
        return "LibroSalidaDto{" +
                "id=" + id +
                ", titulo='" + titulo + '\'' +
                ", fechaDePublicacion=" + fechaDePublicacion +
                ", autor='" + autor + '\'' +
                ", genero='" + genero + '\'' +
                ", editorialSalidaDto=" + editorialSalidaDto +
                '}';
    }
}
