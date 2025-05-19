package com.llm.orderCheff.entity;

import com.llm.orderCheff.entity.enums.Measure;
import jakarta.persistence.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.SoftDelete;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDate;
import java.util.Set;


@Entity
@Table(name = "tb_item")
@SoftDelete
public class Item {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "item_seq")
    @SequenceGenerator(name = "item_seq", sequenceName = "item_seq", allocationSize = 1)
    private Long id;

    private Double price;
    private Boolean inStock;
    private Integer quantity;

    @ManyToMany
    @JoinTable(
            name = "tb_item_ingredient",
            joinColumns = @JoinColumn(name = "item_id"),
            inverseJoinColumns = @JoinColumn(name = "ingredient_id")
    )
    private Set<Ingredient> ingredients;

    @Enumerated(EnumType.STRING)
    private Measure measure;

    @CreationTimestamp
    private LocalDate createdAt;

    @UpdateTimestamp
    private LocalDate updatedAt;

}