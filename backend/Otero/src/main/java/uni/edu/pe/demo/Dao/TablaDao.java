package uni.edu.pe.demo.Dao;

import uni.edu.pe.demo.Dto.*;

import java.util.List;

public interface TablaDao {
    Solicitud_insumo InsertarSolicitudInsumo(Solicitud_insumo solicitudInsumo);
    List<DetalleTabla> obtenerDatosTransporte(String id_transporte);
    ReporteTabla ActualizarTabla(ReporteTabla reporteTabla);
}
