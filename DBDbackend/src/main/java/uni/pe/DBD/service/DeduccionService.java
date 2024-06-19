package uni.pe.DBD.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import uni.pe.DBD.dto.DeduccionDto;
import uni.pe.DBD.models.Deduccion;
import uni.pe.DBD.repository.DeduccionRepositoryI;

import java.util.List;

@Service
public class DeduccionService implements DeduccionServiceI{
    @Autowired
    DeduccionRepositoryI deduccionRepositoryI;

    @Override
    public List<Deduccion> getDeducciones(DeduccionDto dto) {
        return deduccionRepositoryI.getDeducciones(dto);
    }
}
