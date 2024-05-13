package com.gpnu.cn.controller;

import cn.dev33.satoken.stp.StpUtil;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.gpnu.cn.bean.Book;

import com.gpnu.cn.bean.UserOrder;
import com.gpnu.cn.service.IndexService;
import com.gpnu.cn.service.impl.IndexServiceImpl;
import org.apache.logging.log4j.message.Message;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class IndexController {

    @Autowired
    IndexService indexService;

    @GetMapping("/getBookByUserIndex")
    public List<Book> getBookByUserIndex(@RequestParam("user_id") Integer user_id) {
        StpUtil.checkLogin();
        List<Book> bookByUserIndex = indexService.getBookByUserIndex(user_id);
        return bookByUserIndex;
    }//通过user_id获取书，我的发布

    @DeleteMapping("/deleteBookByUserIndex")
    public void deleteBookByUserIndex(@RequestParam("id") Integer id) {
        StpUtil.checkLogin();
        indexService.deleteBookByUserIndex(id);
    }//下架书

}
