package com.proyecto;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import com.vaadin.flow.spring.annotation.EnableVaadin;

@SpringBootApplication
@EnableVaadin
public class ProyectoApplication extends SpringBootServletInitializer {
    public static void main(String[] args) {
        SpringApplication.run(ProyectoApplication.class, args);
    }
}