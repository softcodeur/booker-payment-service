package com.fstg.bookerpaymentservice.infra.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.fstg.bookerpaymentservice.domain.pojo.Order;
import com.fstg.bookerpaymentservice.infra.core.AbstractInfraImpl;
import com.fstg.bookerpaymentservice.infra.facade.OrderInfra;
import com.fstg.bookerpaymentservice.infra.proxy.OrderProxy;


@Component
public class OrderInfraImpl extends AbstractInfraImpl implements OrderInfra {

    @Override
    public Order findByReference(String reference) {
         return orderProxy.findByReference(reference);
    }


    @Override
    public int save(Order order) {
       
        return orderProxy.save(order);
    }

    @Override
    public int update(Order oder) {
       
        return orderProxy.update(oder);
    }
   

    @Autowired
    private OrderProxy orderProxy;;
}