package com.gpnu.cn.service;

import com.gpnu.cn.bean.Book;
import com.gpnu.cn.bean.UserOrder;

import java.util.List;

public interface ProfileService {
    public List<Book> getUserCollectBook(Integer user_id);
    public List<Book> getUserOrder(Integer user_id);
    public List<Book> getUserCart(Integer user_id);
    public List<Book> getUserOrderComplete(Integer user_id);

    public default void deleteUserCollectById(Integer collect_id) {

    }

    public void insertBookByUser(Book book);
    public List<Book> getBookByComplete(Integer seller_id);
 }
