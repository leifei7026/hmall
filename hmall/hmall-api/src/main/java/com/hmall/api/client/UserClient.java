package com.hmall.api.client;

import com.hmall.api.dto.PageDTO;
import com.hmall.api.entity.User;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@FeignClient(name = "hmall-service", contextId = "userClient", path = "/api/user")
public interface UserClient {

    @GetMapping("/{id}")
    User getById(@PathVariable("id") Long id);

    @GetMapping("/list")
    PageDTO<User> list(@RequestParam("pageNum") Integer pageNum, @RequestParam("pageSize") Integer pageSize);

    @PostMapping
    User save(@RequestBody User user);

    @PutMapping
    User update(@RequestBody User user);

    @DeleteMapping("/{id}")
    Boolean deleteById(@PathVariable("id") Long id);
}
