package com.backend.libros.service;

import com.backend.libros.dto.entrada.libro.LibroEntradaDto;
import com.backend.libros.dto.modificacion.LibroModificacionEntradaDto;
import com.backend.libros.dto.salida.libro.LibroSalidaDto;
import com.backend.libros.exceptions.ResourceNotFoundException;

import java.util.List;

public interface ILibroService {

    LibroSalidaDto registrarLibro(LibroEntradaDto libro);
    LibroSalidaDto actulizarLibro(LibroModificacionEntradaDto libro);
    List<LibroSalidaDto> listarLibros();
    LibroSalidaDto buscarLibroPorId(Long id);

    void eliminarLibro(Long id) throws ResourceNotFoundException;
}
