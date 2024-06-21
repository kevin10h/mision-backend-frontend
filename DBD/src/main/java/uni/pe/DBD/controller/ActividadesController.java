package uni.pe.DBD.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import uni.pe.DBD.dto.AsignacionActividadDto;
import uni.pe.DBD.models.*;
import uni.pe.DBD.service.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/actividades")
@CrossOrigin(origins = "${url.client}")
@RequiredArgsConstructor
public class ActividadesController {
    @Autowired
    ActividadesServiceI ActividadesServiceI;

    @GetMapping("/getAllAsig")
    public ResponseEntity<List<AsignacionActividad>> getAllAsig(){
        return new ResponseEntity<>(ActividadesServiceI.getAllAsig(), HttpStatus.OK);
    }

    @GetMapping("/getByIDGestor/{id_gestor}")
    public ResponseEntity<List<AsignacionActividad>> getByIDGestor(@PathVariable String id_gestor){
        return new ResponseEntity<>(ActividadesServiceI.getByIDGestor(id_gestor), HttpStatus.OK);
    }

    @GetMapping("/getByIDOperario/{id_operario}")
    public ResponseEntity<List<AsignacionActividad>> getByIDOperario(@PathVariable String id_operario){
        return new ResponseEntity<>(ActividadesServiceI.getByIDOperario(id_operario), HttpStatus.OK);
    }

    @GetMapping("/getByFechaAsig/{fecha_inicio}/{fecha_final}")
    public ResponseEntity<List<AsignacionActividad>> getByFechaAsig(@PathVariable LocalDate fecha_inicio, @PathVariable LocalDate fecha_final){
        return new ResponseEntity<>(ActividadesServiceI.getByFechaAsig(fecha_inicio,fecha_final), HttpStatus.OK);
    }

    @GetMapping("/getByEstAsig/{est_asig}")
    public ResponseEntity<List<AsignacionActividad>> getByEstAsig(@PathVariable String est_asig){
        return new ResponseEntity<>(ActividadesServiceI.getByEstAsig(est_asig), HttpStatus.OK);
    }

    @PostMapping("/asignarActividad")
    public ResponseEntity<String> asignarActividad(@RequestBody AsignacionActividadDto dto) {
        ActividadesServiceI.asignarActividad(dto);
        return new ResponseEntity<>("asignación hecha" ,HttpStatus.OK);
    }

    @PostMapping("/cancelarActividad/{id_asignacion}")
    public ResponseEntity<String> cancelarActividad(@PathVariable String id_asignacion) {
        ActividadesServiceI.cancelarActividad(id_asignacion);
        return new ResponseEntity<>("asignación cancelada" ,HttpStatus.OK);
    }

    @PostMapping("/envioRevisionActividad/{id_asignacion}")
    public ResponseEntity<String> envioRevisionActividad(@PathVariable String id_asignacion) {
        ActividadesServiceI.envioRevisionActividad(id_asignacion);
        return new ResponseEntity<>("asignación enviada a revision" ,HttpStatus.OK);
    }

    @PostMapping("/finalizarActividad/{id_asignacion}")
    public ResponseEntity<String> finalizarActividad(@PathVariable String id_asignacion) {
        ActividadesServiceI.finalizarActividad(id_asignacion);
        return new ResponseEntity<>("asignación culminada correctamente" ,HttpStatus.OK);
    }

    @PostMapping("/defectoActividad/{id_asignacion}")
    public ResponseEntity<String> defectoActividad(@PathVariable String id_asignacion) {
        ActividadesServiceI.defectoActividad(id_asignacion);
        return new ResponseEntity<>("asignación con defectos" ,HttpStatus.OK);
    }
}
