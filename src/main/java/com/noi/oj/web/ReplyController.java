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
    public Map<String,Object> insert(@RequestBody Reply record, HttpServletRequest request){
        record.setUserId(Long.parseLong(request.getAttribute("userId").toString()));
        setMsg(replyService.insert(record),null,null);
        return msg;
    }

    @RequestMapping(method = RequestMethod.PUT)
    public Map<String,Object> update(@RequestBody Reply record){
        setMsg(replyService.update(record),null,null);
        return msg;
    }

    @RequestMapping(method = RequestMethod.DELETE)
    public Map<String,Object> delete(@RequestParam("id") Integer id){
        setMsg(replyService.delete(id),null,null);
        return msg;
    }

    @RequestMapping(value = "list",method = RequestMethod.POST)
    public Map<String,Object> select(@RequestBody Conditions record){
        List<Reply> replies = replyService.select(record);
        if(replies!=null && replies.size()>0)
            setMsg(1,null,replies);
        else
            setMsg(0,"还没有评论",null);
        return msg;
    }
}
