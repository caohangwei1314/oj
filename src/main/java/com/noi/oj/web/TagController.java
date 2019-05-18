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
    public BaseController insert(@RequestBody Tag record){
        try {
            return BaseController.result(tagService.insert(record),null,null);
        }catch (Exception e){
            return BaseController.result(0,e.getMessage(),null);
        }
        
    }

    @RequestMapping(value = "/list",method = RequestMethod.GET)
    public BaseController select(){
        try {
            List<Tag> tags = tagService.select();
            if(tags!=null)
                return BaseController.result(1,null,tags);
            else
                return BaseController.result(0,"还没有添加标签",null);
        }catch (Exception e){
            return BaseController.result(0,e.getMessage(),null);
        }
        
    }

    @RequestMapping(method = RequestMethod.PUT)
    public BaseController update(@RequestBody Tag tag){
        try {
            return BaseController.result(tagService.update(tag),null,null);
        }catch (Exception e){
            return BaseController.result(0,e.getMessage(),null);
        }
        
    }

    @RequestMapping(method = RequestMethod.DELETE)
    public BaseController delete(@RequestParam("id") Integer id){
        try {
            return BaseController.result(tagService.delete(id),null,null);
        }catch (Exception e){
            return BaseController.result(0,e.getMessage(),null);
        }
        
    }

    @RequestMapping(value = "/class",method = RequestMethod.GET)
    public BaseController statisticClass(HttpServletRequest request){
        try {
            return BaseController.result(1,null,tagService.statisticClass(Long.parseLong(request.getAttribute("userId").toString())));
        } catch (Exception e){
            return BaseController.result(0,e.getMessage(),null);
        }
        
    }

    @RequestMapping(value = "/statistic",method = RequestMethod.GET)
    public BaseController statistic(HttpServletRequest request){
        try {
            return BaseController.result(1,null,tagService.statistic(Long.parseLong(request.getAttribute("userId").toString())));
        } catch (Exception e){
            return BaseController.result(0,e.getMessage(),null);
        }
        
    }
}
