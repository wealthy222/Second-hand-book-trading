package com.gpnu.cn.service;

import com.gpnu.cn.bean.Book;
import com.gpnu.cn.bean.UserCollect;
import com.gpnu.cn.bean.Category;

import java.util.List;

public interface BookListService {
    public List<Book> getBook();

    public List<Category> cate();

    List<Book> tableNameGetBook(Integer cate_id);

    public Book getBookById(Integer id);

    public void insertCollect(Integer user_id,Integer book_id,Integer seller_id);
    public void deleteCollect(Integer book_id);
    public UserCollect selectCollect(Integer user_id, Integer book_id);
    public void deleteCollect(Integer user_id,Integer book_id);
    public List<Book> getBookByvague(String titelName);
    public List<Book> getBookByAuthor(String authorName);
    public List<Book> getAll();
}
