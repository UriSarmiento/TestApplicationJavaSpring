package com.newproject.springboot.app.Testing.controllers;

import com.newproject.springboot.app.Testing.models.User;
import com.newproject.springboot.app.Testing.models.dto.ParamDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/var")
public class PathVariableController {

    // Se toma el valor de la configuracion
    @Value("${config.confCode}")
    private Integer confCode;
    @Value("${config.confMessage}")
    private String confMessage;
    @Value("${config.confList}")
    private List<String> confList;
    //Siempre que es un lenguaje de expresion se usa el gato
    @Value("#{ '${config.confList}'.toUpperCase().split(',') }") //covierte el string en un arreglo a mano, donde encuentra la coma es un elemento
    private List<String> valueList;

    @Value("#{ '${config.confList}'.toUpperCase() }") // Con lenguaje de expresion es mas manipulable
    private String valueString;

    @Value("#{${config.valuesMap}}")
    private Map<String,Object> valuesMap;

    @Value("#{${config.valuesMap}.product}")
    private String product;

    @Autowired
    private Environment environment;

   // @GetMapping("/baz/{message}&{code}") // asi tambien jala
   @GetMapping("/baz/{message}/{code}")
    public ParamDto baz(
            @PathVariable String message,
            @PathVariable Integer code
    ){
        ParamDto param = new ParamDto();
        param.setMessage(message);
        param.setCode(code);
        return param;
    }

    @PostMapping("/create")
    public User create(@RequestBody User user){
        //Magic & save en base de datos
       user.setName(user.getName().toUpperCase());
       user.setLastname(user.getLastname().toUpperCase());
       user.setEmail(user.getEmail().toUpperCase());
       return user;
    }

    @GetMapping("confvalues")// Utilizando valores configurados
    public Map<String, Object> confvalues(@Value("${config.confInject}") double injectedDouble){  // Se puede agregar como argumento para inyectar el valor al metodo
     Long code2 = environment.getProperty("config.confCode",Long.class);
        Map<String, Object> json = new HashMap<>();
        json.put("confCode", confCode);
        json.put("confMessage", confMessage);
        json.put("confList", confList);
        json.put("confInject", injectedDouble);
        json.put("valueList", valueList);
        json.put("valueString", valueString);
        json.put("valuesMap", valuesMap);
        json.put("product", product);
        json.put("environmentMessage", environment.getProperty("config.confMessage")); //Con environment
        json.put("environmentConfCode", Integer.valueOf(environment.getProperty("config.confCode")));
        json.put("environmentConfCodeLong", code2);

        return json;
    }
}
