package com.gpnu.cn.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.gpnu.cn.bean.Attention;
import com.gpnu.cn.bean.User;
import org.apache.ibatis.annotations.*;

@Mapper
public interface UserMapper extends BaseMapper<User> {

    @Select("select * from user where mobile = #{mobile}")
    public User getUserByPassword(String mobile);

    @Insert("insert into user(`username`,`mobile`,`password`,`image`,`fans`) values (#{username},#{mobile},#{password},#{image},#{fans})")
    public int InsertUser(String username,String password,String mobile,String image,Integer fans);

    @Select("select  * from user where username = #{username}")
    public User checkUsername(String username);

    @Select("select * from user where mobile = #{mobile}")
    public User checkMobile(String mobile);

    @Select("select * from user where mobile=#{mobile} and password=#{password}")
    public User userLogin(String mobile, String password);

    @Select("select * from user where id=#{id}")
    public User getUserById(Integer id);

    @Select("select * from user where username=#{username}")
    public User getUserWebsocket(String username);
    ///fans操作
    @Insert("insert into attention(`user_id`,`seller_id`) values(#{userId},#{sellerId})")
    public void insertAttent(Integer userId,Integer sellerId);
    @Update("update user set fans=fans+#{number} where id = #{userId}")
    public void updateUserByFans(Integer number,Integer userId);
    @Delete("delete from attention where user_id=#{userId} and seller_id=#{sellerId}")
    public void deleteAttentById(Integer userId,Integer sellerId);
    @Select("select * from attention where user_id=#{userId} and seller_id=#{sellerId}")
    public Attention getAttent(Integer userId, Integer sellerId);
    @Select("select * from user where id = #{user_id}")
    public User getUserByFans(Integer user_id);
    
}
