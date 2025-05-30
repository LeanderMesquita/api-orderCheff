package com.llm.orderCheff.dto.request;

import com.llm.orderCheff.entity.Ingredient;
import com.llm.orderCheff.entity.enums.Measure;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.PositiveOrZero;

import java.util.Set;

public record ItemCreateRequestDto(
    @NotNull
    @Positive
    Double price,
    @PositiveOrZero
    Integer quantity,
    @NotNull
    Set<Ingredient> ingredients,
    @NotNull
    Measure measure
) {
}
