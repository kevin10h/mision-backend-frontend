package uni.edu.pe.demo.Dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import uni.edu.pe.demo.Dto.*;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@Repository
public class TablaDaoImp implements TablaDao {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public categoria_taller insertarCatalago1(categoria_taller Categoria_taller) {
        String sql = "INSERT INTO categoria_taller (id_cate_taller, nom_cate_taller) VALUES (?, ?)";
        try {
            jdbcTemplate.update(sql, Categoria_taller.getId_cate_taller(), Categoria_taller.getNom_cate_taller());
        } catch (DataAccessException e) {
            System.err.println("Error al insertar en la base de datos: " + e.getMessage());
            throw new RuntimeException("Error al insertar en la base de datos", e);
        }
        return Categoria_taller;
    }
    @Override
    public gestor_produccion insertarCatalago2(gestor_produccion Gestor_produccion){
        String sql = "INSERT INTO gestor_produccion (id_gestor, DNI, prim_nom_ges, seg_nom_ges, prim_ape_ges, seg_ape_ges) values (?, ?, ?, ?, ?, ?)";
        try{
            jdbcTemplate.update(sql, Gestor_produccion.getId_gestor() , Gestor_produccion.getDni(), Gestor_produccion.getPrim_nom_ges(), Gestor_produccion.getSeg_nom_ges(),Gestor_produccion.getPrim_ape_ges(),Gestor_produccion.getSeg_ape_ges() );
        }   catch (DataAccessException e ){
            System.err.println("Error al insertar en la base de datos: " + e.getMessage());
            throw new RuntimeException("Error al inserar en la base de datod ", e);
        }
        return Gestor_produccion;
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

  /*  @Override
    public List<DetalleTabla> obtenerCatalago() {

        List<DetalleTabla> lista = new ArrayList<>();
        String sql = "  SELECT us.codigo_usr, us.cueenta_usr, us.nombre_usr, \n" +
                " us.password_usr, us.codigo_perfil, pe.nombre_peril, \n" +
                " pe.indicador_perfil, ap.codigo_app, ap.nombre_app \n" +
                " FROM usuario us inner join perfil pe  ON (us.codigo_perfil = pe.codigo_perfil)\n" +
                " INNER JOIN perfil_aplicacion pa ON (pe.codigo_perfil = pa.codigo_perfil)\n" +
                " inner JOIN aplicacion ap ON (pa.codigo_app = ap.codigo_app); ";
        try {
            obtenerConexion();
            Statement sentencia = conexion.createStatement();
            ResultSet resultado = sentencia.executeQuery(sql);
            while (resultado.next()){
                lista.add(extraerReporte(resultado));
            }
            cerrarConexion(resultado,sentencia);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return lista;
    }

    @Override
    public ReporteTabla actualizarTabla(ReporteTabla reporteTabla) {
        try {
            obtenerConexion();
            String sql = "UPDATE Solicitud_insumo " +
                    "SET estado_solicitud = ? " +
                    "WHERE id_solicitud_insumo = ? ;";
            PreparedStatement st = conexion.prepareStatement(sql);
            st.setString(1, );
            st.executeUpdate();
            st.close();
            cerrarConexion(null, st);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return reporteTabla;
    }*/
    /*
    @Override
    public Insumo insertarCatalago3(Insumo insumo) {
        try{
            obtenerConexion();
            String sql = "insert into Insumo (id_insumo, cantidad_insumo, tipo_insumo, id_proveedor) values (?, ?, ?, ?);";
            PreparedStatement st = conexion.prepareStatement(sql);
            st.setString(1, insumo.getId_insumo());
            st.setInt(2, insumo.getCantidad_insumo());
            st.setString(3, insumo.getTipo_insumo());
            st.setString(4, insumo.getId_provedor());
            st.executeUpdate();
            st.close();
            cerrarConexion(null, st);
        }catch(SQLException e){
            throw new RuntimeException(e);
        }
        return insumo;
    }

    @Override
    public Operario InsertarCatalago4(Operario operario) {
        try{
            obtenerConexion();
            String sql = "insert into operario (id_operario, dni, prim_nom_op, seg_nom_op, prim_ape_op, seg_ape_op, id_taller) values (?, ?, ?, ?, ?, ?, ?);";
            PreparedStatement st = conexion.prepareStatement(sql);
            st.setString(1, operario.getId_operario());
            st.setString(2, operario.getDni());
            st.setString(3, operario.getPrim_nom_op());
            st.setString(4, operario.getSeg_nom_op());
            st.setString(5, operario.getPrim_ape_op() );
            st.setString(6, operario.getSeg_ape_op());
            st.setString(7, operario.getId_taller());
            st.executeUpdate();
            st.close();
            cerrarConexion(null, st);
        }catch(SQLException e){
            throw new RuntimeException(e);
        }
        return operario;
    }

    @Override
    public Solicitud_insumo InsertarCatalago5(Solicitud_insumo solicitudInsumo) {
        try{
            obtenerConexion();
            String sql = "insert into Solicitud_insumo (id_solicitud_insumo, fecha_solicitud, estado_solicitud, id_gestor, id_insumo) values (?, ?, ?, ?,?);";
            PreparedStatement st = conexion.prepareStatement(sql);
            st.setString(1, solicitudInsumo.getId_solicitud_insumo());
            st.setString(2, solicitudInsumo.getFecha_solicitud());
            st.setString(3, solicitudInsumo.getEstado_solicitud());
            st.setString(4, solicitudInsumo.getId_gestor());
            st.setString(5, solicitudInsumo.getId_insumo());
            st.executeUpdate();
            st.close();
            cerrarConexion(null, st);
        }catch(SQLException e){
            throw new RuntimeException(e);
        }
        return solicitudInsumo;
    }

    @Override
    public Taller InsertarCatalago6(Taller taller) {
        try{
            obtenerConexion();
            String sql = "INSERT INTO taller (id_taller, capacidad_taller, id_cate_taller) VALUES (?, ?, ?);";
            PreparedStatement st = conexion.prepareStatement(sql);
            st.setString(1, taller.getId_taller());
            st.setInt(2, taller.getCapacidad_taller());
            st.setString(3, taller.getId_cate_taller());

            st.close();
            cerrarConexion(null, st);
        }catch(SQLException e){
            throw new RuntimeException(e);
        }
        return taller;
    }

    @Override
    public Tipo_vehiculo InsertarCatalago7(Tipo_vehiculo tipoVehiculo) {
        try{
            obtenerConexion();
            String sql = "INSERT INTO Tipo_vehiculo (id_tipo_vehiculo, nombre_tipo_vehiculo) VALUES (?,?)";
            PreparedStatement st = conexion.prepareStatement(sql);
            st.setString(1, tipoVehiculo.getId_tipo_vehiculo());
            st.setString(2, tipoVehiculo.getNombre_tipo_vehiculo());
            st.close();
            cerrarConexion(null, st);
        }catch(SQLException e){
            throw new RuntimeException(e);
        }
        return tipoVehiculo;
    }

        public Transporte InsertarCatalago8(Transporte transporte) {
            try{
                obtenerConexion();
                String sql = "insert into Transporte (id_transporte, id_operario, fecha_transporte, id_tipo_vehiculo) values (?,?,?,?)";
                PreparedStatement st = conexion.prepareStatement(sql);
                st.setString(1, transporte.getId_transporte());
                st.setString(2, transporte.getId_operario());
                st.setString(3, transporte.getFecha_transporte());
                st.setString(4, transporte.getId_tipo_vehiculo());
                st.close();
                cerrarConexion(null, st);
            }catch(SQLException e){
                throw new RuntimeException(e);
            }
            return transporte;
    }

*/


}
