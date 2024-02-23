CREATE TABLE Pacientes(
	pdni INT NOT NULL,
	pnombreyape VARCHAR(50) NOT NULL,
	ptel BIGINT NOT NULL,
	pfecNac DATE NOT NULL,
	pedad INT NOT NULL,
	psexo CHAR(10) NOT NULL,
	PRIMARY KEY (pdni)
);

CREATE TABLE Orden(
	nroOrden INT NOT NULL,
	ofec DATE NOT NULL,
	obras VARCHAR(10) NOT NULL,
	pdni INT NOT NULL,
	PRIMARY KEY (nroOrden),
	FOREIGN KEY (pdni) REFERENCES Pacientes(pdni)
);

CREATE TABLE Analisis(
	anombre VARCHAR(50) NOT NULL,
	acod INT NOT NULL,
	adescripcion VARCHAR(100) NOT NULL,
	PRIMARY KEY (acod)
);

CREATE TABLE Resultados(
	resultado VARCHAR(100) DEFAULT 'SIN RESULTADO',
	rfec DATE NOT NULL,
	nroOrden INT NOT NULL,
	acod INT NOT NULL,
	FOREIGN KEY (acod) REFERENCES Analisis(acod),
	FOREIGN KEY (nroOrden) REFERENCES Orden(nroOrden)
);

CREATE TABLE Insumos(
	icod INT NOT NULL,
	tipo VARCHAR(50) NOT NULL,
	inombre VARCHAR(30) NOT NULL,
	istock INT DEFAULT 0,
	istock_min INT DEFAULT 0,
	PRIMARY KEY(icod)
);

CREATE TABLE Usainsumos(
	icod INT NOT NULL,
	acod INT NOT NULL,
	cant INT NOT NULL,
	PRIMARY KEY (icod,acod),
	FOREIGN KEY (acod) REFERENCES Analisis(acod),
	FOREIGN KEY (icod) REFERENCES Insumos(icod)
);


CREATE TABLE Indicaciones(
	nombreind VARCHAR(50) NOT NULL,
	idescripcion VARCHAR(100),
	PRIMARY KEY (nombreind)
); 

CREATE TABLE IndicacionesAnalisis(
	nombreind VARCHAR(50) NOT NULL,
	acod INT NOT NULL,
	PRIMARY KEY (nombreind, acod),
	FOREIGN KEY (acod) REFERENCES Analisis(acod),
	FOREIGN KEY (nombreind) REFERENCES Indicaciones(nombreind)
);

-- Inserciones en la tabla "analisis"
INSERT INTO analisis (anombre, acod, adescripcion) VALUES ('Análisis K', 11, 'Descripción del análisis K');
INSERT INTO analisis (anombre, acod, adescripcion) VALUES ('Análisis L', 12, 'Descripción del análisis L');
INSERT INTO analisis (anombre, acod, adescripcion) VALUES ('Análisis M', 13, 'Descripción del análisis M');
INSERT INTO analisis (anombre, acod, adescripcion) VALUES ('Análisis N', 14, 'Descripción del análisis N');
INSERT INTO analisis (anombre, acod, adescripcion) VALUES ('Análisis O', 15, 'Descripción del análisis O');
INSERT INTO analisis (anombre, acod, adescripcion) VALUES ('Análisis P', 16, 'Descripción del análisis P');
INSERT INTO analisis (anombre, acod, adescripcion) VALUES ('Análisis Q', 17, 'Descripción del análisis Q');
INSERT INTO analisis (anombre, acod, adescripcion) VALUES ('Análisis R', 18, 'Descripción del análisis R');
INSERT INTO analisis (anombre, acod, adescripcion) VALUES ('Análisis S', 19, 'Descripción del análisis S');
INSERT INTO analisis (anombre, acod, adescripcion) VALUES ('Análisis T', 20, 'Descripción del análisis T');

-- Inserciones en la tabla "indicaciones"
INSERT INTO indicaciones (nombreind, idescripcion) VALUES ('Indicación 11', 'Descripción de la indicación 11');
INSERT INTO indicaciones (nombreind, idescripcion) VALUES ('Indicación 12', 'Descripción de la indicación 12');
INSERT INTO indicaciones (nombreind, idescripcion) VALUES ('Indicación 13', 'Descripción de la indicación 13');
INSERT INTO indicaciones (nombreind, idescripcion) VALUES ('Indicación 14', 'Descripción de la indicación 14');
INSERT INTO indicaciones (nombreind, idescripcion) VALUES ('Indicación 15', 'Descripción de la indicación 15');
INSERT INTO indicaciones (nombreind, idescripcion) VALUES ('Indicación 16', 'Descripción de la indicación 16');
INSERT INTO indicaciones (nombreind, idescripcion) VALUES ('Indicación 17', 'Descripción de la indicación 17');
INSERT INTO indicaciones (nombreind, idescripcion) VALUES ('Indicación 18', 'Descripción de la indicación 18');
INSERT INTO indicaciones (nombreind, idescripcion) VALUES ('Indicación 19', 'Descripción de la indicación 19');
INSERT INTO indicaciones (nombreind, idescripcion) VALUES ('Indicación 20', 'Descripción de la indicación 20');

