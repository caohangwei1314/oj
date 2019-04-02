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

    private Integer problemId;

    private Integer topicId;

    private String orderBy;

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

    public void setProblemId(Integer problemId) {
        this.problemId = problemId;
    }

    public Integer getProblemId() {
        return problemId;
    }

    public void setTopicId(Integer topicId) {
        this.topicId = topicId;
    }

    public Integer getTopicId() {
        return topicId;
    }

    public void setOrderBy(String orderBy) {
        this.orderBy = orderBy;
    }

    public String getOrderBy() {
        return orderBy;
    }
}
