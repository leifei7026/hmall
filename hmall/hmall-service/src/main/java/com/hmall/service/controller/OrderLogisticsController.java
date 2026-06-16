package com.hmall.service.controller;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.hmall.api.dto.PageDTO;
import com.hmall.api.entity.OrderLogistics;
import com.hmall.service.service.OrderLogisticsService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

@Tag(name = "物流管理", description = "物流增删改查接口")
@RestController
@RequestMapping("/api/order-logistics")
public class OrderLogisticsController {

    @Resource
    private OrderLogisticsService orderLogisticsService;

    @Operation(summary = "根据ID查询物流")
    @GetMapping("/{id}")
    public OrderLogistics getById(@Parameter(description = "物流ID") @PathVariable Long id) {
        return orderLogisticsService.getById(id);
    }

    @Operation(summary = "分页查询物流")
    @GetMapping("/list")
    public PageDTO<OrderLogistics> list(
            @Parameter(description = "页码", example = "1") @RequestParam(defaultValue = "1") Integer pageNum,
            @Parameter(description = "每页大小", example = "10") @RequestParam(defaultValue = "10") Integer pageSize) {
        return PageDTO.of(orderLogisticsService.page(new Page<>(pageNum, pageSize)));
    }

    @Operation(summary = "新增物流")
    @PostMapping
    public OrderLogistics save(@RequestBody OrderLogistics orderLogistics) {
        orderLogisticsService.save(orderLogistics);
        return orderLogistics;
    }

    @Operation(summary = "更新物流")
    @PutMapping
    public OrderLogistics update(@RequestBody OrderLogistics orderLogistics) {
        orderLogisticsService.updateById(orderLogistics);
        return orderLogistics;
    }

    @Operation(summary = "根据ID删除物流")
    @DeleteMapping("/{id}")
    public Boolean deleteById(@Parameter(description = "物流ID") @PathVariable Long id) {
        return orderLogisticsService.removeById(id);
    }
}
