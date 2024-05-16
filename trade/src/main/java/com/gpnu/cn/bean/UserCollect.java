package com.gpnu.cn.bean;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@ToString
@NoArgsConstructor
public class UserCollect {
    private Integer collectId;
    private Integer userId;
    private Integer bookId;
}
