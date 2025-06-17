package com.CapacitacionCert.demo.Controller;

import com.CapacitacionCert.demo.DTO.DiscoDTO;
import com.CapacitacionCert.demo.Model.Disco;
import com.CapacitacionCert.demo.Services.ServiceDisco;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/disco")
public class ControllerDisco {
    @Autowired
    ServiceDisco serviceDisco;

    @GetMapping("/traer")
    public List<Disco> GetDiscos() {
        return serviceDisco.getDisco();
    }

    @GetMapping("/traer/{id}")
    public Disco GetDiscoById(@PathVariable Long id) {
        return serviceDisco.getDiscoById(id);
    }

    @PostMapping("/crear")
    public boolean CreateDisco(@RequestBody DiscoDTO discoDTO) {
        return  serviceDisco.addDisco(discoDTO);
    }

    @DeleteMapping("/delete/{id}")
    public boolean DeleteDisco(@PathVariable Long id) {
        return serviceDisco.deleteDiscoById(id);
    }
}
