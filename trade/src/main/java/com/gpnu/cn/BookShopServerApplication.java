package com.gpnu.cn;

import com.fasterxml.jackson.core.JsonProcessingException;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.gpnu.cn.mapper")
public class BookShopServerApplication {

    public static void main(String[] args) throws JsonProcessingException {

        SpringApplication.run(BookShopServerApplication.class, args);
    }

}
