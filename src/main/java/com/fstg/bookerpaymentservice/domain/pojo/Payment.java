package com.fstg.bookerpaymentservice.domain.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data  
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Payment {
    private Long id;
    private String reference;
    private double amount;
    private String orderReference;
    
}