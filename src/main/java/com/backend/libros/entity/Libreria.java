package com.backend.libros.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "LIBRERIA")
public class Libreria {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column
    private String nombre;

    public Libreria() {
    }

    public Libreria(Long id, String nombre) {
        this.id = id;
        this.nombre = nombre;
    }

    @Override
    public String toString() {
        return "Libreria{" +
                "id=" + id +
                ", nombre='" + nombre + '\'' +
                '}';
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
