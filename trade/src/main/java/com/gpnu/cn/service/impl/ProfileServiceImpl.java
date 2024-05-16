package com.gpnu.cn.service.impl;

import com.gpnu.cn.bean.Book;

import com.gpnu.cn.mapper.ProfileMapper;
import com.gpnu.cn.service.ProfileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class ProfileServiceImpl implements ProfileService {

    @Autowired
    ProfileMapper profileMapper;

    @Override
    public List<Book> getUserCollectBook(Integer user_id){
        List<Book> userCollectBook = profileMapper.getUserCollectBook(user_id);
        return userCollectBook;
    }
    @Override
    public List<Book> getUserOrder(Integer user_id){
        List<Book> userOrder = profileMapper.getUserOrder(user_id);
        return userOrder;
    }
    @Override
    public List<Book> getUserCart(Integer user_id){
        List<Book> userCart = profileMapper.getUserCart(user_id);
        return userCart;
    }
    @Override
    public List<Book> getUserOrderComplete(Integer user_id){
        List<Book> userOrderComplete = profileMapper.getUserOrderComplete(user_id);
        return userOrderComplete;
    }
    @Override
    public void deleteUserCollectById(Integer collect_id){
        profileMapper.deleteUserCollectById(collect_id);
    }
    @Override
    public void insertBookByUser(Book book){
        profileMapper.insertBookByUser(book);
    }
    public List<Book> getBookByComplete(Integer seller_id){
        return profileMapper.getBookByComplete(seller_id);
    }

}
