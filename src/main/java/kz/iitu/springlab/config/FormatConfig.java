package kz.iitu.springlab.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class FormatConfig {

    @Bean
    public String lab2Format() {
        return "LAB2";
    }
}
