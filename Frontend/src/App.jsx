import { useState, useEffect } from "react";
import "./styles/App.css";
import { apiRequest } from "./utils/fetch";

function App() {
  const [data, setData] = useState(null);

  const handleGetUsers = () => {
    apiRequest.get('/users')
  };

  return (
    <>
      <div></div>
      <div>adios</div>
      <button onClick={handleGetUsers}>Traer Datos de usuario</button>
    </>
  );
}

export default App;
