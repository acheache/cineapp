# project cineapp


Pasos para correr el aplicativo:


1.-Ejecutar los siguientes comandos para levantar Postgresql:

docker pull postgres:9.6.6-alpine

docker run -d --name postgres -p 5432:5432 -e POSTGRES_PASSWORD=ache postgres:9.6.6-alpine

2.-Ejecutar los siguientes comandos para clonar el repositorio y arrancar el aplicativo: 

git clone https://github.com/acheache/cineapp.git

mvn spring-boot:run

Entrar a la siguiente url para ver la documentacion:

localhost:8080/swagger-ui.html

![alt tag](https://github.com/acheache/cineapp/blob/master/documentacion.JPG)
