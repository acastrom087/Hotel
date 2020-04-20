CREATE TABLE h.empleado
(
id SERIAL PRIMARY KEY,
cedula INTEGER NOT NULL,
nombre TEXT NOT NULL,
correo TEXT NOT NULL,
usuario TEXT NOT NULL,
contrasena TEXT NOT NULL,
tipo TEXT NOT NULL,
activo BOOLEAN DEFAULT TRUE
);

CREATE TABLE h.hotel
(
id SERIAL PRIMARY KEY,
fila INT NOT NULL,
columna INT NOT NULL
);

CREATE TABLE h.habitacion
(
id SERIAL PRIMARY KEY,
capacidad_max INT NOT NULL,
capacidad_min INT NOT NULL,
tipo TEXT NOT NULL,
precio_noche INT NOT NULL,
disponible BOOLEAN NOT NULL,
activo BOOLEAN NOT NULL
);

CREATE TABLE h.cliente
(
id SERIAL PRIMARY KEY,
cedula INT NOT NULL UNIQUE,
nombre TEXT NOT NULL,
celular INT NOT NULL,
correo TEXT NOT NULL UNIQUE
);

CREATE TABLE h.reserva
(
id SERIAL PRIMARY KEY,
fecha_entrada DATE NOT NULL,
fecha_salida DATE NOT NULL,
id_cliente INT NOT NULL,
id_habitacion INT NOT NULL,
id_empleado INT NOT NULL
);


ALTER TABLE h.reserva
ADD FOREIGN KEY (id_cliente)
REFERENCES h.cliente(id),
ADD FOREIGN KEY (id_habitacion)
REFERENCES h.habitacion(id),
ADD FOREIGN KEY (id_empleado)
REFERENCES h.empleado(id)


select * from h.cliente
where lower(nombre) like lower('%') or cedula = '204250348'

drop table h.cliente

INSERT INTO h.habitacion (capacidad_max, capacidad_min, tipo, precio_noche, disponible, activo)
VALUES (
		'6',
		'2',
		'Matrimonial',
		'15000',
		'true',
		'true');
INSERT INTO h.habitacion (capacidad_max, capacidad_min, tipo, precio_noche, disponible, activo)
VALUES (
		'4',
		'2',
		'Doble',
		'10000',
		'true',
		'true');
INSERT INTO h.habitacion (capacidad_max, capacidad_min, tipo, precio_noche, disponible, activo)
VALUES (
		'2',
		'2',
		'Sencilla',
		'12000',
		'true',
		'true');
INSERT INTO h.habitacion (capacidad_max, capacidad_min, tipo, precio_noche, disponible, activo)
VALUES (
		'6',
		'2',
		'suite presidencial',
		'10000',
		'true',
		'true'
);

INSERT INTO h.cliente (cedula,nombre,celular,correo)
VALUES(
		'207840734',
		'Anthony',
		'84203507',
		'acastrom087gmail.com'
);

INSERT INTO h.cliente (cedula,nombre,celular,correo)
VALUES(
		'204250348',
		'Marielos',
		'89850708',
		'acastrom087gmail.com'
);


SELECT *
FROM h.cliente

select* 
from h.habitacion

select*
from h.reserva
where fecha_salida = between

select* 
from h.empleado

delete from h.reserva where id = 1

UPDATE h.empleado
set tipo = 'a'
WHERE id =1

select r.*, c.nombre, e.nombre
FROM h.reserva r
join h.cliente c
on r.id_cliente = c.id
join h.empleado e
on e.id = r.id_empleado




