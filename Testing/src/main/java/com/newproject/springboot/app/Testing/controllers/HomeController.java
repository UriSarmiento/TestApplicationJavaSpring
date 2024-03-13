package com.newproject.springboot.app.Testing.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {
    @GetMapping({"/home","","/" })
    public String home(){
        return "redirect:/list"; //redirect cambia la ruta y se pierden los parametros, reinicia el request
        //return "forward:/list"; //forward mantiene la ruta y los parametros pero carga a su vez el nuevo request
    }
}
