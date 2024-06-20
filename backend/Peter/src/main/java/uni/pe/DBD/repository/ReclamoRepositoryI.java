package uni.pe.DBD.repository;

import uni.pe.DBD.models.Reclamo;

import java.time.LocalDate;
import java.util.List;

public interface ReclamoRepositoryI {
    List<Reclamo> getAllRec();
    List<Reclamo> getByIDReclamo(String id_reclamo);
    List<Reclamo> getByIDOperario(String id_operario);
    List<Reclamo> getByFechaRec(LocalDate fecha_reclamo);
    List<Reclamo> getByEstRec(String id_estado_reclamo);
}
