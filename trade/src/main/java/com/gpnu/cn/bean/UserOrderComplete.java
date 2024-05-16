package com.gpnu.cn.bean;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@ToString
@NoArgsConstructor
public class UserOrderComplete {

    private Integer complete_id;
    private Integer user_id;
    private Integer book_id;
    private Double price;
    private Integer num;
    private Integer seller_id;

}
