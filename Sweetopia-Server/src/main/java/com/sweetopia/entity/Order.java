package com.sweetopia.entity;


import java.time.LocalDate;
import java.util.List;
import java.util.Map;

import com.fasterxml.jackson.annotation.JsonFormat;

import jakarta.persistence.*;
import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "sweet_order")
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer orderId;
    
    @ManyToOne
    private User userType;
    @JsonFormat(pattern="yyyy/MM/dd")
    private LocalDate createdDate;
    
    @ElementCollection(fetch = FetchType.EAGER)
    @MapKeyJoinColumn(name = "product_id")
    @Column(name = "quantity")
    private Map<Product, Long> groupedProducts;
}
