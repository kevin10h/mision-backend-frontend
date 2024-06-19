package uni.edu.pe.demo.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import uni.edu.pe.demo.Dto.*;
import uni.edu.pe.demo.Dto.Rest.RespuestaDetalleTabla;
import uni.edu.pe.demo.service.BackendService;

import java.awt.*;

@RestController
@CrossOrigin(origins = {"*"})
public class backendController {

    @Autowired
    private BackendService service;

    @PostMapping(value = "/insertarCatalago1",
            produces = "application/json;charset=UTF-8",
            consumes = "application/json")
    public categoria_taller insertarCatalago1(@RequestBody categoria_taller Categoria_taller) {
        return service.insertarCatalago1(Categoria_taller);
    }
    @PostMapping( value = "/insertarCatalogo2",
            produces = "application/json;charset=UTF-8",
            consumes = "application/json")
    public gestor_produccion insertarCatalogo2(@RequestBody gestor_produccion Gestor_produccion){
        return service.insertarCatalago2(Gestor_produccion);
    }
    @PostMapping( value = "/insertarCatalogo3",
            produces = "application/json;charset=UTF-8",
            consumes = "application/json")
    public Insumo insertarCatalago3(@RequestBody Insumo insumo){
        return service.insertarCatalago3(insumo);
    }
    @PostMapping( value = "/insertarCatalogo5",
            produces = "application/json;charset=UTF-8",
            consumes = "application/json"
    )
    public Solicitud_insumo InsertarCatalago5(@RequestBody Solicitud_insumo solicitudInsumo){
        return  service.InsertarCatalago5(solicitudInsumo);
    }
   @GetMapping( value = "/obtenerDatosTransporte",
           produces = "application/json;charset=UTF-8",
           consumes = "application/json"

   )
    public
   RespuestaDetalleTabla obtenerDatosTransporte(){
       RespuestaDetalleTabla rpta =  new RespuestaDetalleTabla();
       rpta.setReportes(service.obtenerDatosTransporte());
        return rpta;
   }
}
