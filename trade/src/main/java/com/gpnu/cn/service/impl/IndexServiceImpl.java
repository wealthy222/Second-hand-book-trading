package com.gpnu.cn.service.impl;

import com.gpnu.cn.bean.Book;

import com.gpnu.cn.mapper.IndexMapper;
import com.gpnu.cn.service.IndexService;
import org.apache.logging.log4j.message.Message;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class IndexServiceImpl implements IndexService {

    @Autowired
    IndexMapper indexMapper;
    @Override
    public List<Book> getBookByUserIndex(Integer user_id) {
        List<Book> bookByUserIndex = indexMapper.getBookByUserIndex(user_id);
        return bookByUserIndex;
    }
    @Override
    public void deleteBookByUserIndex(Integer id){
        indexMapper.deleteBookByUserIndex(id);
    }


}
