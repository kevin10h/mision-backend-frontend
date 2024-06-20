package uni.pe.DBD.repository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import uni.pe.DBD.dto.ObservacionDto;
import uni.pe.DBD.models.*;
import java.time.LocalDate;
import java.util.List;

@Repository
public class ObservacionRepository implements ObservacionRepositoryI {
    @Autowired
    JdbcTemplate jdbcTemplate;

    @Override
    public List<Observacion> getAllObs() {
        String SQL = "SELECT \n" +
                "    ob.id_observacion, \n" +
                "    ob.id_asignacion, \n" +
                "    a.nombre_actividad AS actividad, \n" +
                "    ob.fecha_observacion, \n" +
                "    ob.id_descrip_observacion AS descripcion, \n" +
                "    ob.id_estado_observacion AS estado, \n" +
                "FROM observacion ob \n" +
                "INNER JOIN asignacion_actividad aa ON ob.id_asignacion = aa.id_asignacion \n" +
                "INNER JOIN actividad a ON aa.id_actividad = a.id_actividad \n" +
                "ORDER BY ob.fecha_observacion DESC";
        return jdbcTemplate.query(SQL,new BeanPropertyRowMapper<>(Observacion.class));
    }

    @Override
    public List<Observacion> getByIDObservacion(String id_observacion) {
        String SQL = "SELECT \n" +
                "    ob.id_observacion, \n" +
                "    ob.id_asignacion, \n" +
                "    a.nombre_actividad AS actividad, \n" +
                "    ob.fecha_observacion, \n" +
                "    ob.id_descrip_observacion AS descripcion, \n" +
                "    ob.id_estado_observacion AS estado, \n" +
                "FROM observacion ob \n" +
                "INNER JOIN asignacion_actividad aa ON ob.id_asignacion = aa.id_asignacion \n" +
                "INNER JOIN actividad a ON aa.id_actividad = a.id_actividad \n" +
                "WHERE ob.id_observacion = ? \n" +
                "ORDER BY ob.fecha_observacion DESC";
        return jdbcTemplate.query(SQL,new BeanPropertyRowMapper<>(Observacion.class));
    }

    @Override
    public List<Observacion> getByIDAsignacion(String id_asignacion) {
        String SQL = "SELECT \n" +
                "    ob.id_observacion, \n" +
                "    ob.id_asignacion, \n" +
                "    a.nombre_actividad AS actividad, \n" +
                "    ob.fecha_observacion, \n" +
                "    ob.id_descrip_observacion AS descripcion, \n" +
                "    ob.id_estado_observacion AS estado, \n" +
                "FROM observacion ob \n" +
                "INNER JOIN asignacion_actividad aa ON ob.id_asignacion = aa.id_asignacion \n" +
                "INNER JOIN actividad a ON aa.id_actividad = a.id_actividad \n" +
                "WHERE ob.id_asignacion = ? \n" +
                "ORDER BY ob.fecha_observacion DESC";
        return jdbcTemplate.query(SQL,new BeanPropertyRowMapper<>(Observacion.class));
    }

    @Override
    public List<Observacion> getByEstObs(String id_estado_observacion) {
        String SQL = "SELECT \n" +
                "    ob.id_observacion, \n" +
                "    ob.id_asignacion, \n" +
                "    a.nombre_actividad AS actividad, \n" +
                "    ob.fecha_observacion, \n" +
                "    ob.id_descrip_observacion AS descripcion, \n" +
                "    ob.id_estado_observacion AS estado, \n" +
                "FROM observacion ob \n" +
                "INNER JOIN asignacion_actividad aa ON ob.id_asignacion = aa.id_asignacion \n" +
                "INNER JOIN actividad a ON aa.id_actividad = a.id_actividad \n" +
                "WHERE ob.id_estado_observacion = ? \n" +
                "ORDER BY ob.fecha_observacion DESC";
        return jdbcTemplate.query(SQL,new BeanPropertyRowMapper<>(Observacion.class));
    }

    @Override
    public List<Observacion> getByFechaObs(LocalDate fecha_observacion) {
        String SQL = "SELECT \n" +
                "    ob.id_observacion, \n" +
                "    ob.id_asignacion, \n" +
                "    a.nombre_actividad AS actividad, \n" +
                "    ob.fecha_observacion, \n" +
                "    ob.id_descrip_observacion AS descripcion, \n" +
                "    ob.id_estado_observacion AS estado, \n" +
                "FROM observacion ob \n" +
                "INNER JOIN asignacion_actividad aa ON ob.id_asignacion = aa.id_asignacion \n" +
                "INNER JOIN actividad a ON aa.id_actividad = a.id_actividad \n" +
                "WHERE ob.fecha_observacion = ? \n" +
                "ORDER BY ob.fecha_observacion DESC";
        return jdbcTemplate.query(SQL,new BeanPropertyRowMapper<>(Observacion.class));
    }
}
