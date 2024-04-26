package com.backend.libros.entity;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table(name = "LIBROS")
public class Libro {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column
    private String titulo;
    @Column
    private LocalDate fechaDePublicacion;
    @Column
    private String autor;
    @Column
    private String genero;
    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "editorial_id")
    private Editorial editorial;

    public Libro() {
    }

    public Libro(Long id, String titulo, LocalDate fechaDePublicacion, String autor, String genero, Editorial editorial) {
        this.id=id;
        this.titulo = titulo;
        this.fechaDePublicacion = fechaDePublicacion;;
        this.autor = autor;
        this.genero = genero;
        this.editorial = editorial;
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

    public Long getId() {
        return id;
    }

    public Editorial getEditorial() {
        return editorial;
    }

    public void setEditorial(Editorial editorial) {
        this.editorial = editorial;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Libro{" +
                "id=" + id +
                ", titulo='" + titulo + '\'' +
                ", fechaDePublicacion=" + fechaDePublicacion+
                ", autor='" + autor + '\'' +
                ", genero='" + genero + '\'' +
                ", editorial=" + editorial +
                '}';
    }
}
