package com.CapacitacionCert.demo.Services;

import com.CapacitacionCert.demo.Model.Usuario;
import com.CapacitacionCert.demo.Repository.IrepositoryUsuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ServiceUsuario implements IserviceUsuario{

    @Autowired
    IrepositoryUsuario repositorioUsuario;


    @Override
    public List<Usuario> getUsuarios() {
        return repositorioUsuario.findAll();
    }

    @Override
    public Usuario getUsuarioById(Long id) {

        if(id == null) {
            System.out.println("No se encontro el id del usuario");
            return null;
        }
        return repositorioUsuario.findById(id).orElse(null);
    }

    @Override
    public boolean addUsuario(Usuario usuario) {
        if(usuario == null) {
            System.out.println("No se pudo cargar el usuario");
            return false;
        }
        else
        {
            repositorioUsuario.save(usuario);
            return true;
        }
    }

    @Override
    public boolean deleteUsuario(Long id) {

        if(id == null) {
            System.out.println("No se encontro el id del usuario");
            return  false;
        }
        else
        {
            repositorioUsuario.deleteById(id);
            return true;
        }

    }
}
