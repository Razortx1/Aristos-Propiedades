package com.aristos_propiedades.aristos_propiedades.model;

public class EstadoVentaArriendo {
    private Integer id_estadoventa;
    private String Estado;
    public EstadoVentaArriendo() {
    }
    public EstadoVentaArriendo(String estado) {
        Estado = estado;
    }
    public Integer getId_estadoventa() {
        return id_estadoventa;
    }
    public void setId_estadoventa(Integer id_estadoventa) {
        this.id_estadoventa = id_estadoventa;
    }
    public String getEstado() {
        return Estado;
    }
    public void setEstado(String estado) {
        Estado = estado;
    }
    
}
