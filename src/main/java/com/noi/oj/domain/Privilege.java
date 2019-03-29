package com.noi.oj.domain;

import java.io.Serializable;

/**
 * @author 
 */
public class Privilege implements Serializable {
    private Long userId;

    private String rightstr;

    private String defunct;

    private static final long serialVersionUID = 1L;

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getRightstr() {
        return rightstr;
    }

    public void setRightstr(String rightstr) {
        this.rightstr = rightstr;
    }

    public String getDefunct() {
        return defunct;
    }

    public void setDefunct(String defunct) {
        this.defunct = defunct;
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
        Privilege other = (Privilege) that;
        return (this.getUserId() == null ? other.getUserId() == null : this.getUserId().equals(other.getUserId()))
            && (this.getRightstr() == null ? other.getRightstr() == null : this.getRightstr().equals(other.getRightstr()))
            && (this.getDefunct() == null ? other.getDefunct() == null : this.getDefunct().equals(other.getDefunct()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getUserId() == null) ? 0 : getUserId().hashCode());
        result = prime * result + ((getRightstr() == null) ? 0 : getRightstr().hashCode());
        result = prime * result + ((getDefunct() == null) ? 0 : getDefunct().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", userId=").append(userId);
        sb.append(", rightstr=").append(rightstr);
        sb.append(", defunct=").append(defunct);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}