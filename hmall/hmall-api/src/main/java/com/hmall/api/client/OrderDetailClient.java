package com.hmall.api.client;

import com.hmall.api.dto.PageDTO;
import com.hmall.api.entity.OrderDetail;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@FeignClient(name = "hmall-service", contextId = "orderDetailClient", path = "/api/order-detail")
public interface OrderDetailClient {

    @GetMapping("/{id}")
    OrderDetail getById(@PathVariable("id") Long id);

    @GetMapping("/list")
    PageDTO<OrderDetail> list(@RequestParam("pageNum") Integer pageNum, @RequestParam("pageSize") Integer pageSize);

    @PostMapping
    OrderDetail save(@RequestBody OrderDetail orderDetail);

    @PutMapping
    OrderDetail update(@RequestBody OrderDetail orderDetail);

    @DeleteMapping("/{id}")
    Boolean deleteById(@PathVariable("id") Long id);
}
