-- Creación de la secuencia para solicitud_herramienta

CREATE SEQUENCE seq_solicitud START 1;

-- Función para generar IDs alfanuméricos
CREATE OR REPLACE FUNCTION gen_id(prefix TEXT, seq_name TEXT) RETURNS TEXT AS $$
DECLARE
    seq_val BIGINT;
BEGIN
    EXECUTE format('SELECT nextval(''%s'')', seq_name) INTO seq_val;
    RETURN prefix || LPAD(seq_val::TEXT, 3, '0');
END;
$$ LANGUAGE plpgsql;

CREATE TABLE herramienta (
    id_herramienta VARCHAR(6) PRIMARY KEY,
    nombre_herramienta VARCHAR(50),
    modelo VARCHAR(50),
    nombre_proveedor VARCHAR(50),
	disponible BOOLEAN DEFAULT TRUE
);

CREATE TABLE gestor_produccion
(
  id_gestor CHAR(6) NOT NULL,
  dni CHAR(8) NOT NULL,
  prim_nom_ges VARCHAR(50) NOT NULL,
  seg_nom_ges VARCHAR(50) NOT NULL,
  prim_ape_ges VARCHAR(50) NOT NULL,
  seg_ape_ges VARCHAR(50) NOT NULL,
  PRIMARY KEY (id_gestor)
);

CREATE TABLE actividad
(
  id_actividad CHAR(6) NOT NULL,
  nombre_actividad VARCHAR(50) NOT NULL,
  PRIMARY KEY (id_actividad)
);

CREATE TABLE lote
(
  id_lote CHAR(6) NOT NULL,
  fecha_produccion DATE NOT NULL,
  cant_prod INT NOT NULL,
  PRIMARY KEY (id_lote)
);

CREATE TABLE gestor_produccion_telefono
(
  telefono VARCHAR(9) NOT NULL,
  id_gestor CHAR(6) NOT NULL,
  PRIMARY KEY (telefono, id_gestor),
  FOREIGN KEY (id_gestor) REFERENCES gestor_produccion(id_gestor)
);

CREATE TABLE categoria_taller
(
  id_cate_taller CHAR(6) NOT NULL,
  nom_cate_taller VARCHAR(50) NOT NULL,
  PRIMARY KEY (id_cate_taller)
);

CREATE TABLE estado_asignacion
(
  id_est_asignacion CHAR(6) NOT NULL,
  nom_est_asignacion VARCHAR(50) NOT NULL,
  PRIMARY KEY (id_est_asignacion)
);

CREATE TABLE taller
(
  id_taller CHAR(6) NOT NULL,
  capacidad_taller INT NOT NULL,
  id_cate_taller CHAR(6) NOT NULL,
  PRIMARY KEY (id_taller),
  FOREIGN KEY (id_cate_taller) REFERENCES categoria_taller(id_cate_taller)
);

CREATE TABLE operario
(
  id_operario CHAR(6) NOT NULL,
  prim_nom_op VARCHAR(50) NOT NULL,
  seg_nom_op VARCHAR(50) NOT NULL,
  prim_ape_op VARCHAR(50) NOT NULL,
  seg_ape_op VARCHAR(50) NOT NULL,
  dni CHAR(8) NOT NULL,
  id_taller CHAR(6) NOT NULL,
  PRIMARY KEY (id_operario),
  FOREIGN KEY (id_taller) REFERENCES taller(id_taller)
);

CREATE TABLE asignacion_actividad
(
  fecha_asig DATE NOT NULL,
  hora_inicio TIME NOT NULL,
  hora_fin TIME NOT NULL,
  id_asignacion CHAR(6) NOT NULL,
  id_gestor CHAR(6) NOT NULL,
  id_lote CHAR(6) NOT NULL,
  id_actividad CHAR(6) NOT NULL,
  id_operario CHAR(6) NOT NULL,
  id_est_asignacion CHAR(6) NOT NULL,
  PRIMARY KEY (id_asignacion),
  FOREIGN KEY (id_gestor) REFERENCES gestor_produccion(id_gestor),
  FOREIGN KEY (id_lote) REFERENCES lote(id_lote),
  FOREIGN KEY (id_actividad) REFERENCES actividad(id_actividad),
  FOREIGN KEY (id_operario) REFERENCES operario(id_operario),
  FOREIGN KEY (id_est_asignacion) REFERENCES estado_asignacion(id_est_asignacion)
);

