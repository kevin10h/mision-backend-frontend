package uni.edu.pe.demo.Dto;

import lombok.Data;

@Data
public class DetalleTabla {
    private int cantidad_insumo;
    private String tipo_insumo;
    private String fecha_solicitud;
    private String nombre_transportista;
    private String id_transporte;
    private String fecha_transporte;
   /* private String id_tipo_vehiculo;
    private String id_Transportista;*/

    public DetalleTabla() {
        this.cantidad_insumo = cantidad_insumo;
        this.tipo_insumo = tipo_insumo;
        this.fecha_solicitud = fecha_solicitud;
        this.nombre_transportista = nombre_transportista;
        this.id_transporte = id_transporte;
        this.fecha_transporte = fecha_transporte;
       /* this.id_tipo_vehiculo = id_tipo_vehiculo;
        this.id_Transportista = id_Transportista;*/
    }
}
