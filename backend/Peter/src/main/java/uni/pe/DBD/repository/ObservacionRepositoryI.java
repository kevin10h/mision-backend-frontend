package uni.pe.DBD.repository;

import uni.pe.DBD.models.*;

import java.time.LocalDate;
import java.util.List;

public interface ObservacionRepositoryI {
    List<Observacion> getAllObs();
    List<Observacion> getByIDObservacion(String id_observacion);
    List<Observacion> getByIDAsignacion(String id_asignacion);
    List<Observacion> getByFechaObs(LocalDate fecha_observacion);
    List<Observacion> getByEstObs(String id_estado_observacion);
}
