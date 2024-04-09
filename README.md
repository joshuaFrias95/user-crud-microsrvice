# user-crud-microsrvice

Aplicación de microservicios para CRUD de usuario en donde se utilizaron tecnologías como **Spring Boot**, **ReactJs**, **Docker**, **Docker Compose** y **MariaDB** como gestor de bases de datos relacionales.

<br>

## Método de ejecución
- **Ejecución de todos los contenedores:**
```
cd Backend/
docker-compose up
```
- **En una sola linea:**
```
cd Backend/ && docker-compose up
```
<br>


## Características
- Sistema de microservicios orquestado en Docker Compose
  
  - `localhost:8080` --> read-service
  - `localhost:8081` --> create-service
  - `localhost:8082` --> delete-service
  - `localhost:8083` --> update-service
    
- Sistema de validaciones en input de datos
- Base de datos embebida en servidor Docker
- Pruebas unitarias para testeo de los endpoints de entrada de datos
- Documentación vía Swagger
  
  - **Documentación y prueba de endpoints de lectura:** `http://localhost:8080/swagger-ui.html`
  - **Documentación y prueba de endpoints de escritura:** `http://localhost:8081/swagger-ui.html`
  - **Documentación y prueba de endpoints de eliminado de registro:** `http://localhost:8082/swagger-ui.html`
  - **Documentación y prueba de endpoints de actualización:** `http://localhost:8083/swagger-ui.html`
    
- Actualización de datos de registro totales o unitarios

<br>

## Dificultades en el desarrollo
Este proyecto ha sido un acertijo muy interesante que me ha traido áreas de oportunidad a mejorar. El reto más grande fue el dividir un sistema tan común y unitario como lo es un CRUD de un usuario manteniendo las mejores prácticas, además de la conexión con el cliente FrontEnd debido a la dificultad que la configuración de CORS traía.

No obstante, ha sido un gran reto y estoy emocionado de seguirlo desarrollando poco a poco para pulir mis habilidades.

<br>


## Arquitectura

La arquitectura interna se planificó de forma en que cada operación CRUD (_CREATE, READ, UPDATE, DELETE) funcionara como un microservicio independiente de los demás pero que compartieran la misma base de datos. Se utilizó Docer Compose para gestionar y conectar internamente cada uno de sus servicios dockerizados previamente.

La aplicación permite crear un usuario, leer su información, modificar sus datos o eliminarlos.

<a href='https://postimages.org/' target='_blank'><img src='https://i.postimg.cc/fR4RzRCH/esquema-prueba-tecnica.jpg' height='560' border='50' alt='esquema-prueba-tecnica'/></a>

----
<br>

# Pregunta de prueba técnica

> [!PREGUNTA]  
> EL cliente le ha reportado que existe un problema en su módulo de autenticación de usuario (página inicial), al ingresar los valores de usuario, contraseña y captcha correctamente, siempre le arroja el mensaje _"Usuario incorrecto, verificar los valores ingresados"_. Explique los pasos que a su consideración debe realizar para identificar el comportamiento del sistema y pueda entregar la resolución del planteamiento, considere que el usuario no es técnico y no le puede proporcionar el código fuente de su aplicación, pero si le puede entregar empaquetado, desplegado en producción.

> [!Respuesta]  
> Primero intentaria saber si el usuario ya habia realizado un registro previo; de no haberse registrado le indicaría el proceso para registrarse, de ser lo contrario revisaria con el usuario los datos que está realizando pues el mensaje es "_Usuaruo incorrecto, verificar los valores ingresados_", por ende, es muy posible que debamos revisar que sus datos de ingreso sean los correctos.



💙💙 **¡MUCHAS GRACIAS ENGINE CORE POR ESTE RETO!** 💙💙
