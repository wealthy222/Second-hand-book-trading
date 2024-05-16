package com.gpnu.cn.controller;

import com.gpnu.cn.bean.Book;
import com.gpnu.cn.bean.Category;
import com.gpnu.cn.service.BookListService;
import com.gpnu.cn.service.impl.BookListImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class GetBook {
    @Autowired
    BookListService bookList;


    @GetMapping("/getCategory")
    @ResponseBody
    public List<Category> category() {
        List<Category> cates = bookList.cate();
        return cates;
    }

    @GetMapping("/getBook")
    @ResponseBody
    public List<Book> getBook() {
        List<Book> book = bookList.getBook();
        return book;
    }

    @GetMapping("/tableName")
    @ResponseBody
    public List<Book> tableNameGetBook(@RequestParam("id") Integer id) {
        List<Book> books = bookList.tableNameGetBook((Integer) id);
        return books;
    }

    @GetMapping("/getBookById")
    @ResponseBody
    public Book getBookById(@RequestParam("id") Integer id) {
        Book bookById = bookList.getBookById(id);
        return bookById;
    }
    @GetMapping("/getBookByVague")
    @ResponseBody
    public List<Book> getBookByvague(@RequestParam("title") String titelName,
                                     @RequestParam("cate") String cate){
        if(cate.equals("书名")){
            return bookList.getBookByvague(titelName);
        }
            return bookList.getBookByAuthor(titelName);
    }//搜索书本
}
