package uni.edu.pe.demo.Dto;
import lombok.Data;
@Data
public class Transporte {
    private String id_transporte;
    private String id_operario;
    private String fecha_transporte;
    private String id_tipo_vehiculo;

    public Transporte(String id_transporte, String id_operario, String fecha_transporte, String id_tipo_vehiculo) {
        this.id_transporte = id_transporte;
        this.id_operario = id_operario;
        this.fecha_transporte = fecha_transporte;
        this.id_tipo_vehiculo = id_tipo_vehiculo;
    }
}
