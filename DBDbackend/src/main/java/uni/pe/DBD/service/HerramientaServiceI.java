package uni.pe.DBD.service;

import uni.pe.DBD.dto.SolicitudHerramientaDto;
import uni.pe.DBD.models.Herramienta;
import uni.pe.DBD.models.SolicitudHerramienta;

import java.util.List;

public interface HerramientaServiceI {
    List<Herramienta> getByCodigo (String s);
    List<Herramienta> getByNombre(String nombre);
    void solicitudRequest(SolicitudHerramientaDto dto);
    List<SolicitudHerramienta> getByIDOperario (String id_operario);
    List<SolicitudHerramienta> getBySolicitudPendiente ();
    List<SolicitudHerramienta> getByOperario (String operario);
    void aprobarSolicitud(String id_gestor , String id_solicitud);
    void rechazarSolicitud(String id_gestor , String id_solicitud);
}
