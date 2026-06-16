package com.hmall.api.client;

import com.hmall.api.dto.PageDTO;
import com.hmall.api.entity.Order;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@FeignClient(name = "hmall-service", contextId = "orderClient", path = "/api/order")
public interface OrderClient {

    @GetMapping("/{id}")
    Order getById(@PathVariable("id") Long id);

    @GetMapping("/list")
    PageDTO<Order> list(@RequestParam("pageNum") Integer pageNum, @RequestParam("pageSize") Integer pageSize);

    @PostMapping
    Order save(@RequestBody Order order);

    @PutMapping
    Order update(@RequestBody Order order);

    @DeleteMapping("/{id}")
    Boolean deleteById(@PathVariable("id") Long id);
}
