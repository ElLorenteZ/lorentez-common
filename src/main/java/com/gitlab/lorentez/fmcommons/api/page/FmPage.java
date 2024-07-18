package com.gitlab.lorentez.fmcommons.api.page;

import lombok.Builder;
import lombok.Getter;
import lombok.extern.jackson.Jacksonized;
import org.springframework.data.domain.Page;

import java.util.Collection;
import java.util.function.Function;

@Builder
@Getter
@Jacksonized
public class FmPage<TYPE> {

    private final Collection<TYPE> content;
    private final int totalPages;
    private final long totalElements;
    private final int pageNumber;
    private final int pageSize;
    private final boolean first;
    private final boolean last;
    private final boolean hasNext;
    private final boolean hasPrevious;

    public static <TYPE, OTHER_TYPE> FmPage<TYPE> of(Page<OTHER_TYPE> page, Function<OTHER_TYPE, TYPE> mapper) {
        return FmPage.<TYPE>builder()
                .content(page.getContent()
                        .stream()
                        .map(mapper)
                        .toList()
                )
                .totalPages(page.getTotalPages())
                .totalElements(page.getTotalElements())
                .pageNumber(page.getNumber())
                .pageSize(page.getSize())
                .first(page.isFirst())
                .last(page.isLast())
                .hasNext(page.hasNext())
                .hasPrevious(page.hasPrevious())
                .build();
    }

    public <DEST_TYPE> FmPage<DEST_TYPE> map(Function<TYPE, DEST_TYPE> mapper) {
        return FmPage.<DEST_TYPE>builder()
                .content(this.getContent()
                        .stream()
                        .map(mapper)
                        .toList()
                )
                .totalPages(this.getTotalPages())
                .totalElements(this.getTotalElements())
                .pageNumber(this.getPageNumber())
                .pageSize(this.getPageSize())
                .first(this.isFirst())
                .last(this.isLast())
                .hasNext(this.isHasNext())
                .hasPrevious(this.isHasPrevious())
                .build();
    }
}
