package com.newproject.springboot.app.Testing.controllers;

import com.newproject.springboot.app.Testing.models.dto.ParamDto;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/var")
public class PathVariableController {

    @GetMapping("/baz/{message}&{code}")
    public ParamDto baz(
            @PathVariable String message,
            @PathVariable Integer code
    ){
        ParamDto param = new ParamDto();
        param.setMessage(message);
        param.setCode(code);
        return param;
    }

}
