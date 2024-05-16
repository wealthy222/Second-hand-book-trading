package com.gpnu.cn.bean;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@ToString
@NoArgsConstructor
public class UserOrder {
    private Integer order_id;
    private Integer user_id;
    private Integer book_id;
    private Double price;
    private Integer num;
    private Integer seller_id;
    private String username;
    private String mobile;
    private String address;
}
