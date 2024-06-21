package uni.pe.DBD.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import uni.pe.DBD.models.Bonificacion;
import uni.pe.DBD.repository.BonificacionRepositoryI;

import java.util.List;

@Service
public class BonificacionService implements BonificacionServiceI{
    @Autowired
    BonificacionRepositoryI bonificacionRepositoryI;

    @Override
    public List<Bonificacion> getAll() {
        return bonificacionRepositoryI.getAll();
    }

    @Override
    public List<Bonificacion> getByID(String id) {
        return bonificacionRepositoryI.getByID(id);
    }

    @Override
    public List<Bonificacion> getByBonificacion_type(String b) {
        return bonificacionRepositoryI.getByBonificacion_type(b);
    }

    @Override
    public List<Bonificacion> getByID_Bonif_type(String b, String id) {
        return bonificacionRepositoryI.getByID_Bonif_type(b,id);
    }
}
