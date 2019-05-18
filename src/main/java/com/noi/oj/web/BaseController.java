package com.noi.oj.web;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

public class BaseController implements Serializable {

    private int code;

    private String msg1;

    private Object data;

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMsg1() {
        return msg1;
    }

    public void setMsg1(String msg1) {
        this.msg1 = msg1;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    protected Map<String,Object> msg=new HashMap<>(0);

    public BaseController(){

    }

    public BaseController(Integer code,String msg,Object data){
        this.code = code;
        if(msg != null){
            this.msg1 = msg;
        }
        else{
            switch (code){
                case 0:
                    this.msg1="失败";
                    break;
                default:
                    this.msg1="成功";
                    break;
            }
        }
        if(data != null)
            this.data = data;
        else
            this.data = null;

    }

    public static BaseController result(Integer code,String str,Object data) {
        if(code >= 1)
            code = 1;
        else
            code = 0;
        return new BaseController(code,str,data);
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
