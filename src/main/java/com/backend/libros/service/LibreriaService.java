package com.backend.libros.service;

import com.backend.libros.dto.entrada.libreria.LibreriaEntradaDto;
import com.backend.libros.dto.modificacion.LibreriaModificacionEntradaDto;
import com.backend.libros.dto.salida.libreria.LibreriaSalidaDto;
import com.backend.libros.entity.Libreria;
import com.backend.libros.exceptions.ResourceNotFoundException;
import com.backend.libros.repository.LibreriaRepository;
import com.backend.libros.utils.JsonPrinter;
import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

public class LibreriaService implements ILibreriaService{
    private final Logger LOGGER = LoggerFactory.getLogger(LibreriaService.class);

    private LibreriaRepository libreriaRepository;
    private ModelMapper modelMapper;

    public LibreriaService(LibreriaRepository libreriaRepository, ModelMapper modelMapper) {
        this.libreriaRepository = libreriaRepository;
        this.modelMapper = modelMapper;
        configureMapping();
    }

    @Override
    public LibreriaSalidaDto registrarLibreria(LibreriaEntradaDto libreria) {
        LOGGER.info("LibreriaEntradaDto: " + JsonPrinter.toString(libreria));
        Libreria libreriaEntidad = modelMapper.map(libreria, Libreria.class);
        //mandamos a persistir a la capa dao y obtenemos una entidad
        Libreria libreriaAPersistir = libreriaRepository.save(libreriaEntidad);
        //transformamos la entidad obtenida en salidaDto
        LibreriaSalidaDto libreriaSalidaDto = modelMapper.map(libreriaAPersistir, LibreriaSalidaDto.class);
        LOGGER.info("LibreriaSalidaDto: " + JsonPrinter.toString(libreriaSalidaDto));
        return libreriaSalidaDto;
    }

    @Override
    public List<LibreriaSalidaDto> listarLibrerias() {
        List<LibreriaSalidaDto> libreriaSalidaDto = libreriaRepository.findAll()
                .stream()
                .map(libreria -> modelMapper.map(libreria, LibreriaSalidaDto.class))
                .toList();
        LOGGER.info("Listado de todas las librerias: {}", JsonPrinter.toString(libreriaSalidaDto));
        return libreriaSalidaDto;
    }

    @Override
    public LibreriaSalidaDto buscarLibreria(Long id) {
        Libreria libreriaBuscada = libreriaRepository.findById(id).orElse(null);
        LibreriaSalidaDto libreriaEncontrada = null;
        LOGGER.debug("Libreria buscada con ID {}: {}", id, libreriaBuscada);
        if(libreriaBuscada !=null){
            libreriaEncontrada = modelMapper.map(libreriaBuscada, LibreriaSalidaDto.class);
            LOGGER.info("Libreria encontrada: {}", JsonPrinter.toString(libreriaEncontrada));
        }else{
            LOGGER.error("El id no se encuentra registrado en la base de datos");
        }
        return libreriaEncontrada;
    }

    @Override
    public LibreriaSalidaDto actualizarLibreria(LibreriaModificacionEntradaDto libreria) {
        Libreria libreriaRecibida = modelMapper.map(libreria, Libreria.class);
        Libreria libreriaAActulizar = libreriaRepository.findById(libreriaRecibida.getId()).orElse(null);

        LibreriaSalidaDto libreriaSalidaDto = null;
        if(libreriaAActulizar != null){
            libreriaAActulizar = libreriaRecibida;
            libreriaRepository.save(libreriaAActulizar);

            libreriaSalidaDto = modelMapper.map(libreriaAActulizar, LibreriaSalidaDto.class);
            LOGGER.warn("Libreria actualizada: {}", JsonPrinter.toString(libreriaSalidaDto));
        }else{
            LOGGER.error("No fue posible actualizar la libreria porque no se encuentra en nuestra base de datos");
            //lanzar excepcion correspondiente
        }
        return libreriaSalidaDto;

    }

    @Override
    public void eliminarLibreria(Long id) throws ResourceNotFoundException {
        if(buscarLibreria(id)!=null){
            libreriaRepository.deleteById(id);
            LOGGER.warn("Se ha eliminado la libreria con id: {}", id);
        }else{
            LOGGER.error("No se ha encontrado la libreria con id {}", id);
            throw new ResourceNotFoundException("No se ha encontrado la libreria con id " + id);
        }
    }
    private void configureMapping(){
        modelMapper.typeMap(LibreriaEntradaDto.class, Libreria.class);

        modelMapper.typeMap(Libreria.class, LibreriaSalidaDto.class);


    }
}
