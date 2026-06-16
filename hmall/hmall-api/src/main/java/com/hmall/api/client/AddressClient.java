package com.hmall.api.client;

import com.hmall.api.dto.PageDTO;
import com.hmall.api.entity.Address;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@FeignClient(name = "hmall-service", contextId = "addressClient", path = "/api/address")
public interface AddressClient {

    @GetMapping("/{id}")
    Address getById(@PathVariable("id") Long id);

    @GetMapping("/list")
    PageDTO<Address> list(@RequestParam("pageNum") Integer pageNum, @RequestParam("pageSize") Integer pageSize);

    @PostMapping
    Address save(@RequestBody Address address);

    @PutMapping
    Address update(@RequestBody Address address);

    @DeleteMapping("/{id}")
    Boolean deleteById(@PathVariable("id") Long id);
}
