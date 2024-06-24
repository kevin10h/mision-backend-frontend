package uni.edu.pe.demo.Dto;

import lombok.Data;

@Data

public class ReporteTabla {
    private String estado_solicitud;
    private String id_solicitud_insumo;

    public ReporteTabla(String estado_solicitud, String id_solicitud_insumo) {
        this.estado_solicitud = estado_solicitud;
        this.id_solicitud_insumo = id_solicitud_insumo;
    }
}
