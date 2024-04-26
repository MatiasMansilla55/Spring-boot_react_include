import { createContext, useContext, useEffect, useReducer } from "react";
import { reducer } from "../../Reducer/reducer";
import axios from "axios";

export const ContextGlobal = createContext();

const initialState = {
  BooktSelected: {},
  BookList: [],
  BookRegister:[],
  favs: JSON.parse(localStorage.getItem("favs")) || [],
};

export const ContextProvider = ({ children }) => {
  const [state, dispatch] = useReducer(reducer, initialState);
  const url = "https://localhost:8081/";

  useEffect(() => {
    axios(url).then((res) => dispatch({ type: "GET_LIST", payload: res.data }));
  }, []);
  useEffect(() => {
    localStorage.setItem("favs", JSON.stringify(state.favs));
  }, [state.favs]);

  return (
    <ContextGlobal.Provider value={{ state, dispatch }}>
      {children}
    </ContextGlobal.Provider>
  );
};
export default ContextProvider;

export const useContextGlobal = () => useContext(ContextGlobal);