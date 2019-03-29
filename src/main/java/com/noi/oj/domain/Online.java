package com.noi.oj.domain;

import java.io.Serializable;

/**
 * @author 
 */
public class Online implements Serializable {
    private String hash;

    private String ip;

    private String ua;

    private String refer;

    private Integer lastmove;

    private Integer firsttime;

    private String uri;

    private static final long serialVersionUID = 1L;

    public String getHash() {
        return hash;
    }

    public void setHash(String hash) {
        this.hash = hash;
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    public String getUa() {
        return ua;
    }

    public void setUa(String ua) {
        this.ua = ua;
    }

    public String getRefer() {
        return refer;
    }

    public void setRefer(String refer) {
        this.refer = refer;
    }

    public Integer getLastmove() {
        return lastmove;
    }

    public void setLastmove(Integer lastmove) {
        this.lastmove = lastmove;
    }

    public Integer getFirsttime() {
        return firsttime;
    }

    public void setFirsttime(Integer firsttime) {
        this.firsttime = firsttime;
    }

    public String getUri() {
        return uri;
    }

    public void setUri(String uri) {
        this.uri = uri;
    }

    @Override
    public boolean equals(Object that) {
        if (this == that) {
            return true;
        }
        if (that == null) {
            return false;
        }
        if (getClass() != that.getClass()) {
            return false;
        }
        Online other = (Online) that;
        return (this.getHash() == null ? other.getHash() == null : this.getHash().equals(other.getHash()))
            && (this.getIp() == null ? other.getIp() == null : this.getIp().equals(other.getIp()))
            && (this.getUa() == null ? other.getUa() == null : this.getUa().equals(other.getUa()))
            && (this.getRefer() == null ? other.getRefer() == null : this.getRefer().equals(other.getRefer()))
            && (this.getLastmove() == null ? other.getLastmove() == null : this.getLastmove().equals(other.getLastmove()))
            && (this.getFirsttime() == null ? other.getFirsttime() == null : this.getFirsttime().equals(other.getFirsttime()))
            && (this.getUri() == null ? other.getUri() == null : this.getUri().equals(other.getUri()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getHash() == null) ? 0 : getHash().hashCode());
        result = prime * result + ((getIp() == null) ? 0 : getIp().hashCode());
        result = prime * result + ((getUa() == null) ? 0 : getUa().hashCode());
        result = prime * result + ((getRefer() == null) ? 0 : getRefer().hashCode());
        result = prime * result + ((getLastmove() == null) ? 0 : getLastmove().hashCode());
        result = prime * result + ((getFirsttime() == null) ? 0 : getFirsttime().hashCode());
        result = prime * result + ((getUri() == null) ? 0 : getUri().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", hash=").append(hash);
        sb.append(", ip=").append(ip);
        sb.append(", ua=").append(ua);
        sb.append(", refer=").append(refer);
        sb.append(", lastmove=").append(lastmove);
        sb.append(", firsttime=").append(firsttime);
        sb.append(", uri=").append(uri);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}