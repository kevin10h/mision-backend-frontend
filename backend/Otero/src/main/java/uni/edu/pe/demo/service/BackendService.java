package uni.edu.pe.demo.service;

import uni.edu.pe.demo.Dto.*;

import java.util.List;

public interface BackendService {
    Solicitud_insumo InsertarSolicitudInsumo(Solicitud_insumo solicitudInsumo);
    List<DetalleTabla> obtenerDatosTransporte(String id_transporte);
    ReporteTabla ActualizarTabla(ReporteTabla reporteTabla);
}
