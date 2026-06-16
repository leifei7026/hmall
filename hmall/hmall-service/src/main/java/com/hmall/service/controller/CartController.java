package com.hmall.service.controller;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.hmall.api.dto.PageDTO;
import com.hmall.api.entity.Cart;
import com.hmall.service.service.CartService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

@Tag(name = "购物车管理", description = "购物车增删改查接口")
@RestController
@RequestMapping("/api/cart")
public class CartController {

    @Resource
    private CartService cartService;

    @Operation(summary = "根据ID查询购物车")
    @GetMapping("/{id}")
    public Cart getById(@Parameter(description = "购物车ID") @PathVariable Long id) {
        return cartService.getById(id);
    }

    @Operation(summary = "分页查询购物车")
    @GetMapping("/list")
    public PageDTO<Cart> list(
            @Parameter(description = "页码", example = "1") @RequestParam(defaultValue = "1") Integer pageNum,
            @Parameter(description = "每页大小", example = "10") @RequestParam(defaultValue = "10") Integer pageSize) {
        return PageDTO.of(cartService.page(new Page<>(pageNum, pageSize)));
    }

    @Operation(summary = "新增购物车")
    @PostMapping
    public Cart save(@RequestBody Cart cart) {
        cartService.save(cart);
        return cart;
    }

    @Operation(summary = "更新购物车")
    @PutMapping
    public Cart update(@RequestBody Cart cart) {
        cartService.updateById(cart);
        return cart;
    }

    @Operation(summary = "根据ID删除购物车")
    @DeleteMapping("/{id}")
    public Boolean deleteById(@Parameter(description = "购物车ID") @PathVariable Long id) {
        return cartService.removeById(id);
    }
}
