package uni.pe.DBD.repository;

import uni.pe.DBD.dto.AsignacionActividadDto;
import uni.pe.DBD.models.*;

import java.time.LocalDate;
import java.util.List;

public interface ActividadesRepositoryI {
    List<AsignacionActividad> getAllAsig();
    List<AsignacionActividad> getByIDGestor(String id_gestor);
    List<AsignacionActividad> getByIDOperario(String id_operario);
    List<AsignacionActividad> getByFechaAsig(LocalDate fecha_inicio, LocalDate fecha_fin);
    List<AsignacionActividad> getByEstAsig(String est_asig);
    void asignarActividad(AsignacionActividadDto dto);
    void cancelarActividad(String id_asignacion);
    void envioRevisionActividad(String id_asignacion);
    void finalizarActividad(String id_asignacion);
    void defectoActividad(String id_asignacion);
}
