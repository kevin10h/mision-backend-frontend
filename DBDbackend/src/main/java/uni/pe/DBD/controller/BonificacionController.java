package uni.pe.DBD.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import uni.pe.DBD.dto.BonificacionFilterDto;
import uni.pe.DBD.models.Bonificacion;
import uni.pe.DBD.service.BonificacionServiceI;

import java.util.List;

@RestController
@RequestMapping("/bonificacion")
@CrossOrigin(origins = "${url.client}")
@RequiredArgsConstructor
public class BonificacionController {
    private final BonificacionServiceI bonificacionServiceI;

    @GetMapping("/getBonificaciones")
    public ResponseEntity<List<Bonificacion>> getBonificaciones(@RequestBody BonificacionFilterDto dto){
        return new ResponseEntity<>(bonificacionServiceI.getBonificaciones(dto), HttpStatus.OK);
    }

}
