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

    private Integer originClass;

    private Long userId;

    private String nick;

    private Byte status;

    private Integer packetId;

    private String school;

    private Integer ContestId;

    private Integer levelId;

    private Integer ChallengeId;

    public Integer getChallengeId() {
        return ChallengeId;
    }

    public void setChallengeId(Integer challengeId) {
        ChallengeId = challengeId;
    }

    public Integer getLevelId() {
        return levelId;
    }

    public void setLevelId(Integer levelId) {
        this.levelId = levelId;
    }

    public Integer getContestId() {
        return ContestId;
    }

    public void setContestId(Integer contestId) {
        ContestId = contestId;
    }

    public String getSchool() {
        return school;
    }

    public void setSchool(String school) {
        this.school = school;
    }

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

    public void setNick(String nick) {
        this.nick = nick;
    }

    public String getNick() {
        return nick;
    }

    public void setOriginClass(Integer originClass) {
        this.originClass = originClass;
    }

    public Integer getOriginClass() {
        return originClass;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Long getUserId() {
        return userId;
    }

    public void setStatus(Byte status) {
        this.status = status;
    }

    public Byte getStatus() {
        return status;
    }

    public void setPacketId(Integer packetId) {
        this.packetId = packetId;
    }

    public Integer getPacketId() {
        return packetId;
    }
}
