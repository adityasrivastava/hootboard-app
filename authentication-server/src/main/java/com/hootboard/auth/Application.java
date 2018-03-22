package com.hootboard.auth;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ComponentScans;
import org.springframework.stereotype.Component;

@SpringBootApplication
@ComponentScans(value = {
        @ComponentScan(value = "com.hootboard.auth")
})
public class Application {
    public static void main(String[] args) {
        SpringApplication.run(Application.class,args);
    }
}
