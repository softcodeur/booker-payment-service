package com.fstg.bookerpaymentservice.domain.payment;

import org.springframework.stereotype.Service;

import com.fstg.bookerpaymentservice.domain.core.AbstractProcessImpl;
import com.fstg.bookerpaymentservice.domain.core.Result;
import com.fstg.bookerpaymentservice.domain.pojo.Order;
import com.fstg.bookerpaymentservice.domain.pojo.Payment;
import com.fstg.bookerpaymentservice.infra.facade.OrderInfra;
import com.fstg.bookerpaymentservice.infra.facade.PaymentInfra;

@Service
public class PaymentCreateProcessImpl extends AbstractProcessImpl<PaymentCreateProcessInput> implements PaymentCreateProcess {


    @Override
    public void validate(PaymentCreateProcessInput abstractProcessInput, Result result) {
        Order order = orderInfra.findByReference(abstractProcessInput.getOrderReference());
        Payment payment = paymentInfra.findByReference(abstractProcessInput.getPayment().getReference());
        if (order == null) {
            result.addErrorMessage("payment.create.order_not_founded");
        }else if(order.getTotalPaye()+abstractProcessInput.getPayment().getAmount()>order.getTotal()){
            result.addErrorMessage("payment.create.amount_invalid");
        }
        if (payment != null && payment.getId() != null) {
            result.addErrorMessage("payment.create.payment_already_exists");
        }
    }

    @Override
    public void run(PaymentCreateProcessInput abstractProcessInput, Result result) {
        Order order = orderInfra.findByReference(abstractProcessInput.getOrderReference());
        Payment payment = abstractProcessInput.getPayment();
        payment.setOrderReference(order.getReference());
        order.setTotalPaye(order.getTotalPaye()+payment.getAmount());
        orderInfra.update(order);
        paymentInfra.save(payment);
        result.addInfoMessage("payment.create.payment_created");
    }

    public PaymentCreateProcessImpl(PaymentInfra paymentInfra, OrderInfra orderInfra) {
        this.paymentInfra = paymentInfra;
       this.orderInfra = orderInfra;
    }


    private PaymentInfra paymentInfra;
    private OrderInfra orderInfra;
}
