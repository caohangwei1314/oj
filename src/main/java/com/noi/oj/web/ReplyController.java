package com.noi.oj.web;

import com.noi.oj.domain.Conditions;
import com.noi.oj.domain.Reply;
import com.noi.oj.service.ReplyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/reply")
public class ReplyController extends BaseController{

    @Autowired
    private ReplyService replyService;

    @RequestMapping(method = RequestMethod.POST)
    public BaseController insert(@RequestBody Reply record, HttpServletRequest request){
        record.setUserId(Long.parseLong(request.getAttribute("userId").toString()));
        return BaseController.result(replyService.insert(record),null,null);
        
    }

    @RequestMapping(method = RequestMethod.PUT)
    public BaseController update(@RequestBody Reply record){
        return BaseController.result(replyService.update(record),null,null);
        
    }

    @RequestMapping(method = RequestMethod.DELETE)
    public BaseController delete(@RequestParam("id") Integer id){
        return BaseController.result(replyService.delete(id),null,null);
        
    }

    @RequestMapping(value = "list",method = RequestMethod.POST)
    public BaseController select(@RequestBody Conditions record){
        List<Reply> replies = replyService.select(record);
        if(replies!=null && replies.size()>0)
            return BaseController.result(1,null,replies);
        else
            return BaseController.result(0,"还没有评论",null);
        
    }
}
