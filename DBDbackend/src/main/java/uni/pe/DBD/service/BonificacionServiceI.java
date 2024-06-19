package uni.pe.DBD.service;

import uni.pe.DBD.dto.BonificacionFilterDto;
import uni.pe.DBD.models.Bonificacion;

import java.util.List;

public interface BonificacionServiceI {
    List<Bonificacion> getBonificaciones(BonificacionFilterDto dto);
}
