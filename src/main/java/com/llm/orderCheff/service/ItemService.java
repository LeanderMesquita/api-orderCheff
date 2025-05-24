package com.llm.orderCheff.service;

import com.llm.orderCheff.dto.request.ItemCreateRequestDto;
import com.llm.orderCheff.dto.request.ItemUpdateRequestDto;
import com.llm.orderCheff.entity.Item;
import com.llm.orderCheff.repository.ItemRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class ItemService {

    private final ItemRepository repository;

    public ItemService(ItemRepository repository) {
        this.repository = repository;
    }

    public Page<Item> getAll(Pageable pageable){
        return repository.findAll(pageable);
    }

    public Item getById(Long id){
        return repository.findById(id).orElseThrow(EntityNotFoundException::new);
    }

    public void create(ItemCreateRequestDto requestDto){
        Item item = new Item(
                requestDto.price(),
                true,
                requestDto.quantity(),
                requestDto.ingredients(),
                requestDto.measure()
        );

        repository.save(item);
    }

    public void update(Long id, ItemUpdateRequestDto requestDto){
        Item item = getById(id);

        if (item.getQuantity() <= 0){
            item.setInStock(false);
        }

        item.setPrice(requestDto.price());
        item.setQuantity(requestDto.quantity());
        item.setIngredients(requestDto.ingredients());
        item.setMeasure(requestDto.measure());

        repository.save(item);
    }

    public void delete(Long id){
        repository.delete(getById(id));
    }
}
