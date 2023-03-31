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

    @NotNull(message = "Date is not null")
    @NotBlank(message = "Date is not blank")
    @NotEmpty(message = "Date is not empty")
    @JsonFormat(pattern = "yyyy/MM/dd")
    private LocalDate createdDate;

    @NotNull(message = "Total cost is not null")
    @NotBlank(message = "Total cost is not blank")
    @NotEmpty(message = "Total cost is not empty")
    private float totalCost;

    @OneToOne(mappedBy = "orderBill", cascade = CascadeType.ALL)
    private Order sweetOrder;
}