package com.llm.orderCheff.service;

import com.llm.orderCheff.dto.request.IngredientCreateRequestDto;
import com.llm.orderCheff.dto.request.IngredientUpdateRequestDto;
import com.llm.orderCheff.entity.Ingredient;
import com.llm.orderCheff.repository.IngredientRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class IngredientService {

    private final IngredientRepository repository;

    public IngredientService(IngredientRepository repository) {
        this.repository = repository;
    }

    public Page<Ingredient> getAll(Pageable pageable){
        return repository.findAll(pageable);
    }

    public Ingredient getById(Long id){
        return repository.findById(id).orElseThrow(EntityNotFoundException::new);
    }

    public void create(IngredientCreateRequestDto requestDto){
        Ingredient ingredient = new Ingredient(
                requestDto.measure(),
                requestDto.price(),
                true,
                requestDto.quantity(),
                requestDto.expDate()
        );
        repository.save(ingredient);
    }

    public void update(Long id, IngredientUpdateRequestDto requestDto){
        Ingredient ingredient = getById(id);

        if (ingredient.getQuantity() <= 0){
            ingredient.setInStock(false);
        }

        ingredient.setMeasure(requestDto.measure());
        ingredient.setPrice(requestDto.price());
        ingredient.setQuantity(requestDto.quantity());
        ingredient.setExpDate(requestDto.expDate());

        repository.save(ingredient);
    }

    public void delete(Long id){
        repository.delete(getById(id));
    }
}
