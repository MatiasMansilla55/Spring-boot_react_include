import axios from "axios";
const LIBRO_BASE_REST_API_URL = "http://localhost:8080/libros/listar"
const LIBRO_BASE_REST_API_REGISTRAR ="http://localhost:8080/libros/registrar"
class ClienteService{
    getAllLibros(){
        return axios.get(LIBRO_BASE_REST_API_URL)
    }
    RegistrarLibros(librodata){
        return axios.post(LIBRO_BASE_REST_API_REGISTRAR,librodata)
    }

}

export default new ClienteService;
