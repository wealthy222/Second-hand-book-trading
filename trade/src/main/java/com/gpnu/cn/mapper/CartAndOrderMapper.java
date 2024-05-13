package com.gpnu.cn.mapper;

import com.gpnu.cn.bean.UserOrder;
import org.apache.ibatis.annotations.*;
import org.springframework.web.bind.annotation.RequestBody;

@Mapper
public interface CartAndOrderMapper {

    @Update("update book_all set collect = collect+#{number} where id = #{book_id}")
    public void updateCollect(Integer book_id,Integer number);
    @Update("update book_all set number = number-#{number} where id = #{book_id}")
    public void updateBooknumber(Integer book_id,Integer number);
    @Update("update book_all set number = number-#{num} where id = #{book_id}")
    public void updateBooknumberList(UserOrder userOrder);
    @Insert("insert into user_cart(`user_id`,`book_id`,`seller_id`) values(#{user_id},#{book_id},#{seller_id})")
    public void insertUserCart(Integer user_id,Integer book_id,Integer seller_id);

    @Delete("delete from user_cart where book_id=#{book_id}")
    public void deleteUserCart(Integer book_id);

    @Insert("insert into user_order(`book_id`,`num`,`price`,`user_id`,`seller_id`,`username`,`mobile`,`address`) values(#{book_id},#{num},#{price},#{user_id},#{seller_id},#{username},#{mobile},#{address})")
    public void insertUserOrder(Integer book_id,Integer num,Double price,Integer user_id,Integer seller_id,String username,String mobile,String address);

    @Insert("insert into user_order(`book_id`,`num`,`price`,`user_id`,`seller_id`,`username`,`mobile`,`address`) values(#{book_id},#{num},#{price},#{user_id},#{seller_id},#{username},#{mobile},#{address})")
    public void insertUserOrderList(UserOrder userOrder);

    @Insert("insert into user_order_complete(`book_id`,`num`,`price`,`user_id`,`seller_id`) values(#{book_id},#{num},#{price},#{user_id},#{seller_id})")
    public void inserUserOrderComplete(Integer book_id,Integer num,Double price,Integer user_id,Integer seller_id);


}
