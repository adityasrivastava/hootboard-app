package com.hootboard.persistence.mysql.auditor;

import org.springframework.data.domain.AuditorAware;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;

import java.math.BigInteger;
import java.util.Optional;

public class AuditorAwareImpl implements AuditorAware<String> {
    @Override
    public Optional<String> getCurrentAuditor() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();

        if (authentication == null || !authentication.isAuthenticated()
                || authentication.getName().equalsIgnoreCase("anonymousUser")) {
            return Optional.of("-1");
        }

        try {
            return Optional.of(authentication.getName());
        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }
}
