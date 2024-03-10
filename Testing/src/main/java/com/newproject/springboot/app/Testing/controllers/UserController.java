package com.newproject.springboot.app.Testing.controllers;


import com.newproject.springboot.app.Testing.models.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//@RestController
@Controller
public class UserController {
    /*Pal RestController*/
    /*
    @GetMapping("/app/foo")
    public Map<String, Object> foo(){
        Map<String, Object> json = new HashMap<>();
        json.put("message", "Hola mundo spring boot api rest");
        json.put("date", new Date());

        return json;
    }
    */
    @GetMapping("/details")
    public String details(Model model){
        User user = new User("Andres","Guzman");
        model.addAttribute("title", "Hola Mundo Spring Boot");
        //model.addAttribute("name", "Andres");
        //model.addAttribute("lastname", "Guzman");
        model.addAttribute("user", user);
        return "details";
    }
    @GetMapping("/list")
        public String list(ModelMap model){
       // model.addAttribute("users", users);
        model.addAttribute("title","Listado de usuarios");

        return "list";
    }

    @ModelAttribute("users")
    public List<User> userModel(){
        return Arrays.asList(
                new User("Pepa","Gonzalez"),
                new User("Jaime","Hernandez","jaimito232@gmail.com"),
                new User("Laura","Yepez"),
                new User("Teodoro","Jimenez","elteo390@outlook.com")
        );
    }
}
