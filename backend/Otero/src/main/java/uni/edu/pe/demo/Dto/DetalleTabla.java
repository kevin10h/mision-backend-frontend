package uni.edu.pe.demo.Dto;

import lombok.Data;

@Data
public class DetalleTabla {
    private String dni;
    private String nombre_tipo_vehiculo;
    private String fecha_transporte;
    private String id_tipo_vehiculo;
    private String id_operario;
    private String nombre_vehiculo;

    public DetalleTabla() {
        this.dni = dni;
        this.nombre_tipo_vehiculo = nombre_tipo_vehiculo;
        this.fecha_transporte = fecha_transporte;
        this.id_tipo_vehiculo = id_tipo_vehiculo;
        this.id_operario = id_operario;
        this.nombre_vehiculo = nombre_vehiculo;
    }
}
