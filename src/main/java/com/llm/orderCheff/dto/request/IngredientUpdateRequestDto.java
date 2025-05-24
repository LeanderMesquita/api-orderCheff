package com.llm.orderCheff.dto.request;

import com.llm.orderCheff.entity.enums.Measure;

import java.time.LocalDate;

public record IngredientUpdateRequestDto(
        Measure measure,
        Double price,
        Integer quantity,
        LocalDate expDate
) {
}
