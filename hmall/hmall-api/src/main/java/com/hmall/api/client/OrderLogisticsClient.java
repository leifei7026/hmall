package com.hmall.api.client;

import com.hmall.api.dto.PageDTO;
import com.hmall.api.entity.OrderLogistics;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@FeignClient(name = "hmall-service", contextId = "orderLogisticsClient", path = "/api/order-logistics")
public interface OrderLogisticsClient {

    @GetMapping("/{id}")
    OrderLogistics getById(@PathVariable("id") Long id);

    @GetMapping("/list")
    PageDTO<OrderLogistics> list(@RequestParam("pageNum") Integer pageNum, @RequestParam("pageSize") Integer pageSize);

    @PostMapping
    OrderLogistics save(@RequestBody OrderLogistics orderLogistics);

    @PutMapping
    OrderLogistics update(@RequestBody OrderLogistics orderLogistics);

    @DeleteMapping("/{id}")
    Boolean deleteById(@PathVariable("id") Long id);
}
