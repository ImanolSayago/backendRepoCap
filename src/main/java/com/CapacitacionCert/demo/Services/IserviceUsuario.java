package com.CapacitacionCert.demo.Services;

import com.CapacitacionCert.demo.Model.Usuario;

import java.util.List;

public interface IserviceUsuario {

    public List<Usuario> getUsuarios();

    public Usuario getUsuarioById(Long id);

    public boolean addUsuario(Usuario usuario);

    public boolean deleteUsuario(Long id);

}
