package com.CapacitacionCert.demo.Repository;

import com.CapacitacionCert.demo.Model.Disco;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IrepositoryDisco extends JpaRepository<Disco, Long> {
}
