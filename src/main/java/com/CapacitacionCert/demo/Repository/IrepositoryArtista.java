package com.CapacitacionCert.demo.Repository;

import com.CapacitacionCert.demo.Model.Artista;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IrepositoryArtista extends JpaRepository<Artista, Long> {
}
