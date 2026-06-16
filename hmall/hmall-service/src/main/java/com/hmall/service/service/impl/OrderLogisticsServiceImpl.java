package com.hmall.service.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.hmall.api.entity.OrderLogistics;
import com.hmall.service.mapper.OrderLogisticsMapper;
import com.hmall.service.service.OrderLogisticsService;
import org.springframework.stereotype.Service;

@Service
public class OrderLogisticsServiceImpl extends ServiceImpl<OrderLogisticsMapper, OrderLogistics> implements OrderLogisticsService {
}
