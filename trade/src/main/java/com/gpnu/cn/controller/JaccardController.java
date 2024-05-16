package com.gpnu.cn.controller;

import com.gpnu.cn.bean.Book;

import com.gpnu.cn.service.BookListService;
import com.gpnu.cn.service.impl.BookListImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import com.gpnu.cn.utils.StrJaccard;
@RestController
public class JaccardController {
    @Autowired
    BookListService bookList;

    @GetMapping("/getRecomend")
    public List<Book> getRecomend(@RequestParam("bookName") String bookName,
                                  @RequestParam("bookCart") String bookCart,
                                  @RequestParam("bookOrder") String bookOrder){
        List<Book> all = bookList.getAll();
        StrJaccard strJaccard = new StrJaccard();
        List<Book> bookListRc = new ArrayList<>();
        //for (Book list:all){
           // double jaccard = strJaccard.jaccard(bookName, list.getTitle());
            /*double jaccard1 = strJaccard.jaccard(bookCart, list.getTitle());
            double jaccard2 = strJaccard.jaccard(bookOrder, list.getTitle());
            if(jaccard > 0.1){
                bookListRc.add(list);
            }
            if(jaccard1 > 0.1){
                bookListRc.add(list);
            }
            if(jaccard2 > 0.1){
                bookListRc.add(list);
            }
        }*/
            for (Book list : all) {
                double[] jaccardValues = new double[] {
                        strJaccard.jaccard(bookName, list.getTitle()),
                        strJaccard.jaccard(bookCart, list.getTitle()),
                        strJaccard.jaccard(bookOrder, list.getTitle())
                };

                double maxJaccard = Arrays.stream(jaccardValues)
                        .max()
                        .orElse(Double.NEGATIVE_INFINITY);
                if (maxJaccard > 0.1) {
                    bookListRc.add(list);
                }
            }
        return bookListRc;
    }
}//页面刷新
