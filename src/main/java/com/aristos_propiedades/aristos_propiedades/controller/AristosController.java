package com.aristos_propiedades.aristos_propiedades.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
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
import com.aristos_propiedades.aristos_propiedades.service.AristosService;
import com.aristos_propiedades.aristos_propiedades.service.emailService;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
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
    @Autowired
    private emailService mailService;
    @Autowired
    private AristosService _AristosService;


    //Envia 3 propiedades y noticias a la pagina de inicio
    @GetMapping({"/index", ""})
    public ModelAndView indexCorredor(){
        List<Propiedades> propiedades = this._PropiedadRepository.findAll(PageRequest.of(0, 3, Sort.by("idpropiedad").descending())).toList();
        List<Noticias> noticias = this._NoticiasRepository.findAll(PageRequest.of(0, 3, Sort.by("idnoticia").descending())).toList();
        return new ModelAndView("html/index")
                                            .addObject("propiedades", propiedades)
                                            .addObject("noticias", noticias);
    }
    //Estre representa el codigo de cuando el usuario presiona en propiedades mostrando todas las propiedades existentes en el sistema
    @GetMapping("/propiedades")
    public ModelAndView mostrarTodasLasPropiedades(@PageableDefault(size = 8) Pageable pageable){
        Page<Propiedades> mpropiedades = this._PropiedadRepository.findAll(pageable);
        return new ModelAndView("html/propiedades")
                    .addObject("propiedades", mpropiedades);
    }
    @GetMapping("/propiedades/{id}")
    public ModelAndView mostrarLasPropiedades(@PageableDefault(size = 8) Pageable pageable, Integer filter){
        Page<Propiedades> mpropiedades;
        if (filter == null) {
            mpropiedades = this._PropiedadRepository.findAll(pageable);
        }
        else{
            mpropiedades = this._AristosService.getPropiedadesByTipo(filter);
        }
        return new ModelAndView("html/propiedades")
                    .addObject("propiedades", mpropiedades);
    }
    //Muestra los detalles de la propiedad elegida
    @GetMapping("/propiedad/{id}")
    public ModelAndView mostrarPropiedad(@PathVariable Integer id){
        Propiedades propiedad = this._PropiedadRepository.findById(id).get();
        TipoPropiedad tipo = this._TipoPropiedadRepository.findById(propiedad.getIdtipopropiedad()).get();
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
    //Muestra la pagina donde se puede observar el proceso de negocio de la Empresa
    @GetMapping("/procesos")
    public ModelAndView mostrarProcesos(){
        return new ModelAndView("html/procesos");
    }
    //Muestra formulario de contacto
    @GetMapping("/contacto")
    public ModelAndView mostrarContacto(){
        return new ModelAndView("html/contacto");
    }
    //URL necesario para procesar la informacion del formulario y asi enviarlo
    @PostMapping("/sendMail")
    public ModelAndView sendMail(@RequestParam("name") String name, @RequestParam("mail") String mail, @RequestParam("subject") String subject, @RequestParam("body") String body){

        String message = body +"\n\n Datos de contacto: " + "\nNombre: " + name + "\nE-mail: " + mail;
        mailService.sendEmail("niko.meneses40@gmail.com","nicolas.meneses12@inacapmail.cl",subject,message);

        return new ModelAndView("redirect:/contacto");
    }
}
