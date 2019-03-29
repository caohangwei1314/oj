package com.noi.oj.domain;

import java.io.Serializable;

/**
 * @author 
 */
public class ContestProblem implements Serializable {
    private Integer problemId;

    private Integer contestId;

    private String title;

    private Integer num;

    private Integer cAccepted;

    private Integer cSubmit;

    private static final long serialVersionUID = 1L;

    public Integer getProblemId() {
        return problemId;
    }

    public void setProblemId(Integer problemId) {
        this.problemId = problemId;
    }

    public Integer getContestId() {
        return contestId;
    }

    public void setContestId(Integer contestId) {
        this.contestId = contestId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Integer getNum() {
        return num;
    }

    public void setNum(Integer num) {
        this.num = num;
    }

    public Integer getcAccepted() {
        return cAccepted;
    }

    public void setcAccepted(Integer cAccepted) {
        this.cAccepted = cAccepted;
    }

    public Integer getcSubmit() {
        return cSubmit;
    }

    public void setcSubmit(Integer cSubmit) {
        this.cSubmit = cSubmit;
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
        ContestProblem other = (ContestProblem) that;
        return (this.getProblemId() == null ? other.getProblemId() == null : this.getProblemId().equals(other.getProblemId()))
            && (this.getContestId() == null ? other.getContestId() == null : this.getContestId().equals(other.getContestId()))
            && (this.getTitle() == null ? other.getTitle() == null : this.getTitle().equals(other.getTitle()))
            && (this.getNum() == null ? other.getNum() == null : this.getNum().equals(other.getNum()))
            && (this.getcAccepted() == null ? other.getcAccepted() == null : this.getcAccepted().equals(other.getcAccepted()))
            && (this.getcSubmit() == null ? other.getcSubmit() == null : this.getcSubmit().equals(other.getcSubmit()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getProblemId() == null) ? 0 : getProblemId().hashCode());
        result = prime * result + ((getContestId() == null) ? 0 : getContestId().hashCode());
        result = prime * result + ((getTitle() == null) ? 0 : getTitle().hashCode());
        result = prime * result + ((getNum() == null) ? 0 : getNum().hashCode());
        result = prime * result + ((getcAccepted() == null) ? 0 : getcAccepted().hashCode());
        result = prime * result + ((getcSubmit() == null) ? 0 : getcSubmit().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", problemId=").append(problemId);
        sb.append(", contestId=").append(contestId);
        sb.append(", title=").append(title);
        sb.append(", num=").append(num);
        sb.append(", cAccepted=").append(cAccepted);
        sb.append(", cSubmit=").append(cSubmit);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}