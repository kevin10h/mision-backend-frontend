package uni.pe.DBD.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import uni.pe.DBD.models.*;
import uni.pe.DBD.repository.ReclamoRepositoryI;

import java.time.LocalDate;
import java.util.List;

@Service
public class ReclamoService implements ReclamoServiceI{
    @Autowired
    ReclamoRepositoryI ReclamoRepositoryI;

    @Override
    public List<Reclamo> getAllRec(){
        return ReclamoRepositoryI.getAllRec();
    }

    @Override
    public List<Reclamo> getByIDReclamo(String id_reclamo) {
        return  ReclamoRepositoryI.getByIDReclamo(id_reclamo);
    }

    @Override
    public List<Reclamo> getByIDOperario(String id_operario) {
        return  ReclamoRepositoryI.getByIDOperario(id_operario);
    }

    @Override
    public List<Reclamo> getByFechaRec(LocalDate fecha_reclamo) {
        return  ReclamoRepositoryI.getByFechaRec(fecha_reclamo);
    }

    @Override
    public List<Reclamo> getByEstRec(String id_estado_reclamo) {
        return  ReclamoRepositoryI.getByEstRec(id_estado_reclamo);
    }
}
