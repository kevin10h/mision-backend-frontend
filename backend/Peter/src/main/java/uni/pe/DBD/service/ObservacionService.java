package uni.pe.DBD.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import uni.pe.DBD.models.*;
import uni.pe.DBD.repository.ObservacionRepositoryI;

import java.time.LocalDate;
import java.util.List;

@Service
public class ObservacionService implements ObservacionServiceI {
    @Autowired
    ObservacionRepositoryI ObservacionRepositoryI;

    @Override
    public List<Observacion> getAllObs(){
        return ObservacionRepositoryI.getAllObs();
    }

    @Override
    public List<Observacion> getByIDObservacion(String id_observacion) {
        return  ObservacionRepositoryI.getByIDObservacion(id_observacion);
    }

    @Override
    public List<Observacion> getByIDAsignacion(String id_asignacion) {
        return  ObservacionRepositoryI.getByIDAsignacion(id_asignacion);
    }

    @Override
    public List<Observacion> getByFechaObs(LocalDate fecha_observacion) {
        return  ObservacionRepositoryI.getByFechaObs(fecha_observacion);
    }

    @Override
    public List<Observacion> getByEstObs(String id_estado_observacion) {
        return  ObservacionRepositoryI.getByEstObs(id_estado_observacion);
    }
}