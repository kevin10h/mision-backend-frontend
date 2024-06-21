package uni.pe.DBD.models;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.time.LocalDate;
import java.time.LocalTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AsignacionActividad {
    String id_asignacion;
    String id_operario;
    String operario;
    String actividad;
    LocalDate fecha_asig;
    LocalTime hora_inicio;
    LocalTime hora_fin;
    String id_gestor;
    String gestor;
    String id_lote;
    String estado_asignacion;
}