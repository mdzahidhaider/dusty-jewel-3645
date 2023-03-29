package com.sweetopia.entity;

import lombok.*;

import java.time.LocalDate;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonFormat;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "order_bill")
public class OrderBill {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer orderBillId;
    
    @NotNull(message="Date is Not null")
    @NotBlank(message="Date is Not Blank")
    @NotEmpty(message="Date is Not Empty")
    @JsonFormat(pattern="yyyy/MM/dd")
    private LocalDate createdDate;
    
    
    @NotNull(message="Total cost is Not null")
    @NotBlank(message="Total cost is Not Blank")
    @NotEmpty(message="Total cost is Not Empty")
    private float totalCost;
    
    @OneToMany(mappedBy = "orderBill", cascade = CascadeType.ALL)
    private List<Order> listSweetOrder;
}
