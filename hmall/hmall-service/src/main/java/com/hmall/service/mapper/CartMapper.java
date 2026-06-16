package com.hmall.service.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.hmall.api.entity.Cart;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface CartMapper extends BaseMapper<Cart> {
}
