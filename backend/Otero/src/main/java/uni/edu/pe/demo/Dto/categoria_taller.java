package uni.edu.pe.demo.Dto;
import lombok.Data;
@Data
public class categoria_taller {
    private String id_cate_taller;
    private String nom_cate_taller;

    public categoria_taller(String id_cate_taller, String nom_cate_taller) {
        this.id_cate_taller = id_cate_taller;
        this.nom_cate_taller = nom_cate_taller;
    }

}
