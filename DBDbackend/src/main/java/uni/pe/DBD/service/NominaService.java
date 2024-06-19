package uni.pe.DBD.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import uni.pe.DBD.dto.NominaFilterDto;
import uni.pe.DBD.models.Nomina;
import uni.pe.DBD.repository.NominaRepositoryI;

import java.util.List;

@Service
public class NominaService implements NominaServiceI {
    @Autowired
    NominaRepositoryI nominaRepositoryI;

    @Override
    public List<Nomina> getNominas(NominaFilterDto dto) {
        return nominaRepositoryI.getNominas(dto);
    }
}
