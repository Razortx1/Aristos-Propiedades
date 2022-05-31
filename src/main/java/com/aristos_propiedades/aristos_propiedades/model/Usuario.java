package com.aristos_propiedades.aristos_propiedades.model;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Usuario {
    @Id
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
        Contraseña = contraseña;
    }
    public String getId_rol() {
        return id_rol;
    }
    public void setId_rol(String id_rol) {
        this.id_rol = id_rol;
    }

    
}
