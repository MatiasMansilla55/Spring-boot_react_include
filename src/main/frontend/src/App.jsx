import { LibrosList } from "./components/LibrosList"
import RegisterBook from "./components/RegisterBook"
import { Route, Routes } from "react-router-dom";

function App() {
 return(
    <>
        <Routes>
            <Route path= "/" element ={<LibrosList/>}/>
            <Route path= "/registrar-libro" element ={<RegisterBook/>}/>
        </Routes>
    </>
 )
}

export default App
