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

delete from h.habitacion where id = 25

UPDATE h.empleado
set tipo = 'e'
WHERE id =2



