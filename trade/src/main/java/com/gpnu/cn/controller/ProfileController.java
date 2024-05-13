package com.gpnu.cn.controller;

import cn.dev33.satoken.stp.StpUtil;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.gpnu.cn.bean.Book;

import com.gpnu.cn.service.ProfileService;
import com.gpnu.cn.service.impl.ProfileServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class ProfileController {

    @Autowired
    ProfileService profileService;

    @GetMapping("/getusercollectBook")
    @ResponseBody
    public List<Book> getUserCollectBook(@RequestParam("user_id") Integer id){
        StpUtil.checkLogin();
        List<Book> userCollectBook = profileService.getUserCollectBook(id);
        return userCollectBook;
    }//我的收藏
    @GetMapping("/getUserCart")
    @ResponseBody
    public List<Book> getUserCart(@RequestParam("user_id") Integer user_id){
        StpUtil.checkLogin();
        List<Book> userCart = profileService.getUserCart(user_id);
        return userCart;
    }//购物车
    @GetMapping("/getUserOrder")
    @ResponseBody
    public List<Book> getUserOrder(@RequestParam("user_id") Integer user_id){
        StpUtil.checkLogin();
        List<Book> userOrder = profileService.getUserOrder(user_id);
        return userOrder;
    }//待收货
    @GetMapping("/getUserOrderComplete")
    @ResponseBody
    public List<Book> getOrderComplete(@RequestParam("user_id") Integer user_id){
        StpUtil.checkLogin();
        List<Book> userOrderComplete = profileService.getUserOrderComplete(user_id);
        return userOrderComplete;
    }//已收货
    @DeleteMapping("/deleteUserCollectById")
    @ResponseBody
    public void deleteCollectById(@RequestParam("collect_id") Integer collect_id){
        StpUtil.checkLogin();
        profileService.deleteUserCollectById(collect_id);
    }//通过cllect_id删除收藏
    @PostMapping("/insertBookByUser")
    @ResponseBody
    public void insertBookByUser(@RequestParam("image") String image,
                                 @RequestParam("title") String title,
                                 @RequestParam("author") String author,
                                 @RequestParam("price") Double price,
                                 @RequestParam("cate_id") Integer cate_id,
                                 @RequestParam("user_id") Integer user_id,
                                 @RequestParam("number") Integer number,
                                 @RequestParam("flag") String flag){
        StpUtil.checkLogin();
        Book book = new Book();
        book.setAuthor(author);
        book.setCollect(0);
        book.setCate_id(cate_id);
        book.setNum(1);
        book.setPrice(price);
        book.setImage(image);
        book.setFlag(flag);
        book.setTitle(title);
        book.setNumber(number);
        book.setUserId(user_id);
        profileService.insertBookByUser(book);
    }//发布书

    @GetMapping("/getBookByComplete")
    @ResponseBody
    public List<Book> getBookByComplete(@RequestParam("seller_id") Integer seller_id){
        StpUtil.checkLogin();
        List<Book> bookByComplete = profileService.getBookByComplete(seller_id);
        return bookByComplete;

    }//已售出
}
