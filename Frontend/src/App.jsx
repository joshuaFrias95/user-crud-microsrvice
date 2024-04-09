import { useEffect } from "react";
import "./styles/App.css";

function App() {
  useEffect(() => {
    const handleGetUser = async () => {
      try {
        const res = await fetch("http://http://read-service:8080/api/v1/users", {
            method: "GET",
            headers: {
                "Content-Type": "application/json",
                "Origin": "http://localhost:3000"
            },
        });
        const data = await res.json();
        console.log(data);
      } catch (error) {
        console.error(error);
      }
    };
    handleGetUser();
  }, []);

  return (
    <div>
        <div>Datos de usuario</div>
            <p>{data}</p>
            <button>Traer datos</button>
        </div>
  );
}

export default App;