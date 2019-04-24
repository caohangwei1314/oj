package com.noi.oj.web;

import com.noi.oj.domain.Tag;
import com.noi.oj.service.TagService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("problem/tags")
public class TagController extends BaseController{

    @Autowired
    private TagService tagService;

    @RequestMapping(method = RequestMethod.POST)
    public Map<String,Object> insert(@RequestBody Tag record){
        try {
            setMsg(tagService.insert(record),null,null);
        }catch (Exception e){
            setMsg(0,e.getMessage(),null);
        }
        return msg;
    }

    @RequestMapping(value = "/list",method = RequestMethod.GET)
    public Map<String,Object> select(){
        try {
            List<Tag> tags = tagService.select();
            if(tags!=null)
                setMsg(1,null,tags);
            else
                setMsg(0,"还没有添加标签",null);
        }catch (Exception e){
            setMsg(0,e.getMessage(),null);
        }
        return msg;
    }

    @RequestMapping(method = RequestMethod.PUT)
    public Map<String,Object> update(@RequestBody Tag tag){
        try {
            setMsg(tagService.update(tag),null,null);
        }catch (Exception e){
            setMsg(0,e.getMessage(),null);
        }
        return msg;
    }

    @RequestMapping(method = RequestMethod.DELETE)
    public Map<String,Object> delete(@RequestParam("id") Integer id){
        try {
            setMsg(tagService.delete(id),null,null);
        }catch (Exception e){
            setMsg(0,e.getMessage(),null);
        }
        return msg;
    }

    @RequestMapping(value = "/class",method = RequestMethod.GET)
    public Map<String,Object> statisticClass(HttpServletRequest request){
        try {
            setMsg(1,null,tagService.statisticClass(Long.parseLong(request.getAttribute("userId").toString())));
        } catch (Exception e){
            setMsg(0,e.getMessage(),null);
        }
        return msg;
    }

    @RequestMapping(value = "/statistic",method = RequestMethod.GET)
    public Map<String,Object> statistic(HttpServletRequest request){
        try {
            setMsg(1,null,tagService.statistic(Long.parseLong(request.getAttribute("userId").toString())));
        } catch (Exception e){
            setMsg(0,e.getMessage(),null);
        }
        return msg;
    }
}
