package uni.edu.pe.demo.Dto;
import lombok.Data;
@Data
public class Tipo_Vehiculo {
    private String id_tipo_vehiculo;
    private String nombre_tipo_vehiculo;

    public Tipo_Vehiculo(String id_tipo_vehiculo, String nombre_tipo_vehiculo) {
        this.id_tipo_vehiculo = id_tipo_vehiculo;
        this.nombre_tipo_vehiculo = nombre_tipo_vehiculo;
    }
}
