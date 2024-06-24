package uni.edu.pe.demo.Dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import uni.edu.pe.demo.Dto.*;

import java.io.StringReader;
import java.sql.*;
import java.util.List;

@Repository
public class TablaDaoImp implements TablaDao {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public Tipo_Vehiculo insertarCatalago1(Tipo_Vehiculo tipoVehiculo) {
        String sql = "INSERT INTO Tipo_vehiculo (id_tipo_vehiculo, nombre_tipo_vehiculo) VALUES\n" +
                "(?, ?)";
        try {
            jdbcTemplate.update(sql, tipoVehiculo.getId_tipo_vehiculo(), tipoVehiculo.getNombre_tipo_vehiculo());
        } catch (DataAccessException e) {
            System.err.println("Error al insertar en la base de datos: " + e.getMessage());
            throw new RuntimeException("Error al insertar en la base de datos", e);
        }
        return tipoVehiculo;
    }
    @Override
    public Transporte insertarCatalago2(Transporte transporte){
        String sql = "insert into Transporte (id_transporte, id_operario, fecha_transporte, id_tipo_vehiculo) values (?, ?, ?, ?)";
        try{
            jdbcTemplate.update(sql, transporte.getId_transporte() , transporte.getId_operario(), transporte.getFecha_transporte(), transporte.getId_tipo_vehiculo());
        }   catch (DataAccessException e ){
            System.err.println("Error al insertar en la base de datos: " + e.getMessage());
            throw new RuntimeException("Error al inserar en la base de datod ", e);
        }
        return transporte;
    }
    @Override
    public Insumo insertarCatalago3(Insumo insumo){
        String sql = "insert into Insumo (id_insumo, cantidad_insumo, tipo_insumo, id_proveedor) values (?, ?, ?, ?)";
        try{
            jdbcTemplate.update(sql,insumo.getId_insumo(),insumo.getCantidad_insumo(), insumo.getTipo_insumo(), insumo.getId_provedor() );
        } catch (DataAccessException e){
            System.err.println("Error al insertar en la base de datos: " + e.getMessage());
            throw new RuntimeException("Error al insertar en la base de datos", e);
        }
        return insumo;
    }
    @Override
    public Solicitud_insumo InsertarCatalago5(Solicitud_insumo solicitudInsumo){
        String sql = "insert into Solicitud_insumo (id_solicitud_insumo, fecha_solicitud, estado_solicitud, id_gestor, id_insumo) values (?, ?, ?, ?, ?)";
        try{
            jdbcTemplate.update(sql,solicitudInsumo.getId_solicitud_insumo(),solicitudInsumo.getFecha_solicitud(),solicitudInsumo.getEstado_solicitud(),solicitudInsumo.getId_gestor(),solicitudInsumo.getId_insumo() );
        }catch (DataAccessException e){
            System.err.println("Error al insertar en la base de datos: " + e.getMessage());
            throw new RuntimeException("Error al insertar en la base de datos", e);
        }
        return  solicitudInsumo;
    }
    @Override
    public List<DetalleTabla> obtenerDatosTransporte() {
            String sql = "SELECT " +
                    "c.dni, " +
                    "b.nombre_tipo_vehiculo, " +
                    "a.fecha_transporte, " +
                    "a.id_tipo_vehiculo, " +
                    "a.id_operario, " +
                    "b.nombre_tipo_vehiculo as nombre_vehiculo " +
                    "FROM Transporte a " +
                    "JOIN Tipo_vehiculo b ON b.id_tipo_vehiculo = a.id_tipo_vehiculo " +
                    "JOIN Operario c ON c.id_operario = a.id_operario";

            try {
                return jdbcTemplate.query(sql, (rs, rowNum) -> mapRowToDetalleTabla(rs));
            } catch (DataAccessException e) {
                System.err.println("Error al obtener datos de transporte: " + e.getMessage());
                throw new RuntimeException("Error al obtener datos de transporte", e);
            }
        }

        private DetalleTabla mapRowToDetalleTabla(ResultSet rs) throws SQLException {
            DetalleTabla detalleTabla = new DetalleTabla();
            detalleTabla.setDni(rs.getString("dni"));
            detalleTabla.setNombre_tipo_vehiculo(rs.getString("nombre_tipo_vehiculo"));
            detalleTabla.setFecha_transporte(rs.getString("fecha_transporte"));
            detalleTabla.setId_tipo_vehiculo(rs.getString("id_tipo_vehiculo"));
            detalleTabla.setId_operario(rs.getString("id_operario"));
            detalleTabla.setNombre_vehiculo(rs.getString("nombre_vehiculo"));
            return detalleTabla;
        }

    @Override
    public ReporteTabla ActualizarTabla(ReporteTabla reporteTabla) {
        String sql = "UPDATE Solicitud_insumo SET estado_solicitud = ? WHERE id_solicitud_insumo = ?";

        try {
            jdbcTemplate.update(sql, reporteTabla.getEstado_solicitud(), reporteTabla.getId_solicitud_insumo());
        } catch (DataAccessException e) {
            System.err.println("Error al actualizar la base de datos: " + e.getMessage());
            throw new RuntimeException("Error al actualizar la base de datos", e);
        }
        return reporteTabla;
    }
}
