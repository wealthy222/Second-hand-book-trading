package com.gpnu.cn.service.impl;

import com.gpnu.cn.bean.UserOrder;
import com.gpnu.cn.mapper.CartAndOrderMapper;
import com.gpnu.cn.service.CartAndOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CartAndOrderImpl implements CartAndOrderService {

    @Autowired
    CartAndOrderMapper cartAndOrderMapper;
    @Override
    public void updateCollect(Integer book_id, Integer number) {
        cartAndOrderMapper.updateCollect(book_id,number);
    }
    public void updateBooknumber(Integer book_id, Integer number) {
        cartAndOrderMapper.updateBooknumber(book_id,number);
    }
    public void updateBooknumberList(UserOrder userOrder) {
        cartAndOrderMapper.updateBooknumberList(userOrder);
    }
    @Override
    public void insertUserOrder(Integer book_id,Integer num,Double price,Integer user_id,Integer seller_id,String username,String mobile,String address){
        cartAndOrderMapper.insertUserOrder(book_id,num,price,user_id,seller_id,username,mobile,address);
    }
    @Override
    public void insertUserCart(Integer user_id,Integer book_id,Integer seller_id){
        cartAndOrderMapper.insertUserCart(user_id, book_id,seller_id);
    }
    @Override
    public void deleteUserCart(Integer book_id){
        cartAndOrderMapper.deleteUserCart(book_id);
    }
    @Override
    public void insertUserOrderList(UserOrder userOrder){
        cartAndOrderMapper.insertUserOrderList(userOrder);
    }
    @Override
    public void deleteUserOrder(Integer order_id){
        cartAndOrderMapper.deleteUserOrder(order_id);
    }
    @Override
    public void inserUserOrderComplete(Integer book_id,Integer num,Double price,Integer user_id,Integer seller_id){
        cartAndOrderMapper.inserUserOrderComplete(book_id,num,price,user_id,seller_id);
    }


}
