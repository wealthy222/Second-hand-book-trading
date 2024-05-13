package com.gpnu.cn.service.impl;

import com.gpnu.cn.bean.Book;
import com.gpnu.cn.bean.UserCollect;
import com.gpnu.cn.bean.Category;
import com.gpnu.cn.mapper.BookListMapper;
import com.gpnu.cn.service.BookListService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookListImpl implements BookListService {

    @Autowired
    BookListMapper bookListMapper;

    @Override
    public List<Book> getBook() {
        List<Book> book = bookListMapper.getBook();
        return book;
    }

    @Override
    public List<Category> cate() {
        return bookListMapper.cate();
    }

    @Override
    public List<Book> tableNameGetBook(Integer cate_id) {
        List<Book> books = bookListMapper.tableNameGetBook(cate_id);
        return books;
    }

    @Override
    public Book getBookById(Integer id) {
        Book bookById = bookListMapper.getBookById(id);
        return bookById;
    }

    @Override
    public void insertCollect(Integer user_id, Integer book_id,Integer seller_id) {
        bookListMapper.insertCollect(user_id, book_id,seller_id);
    }

    @Override
    public void deleteCollect(Integer book_id) {
        bookListMapper.deleteCollect(book_id);
    }

    @Override
    public UserCollect selectCollect(Integer user_id,Integer book_id) {
        UserCollect userCollect = bookListMapper.selectCollect(user_id,book_id);
        return userCollect;
    }
    @Override
    public void deleteCollect(Integer user_id,Integer book_id){
        bookListMapper.deleteCollect(user_id, book_id);
    }

    @Override
    public List<Book> getBookByvague(String titelName){
        return bookListMapper.getBookByvague(titelName);
    }
    public List<Book> getBookByAuthor(String authorName){
        return bookListMapper.getBookByAuthor(authorName);
    }
    public List<Book> getAll(){
        List<Book> all = bookListMapper.getAll();
        return all;

    }
}