-- Inserciones en la tabla "indicacionesAnalisis"
INSERT INTO indicacionesAnalisis (nombreind, acod) VALUES ('Indicación 11', 11);
INSERT INTO indicacionesAnalisis (nombreind, acod) VALUES ('Indicación 12', 12);
INSERT INTO indicacionesAnalisis (nombreind, acod) VALUES ('Indicación 13', 13);
INSERT INTO indicacionesAnalisis (nombreind, acod) VALUES ('Indicación 14', 14);
INSERT INTO indicacionesAnalisis (nombreind, acod) VALUES ('Indicación 15', 15);
INSERT INTO indicacionesAnalisis (nombreind, acod) VALUES ('Indicación 16', 16);
INSERT INTO indicacionesAnalisis (nombreind, acod) VALUES ('Indicación 17', 17);
INSERT INTO indicacionesAnalisis (nombreind, acod) VALUES ('Indicación 18', 18);
INSERT INTO indicacionesAnalisis (nombreind, acod) VALUES ('Indicación 19', 19);
INSERT INTO indicacionesAnalisis (nombreind, acod) VALUES ('Indicación 20', 20);

-- Inserciones en la tabla "pacientes"
INSERT INTO pacientes (pdni, pnombreyape, ptel, pedad, psexo, pfecnac) VALUES ('98765432', 'Juan Pérez', '12345678', 30, 'M', '1993-05-15');
INSERT INTO pacientes (pdni, pnombreyape, ptel, pedad, psexo, pfecnac) VALUES ('54321678', 'María Rodríguez', '23456789', 25, 'F', '1998-09-22');
INSERT INTO pacientes (pdni, pnombreyape, ptel, pedad, psexo, pfecnac) VALUES ('23456789', 'Carlos Gómez', '34567890', 40, 'M', '1983-03-10');
INSERT INTO pacientes (pdni, pnombreyape, ptel, pedad, psexo, pfecnac) VALUES ('12345678', 'Ana López', '45678901', 35, 'F', '1988-07-18');
INSERT INTO pacientes (pdni, pnombreyape, ptel, pedad, psexo, pfecnac) VALUES ('87654321', 'Lucía Martínez', '56789012', 28, 'F', '1995-11-25');
INSERT INTO pacientes (pdni, pnombreyape, ptel, pedad, psexo, pfecnac) VALUES ('65498732', 'Jorge Fernández', '67890123', 45, 'M', '1978-02-05');
INSERT INTO pacientes (pdni, pnombreyape, ptel, pedad, psexo, pfecnac) VALUES ('78965423', 'Laura González', '78901234', 32, 'F', '1991-12-01');
INSERT INTO pacientes (pdni, pnombreyape, ptel, pedad, psexo, pfecnac) VALUES ('98765489', 'Martín López', '89012345', 27, 'M', '1996-04-08');
INSERT INTO pacientes (pdni, pnombreyape, ptel, pedad, psexo, pfecnac) VALUES ('12349876', 'Sofía Fernández', '90123456', 38, 'F', '1985-08-12');
INSERT INTO pacientes (pdni, pnombreyape, ptel, pedad, psexo, pfecnac) VALUES ('98761234', 'Lucas Rodríguez', '01234567', 33, 'M', '1990-06-30');

-- Inserciones en la tabla "orden"
INSERT INTO orden (nroorden, ofec, obras, pdni) VALUES (11, '2023-06-11', 'ObraK', '98765432');
INSERT INTO orden (nroorden, ofec, obras, pdni) VALUES (12, '2023-06-12', 'ObraL', '54321678');
INSERT INTO orden (nroorden, ofec, obras, pdni) VALUES (13, '2023-06-13', 'ObraM', '23456789');
INSERT INTO orden (nroorden, ofec, obras, pdni) VALUES (14, '2023-06-14', 'ObraN', '12345678');
INSERT INTO orden (nroorden, ofec, obras, pdni) VALUES (15, '2023-06-15', 'ObraO', '87654321');
INSERT INTO orden (nroorden, ofec, obras, pdni) VALUES (16, '2023-06-16', 'ObraP', '65498732');
INSERT INTO orden (nroorden, ofec, obras, pdni) VALUES (17, '2023-06-17', 'ObraQ', '78965423');
INSERT INTO orden (nroorden, ofec, obras, pdni) VALUES (18, '2023-06-18', 'ObraR', '98765489');
INSERT INTO orden (nroorden, ofec, obras, pdni) VALUES (19, '2023-06-19', 'ObraS', '12349876');
INSERT INTO orden (nroorden, ofec, obras, pdni) VALUES (20, '2023-06-20', 'ObraT', '98761234');



