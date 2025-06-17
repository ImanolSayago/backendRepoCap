package com.CapacitacionCert.demo.Repository;

import com.CapacitacionCert.demo.Model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface IrepositoryUsuario extends JpaRepository<Usuario, Long> {

    Optional<Usuario> findByUsuarioAndPassword(String usuario, String password);
}
