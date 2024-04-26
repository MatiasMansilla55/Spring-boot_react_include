package com.backend.libros.service;

import com.backend.libros.dto.entrada.libro.LibroEntradaDto;
import com.backend.libros.dto.modificacion.LibroModificacionEntradaDto;
import com.backend.libros.dto.salida.libro.LibroSalidaDto;
import com.backend.libros.entity.Libro;
import com.backend.libros.exceptions.ResourceNotFoundException;
import com.backend.libros.repository.LibroRepository;
import com.backend.libros.utils.JsonPrinter;
import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LibroService implements ILibroService {

    private final Logger LOGGER = LoggerFactory.getLogger(LibroService.class);

    private LibroRepository libroRepository;
    private ModelMapper modelMapper;

    public LibroService(LibroRepository libroRepository, ModelMapper modelMapper) {
        this.libroRepository = libroRepository;
        this.modelMapper = modelMapper;
        configureMapping();
    }

    @Override
    public LibroSalidaDto registrarLibro(LibroEntradaDto libro) {
        LOGGER.info("LibroEntradaDto: " + JsonPrinter.toString(libro));
        Libro libroEntidad = modelMapper.map(libro, Libro.class);
        //mandamos a persistir a la capa dao y obtenemos una entidad
        Libro libroAPersistir = libroRepository.save(libroEntidad);
        //transformamos la entidad obtenida en salidaDto
        LibroSalidaDto libroSalidaDto = modelMapper.map(libroAPersistir,LibroSalidaDto.class);
        LOGGER.info("LibroSalidaDto: " + JsonPrinter.toString(libroSalidaDto));

        return libroSalidaDto;
    }

    @Override
    public LibroSalidaDto actulizarLibro(LibroModificacionEntradaDto libro) {
        Libro libroRecibido = modelMapper.map(libro, Libro.class);
        Libro libroAActualizar = libroRepository.findById(libroRecibido.getId()).orElse(null);

        LibroSalidaDto libroSalidaDto= null;
        if(libroAActualizar != null){
            libroAActualizar = libroRecibido;
            libroRepository.save(libroAActualizar);
            libroSalidaDto = modelMapper.map(libroAActualizar, LibroSalidaDto.class);
            LOGGER.warn("Libro actualizado: {}", JsonPrinter.toString(libroSalidaDto));
        }else{
            LOGGER.error("No fue posible actualizar el libro porque no se encuentra en nuestra base de datos");
            //lanzar excepcion correspondiente
        }
        return libroSalidaDto;
    }

    @Override
    public List<LibroSalidaDto> listarLibros() {
        List<LibroSalidaDto> libroSalidaDto= libroRepository.findAll()
                .stream()
                .map(libro -> modelMapper.map(libro, LibroSalidaDto.class))
                .toList();
        LOGGER.info("Listado de todos los libros: {}", JsonPrinter.toString(libroSalidaDto));
        return libroSalidaDto;
    }

    @Override
    public LibroSalidaDto buscarLibroPorId(Long id) {
        Libro libroBuscado = libroRepository.findById(id).orElse(null);
        LibroSalidaDto libroEncontrado = null;

        LOGGER.debug("Libro buscado con ID {}: {}",id , libroBuscado);
        if(libroBuscado != null){
            libroEncontrado = modelMapper.map(libroBuscado, LibroSalidaDto.class);
            LOGGER.info("Libro encontrado: {}", JsonPrinter.toString(libroEncontrado));
        }else LOGGER.error("El id no se encuentra registrado en la base de datos");
        return libroEncontrado;
    }

    @Override
    public void eliminarLibro(Long id) throws ResourceNotFoundException {
        if(buscarLibroPorId(id)!=null){
            libroRepository.deleteById(id);
            LOGGER.warn("Se ha eliminado el libro con id: {}", id);
        }else{
            LOGGER.error("No se ha encontrado el libro con id {}", id);
            throw new ResourceNotFoundException("No se ha encontrado el libro con id " + id);
        }
    }
    private void configureMapping(){
        modelMapper.typeMap(LibroEntradaDto.class, Libro.class)
                .addMappings(modelMapper -> modelMapper.map(LibroEntradaDto::getEditorialEntradaDto, Libro::setEditorial));
        modelMapper.typeMap(Libro.class, LibroSalidaDto.class)
                .addMappings(modelMapper -> modelMapper.map(Libro::getEditorial, LibroSalidaDto::setEditorialSalidaDto));
        modelMapper.typeMap(LibroModificacionEntradaDto.class, Libro.class)
                .addMappings(mapper -> mapper.map(LibroModificacionEntradaDto::getEditorialModificacionEntradaDto, Libro::setEditorial));

    }
}
