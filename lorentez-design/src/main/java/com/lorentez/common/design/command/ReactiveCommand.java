package com.lorentez.common.design.command;

import jakarta.validation.*;
import reactor.core.publisher.Mono;

import java.util.Set;

public abstract class ReactiveCommand<REQUEST extends CommandRequest, RESULT extends CommandResult, CONTEXT extends CommandContext> {

    protected abstract Mono<RESULT> execute(REQUEST request, CONTEXT context);

    public Mono<RESULT> call(REQUEST request, CONTEXT context) {
        validateInput(request);
        return execute(request, context);
    }

    protected void validateInput(REQUEST request) {
        try (ValidatorFactory factory = Validation.buildDefaultValidatorFactory()) {
            Validator validator = factory.getValidator();
            Set<ConstraintViolation<REQUEST>> violations = validator.validate(request);
            if (!violations.isEmpty()) {
                throw new ConstraintViolationException(violations);
            }
        }
    }

}
