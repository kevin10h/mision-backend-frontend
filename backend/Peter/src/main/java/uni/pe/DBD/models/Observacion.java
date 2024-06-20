package uni.pe.DBD.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Observacion {
    String id_observacion;
    LocalDate fecha_observacion;
    String id_descrip_observacion;
    String id_estado_observacion;
    String id_asignacion;
}
