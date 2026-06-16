package com.hmall.service.controller;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.hmall.api.dto.PageDTO;
import com.hmall.api.entity.User;
import com.hmall.service.service.UserService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

@Tag(name = "用户管理", description = "用户增删改查接口")
@RestController
@RequestMapping("/api/user")
public class UserController {

    @Resource
    private UserService userService;

    @Operation(summary = "根据ID查询用户")
    @GetMapping("/{id}")
    public User getById(@Parameter(description = "用户ID") @PathVariable Long id) {
        return userService.getById(id);
    }

    @Operation(summary = "分页查询用户")
    @GetMapping("/list")
    public PageDTO<User> list(
            @Parameter(description = "页码", example = "1") @RequestParam(defaultValue = "1") Integer pageNum,
            @Parameter(description = "每页大小", example = "10") @RequestParam(defaultValue = "10") Integer pageSize) {
        return PageDTO.of(userService.page(new Page<>(pageNum, pageSize)));
    }

    @Operation(summary = "新增用户")
    @PostMapping
    public User save(@RequestBody User user) {
        userService.save(user);
        return user;
    }

    @Operation(summary = "更新用户")
    @PutMapping
    public User update(@RequestBody User user) {
        userService.updateById(user);
        return user;
    }

    @Operation(summary = "根据ID删除用户")
    @DeleteMapping("/{id}")
    public Boolean deleteById(@Parameter(description = "用户ID") @PathVariable Long id) {
        return userService.removeById(id);
    }
}
