package com.newproject.springboot.app.Testing.controllers;

import com.newproject.springboot.app.Testing.models.dto.ParamDto;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/api/params")
public class RequestParamsController {
    @GetMapping("/foo")
        public ParamDto foo(@RequestParam(required = false, defaultValue = "No message") String message){ // por default el parametro es requerido y habra error si no viene en la ruta
        ParamDto param = new ParamDto();
        param.setMessage(message);
      //  param.setMessage(message!=null? message: "No message");
        return param;

    }

    @GetMapping("/bar")
    public ParamDto bar(
            @RequestParam(required = false, defaultValue = "No data", name = "data") String text, //se puede cambiar el nombre del parametro para que asi se reciba en la URL
            @RequestParam(required = false, defaultValue = "0") Integer code
                        ) // Asi se agrega mas de un parametro
    {
        ParamDto params = new ParamDto();
        params.setMessage(text);
        params.setCode(code);
        //  param.setMessage(message!=null? message: "No message");
        return params;

    }
    @GetMapping("/request")
    public ParamDto request(HttpServletRequest request){
        Integer code = 0; // initialize to 0 in case of nulls or incorrect input
        try{
           code = Integer.parseInt(request.getParameter("code"));
        }
        catch (NumberFormatException e) {
        /*
           try {
                Thread.sleep(99999); // Punish user for being dumb
            }
            catch (Throwable e2){

            }
         */
        }

        ParamDto params = new ParamDto();
        params.setCode(code); //Como siempre se recibe como string hay que parsearlo a Integer
        params.setMessage(request.getParameter("message"));

        return params;
    }

}
