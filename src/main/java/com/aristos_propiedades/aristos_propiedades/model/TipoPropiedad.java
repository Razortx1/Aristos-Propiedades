package com.aristos_propiedades.aristos_propiedades.model;

import javax.persistence.Entity;

@Entity
public class TipoPropiedad {
    private Integer id_tipo_propiedad;
    private String tipo_de_propiedad;
    public TipoPropiedad() {
    }
    public TipoPropiedad(String tipo_de_propiedad) {
        this.tipo_de_propiedad = tipo_de_propiedad;
    }
    public Integer getId_tipo_propiedad() {
        return id_tipo_propiedad;
    }
    public void setId_tipo_propiedad(Integer id_tipo_propiedad) {
        this.id_tipo_propiedad = id_tipo_propiedad;
    }
    public String getTipo_de_propiedad() {
        return tipo_de_propiedad;
    }
    public void setTipo_de_propiedad(String tipo_de_propiedad) {
        this.tipo_de_propiedad = tipo_de_propiedad;
    }
    
}
