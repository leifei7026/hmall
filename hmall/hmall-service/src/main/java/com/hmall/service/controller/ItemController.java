package com.hmall.service.controller;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.hmall.api.dto.PageDTO;
import com.hmall.api.entity.Item;
import com.hmall.service.service.ItemService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

@Tag(name = "商品管理", description = "商品增删改查接口")
@RestController
@RequestMapping("/api/item")
public class ItemController {

    @Resource
    private ItemService itemService;

    @Operation(summary = "根据ID查询商品")
    @GetMapping("/{id}")
    public Item getById(@Parameter(description = "商品ID") @PathVariable Long id) {
        return itemService.getById(id);
    }

    @Operation(summary = "分页查询商品")
    @GetMapping("/list")
    public PageDTO<Item> list(
            @Parameter(description = "页码", example = "1") @RequestParam(defaultValue = "1") Integer pageNum,
            @Parameter(description = "每页大小", example = "10") @RequestParam(defaultValue = "10") Integer pageSize) {
        return PageDTO.of(itemService.page(new Page<>(pageNum, pageSize)));
    }

    @Operation(summary = "新增商品")
    @PostMapping
    public Item save(@RequestBody Item item) {
        itemService.save(item);
        return item;
    }

    @Operation(summary = "更新商品")
    @PutMapping
    public Item update(@RequestBody Item item) {
        itemService.updateById(item);
        return item;
    }

    @Operation(summary = "根据ID删除商品")
    @DeleteMapping("/{id}")
    public Boolean deleteById(@Parameter(description = "商品ID") @PathVariable Long id) {
        return itemService.removeById(id);
    }
}
