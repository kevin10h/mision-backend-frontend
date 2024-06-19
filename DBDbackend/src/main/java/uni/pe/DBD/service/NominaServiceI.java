package uni.pe.DBD.service;

import uni.pe.DBD.dto.NominaFilterDto;
import uni.pe.DBD.models.Nomina;

import java.util.List;

public interface NominaServiceI {
    List<Nomina> getNominas(NominaFilterDto dto);
}
