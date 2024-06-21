package uni.pe.DBD.repository;
import io.micrometer.observation.annotation.Observed;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import uni.pe.DBD.dto.AsignacionActividadDto;
import uni.pe.DBD.models.*;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

@Repository
public class ActividadesRepository implements ActividadesRepositoryI{
    @Autowired
    JdbcTemplate jdbcTemplate;
    @Override
    public List<AsignacionActividad> getAllAsig() {
        String SQL = "SELECT \n" +
                "    aa.id_asignacion, \n" +
                "    aa.id_operario, \n" +
                "    o.prim_nom_op || ' ' || o.seg_nom_op || ' ' || o.prim_ape_op || ' ' || o.seg_ape_op AS operario, \n"+
                "    aa.fecha_asig, \n" +
                "    a.nombre_actividad AS actividad, \n" +
                "    aa.hora_inicio, \n" +
                "    aa.hora_fin, \n" +
                "    ea.nom_est_asignacion AS estado_asignacion, \n" +
                "    aa.id_lote, \n" +
                "    o.id_taller, \n" +
                "    aa.id_gestor, \n" +
                "    g.prim_nom_ges || ' ' || g.seg_nom_ges || ' ' || g.prim_ape_ges || ' ' || g.seg_ape_ges AS gestor \n" +
                "FROM asignacion_actividad aa \n" +
                "INNER JOIN actividad a ON aa.id_actividad = a.id_actividad \n" +
                "INNER JOIN estado_asignacion ea ON aa.id_est_asignacion = ea.id_est_asignacion \n" +
                "INNER JOIN operario o ON aa.id_operario = o.id_operario \n" +
                "INNER JOIN gestor_produccion g ON aa.id_gestor = g.id_gestor \n" +
                "ORDER BY aa.fecha_asig DESC";
        return jdbcTemplate.query(SQL,new BeanPropertyRowMapper<>(AsignacionActividad.class));
    }

    @Override
    public List<AsignacionActividad> getByIDGestor(String id_gestor) {
        String SQL = "SELECT \n" +
                "    aa.id_asignacion, \n" +
                "    aa.id_operario, \n" +
                "    o.prim_nom_op || ' ' || o.seg_nom_op || ' ' || o.prim_ape_op || ' ' || o.seg_ape_op AS operario, \n"+
                "    aa.fecha_asig, \n" +
                "    a.nombre_actividad AS actividad, \n" +
                "    aa.hora_inicio, \n" +
                "    aa.hora_fin, \n" +
                "    ea.nom_est_asignacion AS estado_asignacion, \n" +
                "    aa.id_lote, \n" +
                "    o.id_taller, \n" +
                "    aa.id_gestor, \n" +
                "    g.prim_nom_ges || ' ' || g.seg_nom_ges || ' ' || g.prim_ape_ges || ' ' || g.seg_ape_ges AS gestor \n" +
                "FROM asignacion_actividad aa \n" +
                "INNER JOIN actividad a ON aa.id_actividad = a.id_actividad \n" +
                "INNER JOIN estado_asignacion ea ON aa.id_est_asignacion = ea.id_est_asignacion \n" +
                "INNER JOIN operario o ON aa.id_operario = o.id_operario \n" +
                "INNER JOIN gestor_produccion g ON aa.id_gestor = g.id_gestor \n" +
                "WHERE aa.id_gestor = ? \n" +
                "ORDER BY aa.fecha_asig DESC";
        return jdbcTemplate.query(SQL,new BeanPropertyRowMapper<>(AsignacionActividad.class),id_gestor);
    }

    @Override
    public List<AsignacionActividad> getByIDOperario(String id_operario) {
        String SQL = "SELECT \n" +
                "    aa.id_asignacion, \n" +
                "    aa.id_operario, \n" +
                "    o.prim_nom_op || ' ' || o.seg_nom_op || ' ' || o.prim_ape_op || ' ' || o.seg_ape_op AS operario, \n"+
                "    aa.fecha_asig, \n" +
                "    a.nombre_actividad AS actividad, \n" +
                "    aa.hora_inicio, \n" +
                "    aa.hora_fin, \n" +
                "    ea.nom_est_asignacion AS estado_asignacion, \n" +
                "    aa.id_lote, \n" +
                "    o.id_taller, \n" +
                "    aa.id_gestor, \n" +
                "    g.prim_nom_ges || ' ' || g.seg_nom_ges || ' ' || g.prim_ape_ges || ' ' || g.seg_ape_ges AS gestor \n" +
                "FROM asignacion_actividad aa \n" +
                "INNER JOIN actividad a ON aa.id_actividad = a.id_actividad \n" +
                "INNER JOIN estado_asignacion ea ON aa.id_est_asignacion = ea.id_est_asignacion \n" +
                "INNER JOIN operario o ON aa.id_operario = o.id_operario \n" +
                "INNER JOIN gestor_produccion g ON aa.id_gestor = g.id_gestor \n" +
                "WHERE aa.id_operario = ? \n" +
                "ORDER BY aa.fecha_asig DESC";
        return jdbcTemplate.query(SQL,new BeanPropertyRowMapper<>(AsignacionActividad.class),id_operario);
    }

