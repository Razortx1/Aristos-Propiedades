package com.aristos_propiedades.aristos_propiedades.model;

import javax.persistence.Entity;

@Entity
public class Rol {
    private Integer id_rol;
    private String Rol;
    public Rol() {
    }
    public Rol(String rol) {
        Rol = rol;
    }
    public Integer getId_rol() {
        return id_rol;
    }
    public void setId_rol(Integer id_rol) {
        this.id_rol = id_rol;
    }
    public String getRol() {
        return Rol;
    }
    public void setRol(String rol) {
        Rol = rol;
    }
    
}
