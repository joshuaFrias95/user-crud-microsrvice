class Fetch {
  BASE_URL;

  constructor(baseUrl) {
    this.BASE_URL = baseUrl;
  }

  async get(path) {
    const PORT = 8080;
    const URL = `${this.BASE_URL}${PORT}/api/v1${path}`;
    try {
      const res = await fetch(URL, {
        method: "GET",
        headers: {
          "Content-Type": "application/json",
        },
      });
      const data = await res.json();
      return data;
    } catch (error) {
      console.error("Error al realizar la solicitud GET:", error);
      throw error;
    }
  }

  async post(path, body) {
    const PORT = 8081;
    const URL = `${this.BASE_URL}:${PORT}/api/v1${path}`;
    try {
      const res = await fetch(URL, {
        method: "POST",
        headers: {
          "Content-Type": "application/json",
        },
        body: JSON.stringify(body),
      });
      const data = await res.json();
      return data;
    } catch (error) {
      console.error("Error al realizar la solicitud POST:", error);
      throw error;
    }
  }

  async delete(path) {
    const PORT = 8082;
    const URL = `${this.BASE_URL}:${PORT}/api/v1${path}`;
    try {
      const res = await fetch(URL, {
        method: "DELETE",
        headers: {
          "Content-Type": "application/json",
        },
      });
      const data = await res.json();
      return data;
    } catch (error) {
      console.error("Error al realizar la solicitud DELETE:", error);
      throw error;
    }
  }

  async put(path, body) {
    const PORT = 8083;
    const URL = `${this.BASE_URL}:${PORT}/api/v1${path}`;
    try {
      const res = await fetch(URL, {
        method: "PUT",
        headers: {
          "Content-Type": "application/json",
        },
        body: JSON.stringify(body),
      });
      const data = await res.json();
      return data;
    } catch (error) {
      console.error("Error al realizar la solicitud PUT:", error);
      throw error;
    }
  }

 
}

export const apiRequest = new Fetch("http://localhost:");
