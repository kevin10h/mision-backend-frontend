package uni.pe.DBD.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import uni.pe.DBD.dto.BonificacionFilterDto;
import uni.pe.DBD.models.Bonificacion;

import java.util.List;

@Repository
public class BonificacionRepository implements BonificacionRepositoryI{
    @Autowired
    JdbcTemplate jdbcTemplate;
    @Override
    public List<Bonificacion> getBonificaciones(BonificacionFilterDto dto) {
        String SQL = "SELECT c.id_bonificacion, c.monto_bonificacion, t.nom_tipo_boni AS tipo_bonificacion\n" +
                "FROM bonificacion c\n" +
                "INNER JOIN tipo_bonificacion t ON c.id_tipo_boni = t.id_tipo_boni\n" +
                "WHERE \n" +
                "  CASE\n" +
                "    WHEN TRIM(?) = '' THEN TRUE\n" +
                "    ELSE c.id_bonificacion ILIKE '%' || TRIM(?) || '%'\n" +
                "  END\n" +
                "  AND\n" +
                "  CASE\n" +
                "    WHEN ?= '' THEN TRUE\n" +
                "    ELSE t.id_tipo_boni=?\n" +
                "  END";
        return jdbcTemplate.query(SQL, new BeanPropertyRowMapper<>(Bonificacion.class),dto.getId_bonificacion(),dto.getId_bonificacion(),dto.getId_tipo_bonificacion(),dto.getId_tipo_bonificacion());
    }
}
