package br.com.system.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class CORSconfigCadastroCliente {

    @Bean
    public WebMvcConfigurer corsConfigurer(){
        return new WebMvcConfigurer() {
            @Override
            public void addCorsMappings(CorsRegistry registry) {
                registry.addMapping("/api/cadastrar")
                        .allowedOrigins("http://localhost:5500")
                        .allowedMethods("POST");
                registry.addMapping("/api/login/agencia")
                        .allowedOrigins("http://localhost:5500")
                        .allowedMethods("POST");
            }
        };
    }
}
