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
    public Tipo_Vehiculo insertarCatalago1(Tipo_Vehiculo tipoVehiculo) {
        return dao.insertarCatalago1(tipoVehiculo);
    }
    @Override
    public Transporte insertarCatalago2(Transporte transporte) {
        return dao.insertarCatalago2(transporte);
    }
    @Override
    public Insumo insertarCatalago3(Insumo insumo){
        return dao.insertarCatalago3(insumo);
    }
    @Override
    public List<DetalleTabla> obtenerDatosTransporte(){
        return dao.obtenerDatosTransporte();
    }
    @Override
    public Solicitud_insumo InsertarCatalago5(Solicitud_insumo solicitudInsumo) {
        return dao.InsertarCatalago5(solicitudInsumo);
    }
    @Override
    public ReporteTabla ActualizarTabla(ReporteTabla reporteTabla){
        return dao.ActualizarTabla(reporteTabla);
    }
}
