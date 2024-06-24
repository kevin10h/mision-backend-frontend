DROP TABLE IF EXISTS herramienta CASCADE;
DROP TABLE IF EXISTS gestor_produccion CASCADE;
DROP TABLE IF EXISTS actividad CASCADE;
DROP TABLE IF EXISTS lote CASCADE;
DROP TABLE IF EXISTS gestor_produccion_telefono CASCADE;
DROP TABLE IF EXISTS categoria_taller CASCADE;
DROP TABLE IF EXISTS estado_asignacion CASCADE;
DROP TABLE IF EXISTS taller CASCADE;
DROP TABLE IF EXISTS operario CASCADE;
DROP TABLE IF EXISTS asignacion_actividad CASCADE;
DROP TABLE IF EXISTS operario_telefono CASCADE;
DROP TABLE IF EXISTS estado_soli_herra CASCADE;
DROP TABLE IF EXISTS solicitud_herramienta CASCADE;
DROP TABLE IF EXISTS mantenimiento_herramienta CASCADE;
DROP TABLE IF EXISTS Estado_Reclamo CASCADE;
DROP TABLE IF EXISTS Descripcion_reclamo CASCADE;
DROP TABLE IF EXISTS Reclamo CASCADE;
DROP TABLE IF EXISTS Reporte_reclamo CASCADE;
DROP TABLE IF EXISTS Reporte_herramienta CASCADE;
DROP TABLE IF EXISTS Tipo_deduccion CASCADE;
DROP TABLE IF EXISTS Deduccion CASCADE;
DROP TABLE IF EXISTS Tipo_Sueldo_Base CASCADE;
DROP TABLE IF EXISTS Tipo_Bonificacion CASCADE;
DROP TABLE IF EXISTS Bonificacion CASCADE;
DROP TABLE IF EXISTS Periodo_pago CASCADE;
DROP TABLE IF EXISTS Nomina CASCADE;
drop table if exists Transporte Cascade;
drop table if exists Insumo cascade;
drop table if exists Solicitud_insumo cascade;
drop table if exists Tipo_vehiculo cascade;
DROP SEQUENCE IF EXISTS seq_solicitud;
drop table if exists Estado_Observacion cascade;
drop table if exists Descripcion_observacion cascade;
drop table if exists Observacion cascade;
drop table if exists estado_soli_herra cascade;
-- Eliminar función si existe
DROP FUNCTION IF EXISTS gen_id(prefix TEXT, seq_name TEXT);

-- Eliminar vistas si existen
DROP VIEW IF EXISTS Reporte_Reclamos_Por_Fecha;
DROP VIEW IF EXISTS Reporte_Reclamos_Por_Descripcion;
DROP VIEW IF EXISTS Reporte_Reclamos_Por_Estado;
DROP VIEW IF EXISTS Reporte_Reclamos_Por_Operario;

-- Eliminar función y trigger si existen
DROP FUNCTION IF EXISTS adjust_seq_solicitud();
DROP TRIGGER IF EXISTS trg_adjust_seq_solicitud ON solicitud_herramienta;
