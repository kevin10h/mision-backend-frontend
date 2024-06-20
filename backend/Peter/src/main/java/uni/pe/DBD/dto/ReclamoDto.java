package uni.pe.DBD.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ReclamoDto {
    private String id_reclamo;
    private LocalDate fecha_reclamo;
    private String id_descrip_reclamo;
    private String id_estado_reclamo;
    private String id_operario;

    public String getId_reclamo() {
        return id_reclamo;
    }

    public void setId_reclamo(String id_reclamo) {
        this.id_reclamo = id_reclamo;
    }

    public LocalDate getFecha_reclamo() {
        return fecha_reclamo;
    }

    public void setFecha_reclamo(LocalDate fecha_reclamo) {
        this.fecha_reclamo = fecha_reclamo;
    }

    public String getId_descrip_reclamo() {
        return id_descrip_reclamo;
    }

    public void setId_descrip_reclamo(String id_descrip_reclamo) {
        this.id_descrip_reclamo = id_descrip_reclamo;
    }

    public String getId_estado_reclamo() {
        return id_estado_reclamo;
    }

    public void setId_estado_reclamo(String id_estado_reclamo) {
        this.id_estado_reclamo = id_estado_reclamo;
    }

    public String getId_operario() {
        return id_operario;
    }

    public void setId_operario(String id_operario) {
        this.id_operario = id_operario;
    }
}
