package uni.edu.pe.demo.Dto;

import lombok.Data;

@Data

public class ReporteTabla {

    private String id_Transportista;
    private String ruta;

    public ReporteTabla( String id_Transportista, String ruta) {
        this.id_Transportista = id_Transportista;
        this.ruta = ruta;
    }
}
