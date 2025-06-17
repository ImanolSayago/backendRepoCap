package com.CapacitacionCert.demo.Services;

import com.CapacitacionCert.demo.Model.Artista;

import java.util.List;

public interface IserviceArtista {

    public List<Artista> getArtistas();

    public Artista getArtista(Long id);

    public Artista addArtista(Artista artista);

    public boolean deleteArtista(Long id);
}
