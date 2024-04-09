package com.projectdc.application;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;


@SpringBootApplication(scanBasePackages={
        "com.projectdc", "com.projectdc.*"})
@ComponentScan(basePackages={"com.projectdc", "com.projectdc.*"})
@EntityScan(basePackages={"com.projectdc", "com.projectdc.*"})
@EnableJpaRepositories("com.projectdc.repository")
public class Application extends SpringBootServletInitializer {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

}
