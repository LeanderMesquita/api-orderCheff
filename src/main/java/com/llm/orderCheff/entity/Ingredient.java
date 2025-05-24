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

    public Ingredient () {

    }

    public Ingredient(Measure measure, Double price, Boolean inStock, Integer quantity, LocalDate expDate) {
        this.measure = measure;
        this.price = price;
        this.inStock = inStock;
        this.quantity = quantity;
        this.expDate = expDate;
    }

    public Long getId() {
        return id;
    }

    public Measure getMeasure() {
        return measure;
    }

    public void setMeasure(Measure measure) {
        this.measure = measure;
    }

    public Set<Item> getItems() {
        return items;
    }

    public void setItems(Set<Item> items) {
        this.items = items;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Boolean getInStock() {
        return inStock;
    }

    public void setInStock(Boolean inStock) {
        this.inStock = inStock;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public LocalDate getExpDate() {
        return expDate;
    }

    public void setExpDate(LocalDate expDate) {
        this.expDate = expDate;
    }

    public LocalDate getCreatedAt() {
        return createdAt;
    }

    public LocalDate getUpdatedAt() {
        return updatedAt;
    }

}