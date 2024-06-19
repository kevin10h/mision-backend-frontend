package uni.pe.DBD.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Herramienta {
    String id_herramienta;
    String herramienta;
    String modelo;
    String proveedor;
}
