package com.noi.oj.web;

import com.noi.oj.domain.Conditions;
import com.noi.oj.domain.PacketOrder;
import com.noi.oj.domain.ProblemPacket;
import com.noi.oj.service.PacketService;
import com.noi.oj.service.ProblemService;
import com.noi.oj.utils.PageBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;

@RestController
@RequestMapping("/packet")
public class PacketController extends BaseController{

    @Autowired
    private PacketService packetService;

    @RequestMapping(method = RequestMethod.POST)
    public Map<String,Object> insert(@RequestBody ProblemPacket record, HttpServletRequest request){
        setMsg(packetService.insertSelective(record,request),null,record.getPacketId());
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

    @RequestMapping(value = "/upload",method = RequestMethod.POST)
    public Map<String,Object> setUserProfile(@RequestParam("file") MultipartFile profile,@RequestParam("id") Integer pkId){
        msg.clear();
        if(packetService.setPacketProfile(profile,pkId)){
            setMsg(1,null,null);
        }else{
            setMsg(0,null,null);
        }
        return msg;
    }

    @RequestMapping(value = "/temp",method = RequestMethod.POST)
    public Map<String,Object> setUserProfile(@RequestParam("file") MultipartFile profile){
        msg.clear();
        String url =packetService.setPacketProfile(profile);
        if(url!=null){
            setMsg(1,null,url);
        }else{
            setMsg(0,null,null);
        }
        return msg;
    }

    @RequestMapping(method = RequestMethod.GET)
    public Map<String,Object> isBuy(@RequestParam("id") Integer id, HttpServletRequest request){
        Conditions packet = new Conditions();
        packet.setPacketId(id);
        packet.setUserId(Long.parseLong(request.getAttribute("userId").toString()));
        setMsg(packetService.isBuy(packet),null,null);
        return msg;
    }
}
