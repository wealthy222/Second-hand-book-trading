package com.gpnu.cn.bean;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.Date;

@Data
@ToString
@NoArgsConstructor
public class Book {
    private Integer id;
    private String image;
    private String title;
    private String author;
    private double price;
    private Date time;
    private Integer userId;
    private Integer cate_id;
    private Integer collect;
    private Integer num; //当前书购物的临时数量
    private String flag;
    private Integer number;//总数量
    private Integer orderId;//订单未收货的id
    private Integer completeId;//订单已收货的id
    private Integer collectId;//收餐商品的id
    private Integer sellerId; //卖家ID
    private String mobile; // order中的电话号码
    private String address; //order中的地址
    private String username;//
    private Integer seller_id;
}
