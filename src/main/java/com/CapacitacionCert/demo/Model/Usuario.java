package com.CapacitacionCert.demo.Model;

import com.CapacitacionCert.demo.Model.Enums.RolUser;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity

public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String usuario;

    private String password;

    @Column(nullable = false)
    private String tipo;

    public Usuario() {
    }

    public Usuario(Long id, String usuario, String password, String tipo) {
        this.id = id;
        this.usuario = usuario;
        this.password = password;
        this.tipo = tipo;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }
}
