package com.aristos_propiedades.aristos_propiedades.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.aristos_propiedades.aristos_propiedades.model.Rol;
import com.aristos_propiedades.aristos_propiedades.model.Usuario;
import com.aristos_propiedades.aristos_propiedades.repository.RolRepository;
import com.aristos_propiedades.aristos_propiedades.service.UsuarioService;

@Controller
@RequestMapping("/admin")
public class UsuarioController {
    @Autowired
    private UsuarioService _UserService;
    @Autowired
    private RolRepository _rolrepository;
    @GetMapping()
    public String inicio(){
        return "html/administrador/index";
    }
    //Permite al usuario ingresar a una tabla donde se mostrarán todos los usuarios creados hasta la fecha
    @GetMapping("/user")
    public String getUsers(Model model, @RequestParam(required = false, defaultValue ="")String filter){
        List<Usuario> users;
        if(filter == null || filter.isEmpty()){
            users=this._UserService.getAllUsers();
        }else{
            users = this._UserService.getUsersByFilter(filter);
        }
        model.addAttribute("users",users);
        return "html/administrador/list-user";
    }
    //Envia al usuario a un formulario donde pueda crear a los usuarios
    @GetMapping("/user/create")
    public ModelAndView createUser(){
        List<Rol>rol=_rolrepository.findAll();
        return new ModelAndView( "html/administrador/new-user")
        .addObject("usuario", new Usuario())
        .addObject("rol", rol);
    }
    //Una vez se de clic al boton del formulario para crear, esta parte del codigo se encarga de guardar al usuario en la BD
    @PostMapping("/user/create")
    public String saveUser(Model model, @ModelAttribute Usuario user){
       Usuario u = this._UserService.createUser(user);
       model.addAttribute("user",u);
       return "redirect:/admin/user";
    }
    //Envia al usuario a un formulario para poder editar algun usuario
    @GetMapping("/user/{id}/edit")
    public ModelAndView editUser(@PathVariable("id")Integer id){
        Usuario user = this._UserService.getById(id);
        List<Rol> rol = this._rolrepository.findAll();
        return new ModelAndView("html/administrador/edit-user").addObject("user", user).addObject("rol", rol);
    }
    //Una vez se da clic al boton del formulario, esta parte del codigo se encarga de mandar una peticion para actualizar el usuario
    @PutMapping("/user/{id}/edit")
    public ModelAndView updateUser(@PathVariable Integer id, @Validated Usuario user) throws Exception{
        this._UserService.editUser(id, user);
        return new ModelAndView("redirect:/admin/user");
    }
    //Manda una peticion al servicio para eliminar un usuario
    @DeleteMapping("/user/{id}/delete")
    public String delteUser(Model model, @PathVariable("id") Integer id){
        this._UserService.deleteUser(id);
        return "redirect:/admin/user";
    }
}
