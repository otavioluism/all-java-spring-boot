package br.com.otavioluism.api_spring_boot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = "br.com.otavioluism")
public class ApiSpringBoot {

    public static void main(String[] args) {
        SpringApplication.run(ApiSpringBoot.class, args);
    }

}
