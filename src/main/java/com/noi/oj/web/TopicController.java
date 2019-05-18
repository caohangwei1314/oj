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
    public BaseController insert(@RequestBody Topic record, HttpServletRequest request){
        Long userId = Long.parseLong(request.getAttribute("userId").toString());
        return BaseController.result(topicService.insert(record,userId),null,null);
        
    }

    @RequestMapping(value = "list",method = RequestMethod.POST)
    public BaseController select(@RequestBody Conditions record){
        PageBean pageBean = topicService.select(record);
        if(pageBean!=null)
            return BaseController.result(1,null,pageBean);
        else
            return BaseController.result(0,"暂无帖子",null);
        
    }

    @RequestMapping(value = "detail",method = RequestMethod.GET)
    public BaseController selectDetail(@RequestParam("id") Integer id){
        Topic topic = topicService.selectDetail(id);
        if(topic!=null)
            return BaseController.result(1,null,topic);
        else
            return BaseController.result(0,"该帖子不存在或以被删除",null);
        
    }

    @RequestMapping(method = RequestMethod.PUT)
    public BaseController update(@RequestBody Topic record){
        return BaseController.result(topicService.update(record),null,null);
        
    }

    @RequestMapping(method = RequestMethod.DELETE)
    public BaseController delete(@RequestParam("id") Integer id){
        return BaseController.result(topicService.delete(id),null,null);
        
    }
}
