package com.noi.oj.domain;

import java.io.Serializable;

/**
 * @author 
 */
public class ProgramLanguage implements Serializable {
    private Integer id;

    private String name;

    private String description;

    private Integer exttime;

    private Integer extmemory;

    private Byte timefactor;

    private Byte memoryfactor;

    private String ext;

    private String exe;

    private Byte complieorder;

    private String compilecmd;

    /**
     * SyntaxHighlighter brush
     */
    private String brush;

    private Boolean script;

    private Boolean status;

    private static final long serialVersionUID = 1L;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Integer getExttime() {
        return exttime;
    }

    public void setExttime(Integer exttime) {
        this.exttime = exttime;
    }

    public Integer getExtmemory() {
        return extmemory;
    }

    public void setExtmemory(Integer extmemory) {
        this.extmemory = extmemory;
    }

    public Byte getTimefactor() {
        return timefactor;
    }

    public void setTimefactor(Byte timefactor) {
        this.timefactor = timefactor;
    }

    public Byte getMemoryfactor() {
        return memoryfactor;
    }

    public void setMemoryfactor(Byte memoryfactor) {
        this.memoryfactor = memoryfactor;
    }

    public String getExt() {
        return ext;
    }

    public void setExt(String ext) {
        this.ext = ext;
    }

    public String getExe() {
        return exe;
    }

    public void setExe(String exe) {
        this.exe = exe;
    }

    public Byte getComplieorder() {
        return complieorder;
    }

    public void setComplieorder(Byte complieorder) {
        this.complieorder = complieorder;
    }

    public String getCompilecmd() {
        return compilecmd;
    }

    public void setCompilecmd(String compilecmd) {
        this.compilecmd = compilecmd;
    }

    public String getBrush() {
        return brush;
    }

    public void setBrush(String brush) {
        this.brush = brush;
    }

    public Boolean getScript() {
        return script;
    }

    public void setScript(Boolean script) {
        this.script = script;
    }

    public Boolean getStatus() {
        return status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
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
        ProgramLanguage other = (ProgramLanguage) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getName() == null ? other.getName() == null : this.getName().equals(other.getName()))
            && (this.getDescription() == null ? other.getDescription() == null : this.getDescription().equals(other.getDescription()))
            && (this.getExttime() == null ? other.getExttime() == null : this.getExttime().equals(other.getExttime()))
            && (this.getExtmemory() == null ? other.getExtmemory() == null : this.getExtmemory().equals(other.getExtmemory()))
            && (this.getTimefactor() == null ? other.getTimefactor() == null : this.getTimefactor().equals(other.getTimefactor()))
            && (this.getMemoryfactor() == null ? other.getMemoryfactor() == null : this.getMemoryfactor().equals(other.getMemoryfactor()))
            && (this.getExt() == null ? other.getExt() == null : this.getExt().equals(other.getExt()))
            && (this.getExe() == null ? other.getExe() == null : this.getExe().equals(other.getExe()))
            && (this.getComplieorder() == null ? other.getComplieorder() == null : this.getComplieorder().equals(other.getComplieorder()))
            && (this.getCompilecmd() == null ? other.getCompilecmd() == null : this.getCompilecmd().equals(other.getCompilecmd()))
            && (this.getBrush() == null ? other.getBrush() == null : this.getBrush().equals(other.getBrush()))
            && (this.getScript() == null ? other.getScript() == null : this.getScript().equals(other.getScript()))
            && (this.getStatus() == null ? other.getStatus() == null : this.getStatus().equals(other.getStatus()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getName() == null) ? 0 : getName().hashCode());
        result = prime * result + ((getDescription() == null) ? 0 : getDescription().hashCode());
        result = prime * result + ((getExttime() == null) ? 0 : getExttime().hashCode());
        result = prime * result + ((getExtmemory() == null) ? 0 : getExtmemory().hashCode());
        result = prime * result + ((getTimefactor() == null) ? 0 : getTimefactor().hashCode());
        result = prime * result + ((getMemoryfactor() == null) ? 0 : getMemoryfactor().hashCode());
        result = prime * result + ((getExt() == null) ? 0 : getExt().hashCode());
        result = prime * result + ((getExe() == null) ? 0 : getExe().hashCode());
        result = prime * result + ((getComplieorder() == null) ? 0 : getComplieorder().hashCode());
        result = prime * result + ((getCompilecmd() == null) ? 0 : getCompilecmd().hashCode());
        result = prime * result + ((getBrush() == null) ? 0 : getBrush().hashCode());
        result = prime * result + ((getScript() == null) ? 0 : getScript().hashCode());
        result = prime * result + ((getStatus() == null) ? 0 : getStatus().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", name=").append(name);
        sb.append(", description=").append(description);
        sb.append(", exttime=").append(exttime);
        sb.append(", extmemory=").append(extmemory);
        sb.append(", timefactor=").append(timefactor);
        sb.append(", memoryfactor=").append(memoryfactor);
        sb.append(", ext=").append(ext);
        sb.append(", exe=").append(exe);
        sb.append(", complieorder=").append(complieorder);
        sb.append(", compilecmd=").append(compilecmd);
        sb.append(", brush=").append(brush);
        sb.append(", script=").append(script);
        sb.append(", status=").append(status);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}