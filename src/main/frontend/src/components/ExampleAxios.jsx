import axios from 'axios'
import { useEffect, useState } from 'react'

const ExampleAxios = () => {

    const [dog, setDog] = useState()
    // const [toggle, setToggle] = useState(true)
    const url = 'https://localhost:8081/listar'

    const fetchDog = () => {
        axios(url)
        .then(res => setDog(res.data))
        .catch(err => console.log(err))
    }

    useEffect(fetchDog, [])
    
  return (
    <div>
        <button onClick={fetchDog}>Quiero adoptar otro</button>
        {dog ? <img src={dog.message} alt='' className='imagen'/> : 'Cargando'}
    </div>
  )
}

export default ExampleAxios