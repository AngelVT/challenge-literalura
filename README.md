<h1 align="center"> Challenge Literalura </h1>

![Badge en Finalizado](https://img.shields.io/badge/STATUS-COMPLETADO-green)

Este proyecto permite registrar y gestionar libros y autores en una base de datos Postgres SQL utilizando Spring Boot y JPA. Se ha integrado con la API de Gutendex para obtener información de libros y sus autores.

## :hammer:Funcionalidades del proyecto

- `Registrar libros en base de datos`
  - Consultar la API de Gutendex y guardar resultados en una base de datos Postgres SQL
  - Si un libro tiene mas de un idioma disponible se guarda un registro de libro por idioma
  - Los autores no se duplican
  - No se pueden registrar libros con el mismo nombre y autor
  - Se pueden registrar libros con el mismo titulo
- `Listar libros registrados en la base de datos`
- `Listar autores registrados en la base de datos`
- `Listar autores vivos en un año dado`
- `Listar libros registrados en la db por un idioma dado`
- `Buscar autores en la base de datos por nombre`
- `Listar los 10 libros mas descargados`

## Pre-requisitos 📋

- La base de datos debe ser creada previamente, las tablas se generan durante la primer ejecucion
- EL proyecto toma variables de entorno para realizar la conexion a la base de datos las variables deben ser las siguientes
  - `LIT_DB_HOST`='nombre del host'
  - `LIT_DB_PORT`='puerto de la base de datos'
  - `LIT_DB_NAME`='nombre de base de datos'
  - `LIT_DB_USER`='usuario de base de datos'
  - `LIT_DB_PASSWORD`='contraseña de base de datos'
 
## Tecnologias usadas 🛠️

* Java
* Spring
* Postgres
