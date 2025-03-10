package com.tenstech.todocore.config;

import org.springframework.data.domain.AuditorAware;
    import org.springframework.security.core.context.SecurityContextHolder;
    import org.springframework.security.core.userdetails.UserDetails;
    import java.util.Optional;

    public class AuditorAwareImpl implements AuditorAware<String> {

        @Override
        public Optional<String> getCurrentAuditor() {
            try {
                UserDetails userDetails = (UserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
                return Optional.of(userDetails.getUsername());
            } catch (Exception e) {
                return Optional.of("System");
            }
        }
    }