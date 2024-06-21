package uni.pe.DBD.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import uni.pe.DBD.models.Bonificacion;

import java.util.List;

@Repository
public class BonificacionRepository implements BonificacionRepositoryI{
    @Autowired
    JdbcTemplate jdbcTemplate;
    @Override
    public List<Bonificacion> getAll() {
        String SQL="SELECT c.id_bonificacion,c.monto_bonificacion,t.nom_tipo_boni AS tipo_bonificacion\n" +
                "FROM bonificacion c\n" +
                "INNER JOIN tipo_bonificacion t ON c.id_tipo_boni=t.id_tipo_boni";
        return jdbcTemplate.query(SQL,new BeanPropertyRowMapper<>(Bonificacion.class));
    }

    @Override
    public List<Bonificacion> getByID(String id) {
        String SQL="SELECT c.id_bonificacion,c.monto_bonificacion,t.nom_tipo_boni AS tipo_bonificacion\n" +
                "FROM bonificacion c\n" +
                "INNER JOIN tipo_bonificacion t ON c.id_tipo_boni=t.id_tipo_boni" +
                " WHERE LOWER(c.id_bonificacion) LIKE '%"+id.toLowerCase()+"%'";
        return jdbcTemplate.query(SQL,new BeanPropertyRowMapper<>(Bonificacion.class));
    }

    @Override
    public List<Bonificacion> getByBonificacion_type(String b) {
        String SQL="SELECT c.id_bonificacion,c.monto_bonificacion,t.nom_tipo_boni AS tipo_bonificacion\n" +
                "FROM bonificacion c\n" +
                "INNER JOIN tipo_bonificacion t ON c.id_tipo_boni=t.id_tipo_boni" +
                " WHERE c.id_tipo_boni=?";
        return jdbcTemplate.query(SQL,new BeanPropertyRowMapper<>(Bonificacion.class),b);
    }

    @Override
    public List<Bonificacion> getByID_Bonif_type(String b, String id) {
        String SQL="SELECT c.id_bonificacion,c.monto_bonificacion,t.nom_tipo_boni AS tipo_bonificacion\n" +
                "FROM bonificacion c\n" +
                "INNER JOIN tipo_bonificacion t ON c.id_tipo_boni=t.id_tipo_boni" +
                " WHERE LOWER(c.id_bonificacion) LIKE '%"+id.toLowerCase()+"%' AND t.id_tipo_boni=?";
        return jdbcTemplate.query(SQL,new BeanPropertyRowMapper<>(Bonificacion.class),b);
    }
}
