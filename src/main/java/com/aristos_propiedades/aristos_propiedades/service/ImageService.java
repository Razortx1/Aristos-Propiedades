package com.aristos_propiedades.aristos_propiedades.service;


import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;


@Service
public class ImageService implements ImageServiceSuper{

    @Value("${storage.location}")
    private String storageLocation;

    @PostConstruct
    @Override
    public void iniciarAlmacen() {
        try {
            Files.createDirectories(Paths.get(storageLocation));
        } catch (IOException e) {
            e.printStackTrace();
        }
        
    }

    @Override
    public String almacenerArchivo(MultipartFile file) {
        String nombreArchivo = file.getOriginalFilename();
        if(file.isEmpty()){
            return "";
        }
        try {
            InputStream inputStream = file.getInputStream();
            Files.copy(inputStream, Paths.get(storageLocation).resolve(nombreArchivo), StandardCopyOption.REPLACE_EXISTING);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return nombreArchivo;
    }



}
