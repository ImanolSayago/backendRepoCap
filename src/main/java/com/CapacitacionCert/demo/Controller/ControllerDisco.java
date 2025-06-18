package com.CapacitacionCert.demo.Controller;

import com.CapacitacionCert.demo.DTO.DiscoDTO;
import com.CapacitacionCert.demo.Model.Disco;
import com.CapacitacionCert.demo.Respuestas.ResponseMessage;
import com.CapacitacionCert.demo.Services.CloudinaryService;
import com.CapacitacionCert.demo.Services.ServiceDisco;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("api/disco")
public class ControllerDisco {
    @Autowired
    ServiceDisco serviceDisco;

    @Autowired
    CloudinaryService cloudinaryService;

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

    @PutMapping("/edit/{id}")
    public boolean editDisco(@PathVariable Long id,@RequestBody DiscoDTO disco)
    {
        return  serviceDisco.editDisco(id,disco);
    }


    @PostMapping("/crear-con-imagen")
    public ResponseEntity<ResponseMessage> crearDisco(
            @RequestPart("disco") DiscoDTO disco,
            @RequestPart("imagen") MultipartFile imagen
    ) {
        try {
            String url = cloudinaryService.subirImagen(imagen);
            disco.setUrlImg(url);

            serviceDisco.addDisco(disco);
            return ResponseEntity.ok(new ResponseMessage("Disco creado con éxito", true));
        } catch (IOException e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body(new ResponseMessage("Error al subir la imagen", false));
        }
    }
}
