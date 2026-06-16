package com.hmall.api.entity;

import com.baomidou.mybatisplus.annotation.*;
import lombok.Data;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.time.LocalDateTime;

@Data
@Accessors(chain = true)
@TableName("pay_order")
public class PayOrder implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(type = IdType.AUTO)
    private Long id;

    private Long bizOrderNo;

    private Long payOrderNo;

    private Long bizUserId;

    private String payChannelCode;

    private Integer amount;

    private Integer payType;

    private Integer status;

    private String expandJson;

    private String resultCode;

    private String resultMsg;

    private LocalDateTime paySuccessTime;

    private LocalDateTime payOverTime;

    private String qrCodeUrl;

    private LocalDateTime createTime;

    private LocalDateTime updateTime;

    private Long creater;

    private Long updater;

    @TableLogic
    private Boolean isDelete;
}
