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
    public categoria_taller insertarCatalago1(categoria_taller Categoria_Taller) {
        return dao.insertarCatalago1(Categoria_Taller);
    }
    @Override
    public gestor_produccion insertarCatalago2(gestor_produccion Gestor_produccion) {
        return dao.insertarCatalago2(Gestor_produccion);
    }
    @Override
    public Insumo insertarCatalago3(Insumo insumo){
        return dao.insertarCatalago3(insumo);
    }
    @Override
    public List<DetalleTabla> obtenerDatosTransporte(){
        return dao.obtenerDatosTransporte();
    }
/*
    @Override
    public Operario InsertarCatalago4(Operario operario) {
        return dao.InsertarCatalago4(operario);
    }
*/

    @Override
    public Solicitud_insumo InsertarCatalago5(Solicitud_insumo solicitudInsumo) {
        return dao.InsertarCatalago5(solicitudInsumo);
    }
/*
    @Override
    public Taller InsertarCatalago6(Taller taller) {
        return dao.InsertarCatalago6(taller);
    }

    @Override
    public Tipo_vehiculo InsertarCatalago7(Tipo_vehiculo tipoVehiculo) {
        return dao.InsertarCatalago7(tipoVehiculo);
    }

    @Override
    public Transporte InsertarCatalago8(Transporte transporte) {
        return dao.InsertarCatalago8(transporte);
    }*/
}
