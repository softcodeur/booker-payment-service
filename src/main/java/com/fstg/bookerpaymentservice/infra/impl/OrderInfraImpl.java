package com.fstg.bookerpaymentservice.infra.impl;

import com.fstg.bookerpaymentservice.domain.pojo.Order;
import com.fstg.bookerpaymentservice.infra.core.AbstractInfraImpl;
import com.fstg.bookerpaymentservice.infra.facade.OrderInfra;
import com.fstg.bookerpaymentservice.infra.proxy.OrderProxy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


@Component
public class OrderInfraImpl extends AbstractInfraImpl implements OrderInfra {

    @Override
    public Order findByReference(String reference) {
        return orderProxy.findByReference(reference);
    }


    @Override
    public void update(Order oder) {

        orderProxy.update(oder);
    }


    @Autowired
    private OrderProxy orderProxy;
    ;
}
