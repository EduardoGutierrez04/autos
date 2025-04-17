package mx.uam.integracion.autos.autos.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import mx.uam.integracion.autos.autos.dto.AutoDTO;
import mx.uam.integracion.autos.autos.service.AutosService;

@RestController
@RequestMapping("/autos")
@CrossOrigin(origins = "*") 
public class AutosController {

    private final AutosService autosService;

    public AutosController(AutosService autosService) {
        this.autosService = autosService;
    }

    
    @PostMapping
    public ResponseEntity<AutoDTO> createAuto(@RequestBody AutoDTO autoDTO) {
        AutoDTO createdAuto = autosService.createAuto(autoDTO);
        return new ResponseEntity<>(createdAuto, HttpStatus.CREATED);
    }

    
    @GetMapping("/{id}")
    public ResponseEntity<AutoDTO> getAutoById(@PathVariable String id) {
        AutoDTO autoDTO = autosService.getAutoById(id);
        if (autoDTO != null) {
            return new ResponseEntity<>(autoDTO, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }


    @PutMapping("/{id}")
    public ResponseEntity<AutoDTO> updateAuto(@PathVariable String id, @RequestBody AutoDTO autoDTO) {
        AutoDTO updatedAuto = autosService.updateAuto(id, autoDTO);
        if (updatedAuto != null) {
            return new ResponseEntity<>(updatedAuto, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    // DELETE
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteAuto(@PathVariable String id) {
        boolean deleted = autosService.deleteAuto(id);
        if (deleted) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    // LIST ALL
    @GetMapping
    public ResponseEntity<AutoDTO[]> getAllAutos() {
        AutoDTO[] autos = autosService.getAllAutos();
        return new ResponseEntity<>(autos, HttpStatus.OK);
    }
}
