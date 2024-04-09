import { useState } from "react";

function Form() {
  const [nombre, setNombre] = useState("");

  const handleChange = (event) => {
    setNombre(event.target.value);
  };

  const handleSubmit = (event) => {
    event.preventDefault();
    alert(`¡Hola, ${nombre}!`);
  };

  return (
    <div>
      <h1>Formulario React</h1>
      <form onSubmit={handleSubmit}>
        <label>
          Nombre:
          <input type="text" value={nombre} onChange={handleChange} />
        </label>
        <button type="submit">Enviar</button>
      </form>
    </div>
  );
}

export default Form;
