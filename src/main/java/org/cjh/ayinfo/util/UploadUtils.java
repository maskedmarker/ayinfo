package org.cjh.ayinfo.util;

public class UploadUtils {

    public static String getFileExtensionName(String fileName) {
        if (fileName == null) {
            return "";
        }
        int index = fileName.lastIndexOf(".");
        if (index == -1) {
            return "";
        }
        
        return fileName.substring(index + 1, fileName.length());
    }
    
    public static boolean checkFileType(String fileName) {
        //设置允许上传文件类型
        String suffixList = "jpg,png,ico,bmp,jpeg";
        // 获取文件后缀
        String suffix = fileName.substring(fileName.lastIndexOf(".") + 1, fileName.length());
        if (suffixList.contains(suffix.trim().toLowerCase())) {
            return true;
        }
        return false;
    }
}
