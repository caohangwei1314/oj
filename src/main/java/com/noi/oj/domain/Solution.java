package com.noi.oj.domain;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

/**
 * @author 
 */
public class Solution implements Serializable {
    private Integer solutionId;

    private Integer problemId;

    private Long userId;

    private Integer time;

    private Integer memory;

    private Date inDate;

    private Short result;

    private Integer language;

    private String ip;

    private Integer contestId;

    private Byte valid;

    private Byte num;

    private Integer codeLength;

    private Date judgetime;

    private BigDecimal passRate;

    private Integer lintError;

    private String judger;

    private String source;

    private static final long serialVersionUID = 1L;

    public Integer getSolutionId() {
        return solutionId;
    }

    public void setSolutionId(Integer solutionId) {
        this.solutionId = solutionId;
    }

    public Integer getProblemId() {
        return problemId;
    }

    public void setProblemId(Integer problemId) {
        this.problemId = problemId;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Integer getTime() {
        return time;
    }

    public void setTime(Integer time) {
        this.time = time;
    }

    public Integer getMemory() {
        return memory;
    }

    public void setMemory(Integer memory) {
        this.memory = memory;
    }

    public Date getInDate() {
        return inDate;
    }

    public void setInDate(Date inDate) {
        this.inDate = inDate;
    }

    public Short getResult() {
        return result;
    }

    public void setResult(Short result) {
        this.result = result;
    }

    public Integer getLanguage() {
        return language;
    }

    public void setLanguage(Integer language) {
        this.language = language;
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    public Integer getContestId() {
        return contestId;
    }

    public void setContestId(Integer contestId) {
        this.contestId = contestId;
    }

    public Byte getValid() {
        return valid;
    }

    public void setValid(Byte valid) {
        this.valid = valid;
    }

    public Byte getNum() {
        return num;
    }

    public void setNum(Byte num) {
        this.num = num;
    }

    public Integer getCodeLength() {
        return codeLength;
    }

    public void setCodeLength(Integer codeLength) {
        this.codeLength = codeLength;
    }

    public Date getJudgetime() {
        return judgetime;
    }

    public void setJudgetime(Date judgetime) {
        this.judgetime = judgetime;
    }

    public BigDecimal getPassRate() {
        return passRate;
    }

    public void setPassRate(BigDecimal passRate) {
        this.passRate = passRate;
    }

    public Integer getLintError() {
        return lintError;
    }

    public void setLintError(Integer lintError) {
        this.lintError = lintError;
    }

    public String getJudger() {
        return judger;
    }

    public void setJudger(String judger) {
        this.judger = judger;
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
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
        Solution other = (Solution) that;
        return (this.getSolutionId() == null ? other.getSolutionId() == null : this.getSolutionId().equals(other.getSolutionId()))
            && (this.getProblemId() == null ? other.getProblemId() == null : this.getProblemId().equals(other.getProblemId()))
            && (this.getUserId() == null ? other.getUserId() == null : this.getUserId().equals(other.getUserId()))
            && (this.getTime() == null ? other.getTime() == null : this.getTime().equals(other.getTime()))
            && (this.getMemory() == null ? other.getMemory() == null : this.getMemory().equals(other.getMemory()))
            && (this.getInDate() == null ? other.getInDate() == null : this.getInDate().equals(other.getInDate()))
            && (this.getResult() == null ? other.getResult() == null : this.getResult().equals(other.getResult()))
            && (this.getLanguage() == null ? other.getLanguage() == null : this.getLanguage().equals(other.getLanguage()))
            && (this.getIp() == null ? other.getIp() == null : this.getIp().equals(other.getIp()))
            && (this.getContestId() == null ? other.getContestId() == null : this.getContestId().equals(other.getContestId()))
            && (this.getValid() == null ? other.getValid() == null : this.getValid().equals(other.getValid()))
            && (this.getNum() == null ? other.getNum() == null : this.getNum().equals(other.getNum()))
            && (this.getCodeLength() == null ? other.getCodeLength() == null : this.getCodeLength().equals(other.getCodeLength()))
            && (this.getJudgetime() == null ? other.getJudgetime() == null : this.getJudgetime().equals(other.getJudgetime()))
            && (this.getPassRate() == null ? other.getPassRate() == null : this.getPassRate().equals(other.getPassRate()))
            && (this.getLintError() == null ? other.getLintError() == null : this.getLintError().equals(other.getLintError()))
            && (this.getJudger() == null ? other.getJudger() == null : this.getJudger().equals(other.getJudger()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getSolutionId() == null) ? 0 : getSolutionId().hashCode());
        result = prime * result + ((getProblemId() == null) ? 0 : getProblemId().hashCode());
        result = prime * result + ((getUserId() == null) ? 0 : getUserId().hashCode());
        result = prime * result + ((getTime() == null) ? 0 : getTime().hashCode());
        result = prime * result + ((getMemory() == null) ? 0 : getMemory().hashCode());
        result = prime * result + ((getInDate() == null) ? 0 : getInDate().hashCode());
        result = prime * result + ((getResult() == null) ? 0 : getResult().hashCode());
        result = prime * result + ((getLanguage() == null) ? 0 : getLanguage().hashCode());
        result = prime * result + ((getIp() == null) ? 0 : getIp().hashCode());
        result = prime * result + ((getContestId() == null) ? 0 : getContestId().hashCode());
        result = prime * result + ((getValid() == null) ? 0 : getValid().hashCode());
        result = prime * result + ((getNum() == null) ? 0 : getNum().hashCode());
        result = prime * result + ((getCodeLength() == null) ? 0 : getCodeLength().hashCode());
        result = prime * result + ((getJudgetime() == null) ? 0 : getJudgetime().hashCode());
        result = prime * result + ((getPassRate() == null) ? 0 : getPassRate().hashCode());
        result = prime * result + ((getLintError() == null) ? 0 : getLintError().hashCode());
        result = prime * result + ((getJudger() == null) ? 0 : getJudger().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", solutionId=").append(solutionId);
        sb.append(", problemId=").append(problemId);
        sb.append(", userId=").append(userId);
        sb.append(", time=").append(time);
        sb.append(", memory=").append(memory);
        sb.append(", inDate=").append(inDate);
        sb.append(", result=").append(result);
        sb.append(", language=").append(language);
        sb.append(", ip=").append(ip);
        sb.append(", contestId=").append(contestId);
        sb.append(", valid=").append(valid);
        sb.append(", num=").append(num);
        sb.append(", codeLength=").append(codeLength);
        sb.append(", judgetime=").append(judgetime);
        sb.append(", passRate=").append(passRate);
        sb.append(", lintError=").append(lintError);
        sb.append(", judger=").append(judger);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}