package com.popularsafi;

import jakarta.persistence.EntityManagerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

///@ComponentScan(basePackages= {"controller"})
///@ComponentScan(basePackages = {"controller","service","impl","inicio"})
//@EntityScan(basePackages = {"model"})
//@EnableJpaRepositories(basePackages = {"dao"})
//@EnableJpaRepositories
///@EnableAutoConfiguration(exclude={DataSourceAutoConfiguration.class})

@SpringBootApplication
public class PopularsafiappBackendApplication extends SpringBootServletInitializer {

    public static void main(String[] args) {
        SpringApplication.run(PopularsafiappBackendApplication.class, args);
    }

    public SpringApplicationBuilder configure(SpringApplicationBuilder applicationBuilder){
        return applicationBuilder.sources(PopularsafiappBackendApplication.class);
    }

}
