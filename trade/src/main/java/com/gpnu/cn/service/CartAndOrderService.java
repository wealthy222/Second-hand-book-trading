package com.gpnu.cn.service;

import com.gpnu.cn.bean.UserOrder;

public interface CartAndOrderService {

    public void updateCollect(Integer book_id,Integer number);
    public void updateBooknumber(Integer book_id,Integer number);
    public void updateBooknumberList(UserOrder userOrder);
    public void insertUserOrder(Integer book_id,Integer num,Double price,Integer user_id,Integer seller_id,String username,String mobile,String address);
    public void insertUserCart(Integer user_id,Integer book_id,Integer seller_id);
    public void deleteUserCart(Integer book_id);
    public void insertUserOrderList(UserOrder userOrder);
    public void inserUserOrderComplete(Integer book_id,Integer num,Double price,Integer user_id,Integer seller_id);
}
