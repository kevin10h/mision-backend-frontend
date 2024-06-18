package uni.pe.DBD.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Timestamp;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SolicitudHerramienta {
    String id_solicitud;
    Timestamp fecha_solicitud;
    String estado;
    String operario;
    String gestor;
    String herramienta;
    String modelo_herramienta;

}
