package com.aristos_propiedades.aristos_propiedades.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.aristos_propiedades.aristos_propiedades.model.Noticias;
import com.aristos_propiedades.aristos_propiedades.model.TipoNoticias;
import com.aristos_propiedades.aristos_propiedades.repository.noticiasRepository;
import com.aristos_propiedades.aristos_propiedades.repository.tipoNoticiasRepository;
import com.aristos_propiedades.aristos_propiedades.service.ImageService;

@Controller
@RequestMapping("/corredor")
public class NoticiasController {
    @Autowired
    private noticiasRepository _NoticiasRepository;

    @Autowired
    private tipoNoticiasRepository _TipoNoticiasRepository;

    @Autowired
    private ImageService _ImageService;

    @GetMapping("/create/noticias")
    public ModelAndView formularioCrearNoticias(){
        List<TipoNoticias> tipon = this._TipoNoticiasRepository.findAll();
        return new ModelAndView("/corredor/noticias/new-noticias").addObject("noticias", new Noticias())
                                                                .addObject("tipon", tipon);
    }
    @PostMapping("/create/noticias")
    public ModelAndView crearNuevaPropiedad(@Validated Noticias noticias){
        String patharchivo=this._ImageService.almacenerArchivo(noticias.getArchivo());
        noticias.setImagen_noticia(patharchivo);
        this._NoticiasRepository.save(noticias);
        return new ModelAndView("redirect:/corredor");
    }
}
