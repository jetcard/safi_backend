package com.popularsafi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

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
