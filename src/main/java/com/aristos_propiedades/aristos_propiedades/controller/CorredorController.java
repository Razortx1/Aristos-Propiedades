package com.aristos_propiedades.aristos_propiedades.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.aristos_propiedades.aristos_propiedades.model.EstadoVentaArriendo;
import com.aristos_propiedades.aristos_propiedades.model.Propiedades;
import com.aristos_propiedades.aristos_propiedades.model.TipoPropiedad;
import com.aristos_propiedades.aristos_propiedades.repository.estadoVentaRepositorio;
import com.aristos_propiedades.aristos_propiedades.repository.tipoPropiedadRepository;

@Controller
@RequestMapping("/corredor")
public class CorredorController {
    @Autowired
    private tipoPropiedadRepository _tiporepository;

    @Autowired
    private estadoVentaRepositorio _ventaRepositorio;
    
    @GetMapping("/create/propiedades")
    public ModelAndView mostrarFormularioCrearPropiedad(){
        List<TipoPropiedad> tiposp =  _tiporepository.findAll(Sort.by("tipo_de_propiedad"));
        List<EstadoVentaArriendo> estado = _ventaRepositorio.findAll();
        return new ModelAndView("/html/reg-prop")
                                                .addObject("propiedad", new Propiedades())
                                                .addObject("tipoprop", tiposp)
                                                .addObject("estadoprop", estado);
    }
}
