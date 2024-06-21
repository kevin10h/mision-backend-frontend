package uni.pe.DBD.models;


import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Lote {
    String id_lote;
    LocalDate fecha_produccion;
    int cant_prod;
}
