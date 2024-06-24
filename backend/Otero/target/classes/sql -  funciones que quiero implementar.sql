SELECT 
c.dni,
b.nombre_tipo_vehiculo,
a.fecha_transporte, 
a.id_tipo_vehiculo,
a.id_operario,
b.nombre_tipo_vehiculo as nombre_vehiculo
FROM Transporte a
JOIN Tipo_vehiculo b ON b.id_tipo_vehiculo = a.id_tipo_vehiculo
JOIN Operario c ON c.id_operario = a.id_operario

UPDATE Solicitud_insumo
set estado_solicitud = 'APROBADO'
where id_solicitud_insumo = 'ISI1';

SELECT*FROM Transporte
DELETE FROM Transporte
where id_transporte = 'TRA201';