# user-crud-microsrvice

Aplicación de microservicios para CRUD de usuario en donde se utilizaron tecnologías como **Spring Boot**, **ReactJs**, **Docker**, **Docker Compose** y **MariaDB** como gestor de bases de datos relacionales.

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
