-- Crear la tabla de alumnos
CREATE TABLE alumnos (
                         id SERIAL PRIMARY KEY,
                         nombre VARCHAR(100) NOT NULL,
                         apellido VARCHAR(100) NOT NULL,
                         edad INT NOT NULL
);

-- Insertar 10 alumnos de ejemplo
INSERT INTO alumnos (nombre, apellido, edad) VALUES
                                                 ('Juan', 'Pérez', 20),
                                                 ('María', 'González', 22),
                                                 ('Carlos', 'Rodríguez', 21),
                                                 ('Ana', 'Martínez', 23),
                                                 ('Luis', 'Sánchez', 20),
                                                 ('Laura', 'Fernández', 22),
                                                 ('Pedro', 'López', 21),
                                                 ('Sofía', 'Díaz', 23),
                                                 ('Diego', 'Torres', 20),
                                                 ('Valentina', 'Ruiz', 22);