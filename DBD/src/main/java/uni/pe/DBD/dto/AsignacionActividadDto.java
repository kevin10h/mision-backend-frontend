package uni.pe.DBD.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.time.LocalDate;
import java.time.LocalTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AsignacionActividadDto {
    String id_operario;
    String id_actividad;
    LocalDate fecha_asig;
    LocalTime hora_inicio;
    LocalTime hora_fin;
    String id_gestor;
    String id_lote;

    public String getId_operario() {
        return id_operario;
    }

    public void setId_operario(String id_operario) {
        this.id_operario = id_operario;
    }

    public LocalDate getFecha_asig() {
        return fecha_asig;
    }

    public void setFecha_asig(LocalDate fecha_asig) {
        this.fecha_asig = fecha_asig;
    }

    public LocalTime getHora_inicio() {
        return hora_inicio;
    }

    public void setHora_inicio(LocalTime hora_inicio) {
        this.hora_inicio = hora_inicio;
    }

    public LocalTime getHora_fin() {
        return hora_fin;
    }

    public void setHora_fin(LocalTime hora_fin) {
        this.hora_fin = hora_fin;
    }

    public String getId_gestor() {
        return id_gestor;
    }

    public void setId_gestor(String id_gestor) {
        this.id_gestor = id_gestor;
    }

    public String getId_lote() {
        return id_lote;
    }

    public void setId_lote(String id_lote) {
        this.id_lote = id_lote;
    }

    public String getId_actividad() {
        return id_actividad;
    }

    public void setId_actividad(String id_actividad) {
        this.id_actividad = id_actividad;
    }
}