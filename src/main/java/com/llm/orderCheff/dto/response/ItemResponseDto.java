package com.llm.orderCheff.dto.response;

import com.llm.orderCheff.entity.Ingredient;
import com.llm.orderCheff.entity.Item;
import com.llm.orderCheff.entity.enums.Measure;

import java.time.LocalDate;
import java.util.Set;

public record ItemResponseDto(
        Long id,
        Double price,
        Boolean inStock,
        Integer quantity,
        Set<Ingredient> ingredients,
        Measure measure,
        LocalDate createdAt,
        LocalDate updatedAt
) {
    public ItemResponseDto(Item item){
        this(
            item.getId(),
            item.getPrice(),
            item.getInStock(),
            item.getQuantity(),
            item.getIngredients(),
            item.getMeasure(),
            item.getCreatedAt(),
            item.getUpdatedAt()
        );
    }
}
