package com.noi.oj.web;

import java.util.HashMap;
import java.util.Map;

public class BaseController {

    protected Map<String,Object> msg=new HashMap<>(0);

    public Map<String, Object> getMsg() {
        return msg;
    }

    public void setMsg(Integer code,String str,Object data) {
        msg.clear();
        if(code >= 1)
            msg.put("code",1);
        else
            msg.put("code",0);
        if(str!=null){
            msg.put("msg",str);
        } else{
            switch (code){
                case 0:
                    msg.put("msg","失败");
                    break;
                default:
                    msg.put("msg","成功");
            }
        }
        if(data!=null)
            msg.put("data",data);
    }
}
