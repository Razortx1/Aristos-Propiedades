package com.aristos_propiedades.aristos_propiedades.model;


import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Transient;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.DateTimeFormat.ISO;
import org.springframework.web.multipart.MultipartFile;

@Entity
public class Noticias {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idnoticia;
    private String descripcion_noticia;
    private String imagen_noticia;
    
    @DateTimeFormat(iso = ISO.DATE)
    private LocalDate fecha_noticia;
    private Integer id_tipo_noticias;
    private String Titulo_Noticia;

    @Transient
    private MultipartFile archivo;
    
    public MultipartFile getArchivo() {
        return archivo;
    }

    public void setArchivo(MultipartFile archivo) {
        this.archivo = archivo;
    }

    public Noticias() {
    }
    
    public Noticias(String mensaje, String imagen_noticia, LocalDate fecha_noticia, Integer id_tipo_noticias, String titulo_Noticia, MultipartFile archivo) {
        this.descripcion_noticia = mensaje;
        this.imagen_noticia = imagen_noticia;
        this.fecha_noticia = fecha_noticia;
        this.id_tipo_noticias = id_tipo_noticias;
        this.Titulo_Noticia = titulo_Noticia;
        this.archivo = archivo;
    }

    public Integer getIdnoticia() {
        return idnoticia;
    }
    public void setIdnoticia(Integer idnoticia) {
        this.idnoticia = idnoticia;
    }
    
    public String getDescripcion_noticia() {
        return descripcion_noticia;
    }

    public void setDescripcion_noticia(String descripcion_noticia) {
        this.descripcion_noticia = descripcion_noticia;
    }

    public String getImagen_noticia() {
        return imagen_noticia;
    }
    public void setImagen_noticia(String imagen_noticia) {
        this.imagen_noticia = imagen_noticia;
    }
    public LocalDate getFecha_noticia() {
        return fecha_noticia;
    }
    public void setFecha_noticia(LocalDate fecha_noticia) {
        this.fecha_noticia = fecha_noticia;
    }
    public Integer getId_tipo_noticias() {
        return id_tipo_noticias;
    }
    public void setId_tipo_noticias(Integer id_tipo_noticias) {
        this.id_tipo_noticias = id_tipo_noticias;
    }
    public String getTitulo_Noticia() {
        return Titulo_Noticia;
    }
    public void setTitulo_Noticia(String titulo_Noticia) {
        Titulo_Noticia = titulo_Noticia;
    }
    

}
