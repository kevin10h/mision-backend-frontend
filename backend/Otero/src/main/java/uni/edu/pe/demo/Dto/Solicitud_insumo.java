package uni.edu.pe.demo.Dto;
import lombok.AllArgsConstructor;
import lombok.Data;
@Data
public class Solicitud_insumo {
    private String id_solicitud_insumo;
    private String fecha_solicitud;
    private String id_gestor;
    private String tipo_insumo;
    private int cantidad_insumo;
    private String Nombre_provedor;

    public Solicitud_insumo(String id_solicitud_insumo, String fecha_solicitud, String id_gestor, String tipo_insumo, int cantidad_insumo, String nombre_provedor) {
        this.id_solicitud_insumo = id_solicitud_insumo;
        this.fecha_solicitud = fecha_solicitud;
        this.id_gestor = id_gestor;
        this.tipo_insumo = tipo_insumo;
        this.cantidad_insumo = cantidad_insumo;
        this.Nombre_provedor = nombre_provedor;
    }
}
