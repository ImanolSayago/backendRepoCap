package com.CapacitacionCert.demo.Controller;

import com.CapacitacionCert.demo.Model.Artista;
import com.CapacitacionCert.demo.Services.ServiceArtista;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/artista")
public class ControllerArtista {

    @Autowired
    ServiceArtista serviceArtista;

    @GetMapping("/traer")
    public List<Artista> traer() {
        return serviceArtista.getArtistas();
    }

    @GetMapping("/traer/{id}")
    public Artista traerId(@PathVariable Long id) {
        return serviceArtista.getArtista(id);
    }

    @PostMapping("/crear")
    public Artista crear(@RequestBody Artista artista) {
        Artista artistacreado = new Artista();
        artistacreado = artista;
        serviceArtista.addArtista(artistacreado);
        return artistacreado;
    }

    @DeleteMapping("/delete/{id}")
    public void eliminar(@PathVariable Long id) {
        serviceArtista.deleteArtista(id);
    }
}
