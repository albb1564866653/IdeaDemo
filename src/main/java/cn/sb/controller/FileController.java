package cn.sb.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.util.UUID;

@Controller
public class FileController {

    @Value("${file.path}") //yml文件中file.path的值
    private String filePath;

    @RequestMapping("/upload")
    @ResponseBody
    public String upload(MultipartFile file) throws Exception {//file要跟前端的name=""值一致
        //xxx.png
        //获取后缀名   .png
        String extName=file.getOriginalFilename().substring(file.getOriginalFilename().lastIndexOf("."));
        String fileName= UUID.randomUUID().toString()+extName;//文件名
        FileCopyUtils.copy(file.getInputStream(),new FileOutputStream(new File(filePath+fileName)));

        return "上传成功，文件名："+fileName;
    }
}
