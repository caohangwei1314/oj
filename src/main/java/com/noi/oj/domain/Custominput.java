package com.noi.oj.domain;

import java.io.Serializable;

/**
 * @author 
 */
public class Custominput implements Serializable {
    private Integer solutionId;

    private String inputText;

    private static final long serialVersionUID = 1L;

    public Integer getSolutionId() {
        return solutionId;
    }

    public void setSolutionId(Integer solutionId) {
        this.solutionId = solutionId;
    }

    public String getInputText() {
        return inputText;
    }

    public void setInputText(String inputText) {
        this.inputText = inputText;
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
        Custominput other = (Custominput) that;
        return (this.getSolutionId() == null ? other.getSolutionId() == null : this.getSolutionId().equals(other.getSolutionId()))
            && (this.getInputText() == null ? other.getInputText() == null : this.getInputText().equals(other.getInputText()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getSolutionId() == null) ? 0 : getSolutionId().hashCode());
        result = prime * result + ((getInputText() == null) ? 0 : getInputText().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", solutionId=").append(solutionId);
        sb.append(", inputText=").append(inputText);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}