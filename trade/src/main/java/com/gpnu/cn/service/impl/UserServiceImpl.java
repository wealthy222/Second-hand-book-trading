package com.gpnu.cn.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.gpnu.cn.bean.Attention;
import com.gpnu.cn.bean.User;
import com.gpnu.cn.mapper.UserMapper;
import com.gpnu.cn.service.UserMapperService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserMapperService {

    @Autowired
    UserMapper userMapper;

    public User getUserByPassword(String mobile) {
        return userMapper.getUserByPassword(mobile);
    }


    @Override
    public int InsertUser(String username,String password,String mobile,String image,Integer fans){
        userMapper.InsertUser(username,password,mobile,image,fans);
        return 1;
    }

    public int checkUsername(String username) {
        User user = userMapper.checkUsername(username);
        if (user == null) {
            return 0;
        } else {
            return 1;
        }
    }

    public User userLogin(String mobile, String password) {
        User user = userMapper.userLogin(mobile, password);
        return user;
    }

    @Override
    public User getUserById(Integer id) {
        User userById = userMapper.getUserById(id);
        return userById;
    }

    @Override
    public User getUserWebsocket(String username) {
        return userMapper.getUserWebsocket(username);
    }

    @Override
    public void insertAttent(Integer user_id,Integer seller_id){
        userMapper.insertAttent(user_id,seller_id);
    }
    public void updateUserByFans(Integer number,Integer user_id){
        userMapper.updateUserByFans(number,user_id);
    }
    public void deleteAttentById(Integer user_id,Integer seller_id){
        userMapper.deleteAttentById(user_id,seller_id);
    }
    public Attention getAttent(Integer user_id, Integer seller_id){
        Attention attent = userMapper.getAttent(user_id, seller_id);
        return attent;
    }
    public User getUserByFans(Integer user_id){
        return userMapper.getUserByFans(user_id);
    }
    public User checkMobile(String mobile){
        User user = userMapper.checkMobile(mobile);
        return user;
    }
}
