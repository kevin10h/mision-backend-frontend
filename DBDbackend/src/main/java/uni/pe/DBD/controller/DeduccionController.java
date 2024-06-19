package uni.pe.DBD.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import uni.pe.DBD.dto.BonificacionFilterDto;
import uni.pe.DBD.dto.DeduccionDto;
import uni.pe.DBD.models.Bonificacion;
import uni.pe.DBD.models.Deduccion;
import uni.pe.DBD.service.DeduccionServiceI;

import java.util.List;

@RestController
@RequestMapping("/deduccion")
@CrossOrigin(origins = "${url.client}")
@RequiredArgsConstructor
public class DeduccionController {
    @Autowired
    DeduccionServiceI deduccionServiceI;

    @GetMapping("/getDeducciones")
    public ResponseEntity<List<Deduccion>> getBonificaciones(@RequestBody DeduccionDto dto){
        return new ResponseEntity<>(deduccionServiceI.getDeducciones(dto), HttpStatus.OK);
    }
}
