package com.llm.orderCheff.dto.request;

import com.llm.orderCheff.entity.Ingredient;
import com.llm.orderCheff.entity.enums.Measure;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.PositiveOrZero;

import java.util.Set;

public record ItemUpdateRequestDto(
    @Positive
    Double price,
    @PositiveOrZero
    Integer quantity,
    Set<Ingredient> ingredients,
    Measure measure
) {
}
