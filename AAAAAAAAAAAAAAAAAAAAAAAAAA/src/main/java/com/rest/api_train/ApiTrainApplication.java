package com.rest.api_train;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@SpringBootApplication
public class ApiTrainApplication {

    public static void main(String[] args) {

        SpringApplication.run(ApiTrainApplication.class, args);
    }
    @Bean
    public WebMvcConfigurer corsConfigurer(){
        return new WebMvcConfigurer() {
            @Override
            public void addCorsMappings(CorsRegistry registry){
                registry.addMapping("/**")
                        .allowedMethods("GET","PUT","POST","DELETE")
                        .allowedHeaders("origin", "content-type", "accept", "authorization")
                        .allowCredentials(true)
                        .allowedOrigins("http://localhost");
            }
        };
    }

}
