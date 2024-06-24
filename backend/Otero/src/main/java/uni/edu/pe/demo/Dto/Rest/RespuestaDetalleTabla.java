package uni.edu.pe.demo.Dto.Rest;

import lombok.Data;
import uni.edu.pe.demo.Dto.DetalleTabla;
import uni.edu.pe.demo.Dto.ReporteTabla;

import java.util.List;

@Data
public class RespuestaDetalleTabla {
    private List<DetalleTabla> reportes;
}
