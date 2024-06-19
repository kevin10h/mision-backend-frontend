package uni.pe.DBD.repository;

import uni.pe.DBD.dto.DeduccionDto;
import uni.pe.DBD.models.Deduccion;

import java.util.List;

public interface DeduccionRepositoryI {
    List<Deduccion> getDeducciones(DeduccionDto dto);
}
