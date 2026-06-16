package com.hmall.api.client;

import com.hmall.api.dto.PageDTO;
import com.hmall.api.entity.Item;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@FeignClient(name = "hmall-service", contextId = "itemClient", path = "/api/item")
public interface ItemClient {

    @GetMapping("/{id}")
    Item getById(@PathVariable("id") Long id);

    @GetMapping("/list")
    PageDTO<Item> list(@RequestParam("pageNum") Integer pageNum, @RequestParam("pageSize") Integer pageSize);

    @PostMapping
    Item save(@RequestBody Item item);

    @PutMapping
    Item update(@RequestBody Item item);

    @DeleteMapping("/{id}")
    Boolean deleteById(@PathVariable("id") Long id);
}
