package com.ego.service;

import com.ego.result.BaseResult;
import com.ego.result.FileResult;

import java.io.InputStream;

/**
 * Created by James on 2019/3/27 0027.
 */
public interface FileUploadServiceI {

    //文件删除
    BaseResult fileDelete(String fileName);

    /**
     * 文件上传
     * @param fileName  文件名
     * @param is         流
     * @return
     */
    FileResult fileUpload(String fileName, InputStream is);
}
