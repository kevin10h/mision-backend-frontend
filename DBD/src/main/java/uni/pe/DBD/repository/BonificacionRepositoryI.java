package uni.pe.DBD.repository;

import uni.pe.DBD.models.Bonificacion;

import java.util.List;

public interface BonificacionRepositoryI {
    List<Bonificacion> getAll();
    List<Bonificacion> getByID(String id);
    List<Bonificacion> getByBonificacion_type(String b);
    List<Bonificacion> getByID_Bonif_type(String b,String id);
}
