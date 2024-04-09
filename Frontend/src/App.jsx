import "./styles/App.css";
import { apiRequest } from "./utils/fetch";

function App() {
  const handleGetUsers = async () => {
    console.log(await apiRequest.get("/user/1"));
  };

  return (
    <>
      <div>adios</div>
      <button onClick={handleGetUsers}>Traer Datos de usuario</button>
    </>
  );
}

export default App;
