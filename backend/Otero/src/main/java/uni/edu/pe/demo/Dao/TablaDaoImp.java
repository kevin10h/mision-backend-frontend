package uni.edu.pe.demo.Dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;
import uni.edu.pe.demo.Dto.*;

import java.sql.*;
import java.util.List;

@Repository
public class TablaDaoImp implements TablaDao {

    @Autowired
    private JdbcTemplate jdbcTemplate;
    @Override
    public Solicitud_insumo InsertarSolicitudInsumo(Solicitud_insumo solicitudInsumo) {
        // Consulta para obtener el número actual de registros
        String countSql = "SELECT COUNT(*) FROM Solicitud_insumo";
        int count = jdbcTemplate.queryForObject(countSql, Integer.class);

        // Generar el nuevo código de solicitud
        String nuevoCodigo = "ISI" + (count + 1);

        // Asignar el nuevo código a solicitudInsumo
        solicitudInsumo.setId_solicitud_insumo(nuevoCodigo);

        // Consulta para insertar la solicitud de insumo
        String sql = "INSERT INTO Solicitud_insumo (id_solicitud_insumo, fecha_solicitud, id_gestor, tipo_insumo, cantidad_insumo, Nombre_provedor) " +
                "VALUES (?, ?, ?, ?, ?, ?)";

        try {
            // Ejecutar la inserción
            jdbcTemplate.update(sql, solicitudInsumo.getId_solicitud_insumo(), solicitudInsumo.getFecha_solicitud(),
                    solicitudInsumo.getId_gestor(), solicitudInsumo.getTipo_insumo(),
                    solicitudInsumo.getCantidad_insumo(), solicitudInsumo.getNombre_provedor());
        } catch (DataAccessException e) {
            System.err.println("Error al insertar en la base de datos: " + e.getMessage());
            throw new RuntimeException("Error al insertar en la base de datos", e);
        }

        return solicitudInsumo;
    }
    @Override
    public List<DetalleTabla> obtenerDatosTransporte(String id_transporte) {
        String sql = "SELECT\t\n" +
                "    d.fecha_solicitud,\n" +
                "    d.tipo_insumo,\n" +
                "    d.cantidad_insumo,\n" +
                "    c.nombre_transportista,\n" +
                "    a.id_transporte AS identificacion_de_transporte,\n" +
                "    a.fecha_transporte\n" +
                "FROM Transporte a\n" +
                "JOIN Tipo_vehiculo b ON b.id_tipo_vehiculo = a.id_tipo_vehiculo\n" +
                "JOIN Transportista c ON c.id_Transportista = a.id_Transportista\n" +
                "JOIN Solicitud_insumo d ON d.id_solicitud_insumo = a.id_solicitud_insumo "+
                "WHERE (TRIM(?)='' OR id_transporte=TRIM(?))";

        try {
            return jdbcTemplate.query(sql, (rs, rowNum) -> mapRowToDetalleTabla(rs));
        } catch (DataAccessException e) {
            System.err.println("Error al obtener datos de transporte: " + e.getMessage());
            throw new RuntimeException("Error al obtener datos de transporte", e);
        }
    }

        private DetalleTabla mapRowToDetalleTabla(ResultSet rs) throws SQLException {
            DetalleTabla detalleTabla = new DetalleTabla();
            detalleTabla.setFecha_solicitud(rs.getString("fecha_solicitud"));
            detalleTabla.setTipo_insumo(rs.getString("tipo_insumo"));
            detalleTabla.setCantidad_insumo(rs.getInt("cantidad_insumo"));
            detalleTabla.setNombre_transportista(rs.getString("nombre_transportista"));
            detalleTabla.setId_transporte(rs.getString("identificacion_de_transporte"));
            detalleTabla.setFecha_transporte(rs.getString("fecha_transporte"));
            return detalleTabla;
        }

    @Override
    public ReporteTabla ActualizarTabla(ReporteTabla reporteTabla) {
        String sql = "UPDATE Transportista\n" +
                "SET disponibilidad = 'OCUPADO',\n" +
                "    ruta = ? \n" +
                "WHERE id_Transportista = ? ;\n";

        try {
            jdbcTemplate.update(sql,reporteTabla.getRuta(), reporteTabla.getId_Transportista());
        } catch (DataAccessException e) {
            System.err.println("Error al actualizar la base de datos: " + e.getMessage());
            throw new RuntimeException("Error al actualizar la base de datos", e);
        }
        return reporteTabla;
    }
}
