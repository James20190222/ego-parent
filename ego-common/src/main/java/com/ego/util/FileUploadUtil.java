package com.ego.util;


import org.apache.commons.net.ftp.FTP;
import org.apache.commons.net.ftp.FTPClient;
import org.apache.commons.net.ftp.FTPReply;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.io.InputStream;

/**
 * Created by James on 2019/3/26 0026.
 */
public class FileUploadUtil {

    private static Logger logger= LoggerFactory.getLogger(FileUploadUtil.class);

    /**
     *  文件上传
     * @param host          服务器Ip
     * @param port          端口
     * @param username      用户名
     * @param password      密码
     * @param path           路径
     * @param fileName      文件名
     * @param is
     * @return
     */

    public static String fileUpload(String host,Integer port,
                                    String username,String password,
                                    String path,String fileName,
                                  InputStream is){
        //1.创建FTPClient对象
        FTPClient ftpClient = new FTPClient();
        //指定上传文件的字符集
        ftpClient.setControlEncoding("utf-8");
        //InputStream is=null;
        //2.指定服务器地址(端口)
        try {
            ftpClient.connect(host,port);
            //3.登录
            ftpClient.login(username,password);
           //获取登录返回的校验码
            int replyCode = ftpClient.getReplyCode();
            /*System.out.println(replyCode);*/
            //判断校验码是否以2开头,如果不是,断开连接,并返回
            if(!FTPReply.isPositiveCompletion(replyCode)){
                ftpClient.disconnect();
                System.out.println("断开连接!");
                logger.error("文件上传失败,服务器用户名密码错误!");
                return null;
            }
            //4.创建流文件
           // File file=new File("D://beauty.jpg");
             //is = new FileInputStream(file);
            //指定上传文件的地址
            //String path="/home/ftpuser/ego3/2019/03/27";
            boolean result = ftpClient.changeWorkingDirectory(path);
            //如果不存在创建文件路径
            if(!result){
                String basePath="";
                for(String p:path.split("/")){
                    basePath+=p+"/";
                    boolean result2 = ftpClient.changeWorkingDirectory(basePath);
                    if(!result2){
                        ftpClient.makeDirectory(basePath);
                    }
                }
                ftpClient.changeWorkingDirectory(basePath);//重新指定
            }

            //5.指定文件上传的方式(二进制的方式)
            ftpClient.setFileType(FTP.BINARY_FILE_TYPE);
            // 得到文件后缀
            String suffix = fileName.substring(fileName.lastIndexOf("."));
            System.out.println("文件后缀为：" + suffix);
            //上传文件(第一个参数为文件名称,第二个参数为流)
            String remote=UUIDUtil.getUUID()+suffix;
            ftpClient.storeFile(remote,is);
            return remote;
        } catch (IOException e) {
            logger.error("文件上传失败,程序异常");
        }finally {

                try {
                    if(null!=is){
                    is.close();
                    }
                    if(null!=ftpClient && ftpClient.isConnected()){
                        ftpClient.disconnect();
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
        }
        return null;
    }
}
