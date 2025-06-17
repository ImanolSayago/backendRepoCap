package com.CapacitacionCert.demo.Services;

import com.CapacitacionCert.demo.Model.Artista;
import com.CapacitacionCert.demo.Repository.IrepositoryArtista;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ServiceArtista implements IserviceArtista {

    @Autowired
    IrepositoryArtista repoArtista;


    @Override
    public List<Artista> getArtistas() {
        return repoArtista.findAll();
    }

    @Override
    public Artista getArtista(Long id) {
        if(id==null)
        {
            System.out.println("No se encontro el id de la artista");
        }
        return repoArtista.findById(id).orElse(null);
    }

    @Override
    public Artista addArtista(Artista artista) {

        if(artista==null)
        {
            System.out.println("El artista no cumple con las condicioens");
        }
        return repoArtista.save(artista);
    }

    @Override
    public boolean deleteArtista(Long id) {

        if(id==null){
            return false;
        }
        else
        {
            repoArtista.deleteById(id);
            return true;
        }
    }
}
