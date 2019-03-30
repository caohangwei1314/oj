package com.noi.oj.web;

import com.noi.oj.domain.Conditions;
import com.noi.oj.domain.ProblemPacket;
import com.noi.oj.service.PacketService;
import com.noi.oj.service.ProblemService;
import com.noi.oj.utils.PageBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;

@RestController
@RequestMapping("/packet")
public class PacketController extends BaseController{

    @Autowired
    private PacketService packetService;

    @RequestMapping(method = RequestMethod.POST)
    public Map<String,Object> insert(@RequestBody ProblemPacket record, HttpServletRequest request){
        setMsg(packetService.insertSelective(record,request),null,null);
        return msg;
    }

    @RequestMapping(value = "/detail",method = RequestMethod.GET)
    public Map<String,Object> select(@RequestParam("id") Integer id){
        ProblemPacket packet = packetService.selectByPrimaryKey(id);
        if(packet!=null)
            setMsg(1,null,packet);
        else
            setMsg(0,"题包不存在",null);
        return msg;
    }

    @RequestMapping(value = "/list",method = RequestMethod.POST)
    public Map<String,Object> selectList(@RequestBody Conditions record){
        PageBean pageBean = packetService.selectList(record);
        if(pageBean!=null)
            setMsg(1,null,pageBean);
        else
            setMsg(0,"还没有题包",null);
        return msg;
    }

    @RequestMapping(method = RequestMethod.PUT)
    public Map<String,Object> update(@RequestBody ProblemPacket record){
        setMsg(packetService.updateByPrimaryKeySelective(record),null,null);
        return msg;
    }

    @RequestMapping(method = RequestMethod.DELETE)
    public Map<String,Object> delete(@RequestParam("id") Integer id){
        setMsg(packetService.deleteByPrimaryKey(id),null,null);
        return msg;
    }
}
