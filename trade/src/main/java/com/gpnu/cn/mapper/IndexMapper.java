package com.gpnu.cn.mapper;

import com.gpnu.cn.bean.Book;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface IndexMapper {
    @Select("select * from book_all where user_id = #{userId} limit 40")
    public List<Book> getBookByUserIndex(Integer user_id);

    @Delete("delete from book_all where id = #{id}")
    public void deleteBookByUserIndex(Integer id);


}
