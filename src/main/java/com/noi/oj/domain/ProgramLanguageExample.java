package com.noi.oj.domain;

import java.util.ArrayList;
import java.util.List;

public class ProgramLanguageExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    private Integer limit;

    private Integer offset;

    public ProgramLanguageExample() {
        oredCriteria = new ArrayList<Criteria>();
    }

    public void setOrderByClause(String orderByClause) {
        this.orderByClause = orderByClause;
    }

    public String getOrderByClause() {
        return orderByClause;
    }

    public void setDistinct(boolean distinct) {
        this.distinct = distinct;
    }

    public boolean isDistinct() {
        return distinct;
    }

    public List<Criteria> getOredCriteria() {
        return oredCriteria;
    }

    public void or(Criteria criteria) {
        oredCriteria.add(criteria);
    }

    public Criteria or() {
        Criteria criteria = createCriteriaInternal();
        oredCriteria.add(criteria);
        return criteria;
    }

    public Criteria createCriteria() {
        Criteria criteria = createCriteriaInternal();
        if (oredCriteria.size() == 0) {
            oredCriteria.add(criteria);
        }
        return criteria;
    }

    protected Criteria createCriteriaInternal() {
        Criteria criteria = new Criteria();
        return criteria;
    }

    public void clear() {
        oredCriteria.clear();
        orderByClause = null;
        distinct = false;
    }

    public void setLimit(Integer limit) {
        this.limit = limit;
    }

    public Integer getLimit() {
        return limit;
    }

    public void setOffset(Integer offset) {
        this.offset = offset;
    }

    public Integer getOffset() {
        return offset;
    }

    protected abstract static class GeneratedCriteria {
        protected List<Criterion> criteria;

        protected GeneratedCriteria() {
            super();
            criteria = new ArrayList<Criterion>();
        }

        public boolean isValid() {
            return criteria.size() > 0;
        }

        public List<Criterion> getAllCriteria() {
            return criteria;
        }

        public List<Criterion> getCriteria() {
            return criteria;
        }

        protected void addCriterion(String condition) {
            if (condition == null) {
                throw new RuntimeException("Value for condition cannot be null");
            }
            criteria.add(new Criterion(condition));
        }

        protected void addCriterion(String condition, Object value, String property) {
            if (value == null) {
                throw new RuntimeException("Value for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value));
        }

        protected void addCriterion(String condition, Object value1, Object value2, String property) {
            if (value1 == null || value2 == null) {
                throw new RuntimeException("Between values for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value1, value2));
        }

        public Criteria andIdIsNull() {
            addCriterion("id is null");
            return (Criteria) this;
        }

        public Criteria andIdIsNotNull() {
            addCriterion("id is not null");
            return (Criteria) this;
        }

        public Criteria andIdEqualTo(Integer value) {
            addCriterion("id =", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotEqualTo(Integer value) {
            addCriterion("id <>", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThan(Integer value) {
            addCriterion("id >", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("id >=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThan(Integer value) {
            addCriterion("id <", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThanOrEqualTo(Integer value) {
            addCriterion("id <=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdIn(List<Integer> values) {
            addCriterion("id in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotIn(List<Integer> values) {
            addCriterion("id not in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdBetween(Integer value1, Integer value2) {
            addCriterion("id between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotBetween(Integer value1, Integer value2) {
            addCriterion("id not between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andNameIsNull() {
            addCriterion("name is null");
            return (Criteria) this;
        }

        public Criteria andNameIsNotNull() {
            addCriterion("name is not null");
            return (Criteria) this;
        }

        public Criteria andNameEqualTo(String value) {
            addCriterion("name =", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameNotEqualTo(String value) {
            addCriterion("name <>", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameGreaterThan(String value) {
            addCriterion("name >", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameGreaterThanOrEqualTo(String value) {
            addCriterion("name >=", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameLessThan(String value) {
            addCriterion("name <", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameLessThanOrEqualTo(String value) {
            addCriterion("name <=", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameLike(String value) {
            addCriterion("name like", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameNotLike(String value) {
            addCriterion("name not like", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameIn(List<String> values) {
            addCriterion("name in", values, "name");
            return (Criteria) this;
        }

        public Criteria andNameNotIn(List<String> values) {
            addCriterion("name not in", values, "name");
            return (Criteria) this;
        }

        public Criteria andNameBetween(String value1, String value2) {
            addCriterion("name between", value1, value2, "name");
            return (Criteria) this;
        }

        public Criteria andNameNotBetween(String value1, String value2) {
            addCriterion("name not between", value1, value2, "name");
            return (Criteria) this;
        }

        public Criteria andDescriptionIsNull() {
            addCriterion("description is null");
            return (Criteria) this;
        }

        public Criteria andDescriptionIsNotNull() {
            addCriterion("description is not null");
            return (Criteria) this;
        }

        public Criteria andDescriptionEqualTo(String value) {
            addCriterion("description =", value, "description");
            return (Criteria) this;
        }

        public Criteria andDescriptionNotEqualTo(String value) {
            addCriterion("description <>", value, "description");
            return (Criteria) this;
        }

        public Criteria andDescriptionGreaterThan(String value) {
            addCriterion("description >", value, "description");
            return (Criteria) this;
        }

        public Criteria andDescriptionGreaterThanOrEqualTo(String value) {
            addCriterion("description >=", value, "description");
            return (Criteria) this;
        }

        public Criteria andDescriptionLessThan(String value) {
            addCriterion("description <", value, "description");
            return (Criteria) this;
        }

        public Criteria andDescriptionLessThanOrEqualTo(String value) {
            addCriterion("description <=", value, "description");
            return (Criteria) this;
        }

        public Criteria andDescriptionLike(String value) {
            addCriterion("description like", value, "description");
            return (Criteria) this;
        }

        public Criteria andDescriptionNotLike(String value) {
            addCriterion("description not like", value, "description");
            return (Criteria) this;
        }

        public Criteria andDescriptionIn(List<String> values) {
            addCriterion("description in", values, "description");
            return (Criteria) this;
        }

        public Criteria andDescriptionNotIn(List<String> values) {
            addCriterion("description not in", values, "description");
            return (Criteria) this;
        }

        public Criteria andDescriptionBetween(String value1, String value2) {
            addCriterion("description between", value1, value2, "description");
            return (Criteria) this;
        }

        public Criteria andDescriptionNotBetween(String value1, String value2) {
            addCriterion("description not between", value1, value2, "description");
            return (Criteria) this;
        }

        public Criteria andExttimeIsNull() {
            addCriterion("extTime is null");
            return (Criteria) this;
        }

        public Criteria andExttimeIsNotNull() {
            addCriterion("extTime is not null");
            return (Criteria) this;
        }

        public Criteria andExttimeEqualTo(Integer value) {
            addCriterion("extTime =", value, "exttime");
            return (Criteria) this;
        }

        public Criteria andExttimeNotEqualTo(Integer value) {
            addCriterion("extTime <>", value, "exttime");
            return (Criteria) this;
        }

        public Criteria andExttimeGreaterThan(Integer value) {
            addCriterion("extTime >", value, "exttime");
            return (Criteria) this;
        }

        public Criteria andExttimeGreaterThanOrEqualTo(Integer value) {
            addCriterion("extTime >=", value, "exttime");
            return (Criteria) this;
        }

        public Criteria andExttimeLessThan(Integer value) {
            addCriterion("extTime <", value, "exttime");
            return (Criteria) this;
        }

        public Criteria andExttimeLessThanOrEqualTo(Integer value) {
            addCriterion("extTime <=", value, "exttime");
            return (Criteria) this;
        }

        public Criteria andExttimeIn(List<Integer> values) {
            addCriterion("extTime in", values, "exttime");
            return (Criteria) this;
        }

        public Criteria andExttimeNotIn(List<Integer> values) {
            addCriterion("extTime not in", values, "exttime");
            return (Criteria) this;
        }

        public Criteria andExttimeBetween(Integer value1, Integer value2) {
            addCriterion("extTime between", value1, value2, "exttime");
            return (Criteria) this;
        }

        public Criteria andExttimeNotBetween(Integer value1, Integer value2) {
            addCriterion("extTime not between", value1, value2, "exttime");
            return (Criteria) this;
        }

        public Criteria andExtmemoryIsNull() {
            addCriterion("extMemory is null");
            return (Criteria) this;
        }

        public Criteria andExtmemoryIsNotNull() {
            addCriterion("extMemory is not null");
            return (Criteria) this;
        }

        public Criteria andExtmemoryEqualTo(Integer value) {
            addCriterion("extMemory =", value, "extmemory");
            return (Criteria) this;
        }

        public Criteria andExtmemoryNotEqualTo(Integer value) {
            addCriterion("extMemory <>", value, "extmemory");
            return (Criteria) this;
        }

        public Criteria andExtmemoryGreaterThan(Integer value) {
            addCriterion("extMemory >", value, "extmemory");
            return (Criteria) this;
        }

        public Criteria andExtmemoryGreaterThanOrEqualTo(Integer value) {
            addCriterion("extMemory >=", value, "extmemory");
            return (Criteria) this;
        }

        public Criteria andExtmemoryLessThan(Integer value) {
            addCriterion("extMemory <", value, "extmemory");
            return (Criteria) this;
        }

        public Criteria andExtmemoryLessThanOrEqualTo(Integer value) {
            addCriterion("extMemory <=", value, "extmemory");
            return (Criteria) this;
        }

        public Criteria andExtmemoryIn(List<Integer> values) {
            addCriterion("extMemory in", values, "extmemory");
            return (Criteria) this;
        }

        public Criteria andExtmemoryNotIn(List<Integer> values) {
            addCriterion("extMemory not in", values, "extmemory");
            return (Criteria) this;
        }

        public Criteria andExtmemoryBetween(Integer value1, Integer value2) {
            addCriterion("extMemory between", value1, value2, "extmemory");
            return (Criteria) this;
        }

        public Criteria andExtmemoryNotBetween(Integer value1, Integer value2) {
            addCriterion("extMemory not between", value1, value2, "extmemory");
            return (Criteria) this;
        }

        public Criteria andTimefactorIsNull() {
            addCriterion("timeFactor is null");
            return (Criteria) this;
        }

        public Criteria andTimefactorIsNotNull() {
            addCriterion("timeFactor is not null");
            return (Criteria) this;
        }

        public Criteria andTimefactorEqualTo(Byte value) {
            addCriterion("timeFactor =", value, "timefactor");
            return (Criteria) this;
        }

        public Criteria andTimefactorNotEqualTo(Byte value) {
            addCriterion("timeFactor <>", value, "timefactor");
            return (Criteria) this;
        }

        public Criteria andTimefactorGreaterThan(Byte value) {
            addCriterion("timeFactor >", value, "timefactor");
            return (Criteria) this;
        }

        public Criteria andTimefactorGreaterThanOrEqualTo(Byte value) {
            addCriterion("timeFactor >=", value, "timefactor");
            return (Criteria) this;
        }

        public Criteria andTimefactorLessThan(Byte value) {
            addCriterion("timeFactor <", value, "timefactor");
            return (Criteria) this;
        }

        public Criteria andTimefactorLessThanOrEqualTo(Byte value) {
            addCriterion("timeFactor <=", value, "timefactor");
            return (Criteria) this;
        }

        public Criteria andTimefactorIn(List<Byte> values) {
            addCriterion("timeFactor in", values, "timefactor");
            return (Criteria) this;
        }

        public Criteria andTimefactorNotIn(List<Byte> values) {
            addCriterion("timeFactor not in", values, "timefactor");
            return (Criteria) this;
        }

        public Criteria andTimefactorBetween(Byte value1, Byte value2) {
            addCriterion("timeFactor between", value1, value2, "timefactor");
            return (Criteria) this;
        }

        public Criteria andTimefactorNotBetween(Byte value1, Byte value2) {
            addCriterion("timeFactor not between", value1, value2, "timefactor");
            return (Criteria) this;
        }

        public Criteria andMemoryfactorIsNull() {
            addCriterion("memoryFactor is null");
            return (Criteria) this;
        }

        public Criteria andMemoryfactorIsNotNull() {
            addCriterion("memoryFactor is not null");
            return (Criteria) this;
        }

        public Criteria andMemoryfactorEqualTo(Byte value) {
            addCriterion("memoryFactor =", value, "memoryfactor");
            return (Criteria) this;
        }

        public Criteria andMemoryfactorNotEqualTo(Byte value) {
            addCriterion("memoryFactor <>", value, "memoryfactor");
            return (Criteria) this;
        }

        public Criteria andMemoryfactorGreaterThan(Byte value) {
            addCriterion("memoryFactor >", value, "memoryfactor");
            return (Criteria) this;
        }

        public Criteria andMemoryfactorGreaterThanOrEqualTo(Byte value) {
            addCriterion("memoryFactor >=", value, "memoryfactor");
            return (Criteria) this;
        }

        public Criteria andMemoryfactorLessThan(Byte value) {
            addCriterion("memoryFactor <", value, "memoryfactor");
            return (Criteria) this;
        }

        public Criteria andMemoryfactorLessThanOrEqualTo(Byte value) {
            addCriterion("memoryFactor <=", value, "memoryfactor");
            return (Criteria) this;
        }

        public Criteria andMemoryfactorIn(List<Byte> values) {
            addCriterion("memoryFactor in", values, "memoryfactor");
            return (Criteria) this;
        }

        public Criteria andMemoryfactorNotIn(List<Byte> values) {
            addCriterion("memoryFactor not in", values, "memoryfactor");
            return (Criteria) this;
        }

        public Criteria andMemoryfactorBetween(Byte value1, Byte value2) {
            addCriterion("memoryFactor between", value1, value2, "memoryfactor");
            return (Criteria) this;
        }

        public Criteria andMemoryfactorNotBetween(Byte value1, Byte value2) {
            addCriterion("memoryFactor not between", value1, value2, "memoryfactor");
            return (Criteria) this;
        }

        public Criteria andExtIsNull() {
            addCriterion("ext is null");
            return (Criteria) this;
        }

        public Criteria andExtIsNotNull() {
            addCriterion("ext is not null");
            return (Criteria) this;
        }

        public Criteria andExtEqualTo(String value) {
            addCriterion("ext =", value, "ext");
            return (Criteria) this;
        }

        public Criteria andExtNotEqualTo(String value) {
            addCriterion("ext <>", value, "ext");
            return (Criteria) this;
        }

        public Criteria andExtGreaterThan(String value) {
            addCriterion("ext >", value, "ext");
            return (Criteria) this;
        }

        public Criteria andExtGreaterThanOrEqualTo(String value) {
            addCriterion("ext >=", value, "ext");
            return (Criteria) this;
        }

        public Criteria andExtLessThan(String value) {
            addCriterion("ext <", value, "ext");
            return (Criteria) this;
        }

        public Criteria andExtLessThanOrEqualTo(String value) {
            addCriterion("ext <=", value, "ext");
            return (Criteria) this;
        }

        public Criteria andExtLike(String value) {
            addCriterion("ext like", value, "ext");
            return (Criteria) this;
        }

        public Criteria andExtNotLike(String value) {
            addCriterion("ext not like", value, "ext");
            return (Criteria) this;
        }

        public Criteria andExtIn(List<String> values) {
            addCriterion("ext in", values, "ext");
            return (Criteria) this;
        }

        public Criteria andExtNotIn(List<String> values) {
            addCriterion("ext not in", values, "ext");
            return (Criteria) this;
        }

        public Criteria andExtBetween(String value1, String value2) {
            addCriterion("ext between", value1, value2, "ext");
            return (Criteria) this;
        }

        public Criteria andExtNotBetween(String value1, String value2) {
            addCriterion("ext not between", value1, value2, "ext");
            return (Criteria) this;
        }

        public Criteria andExeIsNull() {
            addCriterion("exe is null");
            return (Criteria) this;
        }

        public Criteria andExeIsNotNull() {
            addCriterion("exe is not null");
            return (Criteria) this;
        }

        public Criteria andExeEqualTo(String value) {
            addCriterion("exe =", value, "exe");
            return (Criteria) this;
        }

        public Criteria andExeNotEqualTo(String value) {
            addCriterion("exe <>", value, "exe");
            return (Criteria) this;
        }

        public Criteria andExeGreaterThan(String value) {
            addCriterion("exe >", value, "exe");
            return (Criteria) this;
        }

        public Criteria andExeGreaterThanOrEqualTo(String value) {
            addCriterion("exe >=", value, "exe");
            return (Criteria) this;
        }

        public Criteria andExeLessThan(String value) {
            addCriterion("exe <", value, "exe");
            return (Criteria) this;
        }

        public Criteria andExeLessThanOrEqualTo(String value) {
            addCriterion("exe <=", value, "exe");
            return (Criteria) this;
        }

        public Criteria andExeLike(String value) {
            addCriterion("exe like", value, "exe");
            return (Criteria) this;
        }

        public Criteria andExeNotLike(String value) {
            addCriterion("exe not like", value, "exe");
            return (Criteria) this;
        }

        public Criteria andExeIn(List<String> values) {
            addCriterion("exe in", values, "exe");
            return (Criteria) this;
        }

        public Criteria andExeNotIn(List<String> values) {
            addCriterion("exe not in", values, "exe");
            return (Criteria) this;
        }

        public Criteria andExeBetween(String value1, String value2) {
            addCriterion("exe between", value1, value2, "exe");
            return (Criteria) this;
        }

        public Criteria andExeNotBetween(String value1, String value2) {
            addCriterion("exe not between", value1, value2, "exe");
            return (Criteria) this;
        }

        public Criteria andComplieorderIsNull() {
            addCriterion("complieOrder is null");
            return (Criteria) this;
        }

        public Criteria andComplieorderIsNotNull() {
            addCriterion("complieOrder is not null");
            return (Criteria) this;
        }

        public Criteria andComplieorderEqualTo(Byte value) {
            addCriterion("complieOrder =", value, "complieorder");
            return (Criteria) this;
        }

        public Criteria andComplieorderNotEqualTo(Byte value) {
            addCriterion("complieOrder <>", value, "complieorder");
            return (Criteria) this;
        }

        public Criteria andComplieorderGreaterThan(Byte value) {
            addCriterion("complieOrder >", value, "complieorder");
            return (Criteria) this;
        }

        public Criteria andComplieorderGreaterThanOrEqualTo(Byte value) {
            addCriterion("complieOrder >=", value, "complieorder");
            return (Criteria) this;
        }

        public Criteria andComplieorderLessThan(Byte value) {
            addCriterion("complieOrder <", value, "complieorder");
            return (Criteria) this;
        }

        public Criteria andComplieorderLessThanOrEqualTo(Byte value) {
            addCriterion("complieOrder <=", value, "complieorder");
            return (Criteria) this;
        }

        public Criteria andComplieorderIn(List<Byte> values) {
            addCriterion("complieOrder in", values, "complieorder");
            return (Criteria) this;
        }

        public Criteria andComplieorderNotIn(List<Byte> values) {
            addCriterion("complieOrder not in", values, "complieorder");
            return (Criteria) this;
        }

        public Criteria andComplieorderBetween(Byte value1, Byte value2) {
            addCriterion("complieOrder between", value1, value2, "complieorder");
            return (Criteria) this;
        }

        public Criteria andComplieorderNotBetween(Byte value1, Byte value2) {
            addCriterion("complieOrder not between", value1, value2, "complieorder");
            return (Criteria) this;
        }

        public Criteria andCompilecmdIsNull() {
            addCriterion("compileCmd is null");
            return (Criteria) this;
        }

        public Criteria andCompilecmdIsNotNull() {
            addCriterion("compileCmd is not null");
            return (Criteria) this;
        }

        public Criteria andCompilecmdEqualTo(String value) {
            addCriterion("compileCmd =", value, "compilecmd");
            return (Criteria) this;
        }

        public Criteria andCompilecmdNotEqualTo(String value) {
            addCriterion("compileCmd <>", value, "compilecmd");
            return (Criteria) this;
        }

        public Criteria andCompilecmdGreaterThan(String value) {
            addCriterion("compileCmd >", value, "compilecmd");
            return (Criteria) this;
        }

        public Criteria andCompilecmdGreaterThanOrEqualTo(String value) {
            addCriterion("compileCmd >=", value, "compilecmd");
            return (Criteria) this;
        }

        public Criteria andCompilecmdLessThan(String value) {
            addCriterion("compileCmd <", value, "compilecmd");
            return (Criteria) this;
        }

        public Criteria andCompilecmdLessThanOrEqualTo(String value) {
            addCriterion("compileCmd <=", value, "compilecmd");
            return (Criteria) this;
        }

        public Criteria andCompilecmdLike(String value) {
            addCriterion("compileCmd like", value, "compilecmd");
            return (Criteria) this;
        }

        public Criteria andCompilecmdNotLike(String value) {
            addCriterion("compileCmd not like", value, "compilecmd");
            return (Criteria) this;
        }

        public Criteria andCompilecmdIn(List<String> values) {
            addCriterion("compileCmd in", values, "compilecmd");
            return (Criteria) this;
        }

        public Criteria andCompilecmdNotIn(List<String> values) {
            addCriterion("compileCmd not in", values, "compilecmd");
            return (Criteria) this;
        }

        public Criteria andCompilecmdBetween(String value1, String value2) {
            addCriterion("compileCmd between", value1, value2, "compilecmd");
            return (Criteria) this;
        }

        public Criteria andCompilecmdNotBetween(String value1, String value2) {
            addCriterion("compileCmd not between", value1, value2, "compilecmd");
            return (Criteria) this;
        }

        public Criteria andBrushIsNull() {
            addCriterion("brush is null");
            return (Criteria) this;
        }

        public Criteria andBrushIsNotNull() {
            addCriterion("brush is not null");
            return (Criteria) this;
        }

        public Criteria andBrushEqualTo(String value) {
            addCriterion("brush =", value, "brush");
            return (Criteria) this;
        }

        public Criteria andBrushNotEqualTo(String value) {
            addCriterion("brush <>", value, "brush");
            return (Criteria) this;
        }

        public Criteria andBrushGreaterThan(String value) {
            addCriterion("brush >", value, "brush");
            return (Criteria) this;
        }

        public Criteria andBrushGreaterThanOrEqualTo(String value) {
            addCriterion("brush >=", value, "brush");
            return (Criteria) this;
        }

        public Criteria andBrushLessThan(String value) {
            addCriterion("brush <", value, "brush");
            return (Criteria) this;
        }

        public Criteria andBrushLessThanOrEqualTo(String value) {
            addCriterion("brush <=", value, "brush");
            return (Criteria) this;
        }

        public Criteria andBrushLike(String value) {
            addCriterion("brush like", value, "brush");
            return (Criteria) this;
        }

        public Criteria andBrushNotLike(String value) {
            addCriterion("brush not like", value, "brush");
            return (Criteria) this;
        }

        public Criteria andBrushIn(List<String> values) {
            addCriterion("brush in", values, "brush");
            return (Criteria) this;
        }

        public Criteria andBrushNotIn(List<String> values) {
            addCriterion("brush not in", values, "brush");
            return (Criteria) this;
        }

        public Criteria andBrushBetween(String value1, String value2) {
            addCriterion("brush between", value1, value2, "brush");
            return (Criteria) this;
        }

        public Criteria andBrushNotBetween(String value1, String value2) {
            addCriterion("brush not between", value1, value2, "brush");
            return (Criteria) this;
        }

        public Criteria andScriptIsNull() {
            addCriterion("script is null");
            return (Criteria) this;
        }

        public Criteria andScriptIsNotNull() {
            addCriterion("script is not null");
            return (Criteria) this;
        }

        public Criteria andScriptEqualTo(Boolean value) {
            addCriterion("script =", value, "script");
            return (Criteria) this;
        }

        public Criteria andScriptNotEqualTo(Boolean value) {
            addCriterion("script <>", value, "script");
            return (Criteria) this;
        }

        public Criteria andScriptGreaterThan(Boolean value) {
            addCriterion("script >", value, "script");
            return (Criteria) this;
        }

        public Criteria andScriptGreaterThanOrEqualTo(Boolean value) {
            addCriterion("script >=", value, "script");
            return (Criteria) this;
        }

        public Criteria andScriptLessThan(Boolean value) {
            addCriterion("script <", value, "script");
            return (Criteria) this;
        }

        public Criteria andScriptLessThanOrEqualTo(Boolean value) {
            addCriterion("script <=", value, "script");
            return (Criteria) this;
        }

        public Criteria andScriptIn(List<Boolean> values) {
            addCriterion("script in", values, "script");
            return (Criteria) this;
        }

        public Criteria andScriptNotIn(List<Boolean> values) {
            addCriterion("script not in", values, "script");
            return (Criteria) this;
        }

        public Criteria andScriptBetween(Boolean value1, Boolean value2) {
            addCriterion("script between", value1, value2, "script");
            return (Criteria) this;
        }

        public Criteria andScriptNotBetween(Boolean value1, Boolean value2) {
            addCriterion("script not between", value1, value2, "script");
            return (Criteria) this;
        }

        public Criteria andStatusIsNull() {
            addCriterion("status is null");
            return (Criteria) this;
        }

        public Criteria andStatusIsNotNull() {
            addCriterion("status is not null");
            return (Criteria) this;
        }

        public Criteria andStatusEqualTo(Boolean value) {
            addCriterion("status =", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotEqualTo(Boolean value) {
            addCriterion("status <>", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusGreaterThan(Boolean value) {
            addCriterion("status >", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusGreaterThanOrEqualTo(Boolean value) {
            addCriterion("status >=", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusLessThan(Boolean value) {
            addCriterion("status <", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusLessThanOrEqualTo(Boolean value) {
            addCriterion("status <=", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusIn(List<Boolean> values) {
            addCriterion("status in", values, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotIn(List<Boolean> values) {
            addCriterion("status not in", values, "status");
            return (Criteria) this;
        }

        public Criteria andStatusBetween(Boolean value1, Boolean value2) {
            addCriterion("status between", value1, value2, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotBetween(Boolean value1, Boolean value2) {
            addCriterion("status not between", value1, value2, "status");
            return (Criteria) this;
        }
    }

    /**
     */
    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }
    }

    public static class Criterion {
        private String condition;

        private Object value;

        private Object secondValue;

        private boolean noValue;

        private boolean singleValue;

        private boolean betweenValue;

        private boolean listValue;

        private String typeHandler;

        public String getCondition() {
            return condition;
        }

        public Object getValue() {
            return value;
        }

        public Object getSecondValue() {
            return secondValue;
        }

        public boolean isNoValue() {
            return noValue;
        }

        public boolean isSingleValue() {
            return singleValue;
        }

        public boolean isBetweenValue() {
            return betweenValue;
        }

        public boolean isListValue() {
            return listValue;
        }

        public String getTypeHandler() {
            return typeHandler;
        }

        protected Criterion(String condition) {
            super();
            this.condition = condition;
            this.typeHandler = null;
            this.noValue = true;
        }

        protected Criterion(String condition, Object value, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.typeHandler = typeHandler;
            if (value instanceof List<?>) {
                this.listValue = true;
            } else {
                this.singleValue = true;
            }
        }

        protected Criterion(String condition, Object value) {
            this(condition, value, null);
        }

        protected Criterion(String condition, Object value, Object secondValue, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.secondValue = secondValue;
            this.typeHandler = typeHandler;
            this.betweenValue = true;
        }

        protected Criterion(String condition, Object value, Object secondValue) {
            this(condition, value, secondValue, null);
        }
    }
}