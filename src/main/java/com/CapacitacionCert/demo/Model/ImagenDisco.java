package com.CapacitacionCert.demo.Model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class ImagenDisco {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String url; // URL en Cloudinary

    @ManyToOne
    @JoinColumn(name = "disco_id")
    @JsonIgnore
    private Disco disco;

    public ImagenDisco() {
    }

    public ImagenDisco(Long id, String url, Disco disco) {
        this.id = id;
        this.url = url;
        this.disco = disco;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public Disco getDisco() {
        return disco;
    }

    public void setDisco(Disco disco) {
        this.disco = disco;
    }
}
