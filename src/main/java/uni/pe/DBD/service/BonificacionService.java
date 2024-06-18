package uni.pe.DBD.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import uni.pe.DBD.dto.BonificacionFilterDto;
import uni.pe.DBD.models.Bonificacion;
import uni.pe.DBD.repository.BonificacionRepositoryI;

import java.util.List;

@Service
public class BonificacionService implements BonificacionServiceI{
    @Autowired
    BonificacionRepositoryI bonificacionRepositoryI;

    @Override
    public List<Bonificacion> getBonificaciones(BonificacionFilterDto dto) {
        return bonificacionRepositoryI.getBonificaciones(dto);
    }
}
