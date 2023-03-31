package com.sweetopia.entity;


import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "order_bill")
public class OrderBill {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long orderBillId;



    private LocalDate createdDate;


    private float totalCost;

    @OneToOne(mappedBy = "orderBill", cascade = CascadeType.ALL)
    private Order sweetOrder;
}