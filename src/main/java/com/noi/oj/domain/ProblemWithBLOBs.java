package com.noi.oj.domain;

import java.io.Serializable;

/**
 * @author 
 */
public class ProblemWithBLOBs extends Problem implements Serializable {
    private String description;

    private String input;

    private String output;

    private String sampleInput;

    private String sampleOutput;

    private String hint;

    private static final long serialVersionUID = 1L;

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getInput() {
        return input;
    }

    public void setInput(String input) {
        this.input = input;
    }

    public String getOutput() {
        return output;
    }

    public void setOutput(String output) {
        this.output = output;
    }

    public String getSampleInput() {
        return sampleInput;
    }

    public void setSampleInput(String sampleInput) {
        this.sampleInput = sampleInput;
    }

    public String getSampleOutput() {
        return sampleOutput;
    }

    public void setSampleOutput(String sampleOutput) {
        this.sampleOutput = sampleOutput;
    }

    public String getHint() {
        return hint;
    }

    public void setHint(String hint) {
        this.hint = hint;
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
        ProblemWithBLOBs other = (ProblemWithBLOBs) that;
        return (this.getProblemId() == null ? other.getProblemId() == null : this.getProblemId().equals(other.getProblemId()))
            && (this.getTitle() == null ? other.getTitle() == null : this.getTitle().equals(other.getTitle()))
            && (this.getSpj() == null ? other.getSpj() == null : this.getSpj().equals(other.getSpj()))
            && (this.getSource() == null ? other.getSource() == null : this.getSource().equals(other.getSource()))
            && (this.getInDate() == null ? other.getInDate() == null : this.getInDate().equals(other.getInDate()))
            && (this.getTimeLimit() == null ? other.getTimeLimit() == null : this.getTimeLimit().equals(other.getTimeLimit()))
            && (this.getMemoryLimit() == null ? other.getMemoryLimit() == null : this.getMemoryLimit().equals(other.getMemoryLimit()))
            && (this.getDefunct() == null ? other.getDefunct() == null : this.getDefunct().equals(other.getDefunct()))
            && (this.getAccepted() == null ? other.getAccepted() == null : this.getAccepted().equals(other.getAccepted()))
            && (this.getSubmit() == null ? other.getSubmit() == null : this.getSubmit().equals(other.getSubmit()))
            && (this.getSolved() == null ? other.getSolved() == null : this.getSolved().equals(other.getSolved()))
            && (this.getGmtCreate() == null ? other.getGmtCreate() == null : this.getGmtCreate().equals(other.getGmtCreate()))
            && (this.getGmtModified() == null ? other.getGmtModified() == null : this.getGmtModified().equals(other.getGmtModified()))
            && (this.getDescription() == null ? other.getDescription() == null : this.getDescription().equals(other.getDescription()))
            && (this.getInput() == null ? other.getInput() == null : this.getInput().equals(other.getInput()))
            && (this.getOutput() == null ? other.getOutput() == null : this.getOutput().equals(other.getOutput()))
            && (this.getSampleInput() == null ? other.getSampleInput() == null : this.getSampleInput().equals(other.getSampleInput()))
            && (this.getSampleOutput() == null ? other.getSampleOutput() == null : this.getSampleOutput().equals(other.getSampleOutput()))
            && (this.getHint() == null ? other.getHint() == null : this.getHint().equals(other.getHint()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getProblemId() == null) ? 0 : getProblemId().hashCode());
        result = prime * result + ((getTitle() == null) ? 0 : getTitle().hashCode());
        result = prime * result + ((getSpj() == null) ? 0 : getSpj().hashCode());
        result = prime * result + ((getSource() == null) ? 0 : getSource().hashCode());
        result = prime * result + ((getInDate() == null) ? 0 : getInDate().hashCode());
        result = prime * result + ((getTimeLimit() == null) ? 0 : getTimeLimit().hashCode());
        result = prime * result + ((getMemoryLimit() == null) ? 0 : getMemoryLimit().hashCode());
        result = prime * result + ((getDefunct() == null) ? 0 : getDefunct().hashCode());
        result = prime * result + ((getAccepted() == null) ? 0 : getAccepted().hashCode());
        result = prime * result + ((getSubmit() == null) ? 0 : getSubmit().hashCode());
        result = prime * result + ((getSolved() == null) ? 0 : getSolved().hashCode());
        result = prime * result + ((getGmtCreate() == null) ? 0 : getGmtCreate().hashCode());
        result = prime * result + ((getGmtModified() == null) ? 0 : getGmtModified().hashCode());
        result = prime * result + ((getDescription() == null) ? 0 : getDescription().hashCode());
        result = prime * result + ((getInput() == null) ? 0 : getInput().hashCode());
        result = prime * result + ((getOutput() == null) ? 0 : getOutput().hashCode());
        result = prime * result + ((getSampleInput() == null) ? 0 : getSampleInput().hashCode());
        result = prime * result + ((getSampleOutput() == null) ? 0 : getSampleOutput().hashCode());
        result = prime * result + ((getHint() == null) ? 0 : getHint().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", description=").append(description);
        sb.append(", input=").append(input);
        sb.append(", output=").append(output);
        sb.append(", sampleInput=").append(sampleInput);
        sb.append(", sampleOutput=").append(sampleOutput);
        sb.append(", hint=").append(hint);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}