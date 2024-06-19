package uni.edu.pe.demo.Dto;
import lombok.Data;
@Data
public class Operario {
    private String id_operario;
    private String prim_nom_op;
    private String seg_nom_op;
    private String prim_ape_op;
    private String seg_ape_op;
    private String dni;
    private String id_taller;

    public Operario(String id_operario, String prim_nom_op, String seg_nom_op, String prim_ape_op, String seg_ape_op, String dni, String id_taller) {
        this.id_operario = id_operario;
        this.prim_nom_op = prim_nom_op;
        this.seg_nom_op = seg_nom_op;
        this.prim_ape_op = prim_ape_op;
        this.seg_ape_op = seg_ape_op;
        this.dni = dni;
        this.id_taller = id_taller;
    }
}
