package com.hmall.service.controller;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.hmall.api.dto.PageDTO;
import com.hmall.api.entity.OrderDetail;
import com.hmall.service.service.OrderDetailService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

@Tag(name = "订单明细管理", description = "订单明细增删改查接口")
@RestController
@RequestMapping("/api/order-detail")
public class OrderDetailController {

    @Resource
    private OrderDetailService orderDetailService;

    @Operation(summary = "根据ID查询订单明细")
    @GetMapping("/{id}")
    public OrderDetail getById(@Parameter(description = "订单明细ID") @PathVariable Long id) {
        return orderDetailService.getById(id);
    }

    @Operation(summary = "分页查询订单明细")
    @GetMapping("/list")
    public PageDTO<OrderDetail> list(
            @Parameter(description = "页码", example = "1") @RequestParam(defaultValue = "1") Integer pageNum,
            @Parameter(description = "每页大小", example = "10") @RequestParam(defaultValue = "10") Integer pageSize) {
        return PageDTO.of(orderDetailService.page(new Page<>(pageNum, pageSize)));
    }

    @Operation(summary = "新增订单明细")
    @PostMapping
    public OrderDetail save(@RequestBody OrderDetail orderDetail) {
        orderDetailService.save(orderDetail);
        return orderDetail;
    }

    @Operation(summary = "更新订单明细")
    @PutMapping
    public OrderDetail update(@RequestBody OrderDetail orderDetail) {
        orderDetailService.updateById(orderDetail);
        return orderDetail;
    }

    @Operation(summary = "根据ID删除订单明细")
    @DeleteMapping("/{id}")
    public Boolean deleteById(@Parameter(description = "订单明细ID") @PathVariable Long id) {
        return orderDetailService.removeById(id);
    }
}
