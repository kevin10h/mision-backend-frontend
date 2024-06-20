package uni.pe.DBD.repository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import uni.pe.DBD.dto.ReclamoDto;
import uni.pe.DBD.models.*;
import java.time.LocalDate;
import java.util.List;

@Repository
public class ReclamoRepository implements ReclamoRepositoryI{
    @Autowired
    JdbcTemplate jdbcTemplate;

    @Override
    public List<Reclamo> getAllRec() {
        String SQL = "SELECT \n" +
                "    r.id_reclamo, \n" +
                "    r.id_operario, \n" +
                "    o.prim_nom_op || ' ' || o.seg_nom_op || ' ' || o.prim_ape_op || ' ' || o.seg_ape_op AS operario, \n"+
                "    r.fecha_reclamo, \n" +
                "    r.id_descrip_reclamo AS descripcion, \n" +
                "    r.id_estado_reclamo AS estado, \n" +
                "FROM reclamo r \n" +
                "INNER JOIN operario o ON r.id_operario = o.id_operario \n" +
                "ORDER BY r.fecha_reclamo DESC";
        return jdbcTemplate.query(SQL,new BeanPropertyRowMapper<>(Reclamo.class));
    }

    @Override
    public List<Reclamo> getByIDReclamo(String id_reclamo) {
        String SQL = "SELECT \n" +
                "    r.id_reclamo, \n" +
                "    r.id_operario, \n" +
                "    o.prim_nom_op || ' ' || o.seg_nom_op || ' ' || o.prim_ape_op || ' ' || o.seg_ape_op AS operario, \n"+
                "    r.fecha_reclamo, \n" +
                "    r.id_descrip_reclamo AS descripcion, \n" +
                "    r.id_estado_reclamo AS estado, \n" +
                "FROM reclamo r \n" +
                "INNER JOIN operario o ON r.id_operario = o.id_operario \n" +
                "WHERE r.id_reclamo = ? \n" +
                "ORDER BY r.fecha_reclamo DESC";
        return jdbcTemplate.query(SQL,new BeanPropertyRowMapper<>(Reclamo.class));
    }

    @Override
    public List<Reclamo> getByIDOperario(String id_operario) {
        String SQL = "SELECT \n" +
                "    r.id_reclamo, \n" +
                "    r.id_operario, \n" +
                "    o.prim_nom_op || ' ' || o.seg_nom_op || ' ' || o.prim_ape_op || ' ' || o.seg_ape_op AS operario, \n"+
                "    r.fecha_reclamo, \n" +
                "    r.id_descrip_reclamo AS descripcion, \n" +
                "    r.id_estado_reclamo AS estado, \n" +
                "FROM reclamo r \n" +
                "INNER JOIN operario o ON r.id_operario = o.id_operario \n" +
                "WHERE r.id_operario = ? \n" +
                "ORDER BY r.fecha_reclamo DESC";
        return jdbcTemplate.query(SQL,new BeanPropertyRowMapper<>(Reclamo.class));
    }

    @Override
    public List<Reclamo> getByFechaRec(LocalDate fecha_reclamo) {
        String SQL = "SELECT \n" +
                "    r.id_reclamo, \n" +
                "    r.id_operario, \n" +
                "    o.prim_nom_op || ' ' || o.seg_nom_op || ' ' || o.prim_ape_op || ' ' || o.seg_ape_op AS operario, \n"+
                "    r.fecha_reclamo, \n" +
                "    r.id_descrip_reclamo AS descripcion, \n" +
                "    r.id_estado_reclamo AS estado, \n" +
                "FROM reclamo r \n" +
                "INNER JOIN operario o ON r.id_operario = o.id_operario \n" +
                "WHERE r.fecha_reclamo = ? \n" +
                "ORDER BY r.fecha_reclamo DESC";
        return jdbcTemplate.query(SQL,new BeanPropertyRowMapper<>(Reclamo.class));
    }

    @Override
    public List<Reclamo> getByEstRec(String id_estado_reclamo) {
        String SQL = "SELECT \n" +
                "    r.id_reclamo, \n" +
                "    r.id_operario, \n" +
                "    o.prim_nom_op || ' ' || o.seg_nom_op || ' ' || o.prim_ape_op || ' ' || o.seg_ape_op AS operario, \n"+
                "    r.fecha_reclamo, \n" +
                "    r.id_descrip_reclamo AS descripcion, \n" +
                "    r.id_estado_reclamo AS estado, \n" +
                "FROM reclamo r \n" +
                "INNER JOIN operario o ON r.id_operario = o.id_operario \n" +
                "WHERE r.id_estado_reclamo = ? \n" +
                "ORDER BY r.fecha_reclamo DESC";
        return jdbcTemplate.query(SQL,new BeanPropertyRowMapper<>(Reclamo.class));
    }
}
