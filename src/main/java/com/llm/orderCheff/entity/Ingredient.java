package com.llm.orderCheff.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.llm.orderCheff.entity.enums.Measure;
import jakarta.persistence.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.SoftDelete;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDate;
import java.util.Set;

@Entity
@Table(name = "tb_ingredient")
@SoftDelete
public class Ingredient {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "ingredient_seq")
    @SequenceGenerator(name = "ingredient_seq", sequenceName = "ingredient_seq", allocationSize = 1)
    private Long id;

    @Enumerated(EnumType.STRING)
    private Measure measure;

    @JsonIgnore
    @ManyToMany(mappedBy = "ingredients")
    private Set<Item> items;

    private Double price;
    private Boolean inStock;
    private Integer quantity;

    private LocalDate expDate;

    @CreationTimestamp
    private LocalDate createdAt;

    @UpdateTimestamp
    private LocalDate updatedAt;
}