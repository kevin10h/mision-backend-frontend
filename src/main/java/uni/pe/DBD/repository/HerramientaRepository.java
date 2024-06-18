package uni.pe.DBD.repository;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import uni.pe.DBD.dto.SolicitudHerramientaDto;
import uni.pe.DBD.models.Herramienta;
import uni.pe.DBD.models.SolicitudHerramienta;

import java.util.List;

@Repository
public class HerramientaRepository implements HerramientaRepositoryI {
    @Autowired
    JdbcTemplate jdbcTemplate;
    @Override
    public List<Herramienta> getByCodigo(String s) {
        String SQL= " SELECT id_herramienta, nombre_herramienta as herramienta, modelo, nombre_proveedor as proveedor\n" +
                "  FROM herramienta\n" +
                "  WHERE id_herramienta = ? AND disponible = TRUE;";
        return jdbcTemplate.query(SQL,new BeanPropertyRowMapper<>(Herramienta.class),s);
    }

    @Override
    public List<Herramienta> getByNombre(String nombre) {
        String SQL= "  SELECT id_herramienta, nombre_herramienta as herramienta, modelo, nombre_proveedor as proveedor\n" +
                "  FROM herramienta\n" +
                "  WHERE lower(nombre_herramienta) LIKE '%' || ? || '%' AND disponible = TRUE";
        return jdbcTemplate.query(SQL,new BeanPropertyRowMapper<>(Herramienta.class),nombre.toLowerCase());
    }

    @Override
    public void solicitudRequest(SolicitudHerramientaDto dto) {
        String SQL=" INSERT INTO solicitud_herramienta (id_est_soli_herra, id_operario,id_herramienta)\n" +
                " VALUES (?,?,?)";
        jdbcTemplate.update(SQL, dto.getId_est_soli_herra(),dto.getId_operario(),dto.getId_herramienta());

    }

    @Override
    public List<SolicitudHerramienta> getByIDOperario(String id_operario) {
        String SQL = "SELECT " +
                "s.id_solicitud AS id_solicitud, " +
                "s.fecha_solicitud AS fecha_solicitud, " +
                "s.id_est_soli_herra AS estado, " +
                "o.prim_nom_op || ' ' || o.seg_nom_op || ' ' || o.prim_ape_op || ' ' || o.seg_ape_op AS operario, " +
                "g.prim_nom_ges || ' ' || g.seg_nom_ges || ' ' || g.prim_ape_ges || ' ' || g.seg_ape_ges AS gestor, " +
                "h.nombre_herramienta AS herramienta, " +
                "h.modelo AS modelo_herramienta " +
                "FROM solicitud_herramienta s " +
                "JOIN herramienta h ON s.id_herramienta = h.id_herramienta " +
                "Left JOIN operario o ON s.id_operario = o.id_operario " +
                "JOIN gestor_produccion g ON s.id_gestor = g.id_gestor " +
                "WHERE s.id_operario = ? " +
                "ORDER BY s.fecha_solicitud DESC;";

        return jdbcTemplate.query(SQL, new BeanPropertyRowMapper<>(SolicitudHerramienta.class), id_operario);
    }


    @Override
    public List<SolicitudHerramienta> getBySolicitudPendiente() {
        String SQL= "SELECT \n" +
                "   s.id_solicitud, s.fecha_solicitud,\n" +
                "   e.nom_est_soli_herra as estado,\n" +
                "   o.prim_nom_op || ' ' || o.seg_nom_op || ' ' || o.prim_ape_op || ' ' || o.seg_ape_op AS operario,\n" +
                "   g.prim_nom_ges || ' ' || g.seg_nom_ges || ' ' || g.prim_ape_ges || ' ' || g.seg_ape_ges AS gestor,\n" +
                "   h.modelo as modelo_herramienta,\n" +
                "   h.nombre_herramienta as herramienta\n" +
                "\n" +
                "  FROM \n" +
                "   solicitud_herramienta s\n" +
                "  Join\n" +
                "  estado_soli_herra e on e.id_est_soli_herra = s.id_est_soli_herra\n" +
                "  JOIN \n" +
                "   operario o ON s.id_operario = o.id_operario\n" +
                "   LEFT JOIN \n" +
                "   gestor_produccion g ON s.id_gestor = g.id_gestor\n" +
                "  JOIN \n" +
                "   herramienta h ON s.id_herramienta = h.id_herramienta\n" +
                "  WHERE \n" +
                "   s.id_est_soli_herra = 'EHE1'";
        return jdbcTemplate.query(SQL,new BeanPropertyRowMapper<>(SolicitudHerramienta.class));

    }

    @Override
    public List<SolicitudHerramienta> getByOperario(String operario) {
        String SQL= "SELECT \n" +
                "    s.id_solicitud,s.fecha_solicitud, \n" +
                "    o.prim_nom_op || ' ' || o.seg_nom_op || ' ' || o.prim_ape_op || ' ' || o.seg_ape_op AS operario,\n" +
                "\tg.prim_nom_ges || ' ' || g.seg_nom_ges || ' ' || g.prim_ape_ges || ' ' || g.seg_ape_ges AS gestor,\n" +
                "    h.modelo as modelo_herramienta,\n" +
                "    h.nombre_herramienta as herramienta,\n" +
                "    s.id_est_soli_herra as estado\n" +
                "  FROM \n" +
                "    solicitud_herramienta s\n" +
                "  left JOIN \n" +
                "   operario o ON s.id_operario = o.id_operario\n" +
                "   JOIN \n" +
                "   gestor_produccion g ON s.id_gestor = g.id_gestor\n" +
                "  JOIN \n" +
                "   herramienta h ON s.id_herramienta = h.id_herramienta\n" +
                "  WHERE \n" +
                "   s.id_est_soli_herra = 'EHE1' AND\n" +
                "  (o.prim_nom_op || ' ' || o.seg_nom_op || ' ' || o.prim_ape_op || ' ' || o.seg_ape_op) ILIKE '%' || ? || '%' ";
        return jdbcTemplate.query(SQL,new BeanPropertyRowMapper<>(SolicitudHerramienta.class),operario);
    }

    @Override
    public void aprobarSolicitud(String id_gestor , String id_solicitud) {
        String SQL="UPDATE solicitud_herramienta\n" +
                "  SET id_est_soli_herra = 'EHE2', fecha_solicitud = CURRENT_TIMESTAMP, id_gestor = ?\n" +
                "  WHERE id_solicitud = ? ";
        jdbcTemplate.update(SQL,id_gestor , id_solicitud);


    }

    @Override
    public void rechazarSolicitud(String id_gestor, String id_solicitud) {
        String SQL="UPDATE solicitud_herramienta\n" +
                "  SET id_est_soli_herra = 'EHE3', fecha_solicitud = CURRENT_TIMESTAMP, id_gestor = ?\n" +
                "  WHERE id_solicitud = ? ";
        jdbcTemplate.update(SQL,id_gestor , id_solicitud);

    }


}
