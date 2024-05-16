package com.gpnu.cn.controller;

import cn.dev33.satoken.stp.StpUtil;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.gpnu.cn.bean.UserOrder;
import com.gpnu.cn.service.CartAndOrderService;
import com.gpnu.cn.service.impl.CartAndOrderImpl;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Update;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.ServletException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class CartAndOrderController {
    @Autowired
    CartAndOrderService cartAndOrder;

    @PutMapping("/insertBookCollect")
    @ResponseBody
    public void updateCollect(@RequestParam("book_id") Integer book_id,
                              @RequestParam("number") Integer number) throws ServletException {
        StpUtil.checkLogin();
        cartAndOrder.updateCollect(book_id, number);
    }//更新书的收藏数
    @PutMapping("/updateBooknumber")
    @ResponseBody
    public void updateBooknumber(@RequestParam("book_id") Integer book_id,
                              @RequestParam("number") Integer number) throws ServletException {
        StpUtil.checkLogin();
        cartAndOrder.updateBooknumber(book_id, number);
    }//更新数目
    @PostMapping("/insertUserOrder")
    @ResponseBody
    public void insertUserOrder(@RequestParam("user_id") Integer user_id,
                                @RequestParam("book_id") Integer book_id,
                                @RequestParam("num") Integer num,
                                @RequestParam("price") Double price,
                                @RequestParam("seller_id") Integer seller_id,
                                @RequestParam("username") String username,
                                @RequestParam("mobile") String mobile,
                                @RequestParam("address") String address) {
        StpUtil.checkLogin();
        cartAndOrder.insertUserOrder(book_id, num, price, user_id,seller_id,username,mobile,address);
    }//发起订单

    @PostMapping("/insertUserOrderComplete")
    @ResponseBody
    public void inserUserOrderComplete(@RequestParam("book_id") Integer book_id,
                                       @RequestParam("num") Integer num,
                                       @RequestParam("price") Double price,
                                       @RequestParam("user_id") Integer user_id,
                                       @RequestParam("seller_id") Integer seller_id){
        StpUtil.checkLogin();
        cartAndOrder.inserUserOrderComplete(book_id,num,price,user_id,seller_id);
    }//增加完成的订单

    @DeleteMapping("/deleteUserOrder")
    @ResponseBody
    public void deleteUserOrder(@RequestParam("id") Integer order_id){
        StpUtil.checkLogin();
        cartAndOrder.deleteUserOrder(order_id);
    }


    @PostMapping("/insertUserCart")
    @ResponseBody
    public void insertUserCart(@RequestParam("user_id") Integer user_id,
                               @RequestParam("book_id") Integer book_id,
                               @RequestParam("seller_id") Integer seller_id) {
        StpUtil.checkLogin();
        cartAndOrder.insertUserCart(user_id, book_id,seller_id);
    }//增加购物车

    @DeleteMapping("/deleteUserCart")
    @ResponseBody
    public void deleteUserCart(@RequestParam("book_id") Integer book_id) {
        StpUtil.checkLogin();
        cartAndOrder.deleteUserCart(book_id);
    }//删除购物车
    @PutMapping("/updateBooknumberList")
    @ResponseBody
    public void updateBooknumberList(UserOrder userOrder) throws ServletException {
        StpUtil.checkLogin();
        cartAndOrder.insertUserOrderList(userOrder);

    }//更新数目
    @PostMapping("/insertUserOrderList")
    @ResponseBody
    public void insertUserOrderList(@RequestBody String content) {
        StpUtil.checkLogin();
        JSONObject jsonObject = JSONObject.parseObject(content);
        JSONArray userList = jsonObject.getJSONArray("list");
        Integer user_id = jsonObject.getInteger("user_id");
        for (Object oj : userList) {
            UserOrder userOrder = new UserOrder();
            JSONObject jobj = (JSONObject) oj;
            userOrder.setNum(jobj.getInteger("num"));
            userOrder.setBook_id(jobj.getInteger("id"));
            userOrder.setPrice(jobj.getDouble("price"));
            userOrder.setSeller_id(jobj.getInteger("sellerId"));
            userOrder.setUser_id(user_id);
            userOrder.setUsername(jobj.getString("username"));
            userOrder.setMobile(jobj.getString("mobile"));
            userOrder.setAddress(jobj.getString("address"));
            cartAndOrder.updateBooknumberList(userOrder);
            cartAndOrder.insertUserOrderList(userOrder);
        }
    }//清空购物车
}
