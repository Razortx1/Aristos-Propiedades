package com.aristos_propiedades.aristos_propiedades.model;

import java.sql.Blob;
import java.sql.Date;


import javax.persistence.Id;


public class Noticias {
    @Id
    private Integer id_noticia;
    private String mensaje;
    private Blob imagen_noticia;
    private Date fecha_noticia;
    private Integer id_tipo_noticias;
    private Integer id_user;
    public Noticias() {
    }
    public Noticias(String mensaje, Blob imagen_noticia, Date fecha_noticia) {
        this.mensaje = mensaje;
        this.imagen_noticia = imagen_noticia;
        this.fecha_noticia = fecha_noticia;
    }
    public Integer getId_noticia() {
        return id_noticia;
    }
    public void setId_noticia(Integer id_noticia) {
        this.id_noticia = id_noticia;
    }
    public String getMensaje() {
        return mensaje;
    }
    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }
    public Blob getImagen_noticia() {
        return imagen_noticia;
    }
    public void setImagen_noticia(Blob imagen_noticia) {
        this.imagen_noticia = imagen_noticia;
    }
    public Date getFecha_noticia() {
        return fecha_noticia;
    }
    public void setFecha_noticia(Date fecha_noticia) {
        this.fecha_noticia = fecha_noticia;
    }
    public Integer getId_tipo_noticias() {
        return id_tipo_noticias;
    }
    public void setId_tipo_noticias(Integer id_tipo_noticias) {
        this.id_tipo_noticias = id_tipo_noticias;
    }
    public Integer getId_user() {
        return id_user;
    }
    public void setId_user(Integer id_user) {
        this.id_user = id_user;
    }
    

}
