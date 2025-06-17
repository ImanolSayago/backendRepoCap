package com.CapacitacionCert.demo.Controller;

import com.CapacitacionCert.demo.Model.Usuario;
import com.CapacitacionCert.demo.Services.ServiceUsuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/usuario")
public class ControllerUsuario {

    @Autowired
    ServiceUsuario serviceUsuario;
    @GetMapping("/traer")
    public List<Usuario> getUsuarios() {
        return serviceUsuario.getUsuarios();
    }

    @GetMapping("/traer/{id}")
    public Usuario getUsuario(@PathVariable Long id) {
        return serviceUsuario.getUsuarioById(id);
    }

    @PostMapping("/eliminar/{id}")
    public boolean eliminarUsuario(@PathVariable Long id) {
        return serviceUsuario.deleteUsuario(id);
    }
}
