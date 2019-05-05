package com.noi.oj.utils;

import com.noi.oj.config.ServerConfig;
import org.springframework.web.multipart.MultipartFile;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class UploadUtils {


    public static boolean setProductProfile(MultipartFile profile,String name,String path){
        if(!profile.isEmpty()){
            //磁盘保存
            BufferedOutputStream out = null;
            String newProfileName = path + name;
            try {
                File folder = new File(path);
                if(!folder.exists()){
                    folder.mkdirs();
                }
                out = new BufferedOutputStream(new FileOutputStream(newProfileName));
                // 写入新文件
                out.write(profile.getBytes());
                out.flush();
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                try {
                    out.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            return true;
        }else{
            return false;
        }
    }

    public static boolean deleteProductProfile(String name,String path){
        if ("".equals(name) || name==null)
            return false;
        try {
            String newPath = path+name;
            File file = new File(newPath);
            if(file.exists())
                file.delete();
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public static String getUrl(String path,String name){
        if("".equals(path) || path==null)
            return null;
        String[] limit = path.split("\\\\");
        ServerConfig serverConfig = new ServerConfig();
        return serverConfig.getUrl() + "/" + "profile"
                + "/" + name + "/" + limit[limit.length-1];
    }

    public static List<String> getUrlList(String path,String name){
        String[] paths = path.split(" ");
        List<String> pathList = new ArrayList<>();
        ServerConfig serverConfig = new ServerConfig();
        for(String p : paths){
            String[] limit = p.split("\\\\");
            pathList.add(serverConfig.getUrl() + File.separator + "profile"
                    + File.separator + name + File.separator + limit[limit.length-1]);
        }
        return pathList;
    }
}
