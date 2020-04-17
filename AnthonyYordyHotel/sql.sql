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
		'matrimonial',
		'10000',
		'true',
		'true'
);
select* 
from h.habitacion

select* 
from h.empleado

delete from h.habitacion where id = 25

UPDATE h.empleado
set tipo = 'e'
WHERE id =2



