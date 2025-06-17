package com.CapacitacionCert.demo.Services;

import com.CapacitacionCert.demo.DTO.DiscoDTO;
import com.CapacitacionCert.demo.Model.Artista;
import com.CapacitacionCert.demo.Model.Cancion;
import com.CapacitacionCert.demo.Model.Disco;
import com.CapacitacionCert.demo.Repository.IrepositoryArtista;
import com.CapacitacionCert.demo.Repository.IrepositoryCancion;
import com.CapacitacionCert.demo.Repository.IrepositoryDisco;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

@Service
public class ServiceDisco implements IserviceDisco{

    @Autowired
    IrepositoryDisco repositoryDisco;

    @Autowired
    IrepositoryCancion cancionRepository;

    @Autowired
    IrepositoryArtista artistaRepository;

    @Override
    public List<Disco> getDisco() {
        return repositoryDisco.findAll();
    }

    @Override
    public Disco getDiscoById(Long id) {

        if(id== null)
        {
            System.out.println("No se encontro el id del disco");
        }
        return repositoryDisco.findById(id).orElse(null);
    }

    public Boolean addDisco(DiscoDTO dto) {
        if (dto == null) {
            System.out.println("No se pudo cargar el disco");
            return false;
        }

        // Obtener artista gestionado
        Optional<Artista> artistaOpt = artistaRepository.findById(dto.getArtistaId());
        if (artistaOpt.isEmpty()) {
            System.out.println("Artista no encontrado");
            return false;
        }
        Artista artistaGestionado = artistaOpt.get();

        // Obtener canciones gestionadas
        Set<Cancion> cancionesGestionadas = new HashSet<>();
        for (Long idCancion : dto.getCancionesIds()) {
            Optional<Cancion> cancionOpt = cancionRepository.findById(idCancion);
            if (cancionOpt.isEmpty()) {
                System.out.println("Cancion no encontrada con id: " + idCancion);
                return false;
            }
            Cancion cancionGestionada = cancionOpt.get();
            cancionesGestionadas.add(cancionGestionada);
        }

        // Crear el disco real
        Disco disco = new Disco();
        disco.setTitulo(dto.getTitulo());
        disco.setAnoCreacion(dto.getAnoCreacion());
        disco.setArtista(artistaGestionado);

        // Setear el disco en cada canción
        for (Cancion c : cancionesGestionadas) {
            c.setDisco(disco);
        }

        // Asignar canciones
        disco.setCanciones(cancionesGestionadas);

        // Guardar disco
        repositoryDisco.save(disco);

        return true;
    }

    @Override
    public Boolean deleteDiscoById(Long id) {

        if(id == null)
        {
            System.out.println("No se encontro el id del disco");
            return false;
        }
        else
        {
            repositoryDisco.deleteById(id);
            return true;
        }
    }
}
