package com.ego.result;

import java.io.Serializable;

/*
* 公共的文件上传返回对象
* */

public class FileResult implements Serializable {
 
 // success 字符串 bootstrap file input 必须包含该属性
 private String success;
 // error 字符串 bootstrap file input 必须包含该属性
 private String error;
 // 描述信息
 private String message;
 // 文件路径
 private String fileUrl;
 public String getSuccess() {
 return success;
 }
 public void setSuccess(String success) {
 this.success = success;
 }
 public String getError() {
 return error;
 }
 public void setError(String error) {
 this.error = error;
 }
 public String getMessage() {
 return message;
 }
 public void setMessage(String message) {
 this.message = message;
 }
 public String getFileUrl() {
 return fileUrl;
 }
 public void setFileUrl(String fileUrl) {
 this.fileUrl = fileUrl;
 }
}