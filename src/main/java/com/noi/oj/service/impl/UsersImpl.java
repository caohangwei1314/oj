package com.noi.oj.service.impl;

import com.noi.oj.config.ServerConfig;
import com.noi.oj.dao.UsersMapper;
import com.noi.oj.domain.Users;
import com.noi.oj.service.UsersService;
import com.noi.oj.utils.IpUtil;
import com.noi.oj.utils.PageBean;
import com.noi.oj.utils.Sha2Util;
import com.noi.oj.utils.SystemConstant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.imageio.ImageIO;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.awt.image.BufferedImage;
import java.io.*;
import java.math.BigDecimal;
import java.net.Inet4Address;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.Date;
import java.util.List;
import java.util.UUID;

@Service
public class UsersImpl implements UsersService {

    @Autowired
    private UsersMapper usersMapper;

    @Override
    public int insertSelective(Users record)
    {
        Date date = new Date();
        record.setAccesstime(date);
        record.setRegTime(date);
        record.setPassword(Sha2Util.SHA256(record.getPassword()));
        return usersMapper.insertSelective(record);
    }

    @Override
    public Users selectByPrimaryKey(Long pkId)
    {
        return usersMapper.selectByPrimaryKey(pkId);
    }

    @Override
    public Users selectByEmail(String email)
    {
        return usersMapper.selectByEmail(email);
    }

    @Override
    public Users selectUserInfo(Long pkId){
        Users users = usersMapper.selectByPrimaryKey(pkId);
        if(users.getImage()!=null && !"".equals(users.getImage()))
            users.setImage(getUrl(users.getImage()));
        return users;
    }

    @Override
    public int updateByPrimaryKeySelective(Users record)
    {
        return usersMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public int updateByPrimaryKey(Users record)
    {
        return usersMapper.updateByPrimaryKey(record);
    }

    @Override
    public boolean setUserProfile(MultipartFile profile, HttpServletRequest request){
        // 根据Windows和Linux配置不同的头像保存路径
        String OSName = System.getProperty("os.name");
        String profilePath = OSName.toLowerCase().startsWith("win") ? SystemConstant.WINDOWS_PROFILES_PATH
                : SystemConstant.LINUX_PROFILES_PATH;
        if(!profile.isEmpty()){
            Long userId = Long.parseLong(request.getAttribute("userId").toString());
            Users users = selectByPrimaryKey(userId);
            String profilePathAndNameDB = users.getImage();
            // 默认以原来的头像名称为新头像的名称，这样可以直接替换掉文件夹中对应的旧头像
            String newProfileName = profilePathAndNameDB;
            // 若头像名称不存在
            String[] originName = profile.getOriginalFilename().split("\\.");
            String suffix = originName[originName.length-1];
            if(profilePathAndNameDB == null || "".equals(profilePathAndNameDB)){
                newProfileName = UUID.randomUUID().toString() + System.currentTimeMillis() + "." + suffix;
                // 路径存库
                users.setImage(newProfileName);
                updateByPrimaryKeySelective(users);
            }else{
                String[] profiles = profilePathAndNameDB.split("\\.");
                if(!suffix.equals(profiles[profiles.length-1])){
                    File file = new File(profilePath + profilePathAndNameDB);
                    if(file.exists())
                        file.delete();
                    newProfileName = profiles[0] + "." + suffix;
                    users.setImage(newProfileName);
                    updateByPrimaryKeySelective(users);
                }
            }
            //磁盘保存
            BufferedOutputStream out = null;
            newProfileName = profilePath + newProfileName;
            try {
                File folder = new File(profilePath);
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

    public String getUrl(String path){
        String[] limit = path.split("\\\\");
        ServerConfig serverConfig = new ServerConfig();
        return serverConfig.getUrl() + "/profile/users/" + limit[limit.length-1];
    }

    public boolean updateUsersSubmit(Long pkId){
        Users users = selectByPrimaryKey(pkId);
        users.setSubmit(users.getSubmit()+1);
        return updateByPrimaryKeySelective(users)>0;
    }

    @Override
    public int userRecharge(Users users){
        Users usered = selectByPrimaryKey(users.getUserId());
        users.setBalance(usered.getBalance().add(users.getBalance()));
        return updateByPrimaryKeySelective(users);
    }

    @Override
    public List<Users> rank(){
        return usersMapper.rank();
    }
}
