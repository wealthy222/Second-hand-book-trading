package com.gpnu.cn.controller;

import com.gpnu.cn.utils.jerryString;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;

@Controller
public class UploadImage {


    @PostMapping("/uploadimage")
    @ResponseBody
    public String upLoad(@RequestPart("file") MultipartFile siglefile) throws IOException {
        System.out.println("收到请求了");
        String fileName = siglefile.getOriginalFilename();
        // 使用工具类根据上传文件生成唯一图片名称
        String imgName = jerryString.getRandomImgName(fileName);
        siglefile.transferTo(new File("/data/images/" + imgName));
        return imgName;
    }
}
