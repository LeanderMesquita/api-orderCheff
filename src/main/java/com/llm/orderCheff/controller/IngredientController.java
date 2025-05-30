package com.llm.orderCheff.controller;

import com.llm.orderCheff.dto.request.IngredientCreateRequestDto;
import com.llm.orderCheff.dto.request.IngredientUpdateRequestDto;
import com.llm.orderCheff.dto.response.IngredientResponseDto;
import com.llm.orderCheff.entity.Ingredient;
import com.llm.orderCheff.service.IngredientService;
import jakarta.validation.Valid;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/ingredients")
public class IngredientController {

    private final IngredientService service;

    public IngredientController(IngredientService service) {
        this.service = service;
    }

    @GetMapping
    public ResponseEntity<Page<IngredientResponseDto>> getAll(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "15") int size
    ){
        Pageable pageable = PageRequest.of(page, size, Sort.by(Sort.Direction.DESC, "updatedAt"));
        Page<IngredientResponseDto> response = service.getAll(pageable).map(IngredientResponseDto::new);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<IngredientResponseDto> getById(@PathVariable Long id){
        Ingredient ingredient = service.getById(id);

        return new ResponseEntity<>(new IngredientResponseDto(ingredient), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Void> create(@Valid @RequestBody IngredientCreateRequestDto requestDto){
        service.create(requestDto);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Void> update(@PathVariable Long id, @Valid @RequestBody IngredientUpdateRequestDto requestDto){
        service.update(id, requestDto);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id){
        service.delete(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
