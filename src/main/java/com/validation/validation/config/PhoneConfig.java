package com.validation.validation.config;

import com.validation.validation.config.impl.PhoneService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class PhoneConfig {
    @Bean
    public PhoneService phoneService(){
        return new PhoneService();
    }
}
