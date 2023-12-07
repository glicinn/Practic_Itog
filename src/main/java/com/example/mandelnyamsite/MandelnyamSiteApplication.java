package com.example.mandelnyamsite;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories(basePackages = "com.example.mandelnyamsite.repos")
@EntityScan(basePackages = "com.example.mandelnyamsite.models")
public class MandelnyamSiteApplication {

    public static void main(String[] args) {
        SpringApplication.run(MandelnyamSiteApplication.class, args);
    }

//    public static void main(String[] args) {
//        SpringApplication.run(MandelnyamSiteApplication.class, args);
//    }

}
