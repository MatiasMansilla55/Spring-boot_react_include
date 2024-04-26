import React from "react";
import { useState, useEffect } from "react";
import ClienteService from "../services/ClienteService";


const RegisterBook = () => {
    
  const [libro, setLibro] = useState({
    titulo: "",
    fechaDePublicacion: "",
    autor: "",
    genero: "",
    editorialEntradaDto: {
      id: "",
      nombre: "",
    },
  });

  const [show, setShow] = useState(false);
  const [err, setErr] = useState(false);

  // const fetchLibro = () => {
  //   ClienteService.RegistrarLibros(libro)
  //     .then((res) => setLibro(JSON.stringify(res.data)))
  //     .catch((err) => console.log(err));
  // };

  

  const handleSubmit = async (event) => {
    event.preventDefault();

    try {
      if (
        libro.titulo.length >= 2 &&
        libro.autor.length >= 2 &&
        libro.genero.length >= 2 &&
        libro.editorialEntradaDto.id !== "" &&
        libro.editorialEntradaDto.nombre.length >= 2
      ) {
        setShow(true);
        setErr(false);
        await ClienteService.RegistrarLibros(libro);
        
      } else {
        setErr(true);
      }
    } catch {
      console.error("Error al enviar la solicitud:", error);
      setErr(true);
    }
  };

  return (
    <div>
      {!show && (
        <form onSubmit={handleSubmit}>
          <h3>Registrar Libro</h3>
          <label>Titulo:</label>
          <input
            type="text"
            value={libro.titulo}
            onChange={(event) =>
              setLibro({ ...libro, titulo: event.target.value })
            }
          />
          <label>Fecha De Publicacion:</label>
          <input
            type="text" id="fechaDePublicacion" name="fechaDePublicacion"
            value={libro.fechaDePublicacion}
            onChange={(event) =>
              setLibro({ ...libro, fechaDePublicacion: event.target.value })
            }
          />
          <label>Autor:</label>
          <input
            type="text" id="autor" name="autor"
            value={libro.autor}
            onChange={(event) =>
              setLibro({ ...libro, autor: event.target.value })
            }
          />
          <label>Genero:</label>
          <input
            type="text" id="genero" name="genero"
            value={libro.genero}
            onChange={(event) =>
              setLibro({ ...libro, genero: event.target.value })
            }
          />
          <label>Editorial ID:</label>
          <input
            type="text" id="libro.editorialEntradaDto.id" name="libro.editorialEntradaDto.id"
            value={libro.editorialEntradaDto && libro.editorialEntradaDto.id}
            onChange={(event) =>
              setLibro({
                ...libro,
                editorialEntradaDto: {
                  ...libro.editorialEntradaDto,
                  id: event.target.value,
                },
              })
            }
          />
          <label>Editorial Nombre:</label>
          <input
            type="text" id="nombre" name="nombre"
            value={libro.editorialEntradaDto && libro.editorialEntradaDto.nombre}
            onChange={(event) =>
              setLibro({
                ...libro,
                editorialEntradaDto: {
                  ...libro.editorialEntradaDto,
                  nombre: event.target.value,
                },
              })
            }
          />
          <button className="btn btn-primary mb-2">Enviar</button>
        </form>
      )}
      {show ? (
        <>
          <h3>Genial, el libro {libro.titulo}!</h3>
          <h3>En 30 minutos te llega el pedido a </h3>
        </>
      ) : (
        "Coloque los datos del libro para registrarlo"
      )}
      {err && (
        <h4 style={{ color: "red" }}>Debe colocar los datos correctamente</h4>
      )}
    </div>
  );
};

export default RegisterBook;
