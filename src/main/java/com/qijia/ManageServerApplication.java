package com.qijia;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@EnableConfigurationProperties()
@EnableSwagger2
@EnableWebMvc
public class ManageServerApplication {
    public static void main(String[] args) {
        SpringApplication.run(ManageServerApplication.class, args);
    }
}