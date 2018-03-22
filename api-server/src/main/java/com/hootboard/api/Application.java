package com.hootboard.api;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.SpringBootConfiguration;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ComponentScans;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;


@EnableAutoConfiguration
@ComponentScans(value = {
        @ComponentScan(basePackages = "com.hootboard")
})
public class Application {
    public static void main( String[] args ) {
        SpringApplication.run(Application.class,args);
    }
}
