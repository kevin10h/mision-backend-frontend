package uni.pe.DBD.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import uni.pe.DBD.dto.SolicitudHerramientaDto;
import uni.pe.DBD.models.Herramienta;
import uni.pe.DBD.models.SolicitudHerramienta;
import uni.pe.DBD.service.HerramientaServiceI;

import java.util.List;

@RestController
@RequestMapping("/solicitudHerramienta")
@CrossOrigin(origins = "${url.client}")
public class HerramientaController {
    @Autowired
    HerramientaServiceI herramientaService;

    @GetMapping("/getByCodigo/{s}")
    public ResponseEntity<List<Herramienta>> getByCodigo(@PathVariable String s){
        return new ResponseEntity<>(herramientaService.getByCodigo(s), HttpStatus.OK);
    }
    @GetMapping("/getByNombre/{nombre}")
    public ResponseEntity<List<Herramienta>> getByNombre(@PathVariable String nombre) {
        return new ResponseEntity<>(herramientaService.getByNombre(nombre), HttpStatus.OK);
    }
    @PostMapping("/solicitudRequest")
    public ResponseEntity<String> solicitudRequest(@RequestBody SolicitudHerramientaDto dto) {
        herramientaService.solicitudRequest(dto);
        return new ResponseEntity<>("Solicitud enviada" ,HttpStatus.OK);
    }
    @GetMapping("/getByIDOperario/{id_operario}")
    public ResponseEntity<List<SolicitudHerramienta>> getByIDOperario(@PathVariable String id_operario) {
        return new ResponseEntity<>(herramientaService.getByIDOperario(id_operario), HttpStatus.OK);
    }
    @GetMapping("/getBySolicitudPendiente")
    public ResponseEntity<List<SolicitudHerramienta>> getBySolicitudPendiente() {
        return new ResponseEntity<>(herramientaService.getBySolicitudPendiente(), HttpStatus.OK);
    }
    @GetMapping("/getByOperario/{operario}")
    public ResponseEntity<List<SolicitudHerramienta>> getByOperario(@PathVariable String operario) {
        return new ResponseEntity<>(herramientaService.getByOperario(operario), HttpStatus.OK);
    }
    @PostMapping("/aprobarSolicitud/{id_gestor}/{id_solicitud}")
    public ResponseEntity<String> aprobarSolicitud(@PathVariable String id_gestor , @PathVariable String id_solicitud) {
        herramientaService.aprobarSolicitud(id_gestor, id_solicitud);
        return new ResponseEntity<>("Solicitud aceptada", HttpStatus.OK);
    }
    @PostMapping("/rechazarSolicitud/{id_gestor}/{id_solicitud}")
    public ResponseEntity<String> rechazarSolicitud(@PathVariable String id_gestor , @PathVariable String id_solicitud) {
        herramientaService.rechazarSolicitud(id_gestor, id_solicitud);
        return new ResponseEntity<>("Solicitud rechazada", HttpStatus.OK);
    }

}
