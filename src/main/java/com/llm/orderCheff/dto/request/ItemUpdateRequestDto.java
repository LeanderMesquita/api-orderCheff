package com.llm.orderCheff.dto.request;

import com.llm.orderCheff.entity.Ingredient;
import com.llm.orderCheff.entity.enums.Measure;

import java.util.Set;

public record ItemUpdateRequestDto(
    Double price,
    Integer quantity,
    Set<Ingredient> ingredients,
    Measure measure
) {
}
