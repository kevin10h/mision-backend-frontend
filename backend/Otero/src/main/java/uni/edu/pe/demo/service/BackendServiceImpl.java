package uni.edu.pe.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import uni.edu.pe.demo.Dao.TablaDao;
import uni.edu.pe.demo.Dto.*;

import java.util.List;

@Service
public class BackendServiceImpl implements BackendService {
    @Autowired
    private TablaDao dao;

    @Override
    public List<DetalleTabla> obtenerDatosTransporte(String id_transporte){
        return dao.obtenerDatosTransporte(id_transporte);
    }
    @Override
    public Solicitud_insumo InsertarSolicitudInsumo(Solicitud_insumo solicitudInsumo) {
        return dao.InsertarSolicitudInsumo(solicitudInsumo);
    }
    @Override
    public ReporteTabla ActualizarTabla(ReporteTabla reporteTabla){
        return dao.ActualizarTabla(reporteTabla);
    }
}
