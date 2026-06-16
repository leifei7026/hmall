package com.hmall.service.controller;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.hmall.api.dto.PageDTO;
import com.hmall.api.entity.Order;
import com.hmall.service.service.OrderService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

@Tag(name = "订单管理", description = "订单增删改查接口")
@RestController
@RequestMapping("/api/order")
public class OrderController {

    @Resource
    private OrderService orderService;

    @Operation(summary = "根据ID查询订单")
    @GetMapping("/{id}")
    public Order getById(@Parameter(description = "订单ID") @PathVariable Long id) {
        return orderService.getById(id);
    }

    @Operation(summary = "分页查询订单")
    @GetMapping("/list")
    public PageDTO<Order> list(
            @Parameter(description = "页码", example = "1") @RequestParam(defaultValue = "1") Integer pageNum,
            @Parameter(description = "每页大小", example = "10") @RequestParam(defaultValue = "10") Integer pageSize) {
        return PageDTO.of(orderService.page(new Page<>(pageNum, pageSize)));
    }

    @Operation(summary = "新增订单")
    @PostMapping
    public Order save(@RequestBody Order order) {
        orderService.save(order);
        return order;
    }

    @Operation(summary = "更新订单")
    @PutMapping
    public Order update(@RequestBody Order order) {
        orderService.updateById(order);
        return order;
    }

    @Operation(summary = "根据ID删除订单")
    @DeleteMapping("/{id}")
    public Boolean deleteById(@Parameter(description = "订单ID") @PathVariable Long id) {
        return orderService.removeById(id);
    }
}
