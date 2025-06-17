package com.CapacitacionCert.demo.Repository;

import com.CapacitacionCert.demo.Model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IrepositoryUsuario extends JpaRepository<Usuario, Long> {
}
