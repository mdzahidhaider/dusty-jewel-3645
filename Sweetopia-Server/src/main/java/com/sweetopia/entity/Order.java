package com.sweetopia.entity;


import java.time.LocalDate;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.fasterxml.jackson.annotation.JsonFormat;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
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
    private Long orderId;




    private LocalDate createdDate;

    @ElementCollection(fetch = FetchType.EAGER)
    @CollectionTable(name = "order_products")
    @MapKeyJoinColumn(name = "product_id")
    @Column(name = "quantity")
    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    private Map<Product, Long> groupedProducts=new HashMap<>();

    @ManyToOne
    @JoinColumn(name = "customer_id")
    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    private Customer customer;

    @OneToOne
    @JoinColumn(name = "order_bill_id")
    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    private OrderBill orderBill;
}
