package com.llm.orderCheff.dto.request;

import com.llm.orderCheff.entity.enums.Measure;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.PositiveOrZero;

import java.time.LocalDate;

public record IngredientUpdateRequestDto(
        Measure measure,
        @Positive
        Double price,
        @PositiveOrZero
        Integer quantity,
        LocalDate expDate
) {
}
