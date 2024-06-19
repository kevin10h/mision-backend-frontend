package uni.edu.pe.demo.Dto;
import lombok.Data;
@Data
public class gestor_produccion {
    private String id_gestor;
    private String dni;
    private String prim_nom_ges;
    private String seg_nom_ges;

    private String prim_ape_ges;
    private String seg_ape_ges;

    public gestor_produccion(String id_gestor, String dni, String prim_nom_ges, String seg_nom_ges, String prim_ape_ges, String seg_ape_ges) {
        this.id_gestor = id_gestor;
        this.dni = dni;
        this.prim_nom_ges = prim_nom_ges;
        this.seg_nom_ges = seg_nom_ges;
        this.prim_ape_ges = prim_ape_ges;
        this.seg_ape_ges = seg_ape_ges;
    }

}
