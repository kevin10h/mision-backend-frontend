package uni.pe.DBD.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import uni.pe.DBD.dto.DeduccionDto;
import uni.pe.DBD.models.Deduccion;

import java.util.List;

@Repository
public class DeduccionRepository implements DeduccionRepositoryI{
    @Autowired
    JdbcTemplate jdbcTemplate;

    @Override
    public List<Deduccion> getDeducciones(DeduccionDto dto) {
        String SQL= "SELECT d.id_deduccion,d.monto_deducido AS monto,td.nom_tipo_deduccion AS tipo_deduccion\n" +
                    "FROM deduccion d\n" +
                    "INNER JOIN tipo_deduccion td ON d.id_tipo_deduccion=td.id_tipo_deduccion\n" +
                    "WHERE\n" +
                    "\tCASE WHEN TRIM(?)='' THEN TRUE\n" +
                    "\tELSE d.id_deduccion ILIKE '%' || TRIM(?) || '%'\n" +
                    "\tEND\n" +
                    "AND\n" +
                    "\tCASE WHEN ?='' THEN TRUE\n" +
                    "\tELSE td.id_tipo_deduccion=?\n" +
                    "\tEND";
        return jdbcTemplate.query(SQL,new BeanPropertyRowMapper<>(Deduccion.class),dto.getId_deduccion(),dto.getId_deduccion(),dto.getId_tipo_deduccion(),dto.getId_tipo_deduccion());
    }
}
