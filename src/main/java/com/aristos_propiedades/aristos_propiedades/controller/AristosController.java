package com.aristos_propiedades.aristos_propiedades.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.servlet.ModelAndView;

import com.aristos_propiedades.aristos_propiedades.model.EstadoVentaArriendo;
import com.aristos_propiedades.aristos_propiedades.model.Noticias;
import com.aristos_propiedades.aristos_propiedades.model.Propiedades;
import com.aristos_propiedades.aristos_propiedades.model.TipoNoticias;
import com.aristos_propiedades.aristos_propiedades.model.TipoPropiedad;
import com.aristos_propiedades.aristos_propiedades.repository.estadoVentaRepositorio;
import com.aristos_propiedades.aristos_propiedades.repository.noticiasRepository;
import com.aristos_propiedades.aristos_propiedades.repository.propiedadRepository;
import com.aristos_propiedades.aristos_propiedades.repository.tipoNoticiasRepository;
import com.aristos_propiedades.aristos_propiedades.repository.tipoPropiedadRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
@Controller
public class AristosController {
    @Autowired
    private propiedadRepository _PropiedadRepository;
    @Autowired
    private estadoVentaRepositorio _EstadoVentaRepositorio;
    @Autowired 
    private tipoPropiedadRepository _TipoPropiedadRepository;
    @Autowired
    private noticiasRepository _NoticiasRepository;
    @Autowired
    private tipoNoticiasRepository _TipoNoticiasRepository;

    //Envia 3 propiedades y noticias a la pagina de inicio
    @GetMapping({"/index", ""})
    public ModelAndView indexCorredor(@PageableDefault(size = 3) Pageable pageable){
        Page<Propiedades> propiedades = this._PropiedadRepository.findAll(pageable);
        Page<Noticias> noticias = this._NoticiasRepository.findAll(pageable);
        return new ModelAndView("html/index")
                                            .addObject("propiedades", propiedades)
                                            .addObject("noticias", noticias);
    }
    //Estre representa el codigo de cuando el usuario presiona en propiedades mostrando todas las propiedades existentes en el sistema
    @GetMapping("/propiedades")
    public ModelAndView mostrarTodasLasPropiedades(@PageableDefault(size = 10) Pageable pageable){
        Page<Propiedades> mpropiedades = this._PropiedadRepository.findAll(pageable);
        return new ModelAndView("html/propiedades")
                    .addObject("propiedades", mpropiedades);
    }
    //Muestra los detalles de la propiedad elegida
    @GetMapping("propiedades/{id}")
    public ModelAndView mostrarPropiedad(@PathVariable Integer id){
        Propiedades propiedad = this._PropiedadRepository.findById(id).get();
        TipoPropiedad tipo = this._TipoPropiedadRepository.findById(propiedad.getId_tipo_propiedad()).get();
        EstadoVentaArriendo estado = this._EstadoVentaRepositorio.findById(propiedad.getId_estadoventa()).get();

        return new ModelAndView("html/propiedad").addObject("propiedad", propiedad)
                                                 .addObject("estadoventa", estado)
                                                 .addObject("tipopropiedad", tipo);
    }
    //Muestra los detalles de la noticia elegida
    @GetMapping("noticia/{id}")
    public ModelAndView mostrarNoticia(@PathVariable Integer id){
        Noticias noticia = this._NoticiasRepository.findById(id).get();
        TipoNoticias tNoticias = this._TipoNoticiasRepository.findById(noticia.getId_tipo_noticias()).get();
        return new ModelAndView("/html/noticia/noticia").addObject("noticia", noticia)
                                                        .addObject("tnoticia", tNoticias);
    }
    @GetMapping("/procesos")
    public ModelAndView mostrarProcesos(){
        return new ModelAndView("html/procesos");
    }
    @GetMapping("/contacto")
    public ModelAndView mostrarContacto(){
        return new ModelAndView("html/contacto");
    }
}
