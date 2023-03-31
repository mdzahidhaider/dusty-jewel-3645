package com.sweetopia.entity;


import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.fasterxml.jackson.annotation.JsonFormat;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.sweetopia.dto.ProductDTO;
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




    private LocalDate createdDate=LocalDate.now();


    @Embedded
    @ElementCollection(fetch = FetchType.EAGER)
    @JoinTable(name = "order_Product", joinColumns = @JoinColumn(name = "order_id"))
    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    private List<ProductDTO> groupedProducts=new ArrayList<>();

    @ManyToOne
    @JoinColumn(name = "customer_id")
    @JsonIgnore
    private Customer customer;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "order_bill_id")
    @JsonIgnore
    private OrderBill orderBill;
}
