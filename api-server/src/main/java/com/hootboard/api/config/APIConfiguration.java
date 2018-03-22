package com.hootboard.api.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.bind.annotation.ControllerAdvice;

@Configuration
@ControllerAdvice(basePackages = {"com.hootboard.api"})
public class APIConfiguration {
}
