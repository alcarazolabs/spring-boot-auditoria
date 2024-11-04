package com.alclabs.auditoria.config;

import org.springframework.data.domain.AuditorAware;

import java.util.Optional;

// Creating implementation of AuditorAware and override its methods to provide currently logged in user
public class AuditorAwareImpl implements AuditorAware<String> {


    @Override
    public Optional<String> getCurrentAuditor() {

            return Optional.of("Admin");

            // Can use Spring Security to return currently logged in user
            // return ((User) SecurityContextHolder.getContext().getAuthentication().getPrincipal()).getUsername()
    }
}
