package com.backend.libros.controller;

import com.backend.libros.dto.entrada.libro.LibroEntradaDto;
import com.backend.libros.dto.modificacion.LibroModificacionEntradaDto;
import com.backend.libros.dto.salida.libro.LibroSalidaDto;
import com.backend.libros.exceptions.ResourceNotFoundException;
import com.backend.libros.service.ILibroService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;


@CrossOrigin(origins = "http://localhost:5173")
@RestController
@RequestMapping("/libros")
public class LibroController {

    private ILibroService libroService;

    public LibroController(ILibroService libroService) {
        this.libroService = libroService;
    }

    @Operation(summary = "Listado de todos los libros")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Listado de libros obtenido correctamente",
                    content = {@Content(mediaType = "application/json",
                            schema = @Schema(implementation = LibroSalidaDto.class))}),
            @ApiResponse(responseCode = "400", description = "Bad Request",
                    content = @Content),
            @ApiResponse(responseCode = "500", description = "Server error",
                    content = @Content)
    })

    @GetMapping("/listar")
    public ResponseEntity<List<LibroSalidaDto>> listarLisbros(){
        return new ResponseEntity<>(libroService.listarLibros(), HttpStatus.OK);
    }
    @Operation(summary = "Registro de un nuevo Libro")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Libro guardado correctamente",
                    content = {@Content(mediaType = "application/json",
                            schema = @Schema(implementation = LibroSalidaDto.class))}),
            @ApiResponse(responseCode = "400", description = "Bad Request",
                    content = @Content),
            @ApiResponse(responseCode = "500", description = "Server error",
                    content = @Content)
    })
    @PostMapping("/registrar")
    public ResponseEntity<LibroSalidaDto> guardar(@RequestBody @Valid LibroEntradaDto libro){
        return new ResponseEntity<>(libroService.registrarLibro(libro), HttpStatus.CREATED);
    }
    @Operation(summary = "Eliminación de un libro por Id")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "204", description = "libro eliminado correctamente",
                    content = {@Content(mediaType = "application/json",
                            schema = @Schema(implementation = String.class))}),
            @ApiResponse(responseCode = "400", description = "Id inválido",
                    content = @Content),
            @ApiResponse(responseCode = "404", description = "libro no encontrado",
                    content = @Content),
            @ApiResponse(responseCode = "500", description = "Server error",
                    content = @Content)
    })
    @DeleteMapping("/eliminar/{id}")
    public  ResponseEntity<Void> eliminarLibro(@PathVariable Long id)throws ResourceNotFoundException {
        libroService.eliminarLibro(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
    //buscar libro con PathVariable
    @Operation(summary = "Búsqueda de un libro por Id")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "libro obtenido correctamente",
                    content = {@Content(mediaType = "application/json",
                            schema = @Schema(implementation = LibroSalidaDto.class))}),
            @ApiResponse(responseCode = "400", description = "Id inválido",
                    content = @Content),
            @ApiResponse(responseCode = "404", description = "Libro no encontrado",
                    content = @Content),
            @ApiResponse(responseCode = "500", description = "Server error",
                    content = @Content)
    })
    @GetMapping("{id}")
    public ResponseEntity<LibroSalidaDto> obtenerLibroPorId(@PathVariable Long id){
        return new ResponseEntity<>(libroService.buscarLibroPorId(id), HttpStatus.OK);
    }
    @Operation(summary = "Actualización de un libro")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Libro actualizado correctamente",
                    content = {@Content(mediaType = "application/json",
                            schema = @Schema(implementation = LibroSalidaDto.class))}),
            @ApiResponse(responseCode = "400", description = "Bad Request",
                    content = @Content),
            @ApiResponse(responseCode = "404", description = "Libro no encontrado",
                    content = @Content),
            @ApiResponse(responseCode = "500", description = "UServer error",
                    content = @Content)
    })
    @PutMapping("/actualizar")
    public ResponseEntity<LibroSalidaDto> actualizarLibro(@RequestBody LibroModificacionEntradaDto libro){
        return new ResponseEntity<>(libroService.actulizarLibro(libro),HttpStatus.OK);
    }
}
