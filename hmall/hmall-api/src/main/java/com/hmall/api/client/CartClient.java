package com.hmall.api.client;

import com.hmall.api.dto.PageDTO;
import com.hmall.api.entity.Cart;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@FeignClient(name = "hmall-service", contextId = "cartClient", path = "/api/cart")
public interface CartClient {

    @GetMapping("/{id}")
    Cart getById(@PathVariable("id") Long id);

    @GetMapping("/list")
    PageDTO<Cart> list(@RequestParam("pageNum") Integer pageNum, @RequestParam("pageSize") Integer pageSize);

    @PostMapping
    Cart save(@RequestBody Cart cart);

    @PutMapping
    Cart update(@RequestBody Cart cart);

    @DeleteMapping("/{id}")
    Boolean deleteById(@PathVariable("id") Long id);
}
