package com.peterholub.onlinelibrary.configuration.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Configuration
public class PasswordEncoderConfig {

    private static BCryptPasswordEncoder passwordEncoder;

    @Bean("passwordEncoder")
    public BCryptPasswordEncoder passwordEncoder() {
        if (passwordEncoder == null) {
            passwordEncoder = new BCryptPasswordEncoder(10);
        }
        return passwordEncoder;
    }
}
