package com.gitlab.lorentez.fmcommons.api.page;

import org.junit.jupiter.api.Test;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.function.Function;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class FmPageTest {

    @Test
    void shouldMapPageToPageApiProperly() {
        //given
        Page<Long> testPage = new PageImpl<>(List.of(2L, 5L, 7L), Pageable.ofSize(2), 3L);

        //when
        FmPage<Long> result = FmPage.of(testPage, Function.identity());

        //then
        assertNotNull(result);
        assertEquals(testPage.getContent().size(), result.getContent().size());
        assertThat(testPage.getContent()).containsAll(result.getContent());
        assertEquals(testPage.getTotalPages(), result.getTotalPages());
        assertEquals(testPage.getTotalElements(), result.getTotalElements());
        assertEquals(testPage.getNumber(), result.getPageNumber());
        assertEquals(testPage.getSize(), result.getPageSize());
        assertEquals(testPage.isFirst(), result.isFirst());
        assertEquals(testPage.isLast(), result.isLast());
        assertEquals(testPage.hasNext(), result.isHasNext());
        assertEquals(testPage.hasPrevious(), result.isHasPrevious());
    }

    void shouldMapPageApiToDifferentTypeProperly() {
        //given
        Function<Long, Long> multiplier = (value) -> value * 2L;
        FmPage<Long> page = FmPage.<Long>builder()
                .content(List.of(1L, 2L, 3L))
                .totalPages(1)
                .totalElements(3L)
                .pageSize(3)
                .pageNumber(1)
                .first(true)
                .last(true)
                .hasNext(false)
                .hasPrevious(false)
                .build();

        //when
        FmPage<Long> result = page.map(multiplier);

        //then
        assertNotNull(result);
        assertEquals(page.getContent().size(), result.getContent().size());
        assertThat(page.getContent()).containsAll(List.of(2L, 4L, 6L));
        assertEquals(page.getTotalPages(), result.getTotalPages());
        assertEquals(page.getTotalElements(), result.getTotalElements());
        assertEquals(page.getPageNumber(), result.getPageNumber());
        assertEquals(page.getPageSize(), result.getPageSize());
        assertEquals(page.isFirst(), result.isFirst());
        assertEquals(page.isLast(), result.isLast());
        assertEquals(page.isHasNext(), result.isHasNext());
        assertEquals(page.isHasPrevious(), result.isHasPrevious());
    }

}