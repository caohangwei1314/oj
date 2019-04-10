package com.noi.oj.service;

import com.noi.oj.domain.Users;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public interface UsersService {
    int insertSelective(Users record);

    Users selectByPrimaryKey(Long pkId);

    Users selectByEmail(String email);

    Users selectUserInfo(Long pkId);

    int updateByPrimaryKeySelective(Users record);

    int updateByPrimaryKey(Users record);

    boolean setUserProfile(MultipartFile profile, HttpServletRequest request);

    boolean updateUsersSubmit(Long pkId);

    int userRecharge(Users users);
}
