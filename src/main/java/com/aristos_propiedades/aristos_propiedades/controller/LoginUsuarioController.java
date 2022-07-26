package com.aristos_propiedades.aristos_propiedades.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class LoginUsuarioController {
    //Envia al usuario para que este pueda iniciar sesion dentro del sistema
    @GetMapping("/login")
    public String getLogin(HttpServletRequest request, HttpSession session){
        session.setAttribute("error", "Correo o contraseña no valido");
        return "login";
    }
    //Envia al usuario a una pagina indicando un error al momento de este iniciar sesion
    //Este error vendria siendo si es que una cuenta corredor entra a la interfaz de admin
    //Siendo lo mismo al reves
    @GetMapping("/403")
    public String getError403(){
        return "403error";
    }
}
