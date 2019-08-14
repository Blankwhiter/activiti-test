package com.example.activititest.po;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ActReModelExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public ActReModelExample() {
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
            addCriterion("ID_ is null");
            return (Criteria) this;
        }

        public Criteria andIdIsNotNull() {
            addCriterion("ID_ is not null");
            return (Criteria) this;
        }

        public Criteria andIdEqualTo(String value) {
            addCriterion("ID_ =", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotEqualTo(String value) {
            addCriterion("ID_ <>", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThan(String value) {
            addCriterion("ID_ >", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThanOrEqualTo(String value) {
            addCriterion("ID_ >=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThan(String value) {
            addCriterion("ID_ <", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThanOrEqualTo(String value) {
            addCriterion("ID_ <=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLike(String value) {
            addCriterion("ID_ like", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotLike(String value) {
            addCriterion("ID_ not like", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdIn(List<String> values) {
            addCriterion("ID_ in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotIn(List<String> values) {
            addCriterion("ID_ not in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdBetween(String value1, String value2) {
            addCriterion("ID_ between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotBetween(String value1, String value2) {
            addCriterion("ID_ not between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andRevIsNull() {
            addCriterion("REV_ is null");
            return (Criteria) this;
        }

        public Criteria andRevIsNotNull() {
            addCriterion("REV_ is not null");
            return (Criteria) this;
        }

        public Criteria andRevEqualTo(Integer value) {
            addCriterion("REV_ =", value, "rev");
            return (Criteria) this;
        }

        public Criteria andRevNotEqualTo(Integer value) {
            addCriterion("REV_ <>", value, "rev");
            return (Criteria) this;
        }

        public Criteria andRevGreaterThan(Integer value) {
            addCriterion("REV_ >", value, "rev");
            return (Criteria) this;
        }

        public Criteria andRevGreaterThanOrEqualTo(Integer value) {
            addCriterion("REV_ >=", value, "rev");
            return (Criteria) this;
        }

        public Criteria andRevLessThan(Integer value) {
            addCriterion("REV_ <", value, "rev");
            return (Criteria) this;
        }

        public Criteria andRevLessThanOrEqualTo(Integer value) {
            addCriterion("REV_ <=", value, "rev");
            return (Criteria) this;
        }

        public Criteria andRevIn(List<Integer> values) {
            addCriterion("REV_ in", values, "rev");
            return (Criteria) this;
        }

        public Criteria andRevNotIn(List<Integer> values) {
            addCriterion("REV_ not in", values, "rev");
            return (Criteria) this;
        }

        public Criteria andRevBetween(Integer value1, Integer value2) {
            addCriterion("REV_ between", value1, value2, "rev");
            return (Criteria) this;
        }

        public Criteria andRevNotBetween(Integer value1, Integer value2) {
            addCriterion("REV_ not between", value1, value2, "rev");
            return (Criteria) this;
        }

        public Criteria andNameIsNull() {
            addCriterion("NAME_ is null");
            return (Criteria) this;
        }

        public Criteria andNameIsNotNull() {
            addCriterion("NAME_ is not null");
            return (Criteria) this;
        }

        public Criteria andNameEqualTo(String value) {
            addCriterion("NAME_ =", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameNotEqualTo(String value) {
            addCriterion("NAME_ <>", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameGreaterThan(String value) {
            addCriterion("NAME_ >", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameGreaterThanOrEqualTo(String value) {
            addCriterion("NAME_ >=", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameLessThan(String value) {
            addCriterion("NAME_ <", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameLessThanOrEqualTo(String value) {
            addCriterion("NAME_ <=", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameLike(String value) {
            addCriterion("NAME_ like", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameNotLike(String value) {
            addCriterion("NAME_ not like", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameIn(List<String> values) {
            addCriterion("NAME_ in", values, "name");
            return (Criteria) this;
        }

        public Criteria andNameNotIn(List<String> values) {
            addCriterion("NAME_ not in", values, "name");
            return (Criteria) this;
        }

        public Criteria andNameBetween(String value1, String value2) {
            addCriterion("NAME_ between", value1, value2, "name");
            return (Criteria) this;
        }

        public Criteria andNameNotBetween(String value1, String value2) {
            addCriterion("NAME_ not between", value1, value2, "name");
            return (Criteria) this;
        }

        public Criteria andKeyIsNull() {
            addCriterion("KEY_ is null");
            return (Criteria) this;
        }

        public Criteria andKeyIsNotNull() {
            addCriterion("KEY_ is not null");
            return (Criteria) this;
        }

        public Criteria andKeyEqualTo(String value) {
            addCriterion("KEY_ =", value, "key");
            return (Criteria) this;
        }

        public Criteria andKeyNotEqualTo(String value) {
            addCriterion("KEY_ <>", value, "key");
            return (Criteria) this;
        }

        public Criteria andKeyGreaterThan(String value) {
            addCriterion("KEY_ >", value, "key");
            return (Criteria) this;
        }

        public Criteria andKeyGreaterThanOrEqualTo(String value) {
            addCriterion("KEY_ >=", value, "key");
            return (Criteria) this;
        }

        public Criteria andKeyLessThan(String value) {
            addCriterion("KEY_ <", value, "key");
            return (Criteria) this;
        }

        public Criteria andKeyLessThanOrEqualTo(String value) {
            addCriterion("KEY_ <=", value, "key");
            return (Criteria) this;
        }

        public Criteria andKeyLike(String value) {
            addCriterion("KEY_ like", value, "key");
            return (Criteria) this;
        }

        public Criteria andKeyNotLike(String value) {
            addCriterion("KEY_ not like", value, "key");
            return (Criteria) this;
        }

        public Criteria andKeyIn(List<String> values) {
            addCriterion("KEY_ in", values, "key");
            return (Criteria) this;
        }

        public Criteria andKeyNotIn(List<String> values) {
            addCriterion("KEY_ not in", values, "key");
            return (Criteria) this;
        }

        public Criteria andKeyBetween(String value1, String value2) {
            addCriterion("KEY_ between", value1, value2, "key");
            return (Criteria) this;
        }

        public Criteria andKeyNotBetween(String value1, String value2) {
            addCriterion("KEY_ not between", value1, value2, "key");
            return (Criteria) this;
        }

        public Criteria andCategoryIsNull() {
            addCriterion("CATEGORY_ is null");
            return (Criteria) this;
        }

        public Criteria andCategoryIsNotNull() {
            addCriterion("CATEGORY_ is not null");
            return (Criteria) this;
        }

        public Criteria andCategoryEqualTo(String value) {
            addCriterion("CATEGORY_ =", value, "category");
            return (Criteria) this;
        }

        public Criteria andCategoryNotEqualTo(String value) {
            addCriterion("CATEGORY_ <>", value, "category");
            return (Criteria) this;
        }

        public Criteria andCategoryGreaterThan(String value) {
            addCriterion("CATEGORY_ >", value, "category");
            return (Criteria) this;
        }

        public Criteria andCategoryGreaterThanOrEqualTo(String value) {
            addCriterion("CATEGORY_ >=", value, "category");
            return (Criteria) this;
        }

        public Criteria andCategoryLessThan(String value) {
            addCriterion("CATEGORY_ <", value, "category");
            return (Criteria) this;
        }

        public Criteria andCategoryLessThanOrEqualTo(String value) {
            addCriterion("CATEGORY_ <=", value, "category");
            return (Criteria) this;
        }

        public Criteria andCategoryLike(String value) {
            addCriterion("CATEGORY_ like", value, "category");
            return (Criteria) this;
        }

        public Criteria andCategoryNotLike(String value) {
            addCriterion("CATEGORY_ not like", value, "category");
            return (Criteria) this;
        }

        public Criteria andCategoryIn(List<String> values) {
            addCriterion("CATEGORY_ in", values, "category");
            return (Criteria) this;
        }

        public Criteria andCategoryNotIn(List<String> values) {
            addCriterion("CATEGORY_ not in", values, "category");
            return (Criteria) this;
        }

        public Criteria andCategoryBetween(String value1, String value2) {
            addCriterion("CATEGORY_ between", value1, value2, "category");
            return (Criteria) this;
        }

        public Criteria andCategoryNotBetween(String value1, String value2) {
            addCriterion("CATEGORY_ not between", value1, value2, "category");
            return (Criteria) this;
        }

        public Criteria andCreateTimeIsNull() {
            addCriterion("CREATE_TIME_ is null");
            return (Criteria) this;
        }

        public Criteria andCreateTimeIsNotNull() {
            addCriterion("CREATE_TIME_ is not null");
            return (Criteria) this;
        }

        public Criteria andCreateTimeEqualTo(Date value) {
            addCriterion("CREATE_TIME_ =", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeNotEqualTo(Date value) {
            addCriterion("CREATE_TIME_ <>", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeGreaterThan(Date value) {
            addCriterion("CREATE_TIME_ >", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("CREATE_TIME_ >=", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeLessThan(Date value) {
            addCriterion("CREATE_TIME_ <", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeLessThanOrEqualTo(Date value) {
            addCriterion("CREATE_TIME_ <=", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeIn(List<Date> values) {
            addCriterion("CREATE_TIME_ in", values, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeNotIn(List<Date> values) {
            addCriterion("CREATE_TIME_ not in", values, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeBetween(Date value1, Date value2) {
            addCriterion("CREATE_TIME_ between", value1, value2, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeNotBetween(Date value1, Date value2) {
            addCriterion("CREATE_TIME_ not between", value1, value2, "createTime");
            return (Criteria) this;
        }

        public Criteria andLastUpdateTimeIsNull() {
            addCriterion("LAST_UPDATE_TIME_ is null");
            return (Criteria) this;
        }

        public Criteria andLastUpdateTimeIsNotNull() {
            addCriterion("LAST_UPDATE_TIME_ is not null");
            return (Criteria) this;
        }

        public Criteria andLastUpdateTimeEqualTo(Date value) {
            addCriterion("LAST_UPDATE_TIME_ =", value, "lastUpdateTime");
            return (Criteria) this;
        }

        public Criteria andLastUpdateTimeNotEqualTo(Date value) {
            addCriterion("LAST_UPDATE_TIME_ <>", value, "lastUpdateTime");
            return (Criteria) this;
        }

        public Criteria andLastUpdateTimeGreaterThan(Date value) {
            addCriterion("LAST_UPDATE_TIME_ >", value, "lastUpdateTime");
            return (Criteria) this;
        }

        public Criteria andLastUpdateTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("LAST_UPDATE_TIME_ >=", value, "lastUpdateTime");
            return (Criteria) this;
        }

        public Criteria andLastUpdateTimeLessThan(Date value) {
            addCriterion("LAST_UPDATE_TIME_ <", value, "lastUpdateTime");
            return (Criteria) this;
        }

        public Criteria andLastUpdateTimeLessThanOrEqualTo(Date value) {
            addCriterion("LAST_UPDATE_TIME_ <=", value, "lastUpdateTime");
            return (Criteria) this;
        }

        public Criteria andLastUpdateTimeIn(List<Date> values) {
            addCriterion("LAST_UPDATE_TIME_ in", values, "lastUpdateTime");
            return (Criteria) this;
        }

        public Criteria andLastUpdateTimeNotIn(List<Date> values) {
            addCriterion("LAST_UPDATE_TIME_ not in", values, "lastUpdateTime");
            return (Criteria) this;
        }

        public Criteria andLastUpdateTimeBetween(Date value1, Date value2) {
            addCriterion("LAST_UPDATE_TIME_ between", value1, value2, "lastUpdateTime");
            return (Criteria) this;
        }

        public Criteria andLastUpdateTimeNotBetween(Date value1, Date value2) {
            addCriterion("LAST_UPDATE_TIME_ not between", value1, value2, "lastUpdateTime");
            return (Criteria) this;
        }

        public Criteria andVersionIsNull() {
            addCriterion("VERSION_ is null");
            return (Criteria) this;
        }

        public Criteria andVersionIsNotNull() {
            addCriterion("VERSION_ is not null");
            return (Criteria) this;
        }

        public Criteria andVersionEqualTo(Integer value) {
            addCriterion("VERSION_ =", value, "version");
            return (Criteria) this;
        }

        public Criteria andVersionNotEqualTo(Integer value) {
            addCriterion("VERSION_ <>", value, "version");
            return (Criteria) this;
        }

        public Criteria andVersionGreaterThan(Integer value) {
            addCriterion("VERSION_ >", value, "version");
            return (Criteria) this;
        }

        public Criteria andVersionGreaterThanOrEqualTo(Integer value) {
            addCriterion("VERSION_ >=", value, "version");
            return (Criteria) this;
        }

        public Criteria andVersionLessThan(Integer value) {
            addCriterion("VERSION_ <", value, "version");
            return (Criteria) this;
        }

        public Criteria andVersionLessThanOrEqualTo(Integer value) {
            addCriterion("VERSION_ <=", value, "version");
            return (Criteria) this;
        }

        public Criteria andVersionIn(List<Integer> values) {
            addCriterion("VERSION_ in", values, "version");
            return (Criteria) this;
        }

        public Criteria andVersionNotIn(List<Integer> values) {
            addCriterion("VERSION_ not in", values, "version");
            return (Criteria) this;
        }

        public Criteria andVersionBetween(Integer value1, Integer value2) {
            addCriterion("VERSION_ between", value1, value2, "version");
            return (Criteria) this;
        }

        public Criteria andVersionNotBetween(Integer value1, Integer value2) {
            addCriterion("VERSION_ not between", value1, value2, "version");
            return (Criteria) this;
        }

        public Criteria andMetaInfoIsNull() {
            addCriterion("META_INFO_ is null");
            return (Criteria) this;
        }

        public Criteria andMetaInfoIsNotNull() {
            addCriterion("META_INFO_ is not null");
            return (Criteria) this;
        }

        public Criteria andMetaInfoEqualTo(String value) {
            addCriterion("META_INFO_ =", value, "metaInfo");
            return (Criteria) this;
        }

        public Criteria andMetaInfoNotEqualTo(String value) {
            addCriterion("META_INFO_ <>", value, "metaInfo");
            return (Criteria) this;
        }

        public Criteria andMetaInfoGreaterThan(String value) {
            addCriterion("META_INFO_ >", value, "metaInfo");
            return (Criteria) this;
        }

        public Criteria andMetaInfoGreaterThanOrEqualTo(String value) {
            addCriterion("META_INFO_ >=", value, "metaInfo");
            return (Criteria) this;
        }

        public Criteria andMetaInfoLessThan(String value) {
            addCriterion("META_INFO_ <", value, "metaInfo");
            return (Criteria) this;
        }

        public Criteria andMetaInfoLessThanOrEqualTo(String value) {
            addCriterion("META_INFO_ <=", value, "metaInfo");
            return (Criteria) this;
        }

        public Criteria andMetaInfoLike(String value) {
            addCriterion("META_INFO_ like", value, "metaInfo");
            return (Criteria) this;
        }

        public Criteria andMetaInfoNotLike(String value) {
            addCriterion("META_INFO_ not like", value, "metaInfo");
            return (Criteria) this;
        }

        public Criteria andMetaInfoIn(List<String> values) {
            addCriterion("META_INFO_ in", values, "metaInfo");
            return (Criteria) this;
        }

        public Criteria andMetaInfoNotIn(List<String> values) {
            addCriterion("META_INFO_ not in", values, "metaInfo");
            return (Criteria) this;
        }

        public Criteria andMetaInfoBetween(String value1, String value2) {
            addCriterion("META_INFO_ between", value1, value2, "metaInfo");
            return (Criteria) this;
        }

        public Criteria andMetaInfoNotBetween(String value1, String value2) {
            addCriterion("META_INFO_ not between", value1, value2, "metaInfo");
            return (Criteria) this;
        }

        public Criteria andDeploymentIdIsNull() {
            addCriterion("DEPLOYMENT_ID_ is null");
            return (Criteria) this;
        }

        public Criteria andDeploymentIdIsNotNull() {
            addCriterion("DEPLOYMENT_ID_ is not null");
            return (Criteria) this;
        }

        public Criteria andDeploymentIdEqualTo(String value) {
            addCriterion("DEPLOYMENT_ID_ =", value, "deploymentId");
            return (Criteria) this;
        }

        public Criteria andDeploymentIdNotEqualTo(String value) {
            addCriterion("DEPLOYMENT_ID_ <>", value, "deploymentId");
            return (Criteria) this;
        }

        public Criteria andDeploymentIdGreaterThan(String value) {
            addCriterion("DEPLOYMENT_ID_ >", value, "deploymentId");
            return (Criteria) this;
        }

        public Criteria andDeploymentIdGreaterThanOrEqualTo(String value) {
            addCriterion("DEPLOYMENT_ID_ >=", value, "deploymentId");
            return (Criteria) this;
        }

        public Criteria andDeploymentIdLessThan(String value) {
            addCriterion("DEPLOYMENT_ID_ <", value, "deploymentId");
            return (Criteria) this;
        }

        public Criteria andDeploymentIdLessThanOrEqualTo(String value) {
            addCriterion("DEPLOYMENT_ID_ <=", value, "deploymentId");
            return (Criteria) this;
        }

        public Criteria andDeploymentIdLike(String value) {
            addCriterion("DEPLOYMENT_ID_ like", value, "deploymentId");
            return (Criteria) this;
        }

        public Criteria andDeploymentIdNotLike(String value) {
            addCriterion("DEPLOYMENT_ID_ not like", value, "deploymentId");
            return (Criteria) this;
        }

        public Criteria andDeploymentIdIn(List<String> values) {
            addCriterion("DEPLOYMENT_ID_ in", values, "deploymentId");
            return (Criteria) this;
        }

        public Criteria andDeploymentIdNotIn(List<String> values) {
            addCriterion("DEPLOYMENT_ID_ not in", values, "deploymentId");
            return (Criteria) this;
        }

        public Criteria andDeploymentIdBetween(String value1, String value2) {
            addCriterion("DEPLOYMENT_ID_ between", value1, value2, "deploymentId");
            return (Criteria) this;
        }

        public Criteria andDeploymentIdNotBetween(String value1, String value2) {
            addCriterion("DEPLOYMENT_ID_ not between", value1, value2, "deploymentId");
            return (Criteria) this;
        }

        public Criteria andEditorSourceValueIdIsNull() {
            addCriterion("EDITOR_SOURCE_VALUE_ID_ is null");
            return (Criteria) this;
        }

        public Criteria andEditorSourceValueIdIsNotNull() {
            addCriterion("EDITOR_SOURCE_VALUE_ID_ is not null");
            return (Criteria) this;
        }

        public Criteria andEditorSourceValueIdEqualTo(String value) {
            addCriterion("EDITOR_SOURCE_VALUE_ID_ =", value, "editorSourceValueId");
            return (Criteria) this;
        }

        public Criteria andEditorSourceValueIdNotEqualTo(String value) {
            addCriterion("EDITOR_SOURCE_VALUE_ID_ <>", value, "editorSourceValueId");
            return (Criteria) this;
        }

        public Criteria andEditorSourceValueIdGreaterThan(String value) {
            addCriterion("EDITOR_SOURCE_VALUE_ID_ >", value, "editorSourceValueId");
            return (Criteria) this;
        }

        public Criteria andEditorSourceValueIdGreaterThanOrEqualTo(String value) {
            addCriterion("EDITOR_SOURCE_VALUE_ID_ >=", value, "editorSourceValueId");
            return (Criteria) this;
        }

        public Criteria andEditorSourceValueIdLessThan(String value) {
            addCriterion("EDITOR_SOURCE_VALUE_ID_ <", value, "editorSourceValueId");
            return (Criteria) this;
        }

        public Criteria andEditorSourceValueIdLessThanOrEqualTo(String value) {
            addCriterion("EDITOR_SOURCE_VALUE_ID_ <=", value, "editorSourceValueId");
            return (Criteria) this;
        }

        public Criteria andEditorSourceValueIdLike(String value) {
            addCriterion("EDITOR_SOURCE_VALUE_ID_ like", value, "editorSourceValueId");
            return (Criteria) this;
        }

        public Criteria andEditorSourceValueIdNotLike(String value) {
            addCriterion("EDITOR_SOURCE_VALUE_ID_ not like", value, "editorSourceValueId");
            return (Criteria) this;
        }

        public Criteria andEditorSourceValueIdIn(List<String> values) {
            addCriterion("EDITOR_SOURCE_VALUE_ID_ in", values, "editorSourceValueId");
            return (Criteria) this;
        }

        public Criteria andEditorSourceValueIdNotIn(List<String> values) {
            addCriterion("EDITOR_SOURCE_VALUE_ID_ not in", values, "editorSourceValueId");
            return (Criteria) this;
        }

        public Criteria andEditorSourceValueIdBetween(String value1, String value2) {
            addCriterion("EDITOR_SOURCE_VALUE_ID_ between", value1, value2, "editorSourceValueId");
            return (Criteria) this;
        }

        public Criteria andEditorSourceValueIdNotBetween(String value1, String value2) {
            addCriterion("EDITOR_SOURCE_VALUE_ID_ not between", value1, value2, "editorSourceValueId");
            return (Criteria) this;
        }

        public Criteria andEditorSourceExtraValueIdIsNull() {
            addCriterion("EDITOR_SOURCE_EXTRA_VALUE_ID_ is null");
            return (Criteria) this;
        }

        public Criteria andEditorSourceExtraValueIdIsNotNull() {
            addCriterion("EDITOR_SOURCE_EXTRA_VALUE_ID_ is not null");
            return (Criteria) this;
        }

        public Criteria andEditorSourceExtraValueIdEqualTo(String value) {
            addCriterion("EDITOR_SOURCE_EXTRA_VALUE_ID_ =", value, "editorSourceExtraValueId");
            return (Criteria) this;
        }

        public Criteria andEditorSourceExtraValueIdNotEqualTo(String value) {
            addCriterion("EDITOR_SOURCE_EXTRA_VALUE_ID_ <>", value, "editorSourceExtraValueId");
            return (Criteria) this;
        }

        public Criteria andEditorSourceExtraValueIdGreaterThan(String value) {
            addCriterion("EDITOR_SOURCE_EXTRA_VALUE_ID_ >", value, "editorSourceExtraValueId");
            return (Criteria) this;
        }

        public Criteria andEditorSourceExtraValueIdGreaterThanOrEqualTo(String value) {
            addCriterion("EDITOR_SOURCE_EXTRA_VALUE_ID_ >=", value, "editorSourceExtraValueId");
            return (Criteria) this;
        }

        public Criteria andEditorSourceExtraValueIdLessThan(String value) {
            addCriterion("EDITOR_SOURCE_EXTRA_VALUE_ID_ <", value, "editorSourceExtraValueId");
            return (Criteria) this;
        }

        public Criteria andEditorSourceExtraValueIdLessThanOrEqualTo(String value) {
            addCriterion("EDITOR_SOURCE_EXTRA_VALUE_ID_ <=", value, "editorSourceExtraValueId");
            return (Criteria) this;
        }

        public Criteria andEditorSourceExtraValueIdLike(String value) {
            addCriterion("EDITOR_SOURCE_EXTRA_VALUE_ID_ like", value, "editorSourceExtraValueId");
            return (Criteria) this;
        }

        public Criteria andEditorSourceExtraValueIdNotLike(String value) {
            addCriterion("EDITOR_SOURCE_EXTRA_VALUE_ID_ not like", value, "editorSourceExtraValueId");
            return (Criteria) this;
        }

        public Criteria andEditorSourceExtraValueIdIn(List<String> values) {
            addCriterion("EDITOR_SOURCE_EXTRA_VALUE_ID_ in", values, "editorSourceExtraValueId");
            return (Criteria) this;
        }

        public Criteria andEditorSourceExtraValueIdNotIn(List<String> values) {
            addCriterion("EDITOR_SOURCE_EXTRA_VALUE_ID_ not in", values, "editorSourceExtraValueId");
            return (Criteria) this;
        }

        public Criteria andEditorSourceExtraValueIdBetween(String value1, String value2) {
            addCriterion("EDITOR_SOURCE_EXTRA_VALUE_ID_ between", value1, value2, "editorSourceExtraValueId");
            return (Criteria) this;
        }

        public Criteria andEditorSourceExtraValueIdNotBetween(String value1, String value2) {
            addCriterion("EDITOR_SOURCE_EXTRA_VALUE_ID_ not between", value1, value2, "editorSourceExtraValueId");
            return (Criteria) this;
        }

        public Criteria andTenantIdIsNull() {
            addCriterion("TENANT_ID_ is null");
            return (Criteria) this;
        }

        public Criteria andTenantIdIsNotNull() {
            addCriterion("TENANT_ID_ is not null");
            return (Criteria) this;
        }

        public Criteria andTenantIdEqualTo(String value) {
            addCriterion("TENANT_ID_ =", value, "tenantId");
            return (Criteria) this;
        }

        public Criteria andTenantIdNotEqualTo(String value) {
            addCriterion("TENANT_ID_ <>", value, "tenantId");
            return (Criteria) this;
        }

        public Criteria andTenantIdGreaterThan(String value) {
            addCriterion("TENANT_ID_ >", value, "tenantId");
            return (Criteria) this;
        }

        public Criteria andTenantIdGreaterThanOrEqualTo(String value) {
            addCriterion("TENANT_ID_ >=", value, "tenantId");
            return (Criteria) this;
        }

        public Criteria andTenantIdLessThan(String value) {
            addCriterion("TENANT_ID_ <", value, "tenantId");
            return (Criteria) this;
        }

        public Criteria andTenantIdLessThanOrEqualTo(String value) {
            addCriterion("TENANT_ID_ <=", value, "tenantId");
            return (Criteria) this;
        }

        public Criteria andTenantIdLike(String value) {
            addCriterion("TENANT_ID_ like", value, "tenantId");
            return (Criteria) this;
        }

        public Criteria andTenantIdNotLike(String value) {
            addCriterion("TENANT_ID_ not like", value, "tenantId");
            return (Criteria) this;
        }

        public Criteria andTenantIdIn(List<String> values) {
            addCriterion("TENANT_ID_ in", values, "tenantId");
            return (Criteria) this;
        }

        public Criteria andTenantIdNotIn(List<String> values) {
            addCriterion("TENANT_ID_ not in", values, "tenantId");
            return (Criteria) this;
        }

        public Criteria andTenantIdBetween(String value1, String value2) {
            addCriterion("TENANT_ID_ between", value1, value2, "tenantId");
            return (Criteria) this;
        }

        public Criteria andTenantIdNotBetween(String value1, String value2) {
            addCriterion("TENANT_ID_ not between", value1, value2, "tenantId");
            return (Criteria) this;
        }
    }

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