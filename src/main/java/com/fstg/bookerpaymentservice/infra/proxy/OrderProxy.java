package com.fstg.bookerpaymentservice.infra.proxy;

import com.fstg.bookerpaymentservice.domain.pojo.Order;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(name = "ORDER-SERVICE")
public interface OrderProxy {

    @GetMapping("/api/v1/customerOrder/ref/{ref}")
    public Order findByReference(@PathVariable String ref);

    @PostMapping("/api/v1/customerOrder/")
    public int update(@RequestBody Order oder);

}