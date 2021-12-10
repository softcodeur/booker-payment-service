package com.fstg.bookerpaymentservice.domain.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Order {
    private Long id;
    private String reference;
    private double total;
    private double totalPaye;
    
}