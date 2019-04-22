package com.noi.oj.service;

import com.noi.oj.domain.Users;
import com.noi.oj.utils.PageBean;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

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

    List<Users> rank(Users users);

    Users selectPasswordByPrimaryKey(Long pkId);

    int selectUserBalance(Long pkId);
}
