package uni.pe.DBD.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import uni.pe.DBD.models.Bonificacion;
import uni.pe.DBD.service.BonificacionServiceI;

import java.util.List;

@RestController
@RequestMapping("/bonificacion")
@CrossOrigin(origins = "${url.client}")
@RequiredArgsConstructor
public class BonificacionController {
    private final BonificacionServiceI bonificacionServiceI;

    @GetMapping("/getAll")
    public ResponseEntity<List<Bonificacion>> getAll(){
        return new ResponseEntity<>(bonificacionServiceI.getAll(), HttpStatus.OK);
    }

    @GetMapping("/getByID/{id}")
    public ResponseEntity<List<Bonificacion>> getByID(@PathVariable String id){
        return new ResponseEntity<>(bonificacionServiceI.getByID(id),HttpStatus.OK);
    }

    @GetMapping("/getByBonif/{b}")
    public ResponseEntity<List<Bonificacion>> getByBonificacion(@PathVariable String b){
        return new ResponseEntity<>(bonificacionServiceI.getByBonificacion_type(b),HttpStatus.OK);
    }

    @GetMapping("/getByID_Bonif/{id}/{b}")
    public ResponseEntity<List<Bonificacion>> getBy2Args(@PathVariable String id,@PathVariable String b){
        return new ResponseEntity<>(bonificacionServiceI.getByID_Bonif_type(b,id),HttpStatus.OK);
    }
}
