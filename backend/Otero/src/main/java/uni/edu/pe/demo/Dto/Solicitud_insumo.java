package uni.edu.pe.demo.Dto;
import lombok.Data;
@Data
public class Solicitud_insumo {
    private String id_solicitud_insumo;
    private String fecha_solicitud;
    private String estado_solicitud;
    private String id_gestor;
    private String id_insumo;

    public Solicitud_insumo(String id_solicitud_insumo, String fecha_solicitud, String estado_solicitud, String id_gestor, String id_insumo) {
        this.id_solicitud_insumo = id_solicitud_insumo;
        this.fecha_solicitud = fecha_solicitud;
        this.estado_solicitud = estado_solicitud;
        this.id_gestor = id_gestor;
        this.id_insumo = id_insumo;
    }
}
