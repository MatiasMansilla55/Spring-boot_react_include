package com.backend.libros.repository;

import com.backend.libros.entity.Libreria;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LibreriaRepository extends JpaRepository<Libreria,Long> {
}
