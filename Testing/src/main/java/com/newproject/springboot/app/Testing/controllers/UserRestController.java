package com.newproject.springboot.app.Testing.controllers;


import com.newproject.springboot.app.Testing.models.User;
import com.newproject.springboot.app.Testing.models.dto.UserDto;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.*;

@RestController
@RequestMapping("/api")
public class UserRestController {

    @GetMapping(path="/details")
    public UserDto details(){
   // public Map<String, Object> details(){
        UserDto userDto = new UserDto();
        User user = new User("Andres","Guzman");

        userDto.setUser(user);
        userDto.setTitle("Hola Mundo Spring Boot");

       // Map<String, Object> body = new HashMap<>();

      //  body.put("title", "Hola Mundo Spring Boot");
       // body.put("name", "Andres");
       // body.put("lastname", "Guzman");
       // body.put("User", user);
        return userDto;
        //return body;
    }

    @GetMapping("/list")
    public List<User> list(){
        User user = new User("Andres","Guzman");
        User user2 = new User("Uriel","Sarmiento");
        User user3 = new User("Laura","Hernandez");
        List<User> users = Arrays.asList(user, user2, user3);
//        List<User> users = new ArrayList<>();
//        users.add(user);
//        users.add(user2);
//        users.add(user3);

        return users;
    }
}
