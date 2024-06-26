package uni.edu.pe.demo.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import uni.edu.pe.demo.Dto.*;
import uni.edu.pe.demo.Dto.Rest.RespuestaDetalleTabla;
import uni.edu.pe.demo.service.BackendService;

@RestController
@CrossOrigin(origins = {"*"})
public class backendController {

    @Autowired
    private BackendService service;

    @PostMapping( value = "/insertarSolicitudInsumo",
            produces = "application/json;charset=UTF-8",
            consumes = "application/json"
    )
    public Solicitud_insumo InsertarSolicitudInsumo(@RequestBody Solicitud_insumo solicitudInsumo){
        return  service.InsertarSolicitudInsumo(solicitudInsumo);
    }
   @GetMapping( value = "/obtenerDatosTransporte",
           produces = "application/json;charset=UTF-8",
           consumes = "application/json"

   )
    public
   RespuestaDetalleTabla obtenerDatosTransporte(String id_transporte){
       RespuestaDetalleTabla rpta =  new RespuestaDetalleTabla();
       rpta.setReportes(service.obtenerDatosTransporte(id_transporte));
        return rpta;
   }
    @PutMapping( value = "/ActualizarTabla",
            produces = "application/json;charset=UTF-8" ,
            consumes = "application/json"
    )
    public ReporteTabla actualizarCatalogo4(@RequestBody ReporteTabla reporteTabla) {
        return service.ActualizarTabla(reporteTabla);
    }
}
