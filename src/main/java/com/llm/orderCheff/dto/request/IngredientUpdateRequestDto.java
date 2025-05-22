package com.llm.orderCheff.dto.request;

import com.llm.orderCheff.entity.Item;
import com.llm.orderCheff.entity.enums.Measure;

import java.time.LocalDate;
import java.util.Set;

public record IngredientUpdateRequestDto(
        Measure measure,
        Set<Item> items,
        Double price,
        Boolean inStock,
        LocalDate expDate
) {
}
