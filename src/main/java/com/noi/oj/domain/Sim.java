package com.noi.oj.domain;

import java.io.Serializable;

/**
 * @author 
 */
public class Sim implements Serializable {
    private Integer sId;

    private Integer simSId;

    private Integer sim;

    private static final long serialVersionUID = 1L;

    public Integer getsId() {
        return sId;
    }

    public void setsId(Integer sId) {
        this.sId = sId;
    }

    public Integer getSimSId() {
        return simSId;
    }

    public void setSimSId(Integer simSId) {
        this.simSId = simSId;
    }

    public Integer getSim() {
        return sim;
    }

    public void setSim(Integer sim) {
        this.sim = sim;
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
        Sim other = (Sim) that;
        return (this.getsId() == null ? other.getsId() == null : this.getsId().equals(other.getsId()))
            && (this.getSimSId() == null ? other.getSimSId() == null : this.getSimSId().equals(other.getSimSId()))
            && (this.getSim() == null ? other.getSim() == null : this.getSim().equals(other.getSim()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getsId() == null) ? 0 : getsId().hashCode());
        result = prime * result + ((getSimSId() == null) ? 0 : getSimSId().hashCode());
        result = prime * result + ((getSim() == null) ? 0 : getSim().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", sId=").append(sId);
        sb.append(", simSId=").append(simSId);
        sb.append(", sim=").append(sim);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}