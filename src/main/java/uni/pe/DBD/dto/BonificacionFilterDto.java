package uni.pe.DBD.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BonificacionFilterDto {
    String id_bonificacion;
    String id_tipo_bonificacion;
}
