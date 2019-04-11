package com.noi.oj.config;

import com.noi.oj.utils.SystemConstant;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.net.InetAddress;
import java.net.UnknownHostException;

@Component
public class ServerConfig{

    private int serverPort=9999;

    public int getServerPort(){
        return this.serverPort;
    }



    public String getHost(){
        InetAddress address = null;
        try {
            address = InetAddress.getLocalHost();
        } catch (UnknownHostException e) {
            e.printStackTrace();
        }
        return address.getHostAddress();
//        return SystemConstant.IP;
    }

    public String getUrl(){
        String address = SystemConstant.IP;
        return "http://" + address + ":" + getServerPort();
    }

}
