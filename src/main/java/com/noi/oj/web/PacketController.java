package com.noi.oj.web;

import com.noi.oj.domain.Conditions;
import com.noi.oj.domain.ProblemPacket;
import com.noi.oj.service.PacketService;
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
    public BaseController insert(@RequestBody ProblemPacket record, HttpServletRequest request){
        return BaseController.result(packetService.insertSelective(record,request),null,record.getPacketId());
        
    }

    @RequestMapping(value = "/detail",method = RequestMethod.GET)
    public BaseController select(@RequestParam("id") Integer id){
        ProblemPacket packet = packetService.selectByPrimaryKey(id);
        if(packet!=null)
            return BaseController.result(1,null,packet);
        else
            return BaseController.result(0,"题包不存在",null);
        
    }

    @RequestMapping(value = "/list",method = RequestMethod.POST)
    public BaseController selectList(@RequestBody Conditions record){
        PageBean pageBean = packetService.selectList(record);
        if(pageBean!=null)
            return BaseController.result(1,null,pageBean);
        else
            return BaseController.result(0,"还没有题包",null);
        
    }

    @RequestMapping(value = "/me",method = RequestMethod.GET)
    public BaseController selectPacket(HttpServletRequest request){
        Conditions record = new Conditions();
        record.setUserId(Long.parseLong(request.getAttribute("userId").toString()));
        PageBean pageBean = packetService.selectList(record);
        if(pageBean!=null)
            return BaseController.result(1,null,pageBean);
        else
            return BaseController.result(0,"还没有题包",null);
        
    }

    @RequestMapping(method = RequestMethod.PUT)
    public BaseController update(@RequestBody ProblemPacket record){
        return BaseController.result(packetService.updateByPrimaryKeySelective(record),null,null);
        
    }

    @RequestMapping(method = RequestMethod.DELETE)
    public BaseController delete(@RequestParam("id") Integer id){
        return BaseController.result(packetService.deleteByPrimaryKey(id),null,null);
        
    }

    @RequestMapping(value = "/upload",method = RequestMethod.POST)
    public BaseController setUserProfile(@RequestParam("file") MultipartFile profile,@RequestParam("id") Integer pkId){
        msg.clear();
        if(packetService.setPacketProfile(profile,pkId)){
            return BaseController.result(1,null,null);
        }else{
            return BaseController.result(0,null,null);
        }
        
    }

    @RequestMapping(value = "/temp",method = RequestMethod.POST)
    public BaseController setUserProfile(@RequestParam("file") MultipartFile profile){
        msg.clear();
        String url =packetService.setPacketProfile(profile);
        if(url!=null){
            return BaseController.result(1,null,url);
        }else{
            return BaseController.result(0,null,null);
        }
        
    }

    @RequestMapping(method = RequestMethod.GET)
    public BaseController isBuy(@RequestParam("id") Integer id, HttpServletRequest request){
        Conditions packet = new Conditions();
        packet.setPacketId(id);
        packet.setUserId(Long.parseLong(request.getAttribute("userId").toString()));
        return BaseController.result(packetService.isBuy(packet),null,null);
        
    }
}
