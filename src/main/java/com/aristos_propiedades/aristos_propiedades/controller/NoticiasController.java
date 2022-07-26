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

    //Muestra formulario para crear noticias
    @GetMapping("/create/noticias")
    public ModelAndView formularioCrearNoticias(){
        List<TipoNoticias> tipon = this._TipoNoticiasRepository.findAll();
        return new ModelAndView("/corredor/noticias/new-noticias").addObject("noticias", new Noticias())
                                                                .addObject("tipon", tipon);
    }
    //Toma el contenido del formulario y lo envia a la base de datos
    @PostMapping("/create/noticias")
    public ModelAndView crearNuevaPropiedad(@Validated Noticias noticias){
        String patharchivo=this._ImageService.almacenerArchivo(noticias.getArchivo());
        noticias.setImagen_noticia(patharchivo);
        this._NoticiasRepository.save(noticias);
        return new ModelAndView("redirect:/corredor/listarnoticias");
    }
    //Envia una peticion a la base de datos para traer todas las noticias dentro del sistema, mostrandolas
    @GetMapping("/listarnoticias")
    public ModelAndView mostrarNoticias(@PageableDefault(size = 5) Pageable pageable){
        Page<Noticias> noticias = this._NoticiasRepository.findAll(pageable);
        return new ModelAndView("/corredor/noticias/noticias").addObject("noticias", noticias);
    }
    //Muestra formulario para editar noticias
    @GetMapping("/edit/noticia/{id}")
    public ModelAndView mostrarFormularioNoticias(@PathVariable Integer id){
        Noticias noticia = this._NoticiasRepository.findById(id).get();
        List<TipoNoticias> tipoNoticias = this._TipoNoticiasRepository.findAll();
        return new ModelAndView("/corredor/noticias/new-noticias").addObject("noticias", noticia)
                                                                .addObject("tipon", tipoNoticias);
    }
    //Toma todo el contenido del formulario y lo envia a la base de datos
    @PostMapping("/edit/noticia/{id}")
    public ModelAndView actualizarNoticia(@PathVariable Integer id, @Validated Noticias noticias, BindingResult bindingResult){
        if (bindingResult.hasErrors()) {
            List<TipoNoticias> tipoNoticias = this._TipoNoticiasRepository.findAll();
            return new ModelAndView("/corredor/noticias/new-noticias").addObject("noticias", noticias)
                                                                .addObject("tipon", tipoNoticias);
        }
        Noticias noticiaEdit = this._NoticiasRepository.findById(id).get();
        noticiaEdit.setDescripcion_noticia(noticias.getDescripcion_noticia());
        noticiaEdit.setFecha_noticia(noticias.getFecha_noticia());
        noticiaEdit.setId_tipo_noticias(noticias.getId_tipo_noticias());
        noticiaEdit.setTitulo_Noticia(noticiaEdit.getTitulo_Noticia());

        if (!noticias.getArchivo().isEmpty()) {
            this._ImageService.eliminarArchivo(noticiaEdit.getImagen_noticia());
            String ruta = this._ImageService.almacenerArchivo(noticias.getArchivo());
            noticiaEdit.setImagen_noticia(ruta);
        }
        this._NoticiasRepository.save(noticiaEdit);
        return new ModelAndView("redirect:/corredor/listarnoticias");
    }
    //Toma la id de la noticia y la elimina
    @GetMapping("/delete/noticia/{id}")
	public String eliminarPelicula(@PathVariable Integer id) {
		Noticias noticia = this._NoticiasRepository.findById(id).get();
		this._ImageService.eliminarArchivo(noticia.getImagen_noticia());
        this._NoticiasRepository.delete(noticia);
		return "redirect:/corredor/listarnoticias";
	}
}
