package com.noi.oj.domain;

import java.io.Serializable;
import java.util.Date;

/**
 * @author 
 */
public class Users implements Serializable {
    private Long pkId;

    private String nick;

    private String email;

    private String image;

    private Byte sex;

    private Integer birthday;

    private String introduce;

    private String experience;

    private String province;

    private String city;

    private String school;

    /**
     * 0:初中 1:高中
     */
    private Byte userClass;

    private Integer submit;

    private Integer solved;

    private String defunct;

    private String ip;

    private Date accesstime;

    private Integer volume;

    private Integer language;

    private String password;

    private Date regTime;

    private Date gmtCreate;

    private Date gmtModified;

    private static final long serialVersionUID = 1L;

    public Long getPkId() {
        return pkId;
    }

    public void setPkId(Long pkId) {
        this.pkId = pkId;
    }

    public String getNick() {
        return nick;
    }

    public void setNick(String nick) {
        this.nick = nick;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public Byte getSex() {
        return sex;
    }

    public void setSex(Byte sex) {
        this.sex = sex;
    }

    public Integer getBirthday() {
        return birthday;
    }

    public void setBirthday(Integer birthday) {
        this.birthday = birthday;
    }

    public String getIntroduce() {
        return introduce;
    }

    public void setIntroduce(String introduce) {
        this.introduce = introduce;
    }

    public String getExperience() {
        return experience;
    }

    public void setExperience(String experience) {
        this.experience = experience;
    }

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getSchool() {
        return school;
    }

    public void setSchool(String school) {
        this.school = school;
    }

    public Byte getUserClass() {
        return userClass;
    }

    public void setUserClass(Byte userClass) {
        this.userClass = userClass;
    }

    public Integer getSubmit() {
        return submit;
    }

    public void setSubmit(Integer submit) {
        this.submit = submit;
    }

    public Integer getSolved() {
        return solved;
    }

    public void setSolved(Integer solved) {
        this.solved = solved;
    }

    public String getDefunct() {
        return defunct;
    }

    public void setDefunct(String defunct) {
        this.defunct = defunct;
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    public Date getAccesstime() {
        return accesstime;
    }

    public void setAccesstime(Date accesstime) {
        this.accesstime = accesstime;
    }

    public Integer getVolume() {
        return volume;
    }

    public void setVolume(Integer volume) {
        this.volume = volume;
    }

    public Integer getLanguage() {
        return language;
    }

    public void setLanguage(Integer language) {
        this.language = language;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Date getRegTime() {
        return regTime;
    }

    public void setRegTime(Date regTime) {
        this.regTime = regTime;
    }

    public Date getGmtCreate() {
        return gmtCreate;
    }

    public void setGmtCreate(Date gmtCreate) {
        this.gmtCreate = gmtCreate;
    }

    public Date getGmtModified() {
        return gmtModified;
    }

    public void setGmtModified(Date gmtModified) {
        this.gmtModified = gmtModified;
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
        Users other = (Users) that;
        return (this.getPkId() == null ? other.getPkId() == null : this.getPkId().equals(other.getPkId()))
            && (this.getNick() == null ? other.getNick() == null : this.getNick().equals(other.getNick()))
            && (this.getEmail() == null ? other.getEmail() == null : this.getEmail().equals(other.getEmail()))
            && (this.getImage() == null ? other.getImage() == null : this.getImage().equals(other.getImage()))
            && (this.getSex() == null ? other.getSex() == null : this.getSex().equals(other.getSex()))
            && (this.getBirthday() == null ? other.getBirthday() == null : this.getBirthday().equals(other.getBirthday()))
            && (this.getIntroduce() == null ? other.getIntroduce() == null : this.getIntroduce().equals(other.getIntroduce()))
            && (this.getExperience() == null ? other.getExperience() == null : this.getExperience().equals(other.getExperience()))
            && (this.getProvince() == null ? other.getProvince() == null : this.getProvince().equals(other.getProvince()))
            && (this.getCity() == null ? other.getCity() == null : this.getCity().equals(other.getCity()))
            && (this.getSchool() == null ? other.getSchool() == null : this.getSchool().equals(other.getSchool()))
            && (this.getUserClass() == null ? other.getUserClass() == null : this.getUserClass().equals(other.getUserClass()))
            && (this.getSubmit() == null ? other.getSubmit() == null : this.getSubmit().equals(other.getSubmit()))
            && (this.getSolved() == null ? other.getSolved() == null : this.getSolved().equals(other.getSolved()))
            && (this.getDefunct() == null ? other.getDefunct() == null : this.getDefunct().equals(other.getDefunct()))
            && (this.getIp() == null ? other.getIp() == null : this.getIp().equals(other.getIp()))
            && (this.getAccesstime() == null ? other.getAccesstime() == null : this.getAccesstime().equals(other.getAccesstime()))
            && (this.getVolume() == null ? other.getVolume() == null : this.getVolume().equals(other.getVolume()))
            && (this.getLanguage() == null ? other.getLanguage() == null : this.getLanguage().equals(other.getLanguage()))
            && (this.getPassword() == null ? other.getPassword() == null : this.getPassword().equals(other.getPassword()))
            && (this.getRegTime() == null ? other.getRegTime() == null : this.getRegTime().equals(other.getRegTime()))
            && (this.getGmtCreate() == null ? other.getGmtCreate() == null : this.getGmtCreate().equals(other.getGmtCreate()))
            && (this.getGmtModified() == null ? other.getGmtModified() == null : this.getGmtModified().equals(other.getGmtModified()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getPkId() == null) ? 0 : getPkId().hashCode());
        result = prime * result + ((getNick() == null) ? 0 : getNick().hashCode());
        result = prime * result + ((getEmail() == null) ? 0 : getEmail().hashCode());
        result = prime * result + ((getImage() == null) ? 0 : getImage().hashCode());
        result = prime * result + ((getSex() == null) ? 0 : getSex().hashCode());
        result = prime * result + ((getBirthday() == null) ? 0 : getBirthday().hashCode());
        result = prime * result + ((getIntroduce() == null) ? 0 : getIntroduce().hashCode());
        result = prime * result + ((getExperience() == null) ? 0 : getExperience().hashCode());
        result = prime * result + ((getProvince() == null) ? 0 : getProvince().hashCode());
        result = prime * result + ((getCity() == null) ? 0 : getCity().hashCode());
        result = prime * result + ((getSchool() == null) ? 0 : getSchool().hashCode());
        result = prime * result + ((getUserClass() == null) ? 0 : getUserClass().hashCode());
        result = prime * result + ((getSubmit() == null) ? 0 : getSubmit().hashCode());
        result = prime * result + ((getSolved() == null) ? 0 : getSolved().hashCode());
        result = prime * result + ((getDefunct() == null) ? 0 : getDefunct().hashCode());
        result = prime * result + ((getIp() == null) ? 0 : getIp().hashCode());
        result = prime * result + ((getAccesstime() == null) ? 0 : getAccesstime().hashCode());
        result = prime * result + ((getVolume() == null) ? 0 : getVolume().hashCode());
        result = prime * result + ((getLanguage() == null) ? 0 : getLanguage().hashCode());
        result = prime * result + ((getPassword() == null) ? 0 : getPassword().hashCode());
        result = prime * result + ((getRegTime() == null) ? 0 : getRegTime().hashCode());
        result = prime * result + ((getGmtCreate() == null) ? 0 : getGmtCreate().hashCode());
        result = prime * result + ((getGmtModified() == null) ? 0 : getGmtModified().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", pkId=").append(pkId);
        sb.append(", nick=").append(nick);
        sb.append(", email=").append(email);
        sb.append(", image=").append(image);
        sb.append(", sex=").append(sex);
        sb.append(", birthday=").append(birthday);
        sb.append(", introduce=").append(introduce);
        sb.append(", experience=").append(experience);
        sb.append(", province=").append(province);
        sb.append(", city=").append(city);
        sb.append(", school=").append(school);
        sb.append(", userClass=").append(userClass);
        sb.append(", submit=").append(submit);
        sb.append(", solved=").append(solved);
        sb.append(", defunct=").append(defunct);
        sb.append(", ip=").append(ip);
        sb.append(", accesstime=").append(accesstime);
        sb.append(", volume=").append(volume);
        sb.append(", language=").append(language);
        sb.append(", password=").append(password);
        sb.append(", regTime=").append(regTime);
        sb.append(", gmtCreate=").append(gmtCreate);
        sb.append(", gmtModified=").append(gmtModified);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}