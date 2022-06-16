package com.aristos_propiedades.aristos_propiedades.model;


import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class TipoNoticias {
    @Id
    private Integer id_tipo_noticias;
    private String tipo_de_noticias;
    public TipoNoticias() {
    }
    public TipoNoticias(String tipo_de_noticias) {
        this.tipo_de_noticias = tipo_de_noticias;
    }
    public Integer getId_tipo_noticias() {
        return id_tipo_noticias;
    }
    public void setId_tipo_noticias(Integer id_tipo_noticias) {
        this.id_tipo_noticias = id_tipo_noticias;
    }
    public String getTipo_de_noticias() {
        return tipo_de_noticias;
    }
    public void setTipo_de_noticias(String tipo_de_noticias) {
        this.tipo_de_noticias = tipo_de_noticias;
    }

    
}
