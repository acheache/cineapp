# project cineapp


Pasos para correr el aplicativo:


1.-Ejecutar los siguentes comandos para levantar Postgresql:
docker pull postgres:9.6.6-alpine
docker run -d --name postgres -p 5432:5432 -e POSTGRES_PASSWORD=ache postgres:9.6.6-alpine

2.-Ejecutar los siguentes comandos para clonar el repositorio y arrancar el aplicativo: 
git clone https://github.com/acheache/cineapp.git
mvn spring-boot:run
