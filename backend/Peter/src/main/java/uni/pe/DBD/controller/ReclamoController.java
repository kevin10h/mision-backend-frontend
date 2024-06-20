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
@RequestMapping("/reclamos")
@CrossOrigin(origins = "${url.client}")
@RequiredArgsConstructor
public class ReclamoController {
    @Autowired
    ReclamoServiceI ReclamoServiceI;

    @GetMapping("/getAllRec")
    public ResponseEntity<List<Reclamo>> getAllRec(){
        return new ResponseEntity<>(ReclamoServiceI.getAllRec(), HttpStatus.OK);
    }

    @GetMapping("/getByIDReclamo/{id_reclamo}")
    public ResponseEntity<List<Reclamo>> getByIDReclamo(@PathVariable String id_gestor){
        return new ResponseEntity<>(ReclamoServiceI.getByIDReclamo(id_gestor), HttpStatus.OK);
    }

    @GetMapping("/getByIDOperario/{id_operario}")
    public ResponseEntity<List<Reclamo>> getByIDOperario(@PathVariable String id_operario){
        return new ResponseEntity<>(ReclamoServiceI.getByIDOperario(id_operario), HttpStatus.OK);
    }

    @GetMapping("/getByFechaRec/{fecha_reclamo}")
    public ResponseEntity<List<Reclamo>> getByFechaRec(@PathVariable LocalDate fecha_reclamo){
        return new ResponseEntity<>(ReclamoServiceI.getByFechaRec(fecha_reclamo), HttpStatus.OK);
    }

    @GetMapping("/getByEstRec/{id_estado_reclamo}")
    public ResponseEntity<List<Reclamo>> getByEstRec(@PathVariable String id_estado_reclamo){
        return new ResponseEntity<>(ReclamoServiceI.getByEstRec(id_estado_reclamo), HttpStatus.OK);
    }
}
