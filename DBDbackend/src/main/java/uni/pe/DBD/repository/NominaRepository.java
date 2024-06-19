package uni.pe.DBD.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import uni.pe.DBD.dto.NominaFilterDto;
import uni.pe.DBD.models.Nomina;

import java.util.List;

@Repository
public class NominaRepository implements NominaRepositoryI{
    @Autowired
    JdbcTemplate jdbcTemplate;
    @Override
    public List<Nomina> getNominas(NominaFilterDto dto) {
        String SQL= "SELECT n.id_nomina,n.total_pago,n.fecha_emision AS fecha,p.nom_periodo_pago AS periodo_pago,\n" +
                    "CONCAT(g.prim_nom_ges,' ',g.seg_nom_ges,' ',g.prim_ape_ges,' ',g.seg_ape_ges) AS gestor,\n" +
                    "b.monto_bonificacion AS bonificacion,d.monto_deducido AS deduccion,s.monto_sueldo_base AS sueldo_base\n" +
                    "FROM nomina n\n" +
                    "INNER JOIN periodo_pago p ON n.id_periodo_pago=p.id_periodo_pago\n" +
                    "INNER JOIN gestor_produccion g ON n.id_gestor=g.id_gestor\n" +
                    "INNER JOIN bonificacion b ON n.id_bonificacion=b.id_bonificacion\n" +
                    "INNER JOIN deduccion d ON n.id_deduccion=d.id_deduccion\n" +
                    "INNER JOIN tipo_sueldo_base s ON n.id_sueldo_base=s.id_sueldo_base\n" +
                    "WHERE\n" +
                    "\tCASE\n" +
                    "\tWHEN ? IS NULL THEN TRUE\n" +
                    "\tELSE n.fecha_emision=?\n" +
                    "\tEND\n" +
                    "AND\n" +
                    "\tCASE\n" +
                    "\tWHEN TRIM(?)='' THEN TRUE\n" +
                    "\tELSE d.id_nomina ILIKE '%' || TRIM(?) || '%'\n" +
                    "\tEND";
        return jdbcTemplate.query(SQL,new BeanPropertyRowMapper<>(Nomina.class),dto.getFecha_emision(),dto.getFecha_emision(),dto.getId_nomina(),dto.getId_nomina());
    }
}
