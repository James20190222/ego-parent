package com.ego.controller;

import com.ego.result.FileResult;
import com.ego.service.FileUploadServiceI;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

/** 文件上传controller
 * Created by James on 2019/3/27 0027.
 */
@Controller
@RequestMapping("/fileUpload")
public class FileUploadController {

    @Autowired
    private FileUploadServiceI fileUploadService;

    @RequestMapping("/save")
    @ResponseBody
    public FileResult fileUpload(MultipartFile file){
        try {
            return fileUploadService.fileUpload(file.getOriginalFilename(),file.getInputStream());
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

}
