package uni.pe.DBD.repository;

import uni.pe.DBD.dto.BonificacionFilterDto;
import uni.pe.DBD.models.Bonificacion;

import java.util.List;

public interface BonificacionRepositoryI {
    List<Bonificacion> getBonificaciones(BonificacionFilterDto dto);
}
