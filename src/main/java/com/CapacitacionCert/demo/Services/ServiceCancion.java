package com.CapacitacionCert.demo.Services;

import com.CapacitacionCert.demo.DTO.CancionDTO;
import com.CapacitacionCert.demo.Model.Artista;
import com.CapacitacionCert.demo.Model.Cancion;
import com.CapacitacionCert.demo.Model.Disco;
import com.CapacitacionCert.demo.Repository.IrepositoryArtista;
import com.CapacitacionCert.demo.Repository.IrepositoryCancion;
import com.CapacitacionCert.demo.Repository.IrepositoryDisco;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ServiceCancion implements IserviceCancion {

    @Autowired
    IrepositoryCancion repoCancion;

    @Autowired
    IrepositoryDisco discoRepo;

    @Autowired
    IrepositoryArtista artistaRepository;

    @Override
    public List<Cancion> GetCancion() {
        return repoCancion.findAll();
    }

    @Override
    public Cancion getCancionById(Long id) {
        if(id == null)
        {
            System.out.println("No se encontro el id de la cancion");
        }
        return repoCancion.findById(id).orElse(null);
    }


    @Override
    public Cancion PostCancion(CancionDTO dto) {
        if (dto == null) {
            System.out.println("La canción no cumple con los requisitos");
            return null;
        }

        Optional<Artista> autorOpt = artistaRepository.findById(dto.getAutorID());
        Optional<Disco> discoOpt = discoRepo.findById(dto.getDiscoId());

        if (autorOpt.isEmpty() || discoOpt.isEmpty()) {
            System.out.println("Autor o disco no encontrado");
            return null;
        }

        Cancion cancion = new Cancion();
        cancion.setTitulo(dto.getTitulo());
        cancion.setAutor(autorOpt.get());
        cancion.setDisco(discoOpt.get());

        return repoCancion.save(cancion);
    }


    @Override
    public boolean DeleteCancion(Long id) {
        if(id == null)
        {
            System.out.println("No se encontro el id de la cancion");
            return false;
        }
        else
        {
            repoCancion.deleteById(id);
            return true;
        }

    }
}
