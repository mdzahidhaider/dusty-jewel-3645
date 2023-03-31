package com.sweetopia.dto;

import com.sweetopia.entity.Category;
import jakarta.persistence.Embeddable;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@Embeddable
public class ProductDTO {
    private Long productId;
    private String name;
    private String photoPath;
    private Double price;
    private String description;
    private Integer quantity;

    private String categoryName;


}
