package com.gpnu.cn.service;

import com.gpnu.cn.bean.Book;
import org.apache.logging.log4j.message.Message;

import java.util.List;

public interface IndexService {
    public List<Book> getBookByUserIndex(Integer user_id);
    public void deleteBookByUserIndex(Integer id);

}
