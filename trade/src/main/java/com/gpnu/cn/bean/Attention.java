package com.gpnu.cn.bean;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@NoArgsConstructor
@ToString
public class Attention {
    private Integer attentId;
    private Integer userId;
    private Integer sellerId;
}
