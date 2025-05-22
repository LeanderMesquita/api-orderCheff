package com.llm.orderCheff.dto.request;

import com.llm.orderCheff.entity.Ingredient;
import com.llm.orderCheff.entity.enums.Measure;

import java.util.Set;

public record ItemCreateRequestDto(
    Double price,
    Boolean inStock,
    Integer quantity,
    Set<Ingredient> ingredients,
    Measure measure
) {
}
