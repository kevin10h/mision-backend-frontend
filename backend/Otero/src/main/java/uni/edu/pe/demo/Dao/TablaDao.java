package uni.edu.pe.demo.Dao;

import uni.edu.pe.demo.Dto.*;

import java.util.List;

public interface TablaDao {
  Tipo_Vehiculo insertarCatalago1(Tipo_Vehiculo tipoVehiculo);
  Transporte insertarCatalago2(Transporte transporte);
    Insumo insertarCatalago3(Insumo insumo);
    Solicitud_insumo InsertarCatalago5(Solicitud_insumo solicitudInsumo);
    List<DetalleTabla> obtenerDatosTransporte();
    ReporteTabla ActualizarTabla(ReporteTabla reporteTabla);
}
