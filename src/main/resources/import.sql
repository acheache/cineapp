/* Populate turno y pelicula  */
insert into turno(id_turno,turno,estado) values (1,'13:30:00','Activo');
insert into turno(id_turno,turno,estado) values (2,'15:00:00','Inactivo');
insert into pelicula(id_pelicula,nombre,fecha_publicacion,estado,id_turno) values (1,'X Men: Dias del futuro pasado','2016/05/10','activo',1);
insert into pelicula(id_pelicula,nombre,fecha_publicacion,estado,id_turno) values (2,'Locos de amor','2016/05/24','Inactivo',2);