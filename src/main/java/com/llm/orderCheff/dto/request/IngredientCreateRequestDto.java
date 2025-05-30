package com.llm.orderCheff.dto.request;

import com.llm.orderCheff.entity.enums.Measure;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.PositiveOrZero;

import java.time.LocalDate;

public record IngredientCreateRequestDto(
        @NotNull
        Measure measure,
        @NotNull
        @Positive
        Double price,
        @PositiveOrZero
        Integer quantity,
        @NotNull
        LocalDate expDate
) {
}
