package com.gpnu.cn.controller;

import cn.dev33.satoken.stp.StpUtil;
import com.gpnu.cn.bean.Attention;
import com.gpnu.cn.bean.Status;
import com.gpnu.cn.bean.User;
import com.gpnu.cn.service.UserMapperService;
import com.gpnu.cn.service.impl.UserServiceImpl;
import org.apache.ibatis.annotations.Delete;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.net.URLDecoder;

@Controller
public class UserController {

    @Value("${login.image}")
    private String userImage;

    @Autowired
    UserMapperService userService;

    @ResponseStatus(code = HttpStatus.INTERNAL_SERVER_ERROR, reason = "111")
    public class ServerException extends Exception {
    }

    @GetMapping("/checkUsername")
    @ResponseBody
    public Status checkUsername(@RequestParam("username") String username){
        System.out.println("pp");
        Status status = new Status();
        int i = userService.checkUsername(username);
        if(i == 0){
            status.setReqstatus(false);
        }else {
            status.setReqstatus(true);
        }
        return status;
    }//检查是否重复用户名
    @PostMapping("/regist")
    @ResponseBody
    public Integer Regist(@RequestParam("mobile") String mobile,
                          @RequestParam("password") String password,
                          @RequestParam("user") String username) {
        User userByPassword = userService.getUserByPassword(mobile);
        if (userByPassword == null) {
            int b = userService.InsertUser(username,password,mobile,userImage,0);
            return b;
        } else {
            return 0;
        }

    }

    @GetMapping(value = "/userLogin")
    @ResponseBody
    public User userLogin(@RequestParam("mobile") String mobile,
                          @RequestParam("password") String password, HttpSession session) {
        User user = userService.userLogin(mobile, password);
        if (user == null) {
            return null;
        } else {
            session.setAttribute("username", user.getUsername());
            StpUtil.login(user.getId());
            user.setSatoken(StpUtil.getTokenInfo().tokenValue);
            return user;
        }
    }

    @GetMapping("/userGetById")
    @ResponseBody
    public User userGetById(@RequestParam("userId") Integer id) {
        StpUtil.checkLogin();
        User userById = userService.getUserById(id);
        return userById;
    }

    @GetMapping("/getUserWebsockrt")
    @ResponseBody
    public User getUserWebsocket(@RequestParam("username") String username) {
        User userWebsocket = userService.getUserWebsocket(username);
        return userWebsocket;
    }

    @PostMapping("/insertAttent")
    @ResponseBody
    public void insertAttent(@RequestParam("user_id") Integer user_id,@RequestParam("seller_id") Integer seller_id){
        StpUtil.checkLogin();
        userService.insertAttent(user_id,seller_id);
    }
    @PutMapping("/updateUserByFans")
    @ResponseBody
    public void updateUserByFans(@RequestParam("number") Integer number,@RequestParam("seller_id") Integer user_id){
        StpUtil.checkLogin();
        userService.updateUserByFans(number,user_id);
    }
    @DeleteMapping("/deleteAttentById")
    @ResponseBody
    public void deleteAttentById(@RequestParam("user_id") Integer user_id,
                                 @RequestParam("seller_id") Integer seller_id){
        StpUtil.checkLogin();
        userService.deleteAttentById(user_id,seller_id);
    }
    @GetMapping("/getAttent")
    @ResponseBody
    public Boolean getAttent(@RequestParam("user_id") Integer user_id,
                             @RequestParam("seller_id") Integer seller_id) throws ServerException {
        StpUtil.checkLogin();
        Attention attent = userService.getAttent(user_id, seller_id);
        if(attent.equals("") || attent == null){
            throw new ServerException();
        }else {
            return true;
        }
    }
    @GetMapping("/getUserByFans")
    @ResponseBody
    public User getUserByFans(@RequestParam("user_id") Integer user_id){
        StpUtil.checkLogin();
        User userByFans = userService.getUserByFans(user_id);
        return userByFans;
    }//获取粉丝数
    @GetMapping("/checkPhoneByUser")
    @ResponseBody
    public Status checkMobile(@RequestParam("mobile") String mobile){
        User user = userService.checkMobile(mobile);
        Status status = new Status();
        if(user == null){
            status.setReqstatus(false);
        }else {
            status.setReqstatus(true);
        }
        return status;
    }//查询是否重复电话号码

}
