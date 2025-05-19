package com.llm.orderCheff.repository;

import com.llm.orderCheff.entity.Item;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ItemRepository extends JpaRepository<Item, Long> {
}
