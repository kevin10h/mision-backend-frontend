package uni.pe.DBD.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SolicitudHerramientaDto {
    String id_est_soli_herra;
    String id_operario;
    String id_herramienta;
}

