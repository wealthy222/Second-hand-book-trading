package com.gpnu.cn.bean;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@ToString
@NoArgsConstructor
public class User {
    private Integer id;
    private String username;
    private String mobile;
    private String password;
    private String image;
    private Integer fans;
    private String satoken;

}
