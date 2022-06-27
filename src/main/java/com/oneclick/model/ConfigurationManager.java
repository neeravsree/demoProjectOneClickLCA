package com.oneclick.model;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ConfigurationManager {

     @Bean
     public ResourceList resourcelist() {
        return new ResourceList(-1, "Select Resource");
    } 
}