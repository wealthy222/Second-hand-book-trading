package com.gpnu.cn.mapper;

import com.gpnu.cn.bean.Book;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface ProfileMapper {

    public List<Book> getUserCollectBook(Integer user_id);
    public List<Book> getUserOrder(Integer book_id);
    public List<Book> getUserCart(Integer user_id);
    public List<Book> getUserOrderComplete(Integer user_id);
    public void deleteUserCollectById(Integer collect_id);
    public void insertBookByUser(Book book);
    public List<Book> getBookByComplete(Integer seller_id);

}
