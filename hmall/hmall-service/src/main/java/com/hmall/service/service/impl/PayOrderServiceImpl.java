package com.hmall.service.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.hmall.api.entity.PayOrder;
import com.hmall.service.mapper.PayOrderMapper;
import com.hmall.service.service.PayOrderService;
import org.springframework.stereotype.Service;

@Service
public class PayOrderServiceImpl extends ServiceImpl<PayOrderMapper, PayOrder> implements PayOrderService {
}
