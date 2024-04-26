import React, {useEffect, useState} from 'react'
import ClienteService from '../services/ClienteService'
import { Link } from "react-router-dom";
export const LibrosList = ()=>{
    const[libros, setLibros] = useState([])
    useEffect(() => {
        const fetchLibros = async () => {
            try {
                const response = await ClienteService.getAllLibros();
                setLibros(response.data);
            } catch (error) {
                console.log(error);
            }
        };

        fetchLibros();
    }, []); 

return (
    <div className='container'>
        <h2 className='text-center'>Lista de libros</h2>
        <Link to="/registrar-libro" className='btn btn-primary mb-2'>Registrar Libro</Link>
        <table className='table table-bordered table-striped'>
            <thead>
                <th>ID</th>
                <th>Titulo</th>
                <th>Fecha de Publicacion</th>
                <th>autor</th>
                <th>Genero</th>
                <th>Editoral ID</th>
                <th>Nombre de Editorial</th>
            </thead>
            <tbody>
                {
                    libros.map(libro =><tr key={libro.id}>
                                            <td>{libro.id}</td>
                                            <td>{libro.titulo}</td>
                                            <td>{libro.fechaDePublicacion}</td>
                                            <td>{libro.autor}</td>
                                            <td>{libro.genero}</td>
                                            <td>{libro.editorialSalidaDto.id}</td>
                                            <td>{libro.editorialSalidaDto.nombre}</td>

                                        </tr>)
                }
            </tbody>
        </table>
    </div>
)
}