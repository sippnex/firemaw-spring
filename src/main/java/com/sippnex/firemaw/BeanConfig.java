package com.sippnex.firemaw;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BeanConfig {

    @Bean
    public FiremawProcessor firemawProcessor() {
        return new FiremawProcessor();
    }

}
