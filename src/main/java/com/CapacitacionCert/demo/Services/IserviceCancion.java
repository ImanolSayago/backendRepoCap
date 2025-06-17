package com.CapacitacionCert.demo.Services;

import com.CapacitacionCert.demo.DTO.CancionDTO;
import com.CapacitacionCert.demo.Model.Cancion;

import java.util.List;

public interface IserviceCancion {

    public List<Cancion> GetCancion();

    public Cancion getCancionById(Long id);

    public Cancion PostCancion(CancionDTO cancion);

    public boolean DeleteCancion(Long id);
}