-- Inserciones en la tabla "resultados"
INSERT INTO resultados (resultado, rfec, nroorden, acod) VALUES ('Resultado 11', '2023-06-11', 11, 11);
INSERT INTO resultados (resultado, rfec, nroorden, acod) VALUES ('Resultado 12', '2023-06-12', 12, 12);
INSERT INTO resultados (resultado, rfec, nroorden, acod) VALUES ('Resultado 13', '2023-06-13', 13, 13);
INSERT INTO resultados (resultado, rfec, nroorden, acod) VALUES ('Resultado 14', '2023-06-14', 14, 14);
INSERT INTO resultados (resultado, rfec, nroorden, acod) VALUES ('Resultado 15', '2023-06-15', 15, 15);
INSERT INTO resultados (resultado, rfec, nroorden, acod) VALUES ('Resultado 16', '2023-06-16', 16, 16);
INSERT INTO resultados (resultado, rfec, nroorden, acod) VALUES ('Resultado 17', '2023-06-17', 17, 17);
INSERT INTO resultados (resultado, rfec, nroorden, acod) VALUES ('Resultado 18', '2023-06-18', 18, 18);
INSERT INTO resultados (resultado, rfec, nroorden, acod) VALUES ('Resultado 19', '2023-06-19', 19, 19);
INSERT INTO resultados (resultado, rfec, nroorden, acod) VALUES ('Resultado 20', '2023-06-20', 20, 20);


-- Inserciones en la tabla "indicaciones"
INSERT INTO indicaciones (nombreind, idescripcion) VALUES ('Indicación 1', 'Descripción de la indicación 1');
INSERT INTO indicaciones (nombreind, idescripcion) VALUES ('Indicación 2', 'Descripción de la indicación 2');
INSERT INTO indicaciones (nombreind, idescripcion) VALUES ('Indicación 3', 'Descripción de la indicación 3');
INSERT INTO indicaciones (nombreind, idescripcion) VALUES ('Indicación 4', 'Descripción de la indicación 4');
INSERT INTO indicaciones (nombreind, idescripcion) VALUES ('Indicación 5', 'Descripción de la indicación 5');
INSERT INTO indicaciones (nombreind, idescripcion) VALUES ('Indicación 6', 'Descripción de la indicación 6');
INSERT INTO indicaciones (nombreind, idescripcion) VALUES ('Indicación 7', 'Descripción de la indicación 7');
INSERT INTO indicaciones (nombreind, idescripcion) VALUES ('Indicación 8', 'Descripción de la indicación 8');
INSERT INTO indicaciones (nombreind, idescripcion) VALUES ('Indicación 9', 'Descripción de la indicación 9');
INSERT INTO indicaciones (nombreind, idescripcion) VALUES ('Indicación 10', 'Descripción de la indicación 10');

-- Inserciones en la tabla "indicacionesAnalisis"
INSERT INTO indicacionesAnalisis (nombreind, acod) VALUES ('Indicación 1', 1);
INSERT INTO indicacionesAnalisis (nombreind, acod) VALUES ('Indicación 2', 2);
INSERT INTO indicacionesAnalisis (nombreind, acod) VALUES ('Indicación 3', 1);
INSERT INTO indicacionesAnalisis (nombreind, acod) VALUES ('Indicación 4', 11);
INSERT INTO indicacionesAnalisis (nombreind, acod) VALUES ('Indicación 5', 12);
INSERT INTO indicacionesAnalisis (nombreind, acod) VALUES ('Indicación 6', 13);
INSERT INTO indicacionesAnalisis (nombreind, acod) VALUES ('Indicación 7', 14);
INSERT INTO indicacionesAnalisis (nombreind, acod) VALUES ('Indicación 8', 15);
INSERT INTO indicacionesAnalisis (nombreind, acod) VALUES ('Indicación 9', 16);
INSERT INTO indicacionesAnalisis (nombreind, acod) VALUES ('Indicación 10', 17);

