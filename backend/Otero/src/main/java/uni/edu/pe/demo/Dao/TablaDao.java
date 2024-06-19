package uni.edu.pe.demo.Dao;

import uni.edu.pe.demo.Dto.*;

import java.util.List;

public interface TablaDao {
  /*  ReporteTabla actualizarTabla(ReporteTabla reporteTabla);*/
    categoria_taller insertarCatalago1(categoria_taller Categoria_Taller);
    gestor_produccion insertarCatalago2(gestor_produccion Gestor_produccion);
    Insumo insertarCatalago3(Insumo insumo);
    /*Operario InsertarCatalago4(Operario operario);
    */
    Solicitud_insumo InsertarCatalago5(Solicitud_insumo solicitudInsumo);
    /*Taller InsertarCatalago6(Taller taller);
    Tipo_vehiculo InsertarCatalago7 (Tipo_vehiculo tipoVehiculo);
    Transporte InsertarCatalago8(Transporte transporte);
*/
    List<DetalleTabla> obtenerDatosTransporte();


}