    @Override
    public List<AsignacionActividad> getByFechaAsig(LocalDate fecha_inicio, LocalDate fecha_fin) {
        String SQL = "SELECT \n" +
                "    aa.id_asignacion, \n" +
                "    aa.id_operario, \n" +
                "    o.prim_nom_op || ' ' || o.seg_nom_op || ' ' || o.prim_ape_op || ' ' || o.seg_ape_op AS operario, \n"+
                "    aa.fecha_asig, \n" +
                "    a.nombre_actividad AS actividad, \n" +
                "    aa.hora_inicio, \n" +
                "    aa.hora_fin, \n" +
                "    ea.nom_est_asignacion AS estado_asignacion, \n" +
                "    aa.id_lote, \n" +
                "    o.id_taller, \n" +
                "    aa.id_gestor, \n" +
                "    g.prim_nom_ges || ' ' || g.seg_nom_ges || ' ' || g.prim_ape_ges || ' ' || g.seg_ape_ges AS gestor \n" +
                "FROM asignacion_actividad aa \n" +
                "INNER JOIN actividad a ON aa.id_actividad = a.id_actividad \n" +
                "INNER JOIN estado_asignacion ea ON aa.id_est_asignacion = ea.id_est_asignacion \n" +
                "INNER JOIN operario o ON aa.id_operario = o.id_operario \n" +
                "INNER JOIN gestor_produccion g ON aa.id_gestor = g.id_gestor \n" +
                "WHERE aa.fecha_asig BETWEEN ? AND ? \n" +
                "ORDER BY aa.fecha_asig DESC";
        return jdbcTemplate.query(SQL,new BeanPropertyRowMapper<>(AsignacionActividad.class),fecha_inicio,fecha_fin);
    }

    @Override
    public List<AsignacionActividad> getByEstAsig(String est_asig) {
        String SQL = "SELECT \n" +
                "    aa.id_asignacion, \n" +
                "    aa.id_operario, \n" +
                "    o.prim_nom_op || ' ' || o.seg_nom_op || ' ' || o.prim_ape_op || ' ' || o.seg_ape_op AS operario, \n" +
                "    aa.fecha_asig, \n" +
                "    a.nombre_actividad AS actividad, \n" +
                "    aa.hora_inicio, \n" +
                "    aa.hora_fin, \n" +
                "    ea.nom_est_asignacion AS estado_asignacion, \n" +
                "    aa.id_lote, \n" +
                "    o.id_taller, \n" +
                "    aa.id_gestor, \n" +
                "    g.prim_nom_ges || ' ' || g.seg_nom_ges || ' ' || g.prim_ape_ges || ' ' || g.seg_ape_ges AS gestor \n" +
                "FROM asignacion_actividad aa \n" +
                "INNER JOIN actividad a ON aa.id_actividad = a.id_actividad \n" +
                "INNER JOIN estado_asignacion ea ON aa.id_est_asignacion = ea.id_est_asignacion \n" +
                "INNER JOIN operario o ON aa.id_operario = o.id_operario \n" +
                "INNER JOIN gestor_produccion g ON aa.id_gestor = g.id_gestor \n" +
                "WHERE aa.id_est_asignacion = ? \n" +
                "ORDER BY aa.fecha_asig DESC";
        return jdbcTemplate.query(SQL, new BeanPropertyRowMapper<>(AsignacionActividad.class), est_asig);
    }

    @Override
    public void asignarActividad(AsignacionActividadDto dto) {
        String sql = "SELECT COUNT(*) FROM asignacion_actividad";
        int count = jdbcTemplate.queryForObject(sql,Integer.class);
        String id_asignacion = String.valueOf(count+1);
        String SQL=" INSERT INTO asignacion_actividad (id_asignacion, id_operario, id_actividad, fecha_asig, hora_inicio, hora_fin, id_gestor, id_lote, id_est_asignacion)" +
                " VALUES ( 'ASI"+id_asignacion+"',?,?,?,?,?,?,?,'EST4')";
        jdbcTemplate.update(SQL,dto.getId_operario(),dto.getId_actividad(),dto.getFecha_asig(),dto.getHora_inicio(),dto.getHora_fin(),dto.getId_gestor(),dto.getId_lote());
    }

    @Override
    public void cancelarActividad(String id_asignacion){
        String SQL = "UPDATE public.asignacion_actividad \n" +
                "SET id_est_asignacion = 'EST1', \n" +
                "WHERE id_asignacion = ?";
        jdbcTemplate.update(SQL,id_asignacion);
    }

    @Override
    public void envioRevisionActividad(String id_asignacion){
        String SQL =  "UPDATE public.asignacion_actividad \n" +
                "SET id_est_asignacion = 'EST3', \n" +
                "WHERE id_asignacion = ?";
        jdbcTemplate.update(SQL,id_asignacion);
    }

    @Override
    public void finalizarActividad(String id_asignacion){
        String SQL =  "UPDATE public.asignacion_actividad \n" +
                "SET id_est_asignacion = 'EST2', \n" +
                "WHERE id_asignacion = ?";
        jdbcTemplate.update(SQL,id_asignacion);
    }

    @Override
    public void defectoActividad(String id_asignacion) {
        String SQL= "UPDATE public.asignacion_actividad \n" +
                "SET id_est_asignacion = 'EST5', \n" +
                "WHERE id_asignacion = ?";
        jdbcTemplate.update(SQL,id_asignacion);
    }
}