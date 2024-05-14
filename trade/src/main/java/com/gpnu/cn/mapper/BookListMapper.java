package com.gpnu.cn.mapper;

import com.gpnu.cn.bean.Book;
import com.gpnu.cn.bean.UserCollect;
import com.gpnu.cn.bean.Category;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface BookListMapper {

    @Select("select * from book_all ORDER BY RAND() LIMIT 24")
    public List<Book> getBook();

    @Select("select * from category")
    public List<Category> cate();

    @Select("select * from book_all where id<830 and cate_id=#{cate_id} limit 20")
    List<Book> tableNameGetBook(Integer cate_id);

    @Select("select * from book_all where id=#{id}")
    public Book getBookById(Integer id);
    //////////////////book的操作

    @Insert("insert into user_collect(`user_id`,`book_id`,`seller_id`) values(#{user_id},#{book_id},#{seller_id})")
    public void insertCollect(Integer user_id,Integer book_id,Integer seller_id);

    @Delete("delete from user_collect where book_id = #{book_id}")
    public void deleteCollect(Integer book_id);

    @Select("select * from user_collect where user_id=#{user_id} and book_id = #{book_id}")
    public UserCollect selectCollect(Integer user_id,Integer book_id);

    @Delete("delete from user_collect where user_id=#{user_id} and book_id = #{book_id}")
    public void deleteCollect(Integer user_id,Integer book_id);

    @Select("select * from book_all where title like CONCAT('%',#{titelName},'%') and number!=0 ")
    public List<Book> getBookByvague(String titelName);
    @Select("select * from book_all where author like CONCAT('%',#{authorName},'%') and number!=0")
    public List<Book> getBookByAuthor(String authorName);
    @Select("select * from book_all")
    public List<Book> getAll();

}
