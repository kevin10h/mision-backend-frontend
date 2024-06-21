package uni.pe.DBD.models;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Bonificacion {
    String id_bonificacion;
    int monto_bonificacion;
    String tipo_bonificacion;
}