CREATE TABLE operario_telefono
(
  telefono CHAR(9) NOT NULL,
  id_operario CHAR(6) NOT NULL,
  PRIMARY KEY (telefono, id_operario),
  FOREIGN KEY (id_operario) REFERENCES operario(id_operario)
);
CREATE TABLE estado_soli_herra(
	id_est_soli_herra VARCHAR(6) PRIMARY KEY,
	nom_est_soli_herra VARCHAR(50) DEFAULT 'Pendiente'
);
CREATE TABLE solicitud_herramienta (
    id_solicitud VARCHAR(10) PRIMARY KEY DEFAULT gen_id('SOL', 'seq_solicitud'),
    fecha_solicitud TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
    id_est_soli_herra VARCHAR(6) NOT NULL,
    id_operario VARCHAR(6) NOT NULL,
    id_gestor VARCHAR(6),
	id_herramienta VARCHAR(6) NOT NULL,
    FOREIGN KEY (id_operario) REFERENCES operario(id_operario),
	FOREIGN KEY (id_herramienta) REFERENCES herramienta(id_herramienta),
    FOREIGN KEY (id_gestor) REFERENCES gestor_produccion(id_gestor),
	FOREIGN KEY (id_est_soli_herra) REFERENCES estado_soli_herra(id_est_soli_herra)
);
	

CREATE TABLE mantenimiento_herramienta (
    id_mantenimiento_herramienta VARCHAR(6) PRIMARY KEY,
    tipo_mantenimiento VARCHAR(50),
    fecha_mantenimiento DATE NOT NULL,
    estado VARCHAR(50),
    descripcion_mantenimiento TEXT,
    id_herramienta VARCHAR(6) NOT NULL,
    FOREIGN KEY (id_herramienta) REFERENCES herramienta(id_herramienta)
);
CREATE TABLE Estado_Reclamo
(
 Id_estado_reclamo CHAR(6) NOT NULL,
 Nom_estado_reclamo VARCHAR(50) NOT NULL,
 PRIMARY KEY (Id_estado_reclamo)
);

CREATE TABLE Descripcion_reclamo
(
 Id_descrip_reclamo CHAR(6) NOT NULL,
 Nom_descrip_reclamo VARCHAR(50) NOT NULL,
 PRIMARY KEY (Id_descrip_reclamo)
);

CREATE TABLE Reclamo
(
 Id_reclamo CHAR(6) NOT NULL,
 Fecha_reclamo DATE NOT NULL,
 Id_operario CHAR(6) NOT NULL,
 Id_descrip_reclamo CHAR(6) NOT NULL,
 Id_estado_reclamo CHAR(6) NOT NULL,
 PRIMARY KEY (Id_reclamo),
 FOREIGN KEY (Id_operario) REFERENCES Operario(Id_operario),
 FOREIGN KEY (Id_descrip_reclamo) REFERENCES Descripcion_reclamo(Id_descrip_reclamo),
 FOREIGN KEY (Id_estado_reclamo) REFERENCES Estado_Reclamo(Id_estado_reclamo)
);

CREATE TABLE Estado_Observacion
(
 Id_estado_observacion CHAR(6) NOT NULL,
 Nom_estado_observacion VARCHAR(50) NOT NULL,
 PRIMARY KEY (Id_estado_observacion)
);

CREATE TABLE Descripcion_observacion
(
 Id_descrip_observacion CHAR(6) NOT NULL,
 Nom_descrip_observacion VARCHAR(50) NOT NULL,
 PRIMARY KEY (Id_descrip_observacion)
);

CREATE TABLE Observacion
(
 Id_observacion CHAR(6) NOT NULL,
 Fecha_observacion DATE NOT NULL,
 id_asignacion CHAR(6) NOT NULL,
 Id_descrip_observacion CHAR(6) NOT NULL,
 Id_estado_observacion CHAR(6) NOT NULL,
 PRIMARY KEY (Id_observacion),
 FOREIGN KEY (id_asignacion) REFERENCES asignacion_actividad(id_asignacion),
 FOREIGN KEY (Id_descrip_observacion) REFERENCES Descripcion_observacion(Id_descrip_observacion),
 FOREIGN KEY (Id_estado_observacion) REFERENCES Estado_Observacion(Id_estado_observacion)
);

