package com.noi.oj.service.impl;

import com.noi.oj.config.ServerConfig;
import com.noi.oj.dao.PacketOrderMapper;
import com.noi.oj.dao.UsersMapper;
import com.noi.oj.domain.PacketOrder;
import com.noi.oj.domain.Users;
import com.noi.oj.service.UsersService;
import com.noi.oj.utils.*;
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

    @Autowired
    private PacketOrderMapper packetOrderMapper;

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
        record.setImage(null);
        return usersMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public boolean setUserProfile(MultipartFile profile, HttpServletRequest request){
        // 根据Windows和Linux配置不同的头像保存路径
        String OSName = System.getProperty("os.name");
        String profilePath = OSName.toLowerCase().startsWith("win") ? SystemConstant.WINDOWS_PROFILES_PATH
                : SystemConstant.LINUX_PROFILES_PATH;
        Long userId = Long.parseLong(request.getAttribute("userId").toString());
        Users users = usersMapper.selectByPrimaryKey(userId);
        if(users.getImage()==null || "".equals(users.getImage())){
            String[] originName = profile.getOriginalFilename().split("\\.");
            String suffix = originName[originName.length - 1];
            users.setImage(UUID.randomUUID().toString() + System.currentTimeMillis() + "." + suffix);
            updateByPrimaryKeySelective(users);
        }
        return UploadUtils.setProductProfile(profile,users.getImage(),profilePath);
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
        PacketOrder order = new PacketOrder();
        order.setUserId(users.getUserId());
        order.setCreateDate(new Date());
        order.setPacketId(-1);
        order.setPrice(users.getBalance());
        if(packetOrderMapper.insertSelective(order)>0){
            Users usered = selectByPrimaryKey(users.getUserId());
            users.setBalance(usered.getBalance().add(users.getBalance()));
            return updateByPrimaryKeySelective(users);
        }
        else{
            return 0;
        }

    }

    @Override
    public List<Users> rank(Users users){
        return usersMapper.rank(users);
    }

    @Override
    public Users selectPasswordByPrimaryKey(Long pkId){
        return usersMapper.selectPasswordByPrimaryKey(pkId);
    }

    @Override
    public int selectUserBalance(Long pkId){
        return usersMapper.selectUserBalance(pkId);
    }

}
