package com.aristos_propiedades.aristos_propiedades.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.servlet.ModelAndView;

import com.aristos_propiedades.aristos_propiedades.model.EstadoVentaArriendo;
import com.aristos_propiedades.aristos_propiedades.model.Propiedades;
import com.aristos_propiedades.aristos_propiedades.model.TipoPropiedad;
import com.aristos_propiedades.aristos_propiedades.repository.estadoVentaRepositorio;
import com.aristos_propiedades.aristos_propiedades.repository.propiedadRepository;
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

    @GetMapping({"/index", ""})
    public ModelAndView indexCorredor(@PageableDefault(size = 3) Pageable pageable){
        Page<Propiedades> propiedades = this._PropiedadRepository.findAll(pageable);
        return new ModelAndView("html/index")
                                                        .addObject("propiedades", propiedades);
    }

    @GetMapping("/propiedades")
    public ModelAndView mostrarTodasLasPropiedades(Pageable pageable){
        Page<Propiedades> mpropiedades = this._PropiedadRepository.findAll(pageable);
        return new ModelAndView("html/propiedades")
                    .addObject("propiedades", mpropiedades);
    }
    @GetMapping("propiedades/{id}")
    public ModelAndView mostrarPropiedad(@PathVariable Integer id){
        Propiedades propiedad = this._PropiedadRepository.findById(id).get();
        TipoPropiedad tipo = this._TipoPropiedadRepository.findById(propiedad.getId_tipo_propiedad()).get();
        EstadoVentaArriendo estado = this._EstadoVentaRepositorio.findById(propiedad.getId_estadoventa()).get();

        return new ModelAndView("html/propiedad").addObject("propiedad", propiedad)
                                                 .addObject("estadoventa", estado)
                                                 .addObject("tipopropiedad", tipo);
    }
}
