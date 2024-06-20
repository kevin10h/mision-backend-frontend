package uni.pe.DBD.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ObservacionDto {
    private String id_observacion;
    private LocalDate fecha_observacion;
    private String id_descrip_observacion;
    private String id_estado_observacion;
    private String id_asignacion;

    public String getId_observacion() {
        return id_observacion;
    }

    public void setId_observacion(String id_observacion) {
        this.id_observacion = id_observacion;
    }

    public LocalDate getFecha_observacion() {
        return fecha_observacion;
    }

    public void setFecha_observacion(LocalDate fecha_observacion) {
        this.fecha_observacion = fecha_observacion;
    }

    public String getId_estado_observacion() {
        return id_estado_observacion;
    }

    public void setId_estado_observacion(String id_estado_observacion) {
        this.id_estado_observacion = id_estado_observacion;
    }

    public String getId_descrip_observacion() {
        return id_descrip_observacion;
    }

    public void setId_descrip_observacion(String id_descrip_observacion) {
        this.id_descrip_observacion = id_descrip_observacion;
    }

    public String getId_asignacion() {
        return id_asignacion;
    }

    public void setId_asignacion(String id_asignacion) {
        this.id_asignacion = id_asignacion;
    }
}
