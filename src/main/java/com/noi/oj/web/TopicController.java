package com.noi.oj.web;

import com.noi.oj.domain.Conditions;
import com.noi.oj.domain.Topic;
import com.noi.oj.service.TopicService;
import com.noi.oj.utils.PageBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;

@RestController
@RequestMapping("/topic")
public class TopicController extends BaseController{
    @Autowired
    private TopicService topicService;

    @RequestMapping(method = RequestMethod.POST)
    public Map<String,Object> insert(@RequestBody Topic record, HttpServletRequest request){
        Long userId = Long.parseLong(request.getAttribute("userId").toString());
        setMsg(topicService.insert(record,userId),null,null);
        return msg;
    }

    @RequestMapping(value = "list",method = RequestMethod.POST)
    public Map<String,Object> select(@RequestBody Conditions record){
        PageBean pageBean = topicService.select(record);
        if(pageBean!=null)
            setMsg(1,null,pageBean);
        else
            setMsg(0,"暂无帖子",null);
        return msg;
    }

    @RequestMapping(value = "detail",method = RequestMethod.GET)
    public Map<String,Object> selectDetail(@RequestParam("id") Integer id){
        Topic topic = topicService.selectDetail(id);
        if(topic!=null)
            setMsg(1,null,topic);
        else
            setMsg(0,"该帖子不存在或以被删除",null);
        return msg;
    }

    @RequestMapping(method = RequestMethod.PUT)
    public Map<String,Object> update(@RequestBody Topic record){
        setMsg(topicService.update(record),null,null);
        return msg;
    }

    @RequestMapping(method = RequestMethod.DELETE)
    public Map<String,Object> delete(@RequestParam("id") Integer id){
        setMsg(topicService.delete(id),null,null);
        return msg;
    }
}
