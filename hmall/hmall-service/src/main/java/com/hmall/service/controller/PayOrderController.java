package com.hmall.service.controller;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.hmall.api.dto.PageDTO;
import com.hmall.api.entity.PayOrder;
import com.hmall.service.service.PayOrderService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

@Tag(name = "支付订单管理", description = "支付订单增删改查接口")
@RestController
@RequestMapping("/api/pay-order")
public class PayOrderController {

    @Resource
    private PayOrderService payOrderService;

    @Operation(summary = "根据ID查询支付订单")
    @GetMapping("/{id}")
    public PayOrder getById(@Parameter(description = "支付订单ID") @PathVariable Long id) {
        return payOrderService.getById(id);
    }

    @Operation(summary = "分页查询支付订单")
    @GetMapping("/list")
    public PageDTO<PayOrder> list(
            @Parameter(description = "页码", example = "1") @RequestParam(defaultValue = "1") Integer pageNum,
            @Parameter(description = "每页大小", example = "10") @RequestParam(defaultValue = "10") Integer pageSize) {
        return PageDTO.of(payOrderService.page(new Page<>(pageNum, pageSize)));
    }

    @Operation(summary = "新增支付订单")
    @PostMapping
    public PayOrder save(@RequestBody PayOrder payOrder) {
        payOrderService.save(payOrder);
        return payOrder;
    }

    @Operation(summary = "更新支付订单")
    @PutMapping
    public PayOrder update(@RequestBody PayOrder payOrder) {
        payOrderService.updateById(payOrder);
        return payOrder;
    }

    @Operation(summary = "根据ID删除支付订单")
    @DeleteMapping("/{id}")
    public Boolean deleteById(@Parameter(description = "支付订单ID") @PathVariable Long id) {
        return payOrderService.removeById(id);
    }
}
