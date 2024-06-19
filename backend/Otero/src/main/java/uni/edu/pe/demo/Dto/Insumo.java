package uni.edu.pe.demo.Dto;
import lombok.Data;
@Data
public class Insumo {
    private String id_insumo;
    private int cantidad_insumo;
    private String tipo_insumo;
    private String id_provedor;

    public Insumo(String id_insumo, int cantidad_insumo, String tipo_insumo, String id_provedor) {
        this.id_insumo = id_insumo;
        this.cantidad_insumo = cantidad_insumo;
        this.tipo_insumo = tipo_insumo;
        this.id_provedor = id_provedor;
    }
}
