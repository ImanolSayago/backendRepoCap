package com.CapacitacionCert.demo.Controller;

import com.CapacitacionCert.demo.DTO.CancionDTO;
import com.CapacitacionCert.demo.Model.Cancion;
import com.CapacitacionCert.demo.Services.ServiceCancion;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/cancion")
public class ControllerCancion {
    @Autowired
    ServiceCancion serviceCancion;

    @GetMapping("/traer")
    public List<Cancion> GetCanciones()
    {
        return serviceCancion.GetCancion();
    }

    @GetMapping("/traer/{id}")
    public Cancion getCancionById (@PathVariable Long id)
    {
        return serviceCancion.getCancionById(id);
    }

    @PostMapping("/crear")
    public ResponseEntity<?> crearCancion(@RequestBody CancionDTO cancionDTO) {
        try {
            Cancion nueva = serviceCancion.PostCancion(cancionDTO);
            return ResponseEntity.ok(nueva);
        } catch (RuntimeException e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        }
    }
    @DeleteMapping("/borrar/{id}")
    public boolean deleteCancion(@PathVariable Long id)
    {
        return serviceCancion.DeleteCancion(id);
    }

}
