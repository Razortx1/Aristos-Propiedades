package com.aristos_propiedades.aristos_propiedades.model;


import javax.persistence.Id;


public class TipoNoticias {
    @Id
    private Integer id_tiponoticias;
    private String tipo_de_noticias;
    public TipoNoticias() {
    }
    public TipoNoticias(String tipo_de_noticias) {
        this.tipo_de_noticias = tipo_de_noticias;
    }
    public Integer getId_tiponoticias() {
        return id_tiponoticias;
    }
    public void setId_tiponoticias(Integer id_tiponoticias) {
        this.id_tiponoticias = id_tiponoticias;
    }
    public String getTipo_de_noticias() {
        return tipo_de_noticias;
    }
    public void setTipo_de_noticias(String tipo_de_noticias) {
        this.tipo_de_noticias = tipo_de_noticias;
    }
    
}
