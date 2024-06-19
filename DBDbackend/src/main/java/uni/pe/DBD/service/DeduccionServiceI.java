package uni.pe.DBD.service;

import uni.pe.DBD.dto.DeduccionDto;
import uni.pe.DBD.models.Deduccion;

import java.util.List;

public interface DeduccionServiceI {
    List<Deduccion> getDeducciones(DeduccionDto dto);
}
