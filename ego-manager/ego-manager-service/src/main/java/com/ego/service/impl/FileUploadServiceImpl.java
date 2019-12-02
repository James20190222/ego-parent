package com.ego.service.impl;

import com.ego.result.BaseResult;
import com.ego.result.FileResult;
import com.ego.service.FileUploadServiceI;
import com.ego.util.DateUtil;
import com.ego.util.FTPUtil;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.io.InputStream;
import java.time.LocalDateTime;

/**
 *  文件上传service
 * Created by James on 2019/3/27 0027.
 */
@Service
public class FileUploadServiceImpl implements FileUploadServiceI{

    @Value("${ftp.host}")
    private String host;
    @Value("${ftp.port}")
    private Integer port;
    @Value("${ftp.username}")
    private String username;
    @Value("${ftp.password}")
    private String password;
    @Value("${ftp.path}")
    private String path;


    @Override
    public BaseResult fileDelete(String fileName) {
        boolean b = FTPUtil.fileDelete(host, port, username, password, path, fileName);
        return b ? BaseResult.success():BaseResult.error();
    }

    /**
     *  文件上传
     * @param fileName  文件名
     * @param is         流
     * @return
     */

    @Override
    public FileResult fileUpload(String fileName, InputStream is) {
        //构建日期时间路径  /home/ftpuser/ego/2019/03/27
        String dateStr=DateUtil.getDateStr(LocalDateTime.now(),DateUtil.pattern_date);
        String basePath=path+dateStr;
        //文件上传成功,返回服务器文件名称
        System.out.println("TEST-Before");
        String result = FTPUtil.fileUpload(host, port, username, password, basePath, fileName, is);
        System.out.println("TEST++++"+result);
        //创建返回对象
        FileResult fr=new FileResult();
        if(null==result){
            System.out.println("Failure+++");
            fr.setError("error");
            fr.setMessage("文件上传失败!");
            return fr;
        }
        //最终存储至数据库的文件地址为192.168.137.202/host/ftpuser/ego/2019/03/27/result

        fr.setSuccess("success");
        fr.setFileUrl("http://"+host+"/"+dateStr+"/"+result);
        return fr;
    }
}
