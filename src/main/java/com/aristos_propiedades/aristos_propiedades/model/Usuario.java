package com.aristos_propiedades.aristos_propiedades.model;

<<<<<<< Updated upstream
import javax.persistence.Entity;
import javax.persistence.Id;

=======

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

>>>>>>> Stashed changes
@Entity
public class Usuario {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Integer id_user;
    private String Nombre;
    private String Contraseña;
    private String id_rol;
    public Usuario() {
    }
    public Usuario(String nombre, String contraseña) {
        Nombre = nombre;
        Contraseña = contraseña;
    }
    public Integer getId() {
        return id_user;
    }
    public void setId(Integer id) {
        this.id_user = id;
    }
    public String getNombre() {
        return Nombre;
    }
    public void setNombre(String nombre) {
        Nombre = nombre;
    }
    public String getContraseña() {
        return Contraseña;
    }
    public void setContraseña(String contraseña) {
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        String encodedPassword = passwordEncoder.encode(contraseña);
        this.Contraseña = encodedPassword;
    }
    public String getId_rol() {
        return id_rol;
    }
    public void setId_rol(String id_rol) {
        this.id_rol = id_rol;
    }

    
}
