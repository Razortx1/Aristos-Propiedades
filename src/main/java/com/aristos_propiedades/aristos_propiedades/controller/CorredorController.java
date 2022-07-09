package com.aristos_propiedades.aristos_propiedades.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.aristos_propiedades.aristos_propiedades.model.EstadoVentaArriendo;
import com.aristos_propiedades.aristos_propiedades.model.Noticias;
import com.aristos_propiedades.aristos_propiedades.model.Propiedades;
import com.aristos_propiedades.aristos_propiedades.model.TipoPropiedad;
import com.aristos_propiedades.aristos_propiedades.repository.estadoVentaRepositorio;
import com.aristos_propiedades.aristos_propiedades.repository.noticiasRepository;
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

    @Autowired
    private noticiasRepository _NoticiasRepository;

    @GetMapping()
    public ModelAndView indexCorredor(@PageableDefault(size = 3) Pageable pageable){
        Page<Propiedades> propiedades = this._propiedadRepository.findAll(pageable);
        Page<Noticias> noticias = this._NoticiasRepository.findAll(pageable);
        return new ModelAndView("corredor/indexcorredor")
                                                        .addObject("propiedades", propiedades)
                                                        .addObject("noticias", noticias);
    }
    
    @GetMapping("/create/propiedades")
    public ModelAndView mostrarFormularioCrearPropiedad(){
        List<TipoPropiedad> tiposp =  _tiporepository.findAll();
        List<EstadoVentaArriendo> estado = _ventaRepositorio.findAll();
        return new ModelAndView("corredor/reg-prop")
                                                .addObject("propiedad", new Propiedades())
                                                .addObject("tipoprop", tiposp)
                                                .addObject("estadoprop", estado);
    }
    @PostMapping("/create/propiedades")
    public ModelAndView crearNuevaPropiedad(@Validated Propiedades propiedad){
        String patharchivo=this._ImageService.almacenerArchivo(propiedad.getArchivoFile());
        propiedad.setImagenes_propiedad(patharchivo);
        this._propiedadRepository.save(propiedad);
        return new ModelAndView("redirect:/corredor/listapropiedades");
    }
    @GetMapping("/listapropiedades")
    public ModelAndView listarPropiedades(@PageableDefault(size = 5) Pageable pageable){
        Page<Propiedades> propiedades = this._propiedadRepository.findAll(pageable);
        return new ModelAndView("corredor/propiedades")
                                                        .addObject("propiedades", propiedades);
    }
    @GetMapping("/edit/{id}")
    public ModelAndView editarPropiedades(@PathVariable Integer id){
        Propiedades propiedad = this._propiedadRepository.findById(id).get();
        List<TipoPropiedad> tiposp =  _tiporepository.findAll();
        List<EstadoVentaArriendo> estado = _ventaRepositorio.findAll();
        return new ModelAndView("corredor/edit-prop")
                                                .addObject("propiedad", propiedad)
                                                .addObject("tipoprop", tiposp)
                                                .addObject("estadoprop", estado);
    }
    @PostMapping("edit/{id}")
    public ModelAndView actualizarPropiedad(@PathVariable Integer id, @Validated Propiedades propiedad, BindingResult bindingResult){
        if (bindingResult.hasErrors()) {
            List<TipoPropiedad> tiposp =  _tiporepository.findAll();
            List<EstadoVentaArriendo> estado = _ventaRepositorio.findAll();
            return new ModelAndView("corredor/edit-prop")
                                                        .addObject("propiedad", propiedad)
                                                        .addObject("tipoprop", tiposp)
                                                        .addObject("estadoprop", estado);
        }
        Propiedades propiedades = this._propiedadRepository.findById(id).get();
        propiedades.setBanios(propiedad.getBanios());
        propiedades.setEstacionamiento(propiedad.getEstacionamiento());
        propiedades.setHabitaciones(propiedad.getHabitaciones());
        propiedades.setId_estadoventa(propiedad.getId_estadoventa());
        propiedades.setId_tipo_propiedad(propiedad.getId_tipo_propiedad());
        propiedades.setM2_construidos(propiedad.getM2_construidos());
        propiedades.setM2_terreno(propiedad.getM2_terreno());
        propiedades.setPatio(propiedad.getPatio());
        propiedades.setQuincho(propiedad.getQuincho());
        propiedades.setValor(propiedad.getValor());
        propiedades.setUbicacion(propiedad.getUbicacion());
        propiedades.setTitulo_Propiedad(propiedad.getTitulo_Propiedad());
        propiedades.setTerrazas(propiedad.getTerrazas());

        if (!propiedad.getArchivoFile().isEmpty()) {
            this._ImageService.eliminarArchivo(propiedades.getImagenes_propiedad());
            String ruta = this._ImageService.almacenerArchivo(propiedad.getArchivoFile());
            propiedades.setImagenes_propiedad(ruta);
        }
        this._propiedadRepository.save(propiedades);
        return new ModelAndView("redirect:/corredor/listapropiedades");
    }
}
