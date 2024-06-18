package uni.pe.DBD.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import uni.pe.DBD.dto.SolicitudHerramientaDto;
import uni.pe.DBD.models.Herramienta;
import uni.pe.DBD.models.SolicitudHerramienta;
import uni.pe.DBD.repository.HerramientaRepositoryI;

import java.util.List;

@Service
public class HerramientaService implements HerramientaServiceI {
    @Autowired
    HerramientaRepositoryI herramientaRepositoryI;

    @Override
    public List<Herramienta> getByCodigo(String s) {
        return herramientaRepositoryI.getByCodigo(s);
    }

    @Override
    public List<Herramienta> getByNombre(String nombre) {
        return herramientaRepositoryI.getByNombre(nombre);
    }

    @Override
    public void solicitudRequest(SolicitudHerramientaDto dto) {
        herramientaRepositoryI.solicitudRequest(dto);

    }

    @Override
    public List<SolicitudHerramienta> getByIDOperario(String id_operario) {
        return herramientaRepositoryI.getByIDOperario(id_operario);
    }

    @Override
    public List<SolicitudHerramienta> getBySolicitudPendiente() {
        return herramientaRepositoryI.getBySolicitudPendiente();
    }

    @Override
    public List<SolicitudHerramienta> getByOperario(String operario) {
        return herramientaRepositoryI.getByOperario(operario);
    }

    @Override
    public void aprobarSolicitud(String id_gestor, String id_solicitud) {
        herramientaRepositoryI.aprobarSolicitud(id_gestor , id_solicitud);

    }

    @Override
    public void rechazarSolicitud(String id_gestor, String id_solicitud) {
        herramientaRepositoryI.rechazarSolicitud(id_gestor , id_solicitud);

    }
}
