package com.mcc.controller;


import com.mcc.pojo.Result;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.util.UUID;

@Slf4j
@RestController
@RequestMapping("/upload")
public class Upload {

    private static final String UPLOAD_DIR = "D:/images/";

    @PostMapping
    public Result upload(String name, String age, MultipartFile file) throws Exception {

        String originalFilename = file.getOriginalFilename();
        String extName = originalFilename.substring(originalFilename.lastIndexOf("."));

        String uniqueFileName = UUID.randomUUID().toString().replace("-", "") + extName;
        // 拼接完整的文件路径
        File targetFile = new File(UPLOAD_DIR + uniqueFileName);

        // 如果目标目录不存在，则创建它
        if (!targetFile.getParentFile().exists()) {
            targetFile.getParentFile().mkdirs();
        }
        // 保存文件
        file.transferTo(targetFile);

        return Result.success();
    }
}
