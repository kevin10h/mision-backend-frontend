package uni.pe.DBD.repository;

import uni.pe.DBD.dto.NominaFilterDto;
import uni.pe.DBD.models.Nomina;

import java.util.List;

public interface NominaRepositoryI {
    List<Nomina> getNominas(NominaFilterDto dto);
}
