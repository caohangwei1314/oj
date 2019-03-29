package com.noi.oj.domain;

import java.io.Serializable;

/**
 * @author 
 */
public class ProblemTagShip implements Serializable{
    private Integer problemTagId;

    private Integer problemId;

    private Integer tagId;

    private static final long serialVersionUID = 1L;

    public Integer getProblemTagId() {
        return problemTagId;
    }

    public void setProblemTagId(Integer problemTagId) {
        this.problemTagId = problemTagId;
    }

    public Integer getProblemId() {
        return problemId;
    }

    public void setProblemId(Integer problemId) {
        this.problemId = problemId;
    }

    public Integer getTagId() {
        return tagId;
    }

    public void setTagId(Integer tagId) {
        this.tagId = tagId;
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
        ProblemTagShip other = (ProblemTagShip) that;
        return (this.getProblemTagId() == null ? other.getProblemTagId() == null : this.getProblemTagId().equals(other.getProblemTagId()))
            && (this.getProblemId() == null ? other.getProblemId() == null : this.getProblemId().equals(other.getProblemId()))
            && (this.getTagId() == null ? other.getTagId() == null : this.getTagId().equals(other.getTagId()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getProblemTagId() == null) ? 0 : getProblemTagId().hashCode());
        result = prime * result + ((getProblemId() == null) ? 0 : getProblemId().hashCode());
        result = prime * result + ((getTagId() == null) ? 0 : getTagId().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", problemTagId=").append(problemTagId);
        sb.append(", problemId=").append(problemId);
        sb.append(", tagId=").append(tagId);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}