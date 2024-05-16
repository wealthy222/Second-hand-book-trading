package com.gpnu.cn.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.gpnu.cn.bean.Attention;
import com.gpnu.cn.bean.Book;
import com.gpnu.cn.bean.User;
import com.gpnu.cn.mapper.UserMapper;

public interface UserMapperService extends IService<User> {
    public int InsertUser(String username,String password,String mobile,String image,Integer fans);

    public int checkUsername(String username);

    public User userLogin(String mobile, String password);

    public User getUserById(Integer id);

    public User checkMobile(String mobile);

    public User getUserWebsocket(String username);

    public void insertAttent(Integer user_id,Integer seller_id);
    public void updateUserByFans(Integer number,Integer user_id);
    public void deleteAttentById(Integer user_id,Integer seller_id);
    public Attention getAttent(Integer user_id, Integer seller_id);
    public User getUserByFans(Integer user_id);

}
