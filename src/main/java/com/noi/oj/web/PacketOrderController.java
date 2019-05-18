package com.noi.oj.web;

import com.noi.oj.domain.Conditions;
import com.noi.oj.domain.PacketOrder;
import com.noi.oj.service.OrderService;
import com.noi.oj.utils.JwtUtil;
import com.noi.oj.utils.PageBean;
import io.jsonwebtoken.Claims;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;

@RestController
@RequestMapping("users/order")
public class PacketOrderController extends BaseController{

    @Autowired
    private OrderService orderService;

    @RequestMapping(method = RequestMethod.POST)
    public BaseController insert(@RequestBody PacketOrder record, HttpServletRequest request){
        record.setUserId(Long.parseLong(request.getAttribute("userId").toString()));
        return BaseController.result(orderService.insert(record),null,null);
        
    }

    @RequestMapping(value = "/list",method = RequestMethod.POST)
    public BaseController select(@RequestBody Conditions record, HttpServletRequest request){
        String header = request.getHeader("X-Token");
        if(header!=null){
            try {
                JwtUtil jwtUtil = new JwtUtil();
                Claims claims = jwtUtil.parseJWT(header);
                record.setUserId(Long.parseLong(claims.getId()));
            } catch (Exception e) {
                record.setUserId(null);
            }
        }else{
            return BaseController.result(0,"请先登陆",null);
            
        }
        PageBean pageBean = orderService.selectList(record);
        if(pageBean!=null)
            return BaseController.result(1,null,pageBean);
        else
            return BaseController.result(0,null,null);
        
    }

}
