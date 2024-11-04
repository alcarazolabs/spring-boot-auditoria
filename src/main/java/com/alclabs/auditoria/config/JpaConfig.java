package com.alclabs.auditoria.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.domain.AuditorAware;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

// Will need to enable JPA Auditing
@Configuration
@EnableJpaAuditing(auditorAwareRef = "auditorAware")
public class JpaConfig {

    // Creating a bean of AuditorAwareImpl which will provide currently logged in user
    @Bean
    public AuditorAware<String> auditorAware() {
        return new AuditorAwareImpl();
    }



}
