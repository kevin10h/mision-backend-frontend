package uni.pe.DBD.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class NominaFilterDto {
    Date fecha_emision;
    String id_nomina;
}
