package com.CapacitacionCert.demo.Services;

import com.CapacitacionCert.demo.Model.ImagenDisco;
import com.CapacitacionCert.demo.Repository.IrepositoryImagenDisco;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ServiceImagenDisco implements IserviceImagenDisco{
    @Autowired
    IrepositoryImagenDisco repoImagen;

    @Override
    public List<ImagenDisco> getImagenes() {
        return repoImagen.findAll();
}}
