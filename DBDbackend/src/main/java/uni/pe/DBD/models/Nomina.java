package uni.pe.DBD.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Nomina {
    String id_nomina;
    int total_pago;
    Date fecha;
    String periodo_pago;
    String gestor;
    int bonificacion;
    int deduccion;
    int sueldo_base;
}
