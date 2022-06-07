package com.aristos_propiedades.aristos_propiedades.model;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Entity
public class Usuario {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Integer id_user;
    private String nombre;
    private String contraseña;
    private String id_rol;
    public Usuario() {
    }
    public Usuario(String nombre, String contraseña, String id_rol) {
        this.nombre = nombre;
        this.contraseña = contraseña;
        this.id_rol = id_rol;
    }
    public Integer getId_user() {
        return id_user;
    }
    public void setId_user(Integer id_user) {
        this.id_user = id_user;
    }
    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public String getContraseña() {
        return contraseña;
    }
    public void setContraseña(String contraseña) {
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        String encodedPassword = passwordEncoder.encode(contraseña);
        this.contraseña = encodedPassword;
    }
    public String getId_rol() {
        return id_rol;
    }
    public void setId_rol(String id_rol) {
        this.id_rol = id_rol;
    }
   
 

    
}
