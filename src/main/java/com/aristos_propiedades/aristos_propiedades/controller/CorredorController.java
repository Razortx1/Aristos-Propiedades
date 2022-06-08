package com.aristos_propiedades.aristos_propiedades.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.aristos_propiedades.aristos_propiedades.model.EstadoVentaArriendo;
import com.aristos_propiedades.aristos_propiedades.model.Propiedades;
import com.aristos_propiedades.aristos_propiedades.model.TipoPropiedad;
import com.aristos_propiedades.aristos_propiedades.repository.estadoVentaRepositorio;
import com.aristos_propiedades.aristos_propiedades.repository.propiedadRepository;
import com.aristos_propiedades.aristos_propiedades.repository.tipoPropiedadRepository;
import com.aristos_propiedades.aristos_propiedades.service.ImageServiceSuper;

@Controller
@RequestMapping("/corredor")
public class CorredorController {
    @Autowired
    private tipoPropiedadRepository _tiporepository;

    @Autowired
    private estadoVentaRepositorio _ventaRepositorio;

    @Autowired
    private propiedadRepository _propiedadRepository;

    @Autowired
    private ImageServiceSuper _ImageService;

    @GetMapping()
    public String indexCorredor(){
        return "corredor/indexcorredor";
    }
    
    @GetMapping("/create/propiedades")
    public ModelAndView mostrarFormularioCrearPropiedad(){
        List<TipoPropiedad> tiposp =  _tiporepository.findAll();
        List<EstadoVentaArriendo> estado = _ventaRepositorio.findAll();
        return new ModelAndView("/html/reg-prop")
                                                .addObject("propiedad", new Propiedades())
                                                .addObject("tipoprop", tiposp)
                                                .addObject("estadoprop", estado);
    }
    @PostMapping("/create/propiedades")
    public ModelAndView crearNuevaPropiedad(@Validated Propiedades propiedad){
        String patharchivo=this._ImageService.almacenerArchivo(propiedad.getArchivoFile());
        propiedad.setImagenes_propiedad(patharchivo);
        this._propiedadRepository.save(propiedad);
        return new ModelAndView("redirect:/corredor");
    }
}
