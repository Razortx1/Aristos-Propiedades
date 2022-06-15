package com.aristos_propiedades.aristos_propiedades.controller;

import java.net.MalformedURLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.aristos_propiedades.aristos_propiedades.service.ImageServiceSuper;

@RestController
@RequestMapping("/assets")
public class AssetsController {
    @Autowired
    private ImageServiceSuper _ImageServiceSuper;

    @GetMapping("/{filename:.+}")
    public Resource obtenerRecurso(@PathVariable String filename) throws MalformedURLException{
        return this._ImageServiceSuper.cargarComoRecurso(filename);
    }
}
