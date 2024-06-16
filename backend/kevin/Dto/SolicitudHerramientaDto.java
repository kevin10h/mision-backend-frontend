package uni.pe.DBD.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SolicitudHerramientaDto {
    String id_est_soli_herra;
    String id_operario;
    String id_herramienta;


    public String getId_operario() {
        return id_operario;
    }

    public void setId_operario(String id_operario) {
        this.id_operario = id_operario;
    }

    public String getId_est_soli_herra() {
        return id_est_soli_herra;
    }

    public void setId_est_soli_herra(String id_est_soli_herra) {
        this.id_est_soli_herra = id_est_soli_herra;
    }

    public String getId_herramienta() {
        return id_herramienta;
    }

    public void setId_herramienta(String id_herramienta) {
        this.id_herramienta = id_herramienta;
    }
}
