package com.CapacitacionCert.demo;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class configuracion implements WebMvcConfigurer {

        @Override
        public void addCorsMappings(CorsRegistry registry) {
            registry.addMapping("/**") // Aplica la configuración CORS a todos los endpoints (/**)
                    .allowedOrigins("http://localhost:4200") // Permite solo este origen
                    .allowedMethods("GET", "POST", "PUT", "DELETE", "OPTIONS") // Permite estos métodos HTTP
                    .allowedHeaders("*") // Permite todas las cabeceras
                    .allowCredentials(true); // Si necesitas enviar cookies o cabeceras de autorización
        }
    }

