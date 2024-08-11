package com.polarbookshop.catalogservice.config;

import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * Configuration class from Chapter 4 for getting the welcome message
 */

@ConfigurationProperties(prefix = "polar")
public class PolarProperties {

    private String greeting;

    public String getGreeting(){
        return greeting;
    }

    public void setGreeting(String greeting){
        this.greeting = greeting;
    }
}
