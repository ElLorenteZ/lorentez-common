package com.gitlab.lorentez.fmcommons.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor(staticName = "of")
public class ExceptionProjection {
    private final String name;
    private final String description;
}
