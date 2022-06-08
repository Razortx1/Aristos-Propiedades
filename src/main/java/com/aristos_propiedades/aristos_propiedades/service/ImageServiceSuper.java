package com.aristos_propiedades.aristos_propiedades.service;

import org.springframework.web.multipart.MultipartFile;

public interface ImageServiceSuper {
    
    public void iniciarAlmacen();

    public String almacenerArchivo(MultipartFile file);
}
