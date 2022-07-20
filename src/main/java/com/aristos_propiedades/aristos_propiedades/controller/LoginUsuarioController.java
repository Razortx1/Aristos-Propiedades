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
        session.setAttribute("error", "Error al validar el usuario");
        return "login";
    }
}
