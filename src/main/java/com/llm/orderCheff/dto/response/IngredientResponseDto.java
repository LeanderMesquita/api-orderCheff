package com.llm.orderCheff.dto.response;

import com.llm.orderCheff.entity.Ingredient;
import com.llm.orderCheff.entity.Item;
import com.llm.orderCheff.entity.enums.Measure;

import java.time.LocalDate;
import java.util.Set;

public record IngredientResponseDto(
        Long id,
        Measure measure,
        Set<Item> items,
        Double price,
        Boolean inStock,
        Integer quantity,
        LocalDate expDate,
        LocalDate createdAt,
        LocalDate updatedAt
) {
    public IngredientResponseDto(Ingredient ingredient){
        this(
                ingredient.getId(),
                ingredient.getMeasure(),
                ingredient.getItems(),
                ingredient.getPrice(),
                ingredient.getInStock(),
                ingredient.getQuantity(),
                ingredient.getExpDate(),
                ingredient.getCreatedAt(),
                ingredient.getUpdatedAt()
        );
    }
}
