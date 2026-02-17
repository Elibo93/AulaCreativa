-- =========================
-- PROFESORES (5)
-- =========================
INSERT INTO profesores
(nombre, apellido, especialidad, email, telefono, created_at)
VALUES
('Lucía', 'García', 'Dibujo y pintura', 'lucia.garcia@aulacreativa.local', '+34600111222', NOW()),
('Carlos', 'Martín', 'Música - Guitarra', 'carlos.martin@aulacreativa.local', '+34600222333', NOW()),
('Marta', 'López', 'Teatro y expresión', 'marta.lopez@aulacreativa.local', '+34600333444', NOW()),
('Javier', 'Ruiz', 'Escultura', 'javier.ruiz@aulacreativa.local', '+34600444555', NOW()),
('Ana', 'Santos', 'Ilustración digital', 'ana.santos@aulacreativa.local', '+34600555666', NOW());

-- TALLERES (5)
INSERT INTO talleres 
(nombre, descripcion, id_profesor, hora_inicio, hora_fin, aforo_maximo)VALUES 
('Taller de Dibujo Básico', 'Introducción al dibujo: líneas, formas y sombreado.', 1, '17:00', '19:00', 12),
('Guitarra para Principiantes', 'Acordes básicos, ritmos y primeras canciones.', 2, '18:00', '20:00', 10),
('Teatro Infantil', 'Juegos dramáticos y expresión corporal para niños.', 3, '16:30', '18:00', 15),
('Escultura en Arcilla', 'Técnicas básicas de modelado y acabado.', 4, '10:00', '12:30', 8),
('Ilustración Digital Avanzada', 'Técnicas avanzadas en tableta gráfica y retoque.', 5, '19:00', '21:00', 10);

-- ALUMNOS (20)
INSERT INTO alumnos
(dni, nombre, apellido, email, telefono, direccion, fecha_nacimiento, created_at) VALUES
('12345678A', 'Diego', 'Romero', 'diego.romero@local', '600000001', 'C/ Sol 1, Madrid', '2001-03-10', NOW()),
('23456789B', 'Lucía', 'Martínez', 'lucia.martinez@local', '600000002', 'C/ Luna 2, Sevilla', '2003-07-22', NOW()),
('34567890C', 'Carlos', 'Santos', 'carlos.santos@local', '600000003', 'C/ Río 3, Valencia', '1999-11-11', NOW()),
('45678901D', 'Marta', 'López', 'marta.lopez@local', '600000004', 'C/ Mar 4, Barcelona', '2002-01-05', NOW()),
('56789012E', 'Javier', 'García', 'javier.garcia@local', '600000005', 'C/ Álamo 5, Bilbao', '2000-05-17', NOW()),
('67890123F', 'Paula', 'Ruiz', 'paula.ruiz@local', '600000006', 'C/ Cedro 6, Málaga', '2004-08-30', NOW()),
('78901234G', 'Raúl', 'Fernández', 'raul.fernandez@local', '600000007', 'C/ Oro 7, Zaragoza', '1998-12-14', NOW()),
('89012345H', 'Sofía', 'Gómez', 'sofia.gomez@local', '600000008', 'C/ Bronce 8, Madrid', '2003-09-25', NOW()),
('90123456J', 'Adrián', 'Hernández', 'adrian.hernandez@local', '600000009', 'C/ Pino 9, Cádiz', '2001-02-02', NOW()),
('01234567K', 'Laura', 'Sanz', 'laura.sanz@local', '600000010', 'C/ Fresno 10, Murcia', '2000-10-20', NOW()),
('11223344L', 'David', 'Torres', 'david.torres@local', '600000011', 'C/ Olivo 11, Salamanca', '2005-03-08', NOW()),
('22334455M', 'Clara', 'Vega', 'clara.vega@local', '600000012', 'C/ Roble 12, Valladolid', '2002-06-15', NOW()),
('33445566N', 'Álvaro', 'Iglesias', 'alvaro.iglesias@local', '600000013', 'C/ Haya 13, Pamplona', '1999-04-01', NOW()),
('44556677P', 'Irene', 'Mora', 'irene.mora@local', '600000014', 'C/ Olmo 14, León', '2003-12-12', NOW()),
('55667788Q', 'Sergio', 'Navarro', 'sergio.navarro@local', '600000015', 'C/ Águila 15, Málaga', '2001-09-09', NOW()),
('66778899R', 'Natalia', 'Prado', 'natalia.prado@local', '600000016', 'C/ Laurel 16, Logroño', '2000-07-27', NOW()),
('77889900S', 'Tomás', 'Rey', 'tomas.rey@local', '600000017', 'C/ Lago 17, Burgos', '1998-11-29', NOW()),
('88990011T', 'Elena', 'Bueno', 'elena.bueno@local', '600000018', 'C/ Verde 18, Santander', '2004-05-06', NOW()),
('99001122V', 'Pablo', 'Casado', 'pablo.casado@local', '600000019', 'C/ Encina 19, Murcia', '2002-02-21', NOW()),
('11112222W', 'Rosa', 'Delgado', 'rosa.delgado@local', '600000020', 'C/ Castaño 20, Granada', '1999-08-18', NOW());

-- TALLERES (30)
INSERT INTO inscripciones (id_alumno, id_taller, created_at) VALUES
-- Taller 1 (8 inscripciones)
(1, 1, NOW()),
(2, 1, NOW()),
(3, 1, NOW()),
(4, 1, NOW()),
(5, 1, NOW()),
(6, 1, NOW()),
(7, 1, NOW()),
(8, 1, NOW()),

-- Taller 2 (6 inscripciones)
(3, 2, NOW()),
(4, 2, NOW()),
(8, 2, NOW()),
(9, 2, NOW()),
(10, 2, NOW()),
(11, 2, NOW()),

-- Taller 3 (6 inscripciones)
(5, 3, NOW()),
(6, 3, NOW()),
(7, 3, NOW()),
(12, 3, NOW()),
(13, 3, NOW()),
(14, 3, NOW()),

-- Taller 4 (5 inscripciones)
(15, 4, NOW()),
(16, 4, NOW()),
(17, 4, NOW()),
(18, 4, NOW()),
(10, 4, NOW()),

-- Taller 5 (5 inscripciones)
(1, 5, NOW()),
(2, 5, NOW()),
(6, 5, NOW()),
(11, 5, NOW()),
(20, 5, NOW());
