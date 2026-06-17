# 👥 MS Roles - Inovatech

Microservicio encargado de la administración de roles de usuarios.

Permite:

* Asignar rol por defecto al registrar usuarios
* Consultar roles existentes
* Buscar roles por correo electrónico
* Modificar roles de usuarios

---

# 📌 Tecnologías utilizadas

* Java 21
* Spring Boot 3
* Spring Security
* Spring Data JPA
* H2 Database
* Lombok
* Maven
* Postman

---

# 📦 Dependencias utilizadas

* Spring Web
* Spring Security
* Spring Data JPA
* H2 Database
* Lombok
* DevTools
* Validation
* Spring Boot Starter Test

---

# 🛠 Requisitos previos

## ✅ Java 21

https://www.oracle.com/java/technologies/javase/jdk21-archive-downloads.html

---

## ✅ Maven

https://maven.apache.org/download.cgi

---

## ✅ IntelliJ IDEA

https://www.jetbrains.com/idea/download/

---

## ✅ Postman

https://www.postman.com/downloads/

---

# ⚙ Configuración

## Puerto

server.port=9093

---

# 🗄 Base de datos H2

## Configuración

spring.datasource.url=jdbc:h2:file:./data/rolesdb
spring.datasource.driverClassName=org.h2.Driver
spring.datasource.username=admin
spring.datasource.password=admin

spring.jpa.hibernate.ddl-auto=update

spring.h2.console.enabled=true
spring.h2.console.path=/h2-console

---

# 🧪 Consola H2

Abrir:

http://localhost:9093/h2-console

## Datos conexión

JDBC URL: jdbc:h2:file:./data/rolesdb
User: admin
Password: admin

---

# ▶ Cómo ejecutar

MsRolesApplication

---

# 📡 Endpoints principales

## Crear rol por defecto

POST http://localhost:9090/api/roles/default

---

## Obtener todos los roles

GET http://localhost:9090/api/roles

---

## Buscar rol por correo

GET http://localhost:9090/api/roles/{email}

---

## Cambiar rol

PUT http://localhost:9090/api/roles

Body:

{
"email":"[usuario@test.com](mailto:usuario@test.com)",
"role":"MASTER"
}

---

# 👑 Roles disponibles

* ADMIN
* MASTER
* DEVELOPER

Por defecto todos los usuarios nuevos reciben el rol DEVELOPER.

---

# 🧠 Función del microservicio

Este microservicio:

* Gestiona los roles de los usuarios
* Se comunica con MS Register
* Permite escalar privilegios de usuarios
* Centraliza el control de permisos

---

# 🧪 Tests

mvn test

---

# 👨‍💻 Autores

Camilo Leiva ([cc.leiva@duocuc.cl](mailto:cc.leiva@duocuc.cl))

Nicolas Rivera ([nico.veraf@duocuc.cl](mailto:nico.veraf@duocuc.cl))

Ramiro Gomez ([ra.gomezv@duocuc.cl](mailto:ra.gomezv@duocuc.cl))

Laura Fontecilla ([la.fontecilla@duocuc.cl](mailto:la.fontecilla@duocuc.cl))

## Proyecto desarrollado para Inovatech.