CREATE TABLE Reporte_reclamo
(
    Id_reporte CHAR(9) NOT NULL,
    Fecha_reporte DATE NOT NULL,
    Hora_reporte TIME NOT NULL,
    Id_gestor CHAR(6) NOT NULL,
    PRIMARY KEY (id_reporte),
    FOREIGN KEY (id_gestor) REFERENCES gestor_produccion(id_gestor)
);

CREATE VIEW Reporte_Reclamos_Por_Fecha AS
SELECT Fecha_reclamo, COUNT(*) AS Numero_de_Reclamos
FROM Reclamo
GROUP BY Fecha_reclamo;

CREATE VIEW Reporte_Reclamos_Por_Descripcion AS
SELECT D.Nom_descrip_reclamo, COUNT(*) AS Numero_de_Reclamos
FROM Reclamo R
JOIN Descripcion_reclamo D ON R.Id_descrip_reclamo = D.Id_descrip_reclamo
GROUP BY D.Nom_descrip_reclamo;

CREATE VIEW Reporte_Reclamos_Por_Estado AS
SELECT E.Nom_estado_reclamo, COUNT(*) AS Numero_de_Reclamos
FROM Reclamo R
JOIN Estado_Reclamo E ON R.Id_estado_reclamo = E.Id_estado_reclamo
GROUP BY E.Nom_estado_reclamo;

CREATE VIEW Reporte_Reclamos_Por_Operario AS
SELECT O.Id_operario, COUNT(*) AS Numero_de_Reclamos
FROM Reclamo R
JOIN Operario O ON R.Id_operario = O.Id_operario
GROUP BY O.Id_operario;


CREATE TABLE Reporte_herramienta (
    id_reporte SERIAL PRIMARY KEY,
    categoria VARCHAR(50),
    valor VARCHAR(50),
    cantidad INT
);

INSERT INTO Reporte_herramienta (categoria, valor, cantidad)
SELECT 'Nombre de herramienta' AS categoria, nombre_herramienta AS valor, COUNT(*) AS cantidad
FROM herramienta
GROUP BY nombre_herramienta;
INSERT INTO Reporte_herramienta (categoria, valor, cantidad)
SELECT 'Proveedor de herramienta' AS categoria, nombre_proveedor AS valor, COUNT(*) AS cantidad
FROM herramienta
GROUP BY nombre_proveedor;
INSERT INTO Reporte_herramienta (categoria, valor, cantidad)
SELECT 'Modelo de herramienta' AS categoria, modelo AS valor, COUNT(*) AS cantidad
FROM herramienta
GROUP BY modelo;

SELECT * FROM Reporte_herramienta
WHERE categoria = 'Nombre de herramienta';
SELECT * FROM Reporte_herramienta
WHERE categoria = 'Proveedor de herramienta';
SELECT * FROM Reporte_herramienta
WHERE categoria = 'Modelo de herramienta';

CREATE TABLE Tipo_deduccion
(
 Id_tipo_deduccion CHAR(6) NOT NULL,
 Nom_tipo_deduccion VARCHAR(50) NOT NULL,
 PRIMARY KEY (Id_tipo_deduccion)
);

CREATE TABLE Deduccion
(
 Id_deduccion CHAR(6) NOT NULL,
 Monto_deducido FLOAT NOT NULL,
 Id_tipo_deduccion CHAR(6) NOT NULL,
 Id_nomina CHAR(6) NOT NULL,
 PRIMARY KEY (Id_deduccion),
 FOREIGN KEY (Id_tipo_deduccion) REFERENCES Tipo_deduccion(Id_tipo_deduccion)
);

CREATE TABLE Tipo_Sueldo_Base
(
    Id_sueldo_base CHAR(6) NOT NULL,
    Monto_sueldo_base FLOAT NOT NULL,
    PRIMARY KEY (Id_sueldo_base)
);

CREATE TABLE Tipo_Bonificacion
(
 Id_tipo_boni CHAR(6) NOT NULL,
 Nom_tipo_boni VARCHAR(50) NOT NULL,
 PRIMARY KEY (Id_tipo_boni)
);

