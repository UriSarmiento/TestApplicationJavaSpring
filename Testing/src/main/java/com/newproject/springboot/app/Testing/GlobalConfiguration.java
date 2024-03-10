package com.newproject.springboot.app.Testing;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.PropertySources;

@Configuration
// Para utilizar archivos de configuracion, si se agregan mas se separan con , y se usa el PropertySource
@PropertySources({
        //@PropertySource("classpath:customConfig.properties")
        @PropertySource(value = "classpath:customConfig.properties", encoding = "UTF-8") // El encoding es para los caracteres especiales por alguna razon el file igual debe estar codificado como UTF-8
})
public class GlobalConfiguration {
}
