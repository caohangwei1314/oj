package com.noi.oj.domain;

public class Conditions {

    private Integer limit;

    private Integer page;

    private int[] tags;

    private Byte difficulty;

    private Byte type;

    private String title;

    private Byte isFree;

    private Integer offset;

    public void setLimit(Integer limit){
        this.limit=limit;
    }

    public Integer getLimit(){
        return limit;
    }

    public void setPage(Integer page) {
        this.page = page;
    }

    public Integer getPage() {
        return page;
    }

    public void setTags(int[] tags) {
        this.tags = tags;
    }

    public int[] getTags() {
        return tags;
    }

    public void setDifficulty(Byte difficulty) {
        this.difficulty = difficulty;
    }

    public Byte getDifficulty() {
        return difficulty;
    }

    public void setType(Byte type) {
        this.type = type;
    }

    public Byte getType() {
        return type;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getTitle() {
        return title;
    }

    public void setIsFree(Byte isFree) {
        this.isFree = isFree;
    }

    public Byte getIsFree() {
        return isFree;
    }

    public void setOffset(Integer offset) {
        this.offset = offset;
    }

    public Integer getOffset() {
        return offset;
    }
}
