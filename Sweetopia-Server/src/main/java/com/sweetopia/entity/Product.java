package com.sweetopia.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Objects;

@Entity
@Data
@NoArgsConstructor
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long productId;
    @NotNull
    private String name;
    @NotNull
    private String photoPath;
    @NotNull
    private Double price;
    @NotNull
    private String description;
    @NotNull
    @JsonIgnore
    private Integer available;
    @ManyToOne
    private Category category;


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Product product = (Product) o;
        return productId.equals(product.productId) && name.equals(product.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(productId, name);
    }
}
