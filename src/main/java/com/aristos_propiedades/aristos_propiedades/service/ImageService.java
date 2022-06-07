package com.aristos_propiedades.aristos_propiedades.service;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;


@Service
public class ImageService {

    private String archivo = ".//src//main//resources//templates//image";

    public String guardarArchivo(MultipartFile file) throws IOException{
        if (!archivo.isEmpty()) {
            byte[] bytes = file.getBytes();
            Path path = Paths.get(archivo, file.getOriginalFilename());
            Files.write(path, bytes);
        }
        return file.getOriginalFilename();
    }
}
