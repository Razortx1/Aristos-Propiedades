package com.aristos_propiedades.aristos_propiedades.model;

import java.sql.Blob;

public class Departamento {
    private Integer id_propiedad;
    private String baños;
    private String habitaciones;
    private String terrazas;
    private String m2_terreno;
    private String m2_construidos;
    private String valor;
    private String quincho;
    private String estacionamiento;
    private String patio;
    private Blob imagenes_propiedad;
    private Integer id_estadoventa;
    private String ubicacion;
    private Integer id_tipo_propiedad;
    private Integer id_user;
    public Departamento() {
    }
    public Departamento(String baños, String habitaciones, String terrazas, String m2_terreno, String m2_construidos,
            String valor, String quincho, String estacionamiento, String patio, Blob imagenes_propiedad,
            String ubicacion) {
        this.baños = baños;
        this.habitaciones = habitaciones;
        this.terrazas = terrazas;
        this.m2_terreno = m2_terreno;
        this.m2_construidos = m2_construidos;
        this.valor = valor;
        this.quincho = quincho;
        this.estacionamiento = estacionamiento;
        this.patio = patio;
        this.imagenes_propiedad = imagenes_propiedad;
        this.ubicacion = ubicacion;
    }
    public Integer getId_propiedad() {
        return id_propiedad;
    }
    public void setId_propiedad(Integer id_propiedad) {
        this.id_propiedad = id_propiedad;
    }
    public String getBaños() {
        return baños;
    }
    public void setBaños(String baños) {
        this.baños = baños;
    }
    public String getHabitaciones() {
        return habitaciones;
    }
    public void setHabitaciones(String habitaciones) {
        this.habitaciones = habitaciones;
    }
    public String getTerrazas() {
        return terrazas;
    }
    public void setTerrazas(String terrazas) {
        this.terrazas = terrazas;
    }
    public String getM2_terreno() {
        return m2_terreno;
    }
    public void setM2_terreno(String m2_terreno) {
        this.m2_terreno = m2_terreno;
    }
    public String getM2_construidos() {
        return m2_construidos;
    }
    public void setM2_construidos(String m2_construidos) {
        this.m2_construidos = m2_construidos;
    }
    public String getValor() {
        return valor;
    }
    public void setValor(String valor) {
        this.valor = valor;
    }
    public String getQuincho() {
        return quincho;
    }
    public void setQuincho(String quincho) {
        this.quincho = quincho;
    }
    public String getEstacionamiento() {
        return estacionamiento;
    }
    public void setEstacionamiento(String estacionamiento) {
        this.estacionamiento = estacionamiento;
    }
    public String getPatio() {
        return patio;
    }
    public void setPatio(String patio) {
        this.patio = patio;
    }
    public Blob getImagenes_propiedad() {
        return imagenes_propiedad;
    }
    public void setImagenes_propiedad(Blob imagenes_propiedad) {
        this.imagenes_propiedad = imagenes_propiedad;
    }
    public Integer getId_estadoventa() {
        return id_estadoventa;
    }
    public void setId_estadoventa(Integer id_estadoventa) {
        this.id_estadoventa = id_estadoventa;
    }
    public String getUbicacion() {
        return ubicacion;
    }
    public void setUbicacion(String ubicacion) {
        this.ubicacion = ubicacion;
    }
    public Integer getId_tipo_propiedad() {
        return id_tipo_propiedad;
    }
    public void setId_tipo_propiedad(Integer id_tipo_propiedad) {
        this.id_tipo_propiedad = id_tipo_propiedad;
    }
    public Integer getId_user() {
        return id_user;
    }
    public void setId_user(Integer id_user) {
        this.id_user = id_user;
    }
    
    
}