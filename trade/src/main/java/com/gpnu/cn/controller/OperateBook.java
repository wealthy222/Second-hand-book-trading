package com.gpnu.cn.controller;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import cn.dev33.satoken.stp.StpUtil;
import com.gpnu.cn.bean.UserCollect;
import com.gpnu.cn.service.BookListService;
import com.gpnu.cn.service.impl.BookListImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
public class OperateBook {

    @Autowired
    BookListService bookList;

    @PostMapping("/insertcollect")
    @ResponseBody
    public void insertCollect(@RequestParam("user_id") Integer user_id,
                              @RequestParam("book_id") Integer book_id,
                              @RequestParam("seller_id") Integer seller_id) {
        StpUtil.checkLogin();
        bookList.insertCollect(user_id, book_id,seller_id);

    }

    @DeleteMapping("/deletecollect")
    @ResponseBody
    public void deleteCollect(@RequestParam("book_id") Integer book_id) {
        StpUtil.checkLogin();
        bookList.deleteCollect(book_id);
    }

    @ResponseStatus(code = HttpStatus.INTERNAL_SERVER_ERROR, reason = "111")
    public class ServerException extends Exception {
    }

    @GetMapping("/selectcollect")
    @ResponseBody
    public Object selectCollect(@RequestParam("user_id") Integer user_id,
                                @RequestParam("book_id") Integer book_id) throws ServerException {
        StpUtil.checkLogin();
        UserCollect userCollect = bookList.selectCollect(user_id, book_id);
        if (userCollect == null) {
            throw new ServerException();
        }else {
            return userCollect;
        }
    }//获取是否被收藏

    @DeleteMapping("/deleteUserCollect")
    @ResponseBody
    public void deleteCollect(@RequestParam("user_id") Integer user_id,
                              @RequestParam("book_id") Integer book_id){
        StpUtil.checkLogin();
        bookList.deleteCollect(user_id, book_id);

    }

}
