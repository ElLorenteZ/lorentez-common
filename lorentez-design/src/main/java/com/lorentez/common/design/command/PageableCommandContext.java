package com.lorentez.common.design.command;

import lombok.Getter;

@Getter
public class PageableCommandContext extends CommandContext {

    private final boolean onlyActive;
    private final int pageNumber;
    private final int pageSize;

    public static PageableCommandContext of(boolean onlyActive, int pageNumber, int pageSize) {
        return new PageableCommandContext(onlyActive, pageNumber, pageSize);
    }

    protected PageableCommandContext(boolean onlyActive, int pageNumber, int pageSize) {
        this.onlyActive = onlyActive;
        this.pageNumber = pageNumber;
        this.pageSize = pageSize;
    }
}
