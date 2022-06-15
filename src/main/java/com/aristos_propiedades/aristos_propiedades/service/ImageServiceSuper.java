package com.aristos_propiedades.aristos_propiedades.service;

import java.net.MalformedURLException;
import java.nio.file.Path;

import org.springframework.core.io.Resource;
import org.springframework.web.multipart.MultipartFile;

public interface ImageServiceSuper {
    
    public void iniciarAlmacen();

    public String almacenerArchivo(MultipartFile file);

    public Path cargarArchivo(String nombreArchivo);

    public Resource cargarComoRecurso(String nombreArchivo) throws MalformedURLException;
}
