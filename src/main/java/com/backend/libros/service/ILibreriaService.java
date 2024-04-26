package com.backend.libros.service;

import com.backend.libros.dto.entrada.libreria.LibreriaEntradaDto;

import com.backend.libros.dto.modificacion.LibreriaModificacionEntradaDto;
import com.backend.libros.dto.salida.libreria.LibreriaSalidaDto;
import com.backend.libros.exceptions.ResourceNotFoundException;

import java.util.List;


public interface ILibreriaService {

    LibreriaSalidaDto registrarLibreria(LibreriaEntradaDto libreria);

    List<LibreriaSalidaDto> listarLibrerias();

    LibreriaSalidaDto buscarLibreria(Long id);

    LibreriaSalidaDto actualizarLibreria (LibreriaModificacionEntradaDto libreriaModificacionDto);

    void eliminarLibreria(Long id) throws ResourceNotFoundException;
}
