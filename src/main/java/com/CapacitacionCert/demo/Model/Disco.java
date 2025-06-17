package com.CapacitacionCert.demo.Model;


import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.HashSet;
import java.util.Set;

@Entity
@Getter
@Setter
public class Disco {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long  id;
    private String titulo;
    @Column(name = "ano_creacion", nullable = false)
    private String anoCreacion;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "artista_id", nullable = false)
    private Artista artista;

    private String urlImg;

    @OneToMany(mappedBy = "disco", cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonManagedReference
    private Set<Cancion> canciones = new HashSet<>();

    public Disco() {
    }

    public Disco(Long id, String titulo, String anoCreacion, Artista artista, String urlImg, Set<Cancion> canciones) {
        this.id = id;
        this.titulo = titulo;
        this.anoCreacion = anoCreacion;
        this.artista = artista;
        this.urlImg = urlImg;
        this.canciones = canciones;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

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

    public Artista getArtista() {
        return artista;
    }

    public void setArtista(Artista artista) {
        this.artista = artista;
    }

    public String getUrlImg() {
        return urlImg;
    }

    public void setUrlImg(String urlImg) {
        this.urlImg = urlImg;
    }

    public Set<Cancion> getCanciones() {
        return canciones;
    }

    public void setCanciones(Set<Cancion> canciones) {
        this.canciones = canciones;
    }
}
