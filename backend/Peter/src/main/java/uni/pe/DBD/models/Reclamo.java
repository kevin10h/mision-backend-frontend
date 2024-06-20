package uni.pe.DBD.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Reclamo {
    String id_reclamo;
    LocalDate fecha_reclamo;
    String id_descrip_reclamo;
    String id_estado_reclamo;
    String id_operario;
}
