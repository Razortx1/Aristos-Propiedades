package com.aristos_propiedades.aristos_propiedades.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.aristos_propiedades.aristos_propiedades.model.Rol;
import com.aristos_propiedades.aristos_propiedades.model.Usuario;
import com.aristos_propiedades.aristos_propiedades.repository.RolRepository;
import com.aristos_propiedades.aristos_propiedades.service.UsuarioService;

@Controller
public class UsuarioController {
    @Autowired
    private UsuarioService _UserService;
    @Autowired
    private RolRepository _rolrepository;
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
    @GetMapping("/user/create")
    public ModelAndView createUser(){
        List<Rol>rol=_rolrepository.findAll();
        return new ModelAndView( "html/administrador/new-user")
        .addObject("usuario", new Usuario())
        .addObject("rol", rol);
    }

    @PostMapping("/user")
    public String saveUser(Model model, @ModelAttribute Usuario user){
       Usuario u = this._UserService.createUser(user);
       model.addAttribute("user",u);
       return "redirect:/user";
    }
    
    @GetMapping("/user/{id}/edit")
    public String editUser(Model model, @PathVariable("id")Integer id){
        model.addAttribute("user", this._UserService.getById(id));
        return "html/administrador/edit-user";
    }

    @PutMapping("/user/{id}/update")
    public String updateUser(Model model, @PathVariable("id") Integer id, @ModelAttribute Usuario user) throws Exception{
        Usuario u = this._UserService.editUser(id, user);
        model.addAttribute("user",u);
        return "redirect:/user";
    }

    @DeleteMapping("/user/{id}/delete")
    public String delteUser(Model model, @PathVariable("id") Integer id){
        this._UserService.deleteUser(id);
        return "redirect:/user";
    }
}
