package com.gitlab.lorentez.fmcommons.command;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;

import java.util.UUID;

@Getter
public class SuccessSaveResult extends CommandResult {

    private final UUID id;
    private final Long version;

    private SuccessSaveResult(UUID id, Long version) {
        this.id = id;
        this.version = version;
    }

    @JsonCreator
    public static SuccessSaveResult of(
            @JsonProperty("id") UUID id,
            @JsonProperty("version") Long version) {
        return new SuccessSaveResult(id, version);
    }

}
