package com.aristos_propiedades.aristos_propiedades.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
@Controller
public class AristosController {
    @GetMapping("/index")
    public String index() {
        return "html/index";
    }
    
}
