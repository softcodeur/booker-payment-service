package com.fstg.bookerpaymentservice.application.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import org.springframework.beans.BeanUtils;

import com.fstg.bookerpaymentservice.domain.payment.PaymentCreateProcessInput;
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class PaymentDto {

    private Long id;
    private String reference;
    private double amount;
    private String orderReference;



    public static PaymentCreateProcessInput to(PaymentDto paymentDto) {
        PaymentCreateProcessInput paymentCreateProcessInput = new PaymentCreateProcessInput();
        BeanUtils.copyProperties(paymentDto, paymentCreateProcessInput.getPayment());
        paymentCreateProcessInput.setOrderReference(paymentDto.getOrderReference());
        return paymentCreateProcessInput;
    }
}
