package com.fstg.bookerpaymentservice.infra.proxy;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.fstg.bookerpaymentservice.domain.pojo.Order;

@FeignClient(name = "booker-order-service", url="localhost:8085")
public interface OrderProxy {
	
	@GetMapping("order-api/ref/{ref}")
	public Order findByReference( @PathVariable String reference);

    @PostMapping("order-api/")
	public int update(@RequestBody Order oder) ;
	   
}