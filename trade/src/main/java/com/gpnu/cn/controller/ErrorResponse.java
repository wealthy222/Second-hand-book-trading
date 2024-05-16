package com.gpnu.cn.controller;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@ToString
@NoArgsConstructor
public class ErrorResponse {
    private int code;
    private String message;

}
