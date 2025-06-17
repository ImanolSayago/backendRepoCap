package com.CapacitacionCert.demo.DTO;

import com.CapacitacionCert.demo.Model.Artista;

public class CancionDTO {
    private String titulo;
    private Long autorID;
    private Long discoId;

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public Long getAutorID() {
        return autorID;
    }

    public void setAutorID(Long autorID) {
        this.autorID = autorID;
    }

    public Long getDiscoId() {
        return discoId;
    }

    public void setDiscoId(Long discoId) {
        this.discoId = discoId;
    }
}
