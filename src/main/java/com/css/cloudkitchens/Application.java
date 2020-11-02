package com.css.cloudkitchens;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.SpringBootConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
@SpringBootConfiguration
public class Application {

    public static void main(String[] args) {
        ConfigurableApplicationContext cont = SpringApplication.run(Application.class, args);
        System.out.println("App start success!");
    }

}
