package com.fstg.bookerpaymentservice.domain.order.payment;

import com.fstg.bookerpaymentservice.domain.core.AbstractProcessImpl;
import com.fstg.bookerpaymentservice.domain.core.Result;
import com.fstg.bookerpaymentservice.domain.pojo.Order;
import com.fstg.bookerpaymentservice.infra.facade.OrderInfra;

public class OrderPaymentProcessImpl extends AbstractProcessImpl<OrderPaymentInput> implements OrderPaymentProcess {

    private OrderInfra orderInfra;


    public void validate(OrderPaymentInput orderPaymentInput, Result result) {
        String reference = orderPaymentInput.getReference();
        double amount = orderPaymentInput.getAmount();
      Order order = orderInfra.findByReference(reference);
        if (order == null || order.getId() == null) {
            result.addErrorMessage(orderInfra.getMessage("order.payment.not_founded"));
        } else if (order.getTotalPaye() + amount > order.getTotal()) {
           result.addErrorMessage(orderInfra.getMessage("order.payment.prob_payment"));
        }
    }


    public void run(OrderPaymentInput orderPaymentInput, Result result) {
        String reference = orderPaymentInput.getReference();
        double montant = orderPaymentInput.getAmount();
        Order order = orderInfra.findByReference(reference);
        double nvTotalPaye = order.getTotalPaye() + montant;
        order.setTotalPaye(nvTotalPaye);
        orderInfra.update(order);
        result.addInfoMessage(orderInfra.getMessage("order.payment.created"));
    }


    public OrderPaymentProcessImpl(OrderInfra orderInfra) {
        this.orderInfra = orderInfra;
    }

}
