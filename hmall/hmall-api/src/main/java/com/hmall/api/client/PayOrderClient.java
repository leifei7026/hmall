package com.hmall.api.client;

import com.hmall.api.dto.PageDTO;
import com.hmall.api.entity.PayOrder;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@FeignClient(name = "hmall-service", contextId = "payOrderClient", path = "/api/pay-order")
public interface PayOrderClient {

    @GetMapping("/{id}")
    PayOrder getById(@PathVariable("id") Long id);

    @GetMapping("/list")
    PageDTO<PayOrder> list(@RequestParam("pageNum") Integer pageNum, @RequestParam("pageSize") Integer pageSize);

    @PostMapping
    PayOrder save(@RequestBody PayOrder payOrder);

    @PutMapping
    PayOrder update(@RequestBody PayOrder payOrder);

    @DeleteMapping("/{id}")
    Boolean deleteById(@PathVariable("id") Long id);
}
