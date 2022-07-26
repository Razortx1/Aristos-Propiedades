package com.aristos_propiedades.aristos_propiedades.service;


import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.stereotype.Service;
import org.springframework.util.FileSystemUtils;
import org.springframework.web.multipart.MultipartFile;


@Service
public class ImageService implements ImageServiceSuper{
    //Representa la localizacion del almacenaje de las imagenes
    @Value("${storage.location}")
    private String storageLocation;

    @PostConstruct
    @Override
    //Esta parte del codigo representa la inicializacion del almacen
    public void iniciarAlmacen() {
        try {
            Files.createDirectories(Paths.get(storageLocation));
        } catch (IOException e) {
            e.printStackTrace();
        }
        
    }
    //Este codigo es para almacenar las imagenes en la localizacion antes dicha
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
    
    @Override
    public Resource cargarComoRecurso(String nombreArchivo) throws MalformedURLException {
        Path archivo = cargarArchivo(nombreArchivo);
        Resource resource = new UrlResource(archivo.toUri());
        return resource;
    }
    //Esta parte del codigo es para cargar las imagenes y asi poder mostrarlas luego en la pagina web
    @Override
    public Path cargarArchivo(String nombreArchivo) {
        return Paths.get(storageLocation).resolve(nombreArchivo);
    }
    //Esta parte del codigo representa la eliminacion de las imagenes una vez se eliminen ya sea las propiedades
    //o las noticias
    @Override
    public void eliminarArchivo(String nombreArchivo) {
        Path archivo = cargarArchivo(nombreArchivo);
        try {
            FileSystemUtils.deleteRecursively(archivo);
        } catch (Exception e) {
            System.out.println(e);
        }
        
    }



}
