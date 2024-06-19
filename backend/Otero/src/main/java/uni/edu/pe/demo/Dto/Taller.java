package uni.edu.pe.demo.Dto;
import lombok.Data;
@Data

public class Taller {
    private String id_taller;
    private int capacidad_taller;
    private String id_cate_taller;

    public Taller(String id_taller, int capacidad_taller, String id_cate_taller) {
        this.id_taller = id_taller;
        this.capacidad_taller = capacidad_taller;
        this.id_cate_taller = id_cate_taller;
    }
}
