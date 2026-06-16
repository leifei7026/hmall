package com.hmall.api.entity;

import com.baomidou.mybatisplus.annotation.*;
import lombok.Data;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
@Accessors(chain = true)
@TableName("\"order\"")
public class Order implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId
    private Long id;

    private Integer totalFee;

    private Integer paymentType;

    private Long userId;

    private Integer status;

    @TableField(fill = FieldFill.INSERT)
    private LocalDateTime createTime;

    private LocalDateTime payTime;

    private LocalDateTime consignTime;

    private LocalDateTime endTime;

    private LocalDateTime closeTime;

    private LocalDateTime commentTime;

    @TableField(fill = FieldFill.INSERT_UPDATE)
    private LocalDateTime updateTime;
}
