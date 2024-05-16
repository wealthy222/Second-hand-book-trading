package com.gpnu.cn.bean;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@ToString
@NoArgsConstructor
public class UserCart {
    private Integer user_id;
    private Integer book_id;
    private Integer seller_id;
}
