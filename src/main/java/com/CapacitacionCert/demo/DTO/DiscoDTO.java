package com.CapacitacionCert.demo.DTO;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Setter
@Getter
public class DiscoDTO {
    private String titulo;
    private String anoCreacion;
    private Long artistaId;
    private List<Long> cancionesIds;

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getAnoCreacion() {
        return anoCreacion;
    }

    public void setAnoCreacion(String anoCreacion) {
        this.anoCreacion = anoCreacion;
    }

    public Long getArtistaId() {
        return artistaId;
    }

    public void setArtistaId(Long artistaId) {
        this.artistaId = artistaId;
    }

    public List<Long> getCancionesIds() {
        return cancionesIds;
    }

    public void setCancionesIds(List<Long> cancionesIds) {
        this.cancionesIds = cancionesIds;
    }
}