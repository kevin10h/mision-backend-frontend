package uni.pe.DBD.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import uni.pe.DBD.models.*;
import uni.pe.DBD.service.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/observaciones")
@CrossOrigin(origins = "${url.client}")
@RequiredArgsConstructor
public class ObservacionController {
    @Autowired
    ObservacionServiceI ObservacionServiceI;

    @GetMapping("/getAllObs")
    public ResponseEntity<List<Observacion>> getAllObs(){
        return new ResponseEntity<>(ObservacionServiceI.getAllObs(), HttpStatus.OK);
    }

    @GetMapping("/getByIDObservacion/{id_gestor}")
    public ResponseEntity<List<Observacion>> getByIDObservacion(@PathVariable String id_gestor){
        return new ResponseEntity<>(ObservacionServiceI.getByIDObservacion(id_gestor), HttpStatus.OK);
    }

    @GetMapping("/getByIDAsignacion/{id_asignacion}")
    public ResponseEntity<List<Observacion>> getByIDAsignacion(@PathVariable String id_asignacion){
        return new ResponseEntity<>(ObservacionServiceI.getByIDAsignacion(id_asignacion), HttpStatus.OK);
    }

    @GetMapping("/getByFechaObs/{fecha_observacion}")
    public ResponseEntity<List<Observacion>> getByFechaObs(@PathVariable LocalDate fecha_observacion){
        return new ResponseEntity<>(ObservacionServiceI.getByFechaObs(fecha_observacion), HttpStatus.OK);
    }

    @GetMapping("/getByEstObs/{id_estado_observacion}")
    public ResponseEntity<List<Observacion>> getByEstObs(@PathVariable String id_estado_observacion){
        return new ResponseEntity<>(ObservacionServiceI.getByEstObs(id_estado_observacion), HttpStatus.OK);
    }
}
