package com.hmall.api.entity;

import com.baomidou.mybatisplus.annotation.*;
import lombok.Data;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.time.LocalDateTime;

@Data
@Accessors(chain = true)
@TableName("order_logistics")
public class OrderLogistics implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId
    private Long orderId;

    private String logisticsNumber;

    private String logisticsCompany;

    private String contact;

    private String mobile;

    private String province;

    private String city;

    private String town;

    private String street;

    @TableField(fill = FieldFill.INSERT)
    private LocalDateTime createTime;

    @TableField(fill = FieldFill.INSERT_UPDATE)
    private LocalDateTime updateTime;
}
