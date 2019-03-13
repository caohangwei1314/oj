package com.noi.oj.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.net.InetAddress;
import java.net.UnknownHostException;

public class ServerConfig{

    private int serverPort=8080;

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
    }

    public String getUrl(){
        String address = getHost();
        return "http://" + address + ":" + getServerPort();
    }

}
