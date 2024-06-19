package uni.pe.DBD.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import uni.pe.DBD.dto.NominaFilterDto;
import uni.pe.DBD.models.Nomina;
import uni.pe.DBD.service.NominaServiceI;

import java.util.List;

@RestController
@RequestMapping("/nomina")
@CrossOrigin(origins = "${url.client}")
@RequiredArgsConstructor
public class NominaController {
    @Autowired
    NominaServiceI nominaServiceI;

    @GetMapping("/getNominas")
    public ResponseEntity<List<Nomina>> getBonificaciones(@RequestBody NominaFilterDto dto){
        return new ResponseEntity<>(nominaServiceI.getNominas(dto), HttpStatus.OK);
    }
}
