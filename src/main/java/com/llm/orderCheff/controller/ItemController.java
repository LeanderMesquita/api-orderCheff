package com.llm.orderCheff.controller;

import com.llm.orderCheff.dto.request.ItemCreateRequestDto;
import com.llm.orderCheff.dto.request.ItemUpdateRequestDto;
import com.llm.orderCheff.dto.response.ItemResponseDto;
import com.llm.orderCheff.entity.Item;
import com.llm.orderCheff.service.ItemService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/items")
public class ItemController {

    private final ItemService service;

    public ItemController(ItemService service) {
        this.service = service;
    }

    @GetMapping
    public ResponseEntity<Page<ItemResponseDto>> getAll(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "15") int size
    ){
        Pageable pageable = PageRequest.of(page, size, Sort.by(Sort.Direction.DESC, "updatedAt"));
        Page<ItemResponseDto> response = service.getAll(pageable).map(ItemResponseDto::new);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ItemResponseDto> getById(@PathVariable Long id){
        Item item = service.getById(id);

        return new ResponseEntity<>(new ItemResponseDto(item), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Void> create(@RequestBody ItemCreateRequestDto requestDto){
        service.create(requestDto);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Void> update(@PathVariable Long id, @RequestBody ItemUpdateRequestDto requestDto){
        service.update(id, requestDto);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id){
        service.delete(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
