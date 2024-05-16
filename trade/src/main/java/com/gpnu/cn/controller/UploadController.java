package com.gpnu.cn.controller;

import cn.dev33.satoken.stp.StpUtil;
import com.gpnu.cn.service.UploadImageService;
import com.gpnu.cn.utils.StringUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import java.io.FileInputStream;
import java.io.IOException;

/**
 * @program: SpringBoot Qiniu
 * @description:
 * @author: CodeDuck
 * @create: 2020-07-30 16:12
 **/
@Slf4j
@RestController
@RequestMapping("/qiniu")
public class UploadController {

    @Resource
    UploadImageService uploadImageService;

    @PostMapping(value = "/image")
    @CrossOrigin
    private String upLoadImage(@RequestParam("file") MultipartFile file) throws IOException {
        // 获取文件的名称
        String fileName = file.getOriginalFilename();
        // 使用工具类根据上传文件生成唯一图片名称
        String imgName = StringUtil.getRandomImgName(fileName);

        if (!file.isEmpty()) {

            FileInputStream inputStream = (FileInputStream) file.getInputStream();

            String path = uploadImageService.uploadQNImg(inputStream, imgName);
//            System.out.print("七牛云返回的图片链接:" + path);
            return path;
        }
        return "上传失败";
    }

}
