package uni.pe.DBD.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import uni.pe.DBD.dto.AsignacionActividadDto;
import uni.pe.DBD.models.*;
import uni.pe.DBD.repository.ActividadesRepositoryI;

import java.time.LocalDate;
import java.util.List;

@Service
public class ActividadesService implements ActividadesServiceI {
    @Autowired
    ActividadesRepositoryI ActividadesRepositoryI;

    @Override
    public List<AsignacionActividad> getAllAsig() {
        return  ActividadesRepositoryI.getAllAsig();
    }

    @Override
    public List<AsignacionActividad> getByIDGestor(String id_gestor) {
        return  ActividadesRepositoryI.getByIDGestor(id_gestor);
    }

    @Override
    public List<AsignacionActividad> getByIDOperario(String id_operario) {
        return  ActividadesRepositoryI.getByIDOperario(id_operario);
    }

    @Override
    public List<AsignacionActividad> getByFechaAsig(LocalDate fecha_inicio, LocalDate fecha_fin) {
        return  ActividadesRepositoryI.getByFechaAsig(fecha_inicio,fecha_fin);
    }

    @Override
    public List<AsignacionActividad> getByEstAsig(String est_asig) {
        return  ActividadesRepositoryI.getByEstAsig(est_asig);
    }

    @Override
    public void asignarActividad(AsignacionActividadDto dto) {
        ActividadesRepositoryI.asignarActividad(dto);
    }

    @Override
    public void cancelarActividad(String id_asignacion){
        ActividadesRepositoryI.cancelarActividad(id_asignacion);
    }

    @Override
    public void envioRevisionActividad(String id_asignacion){
        ActividadesRepositoryI.envioRevisionActividad(id_asignacion);
    }

    @Override
    public void finalizarActividad(String id_asignacion){
        ActividadesRepositoryI.finalizarActividad(id_asignacion);
    }
    public void defectoActividad(String id_asignacion){
        ActividadesRepositoryI.defectoActividad(id_asignacion);
    }
}
