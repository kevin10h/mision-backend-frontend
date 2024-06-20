package uni.pe.DBD.service;

import uni.pe.DBD.models.*;

import java.time.LocalDate;
import java.util.List;
public interface ReclamoServiceI {
    List<Reclamo> getAllRec();
    List<Reclamo> getByIDReclamo(String id_reclamo);
    List<Reclamo> getByIDOperario(String id_operario);
    List<Reclamo> getByFechaRec(LocalDate fecha_reclamo);
    List<Reclamo> getByEstRec(String id_estado_reclamo);
}