CREATE TABLE Bonificacion
(
 Id_bonificacion CHAR(6) NOT NULL,
 Monto_bonificacion FLOAT NOT NULL,
 Id_tipo_boni CHAR(6) NOT NULL,
 PRIMARY KEY (Id_bonificacion),
 FOREIGN KEY (Id_tipo_boni) REFERENCES Tipo_Bonificacion(Id_tipo_boni)
);
CREATE TABLE Periodo_pago
(
 Id_periodo_pago CHAR(6) NOT NULL,
 Nom_periodo_pago VARCHAR(50) NOT NULL,
 PRIMARY KEY (Id_periodo_pago)
);
	
CREATE TABLE Nomina
(
    Id_nomina CHAR(6) NOT NULL,
    Total_pago FLOAT,
    Fecha_emision DATE NOT NULL,
    Id_periodo_pago CHAR(6) NOT NULL,
    Id_gestor CHAR(6) NOT NULL,
    Id_bonificacion CHAR(6) NOT NULL,
    Id_deduccion CHAR(6) NOT NULL,
    Id_sueldo_base CHAR(6) NOT NULL,
    PRIMARY KEY (Id_nomina),
    FOREIGN KEY (Id_periodo_pago) REFERENCES Periodo_Pago(Id_periodo_pago),
    FOREIGN KEY (Id_gestor) REFERENCES Gestor_Produccion(Id_gestor),
    FOREIGN KEY (Id_bonificacion) REFERENCES Bonificacion(Id_bonificacion),
    FOREIGN KEY (Id_deduccion) REFERENCES Deduccion(Id_deduccion),
    FOREIGN KEY (Id_sueldo_base) REFERENCES Tipo_Sueldo_Base(Id_sueldo_base)
);

CREATE OR REPLACE FUNCTION adjust_seq_solicitud() RETURNS TRIGGER AS $$
BEGIN
    IF NEW.id_solicitud IS NOT NULL THEN
        PERFORM setval('seq_solicitud', GREATEST((SELECT MAX(CAST(SUBSTRING(id_solicitud, 4) AS INTEGER)) FROM solicitud_herramienta), nextval('seq_solicitud')-1));
    END IF;
    RETURN NEW;
END;
$$ LANGUAGE plpgsql;

-- Crear el Trigger
CREATE TRIGGER trg_adjust_seq_solicitud
BEFORE INSERT ON solicitud_herramienta
FOR EACH ROW
EXECUTE FUNCTION adjust_seq_solicitud();


CREATE TABLE Tipo_vehiculo (
    id_tipo_vehiculo CHAR(6) NOT NULL,
    nombre_tipo_vehiculo VARCHAR(50) NOT NULL,
    PRIMARY KEY (id_tipo_vehiculo)
);

CREATE TABLE Transporte (
    id_transporte CHAR(6) NOT NULL,
    id_operario CHAR(6) NOT NULL,
    fecha_transporte CHAR(10) NOT NULL,
    id_tipo_vehiculo CHAR(6) NOT NULL,
    PRIMARY KEY (id_transporte),
    FOREIGN KEY (id_operario) REFERENCES Operario(id_operario),
    FOREIGN KEY (id_tipo_vehiculo) REFERENCES Tipo_vehiculo(id_tipo_vehiculo)
);
 CREATE TABLE Insumo (
    id_insumo CHAR(6) NOT NULL,
    cantidad_insumo INT NOT NULL,
    tipo_insumo VARCHAR(50) NOT NULL,
    id_proveedor CHAR(6) NOT NULL,
    PRIMARY KEY (id_insumo)
);
CREATE TABLE Solicitud_insumo (
    id_solicitud_insumo CHAR(6) NOT NULL,
    fecha_solicitud DATE NOT NULL,
    estado_solicitud VARCHAR(50) NOT NULL,
    id_gestor CHAR(6) NOT NULL,
    id_insumo CHAR(6) NOT NULL,
    PRIMARY KEY (id_solicitud_insumo),
    FOREIGN KEY (id_gestor) REFERENCES gestor_produccion(id_gestor),
    FOREIGN KEY (id_insumo) REFERENCES Insumo(id_insumo)
);