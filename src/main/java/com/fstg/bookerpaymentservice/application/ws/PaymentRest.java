package com.fstg.bookerpaymentservice.application.ws;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fstg.bookerpaymentservice.application.dto.PaymentDto;
import com.fstg.bookerpaymentservice.domain.core.Result;
import com.fstg.bookerpaymentservice.domain.payment.PaymentCreateProcess;
import com.fstg.bookerpaymentservice.domain.payment.PaymentCreateProcessInput;


@RestController
@RequestMapping("/api/v1/payment")
public class PaymentRest {

    @PostMapping("/")
    public Result save(@RequestBody PaymentDto paymentDto) {
        PaymentCreateProcessInput paymentCreateProcessInput = paymentDto.to(paymentDto);
        return paymentCreateProcess.execute(paymentCreateProcessInput);
    }

    @Autowired
    private PaymentCreateProcess paymentCreateProcess;


}