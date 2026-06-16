package com.hmall.service.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.hmall.api.entity.Item;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface ItemMapper extends BaseMapper<Item> {
}
