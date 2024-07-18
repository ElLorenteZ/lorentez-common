package com.lorentez.common.data.audit;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.AuditorAware;

import java.util.Optional;

@RequiredArgsConstructor
public class AuditorAwareImpl implements AuditorAware<String> {

    private final String auditorName;

    @Override
    public Optional<String> getCurrentAuditor() {
        return Optional.of(auditorName);
    }
}
