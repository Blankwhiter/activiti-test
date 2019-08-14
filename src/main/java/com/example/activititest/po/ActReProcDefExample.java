package com.example.activititest.po;

import java.util.ArrayList;
import java.util.List;

public class ActReProcDefExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public ActReProcDefExample() {
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

        public Criteria andResourceNameIsNull() {
            addCriterion("RESOURCE_NAME_ is null");
            return (Criteria) this;
        }

        public Criteria andResourceNameIsNotNull() {
            addCriterion("RESOURCE_NAME_ is not null");
            return (Criteria) this;
        }

        public Criteria andResourceNameEqualTo(String value) {
            addCriterion("RESOURCE_NAME_ =", value, "resourceName");
            return (Criteria) this;
        }

        public Criteria andResourceNameNotEqualTo(String value) {
            addCriterion("RESOURCE_NAME_ <>", value, "resourceName");
            return (Criteria) this;
        }

        public Criteria andResourceNameGreaterThan(String value) {
            addCriterion("RESOURCE_NAME_ >", value, "resourceName");
            return (Criteria) this;
        }

        public Criteria andResourceNameGreaterThanOrEqualTo(String value) {
            addCriterion("RESOURCE_NAME_ >=", value, "resourceName");
            return (Criteria) this;
        }

        public Criteria andResourceNameLessThan(String value) {
            addCriterion("RESOURCE_NAME_ <", value, "resourceName");
            return (Criteria) this;
        }

        public Criteria andResourceNameLessThanOrEqualTo(String value) {
            addCriterion("RESOURCE_NAME_ <=", value, "resourceName");
            return (Criteria) this;
        }

        public Criteria andResourceNameLike(String value) {
            addCriterion("RESOURCE_NAME_ like", value, "resourceName");
            return (Criteria) this;
        }

        public Criteria andResourceNameNotLike(String value) {
            addCriterion("RESOURCE_NAME_ not like", value, "resourceName");
            return (Criteria) this;
        }

        public Criteria andResourceNameIn(List<String> values) {
            addCriterion("RESOURCE_NAME_ in", values, "resourceName");
            return (Criteria) this;
        }

        public Criteria andResourceNameNotIn(List<String> values) {
            addCriterion("RESOURCE_NAME_ not in", values, "resourceName");
            return (Criteria) this;
        }

        public Criteria andResourceNameBetween(String value1, String value2) {
            addCriterion("RESOURCE_NAME_ between", value1, value2, "resourceName");
            return (Criteria) this;
        }

        public Criteria andResourceNameNotBetween(String value1, String value2) {
            addCriterion("RESOURCE_NAME_ not between", value1, value2, "resourceName");
            return (Criteria) this;
        }

        public Criteria andDgrmResourceNameIsNull() {
            addCriterion("DGRM_RESOURCE_NAME_ is null");
            return (Criteria) this;
        }

        public Criteria andDgrmResourceNameIsNotNull() {
            addCriterion("DGRM_RESOURCE_NAME_ is not null");
            return (Criteria) this;
        }

        public Criteria andDgrmResourceNameEqualTo(String value) {
            addCriterion("DGRM_RESOURCE_NAME_ =", value, "dgrmResourceName");
            return (Criteria) this;
        }

        public Criteria andDgrmResourceNameNotEqualTo(String value) {
            addCriterion("DGRM_RESOURCE_NAME_ <>", value, "dgrmResourceName");
            return (Criteria) this;
        }

        public Criteria andDgrmResourceNameGreaterThan(String value) {
            addCriterion("DGRM_RESOURCE_NAME_ >", value, "dgrmResourceName");
            return (Criteria) this;
        }

        public Criteria andDgrmResourceNameGreaterThanOrEqualTo(String value) {
            addCriterion("DGRM_RESOURCE_NAME_ >=", value, "dgrmResourceName");
            return (Criteria) this;
        }

        public Criteria andDgrmResourceNameLessThan(String value) {
            addCriterion("DGRM_RESOURCE_NAME_ <", value, "dgrmResourceName");
            return (Criteria) this;
        }

        public Criteria andDgrmResourceNameLessThanOrEqualTo(String value) {
            addCriterion("DGRM_RESOURCE_NAME_ <=", value, "dgrmResourceName");
            return (Criteria) this;
        }

        public Criteria andDgrmResourceNameLike(String value) {
            addCriterion("DGRM_RESOURCE_NAME_ like", value, "dgrmResourceName");
            return (Criteria) this;
        }

        public Criteria andDgrmResourceNameNotLike(String value) {
            addCriterion("DGRM_RESOURCE_NAME_ not like", value, "dgrmResourceName");
            return (Criteria) this;
        }

        public Criteria andDgrmResourceNameIn(List<String> values) {
            addCriterion("DGRM_RESOURCE_NAME_ in", values, "dgrmResourceName");
            return (Criteria) this;
        }

        public Criteria andDgrmResourceNameNotIn(List<String> values) {
            addCriterion("DGRM_RESOURCE_NAME_ not in", values, "dgrmResourceName");
            return (Criteria) this;
        }

        public Criteria andDgrmResourceNameBetween(String value1, String value2) {
            addCriterion("DGRM_RESOURCE_NAME_ between", value1, value2, "dgrmResourceName");
            return (Criteria) this;
        }

        public Criteria andDgrmResourceNameNotBetween(String value1, String value2) {
            addCriterion("DGRM_RESOURCE_NAME_ not between", value1, value2, "dgrmResourceName");
            return (Criteria) this;
        }

        public Criteria andDescriptionIsNull() {
            addCriterion("DESCRIPTION_ is null");
            return (Criteria) this;
        }

        public Criteria andDescriptionIsNotNull() {
            addCriterion("DESCRIPTION_ is not null");
            return (Criteria) this;
        }

        public Criteria andDescriptionEqualTo(String value) {
            addCriterion("DESCRIPTION_ =", value, "description");
            return (Criteria) this;
        }

        public Criteria andDescriptionNotEqualTo(String value) {
            addCriterion("DESCRIPTION_ <>", value, "description");
            return (Criteria) this;
        }

        public Criteria andDescriptionGreaterThan(String value) {
            addCriterion("DESCRIPTION_ >", value, "description");
            return (Criteria) this;
        }

        public Criteria andDescriptionGreaterThanOrEqualTo(String value) {
            addCriterion("DESCRIPTION_ >=", value, "description");
            return (Criteria) this;
        }

        public Criteria andDescriptionLessThan(String value) {
            addCriterion("DESCRIPTION_ <", value, "description");
            return (Criteria) this;
        }

        public Criteria andDescriptionLessThanOrEqualTo(String value) {
            addCriterion("DESCRIPTION_ <=", value, "description");
            return (Criteria) this;
        }

        public Criteria andDescriptionLike(String value) {
            addCriterion("DESCRIPTION_ like", value, "description");
            return (Criteria) this;
        }

        public Criteria andDescriptionNotLike(String value) {
            addCriterion("DESCRIPTION_ not like", value, "description");
            return (Criteria) this;
        }

        public Criteria andDescriptionIn(List<String> values) {
            addCriterion("DESCRIPTION_ in", values, "description");
            return (Criteria) this;
        }

        public Criteria andDescriptionNotIn(List<String> values) {
            addCriterion("DESCRIPTION_ not in", values, "description");
            return (Criteria) this;
        }

        public Criteria andDescriptionBetween(String value1, String value2) {
            addCriterion("DESCRIPTION_ between", value1, value2, "description");
            return (Criteria) this;
        }

        public Criteria andDescriptionNotBetween(String value1, String value2) {
            addCriterion("DESCRIPTION_ not between", value1, value2, "description");
            return (Criteria) this;
        }

        public Criteria andHasStartFormKeyIsNull() {
            addCriterion("HAS_START_FORM_KEY_ is null");
            return (Criteria) this;
        }

        public Criteria andHasStartFormKeyIsNotNull() {
            addCriterion("HAS_START_FORM_KEY_ is not null");
            return (Criteria) this;
        }

        public Criteria andHasStartFormKeyEqualTo(Byte value) {
            addCriterion("HAS_START_FORM_KEY_ =", value, "hasStartFormKey");
            return (Criteria) this;
        }

        public Criteria andHasStartFormKeyNotEqualTo(Byte value) {
            addCriterion("HAS_START_FORM_KEY_ <>", value, "hasStartFormKey");
            return (Criteria) this;
        }

        public Criteria andHasStartFormKeyGreaterThan(Byte value) {
            addCriterion("HAS_START_FORM_KEY_ >", value, "hasStartFormKey");
            return (Criteria) this;
        }

        public Criteria andHasStartFormKeyGreaterThanOrEqualTo(Byte value) {
            addCriterion("HAS_START_FORM_KEY_ >=", value, "hasStartFormKey");
            return (Criteria) this;
        }

        public Criteria andHasStartFormKeyLessThan(Byte value) {
            addCriterion("HAS_START_FORM_KEY_ <", value, "hasStartFormKey");
            return (Criteria) this;
        }

        public Criteria andHasStartFormKeyLessThanOrEqualTo(Byte value) {
            addCriterion("HAS_START_FORM_KEY_ <=", value, "hasStartFormKey");
            return (Criteria) this;
        }

        public Criteria andHasStartFormKeyIn(List<Byte> values) {
            addCriterion("HAS_START_FORM_KEY_ in", values, "hasStartFormKey");
            return (Criteria) this;
        }

        public Criteria andHasStartFormKeyNotIn(List<Byte> values) {
            addCriterion("HAS_START_FORM_KEY_ not in", values, "hasStartFormKey");
            return (Criteria) this;
        }

        public Criteria andHasStartFormKeyBetween(Byte value1, Byte value2) {
            addCriterion("HAS_START_FORM_KEY_ between", value1, value2, "hasStartFormKey");
            return (Criteria) this;
        }

        public Criteria andHasStartFormKeyNotBetween(Byte value1, Byte value2) {
            addCriterion("HAS_START_FORM_KEY_ not between", value1, value2, "hasStartFormKey");
            return (Criteria) this;
        }

        public Criteria andHasGraphicalNotationIsNull() {
            addCriterion("HAS_GRAPHICAL_NOTATION_ is null");
            return (Criteria) this;
        }

        public Criteria andHasGraphicalNotationIsNotNull() {
            addCriterion("HAS_GRAPHICAL_NOTATION_ is not null");
            return (Criteria) this;
        }

        public Criteria andHasGraphicalNotationEqualTo(Byte value) {
            addCriterion("HAS_GRAPHICAL_NOTATION_ =", value, "hasGraphicalNotation");
            return (Criteria) this;
        }

        public Criteria andHasGraphicalNotationNotEqualTo(Byte value) {
            addCriterion("HAS_GRAPHICAL_NOTATION_ <>", value, "hasGraphicalNotation");
            return (Criteria) this;
        }

        public Criteria andHasGraphicalNotationGreaterThan(Byte value) {
            addCriterion("HAS_GRAPHICAL_NOTATION_ >", value, "hasGraphicalNotation");
            return (Criteria) this;
        }

        public Criteria andHasGraphicalNotationGreaterThanOrEqualTo(Byte value) {
            addCriterion("HAS_GRAPHICAL_NOTATION_ >=", value, "hasGraphicalNotation");
            return (Criteria) this;
        }

        public Criteria andHasGraphicalNotationLessThan(Byte value) {
            addCriterion("HAS_GRAPHICAL_NOTATION_ <", value, "hasGraphicalNotation");
            return (Criteria) this;
        }

        public Criteria andHasGraphicalNotationLessThanOrEqualTo(Byte value) {
            addCriterion("HAS_GRAPHICAL_NOTATION_ <=", value, "hasGraphicalNotation");
            return (Criteria) this;
        }

        public Criteria andHasGraphicalNotationIn(List<Byte> values) {
            addCriterion("HAS_GRAPHICAL_NOTATION_ in", values, "hasGraphicalNotation");
            return (Criteria) this;
        }

        public Criteria andHasGraphicalNotationNotIn(List<Byte> values) {
            addCriterion("HAS_GRAPHICAL_NOTATION_ not in", values, "hasGraphicalNotation");
            return (Criteria) this;
        }

        public Criteria andHasGraphicalNotationBetween(Byte value1, Byte value2) {
            addCriterion("HAS_GRAPHICAL_NOTATION_ between", value1, value2, "hasGraphicalNotation");
            return (Criteria) this;
        }

        public Criteria andHasGraphicalNotationNotBetween(Byte value1, Byte value2) {
            addCriterion("HAS_GRAPHICAL_NOTATION_ not between", value1, value2, "hasGraphicalNotation");
            return (Criteria) this;
        }

        public Criteria andSuspensionStateIsNull() {
            addCriterion("SUSPENSION_STATE_ is null");
            return (Criteria) this;
        }

        public Criteria andSuspensionStateIsNotNull() {
            addCriterion("SUSPENSION_STATE_ is not null");
            return (Criteria) this;
        }

        public Criteria andSuspensionStateEqualTo(Integer value) {
            addCriterion("SUSPENSION_STATE_ =", value, "suspensionState");
            return (Criteria) this;
        }

        public Criteria andSuspensionStateNotEqualTo(Integer value) {
            addCriterion("SUSPENSION_STATE_ <>", value, "suspensionState");
            return (Criteria) this;
        }

        public Criteria andSuspensionStateGreaterThan(Integer value) {
            addCriterion("SUSPENSION_STATE_ >", value, "suspensionState");
            return (Criteria) this;
        }

        public Criteria andSuspensionStateGreaterThanOrEqualTo(Integer value) {
            addCriterion("SUSPENSION_STATE_ >=", value, "suspensionState");
            return (Criteria) this;
        }

        public Criteria andSuspensionStateLessThan(Integer value) {
            addCriterion("SUSPENSION_STATE_ <", value, "suspensionState");
            return (Criteria) this;
        }

        public Criteria andSuspensionStateLessThanOrEqualTo(Integer value) {
            addCriterion("SUSPENSION_STATE_ <=", value, "suspensionState");
            return (Criteria) this;
        }

        public Criteria andSuspensionStateIn(List<Integer> values) {
            addCriterion("SUSPENSION_STATE_ in", values, "suspensionState");
            return (Criteria) this;
        }

        public Criteria andSuspensionStateNotIn(List<Integer> values) {
            addCriterion("SUSPENSION_STATE_ not in", values, "suspensionState");
            return (Criteria) this;
        }

        public Criteria andSuspensionStateBetween(Integer value1, Integer value2) {
            addCriterion("SUSPENSION_STATE_ between", value1, value2, "suspensionState");
            return (Criteria) this;
        }

        public Criteria andSuspensionStateNotBetween(Integer value1, Integer value2) {
            addCriterion("SUSPENSION_STATE_ not between", value1, value2, "suspensionState");
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

        public Criteria andEngineVersionIsNull() {
            addCriterion("ENGINE_VERSION_ is null");
            return (Criteria) this;
        }

        public Criteria andEngineVersionIsNotNull() {
            addCriterion("ENGINE_VERSION_ is not null");
            return (Criteria) this;
        }

        public Criteria andEngineVersionEqualTo(String value) {
            addCriterion("ENGINE_VERSION_ =", value, "engineVersion");
            return (Criteria) this;
        }

        public Criteria andEngineVersionNotEqualTo(String value) {
            addCriterion("ENGINE_VERSION_ <>", value, "engineVersion");
            return (Criteria) this;
        }

        public Criteria andEngineVersionGreaterThan(String value) {
            addCriterion("ENGINE_VERSION_ >", value, "engineVersion");
            return (Criteria) this;
        }

        public Criteria andEngineVersionGreaterThanOrEqualTo(String value) {
            addCriterion("ENGINE_VERSION_ >=", value, "engineVersion");
            return (Criteria) this;
        }

        public Criteria andEngineVersionLessThan(String value) {
            addCriterion("ENGINE_VERSION_ <", value, "engineVersion");
            return (Criteria) this;
        }

        public Criteria andEngineVersionLessThanOrEqualTo(String value) {
            addCriterion("ENGINE_VERSION_ <=", value, "engineVersion");
            return (Criteria) this;
        }

        public Criteria andEngineVersionLike(String value) {
            addCriterion("ENGINE_VERSION_ like", value, "engineVersion");
            return (Criteria) this;
        }

        public Criteria andEngineVersionNotLike(String value) {
            addCriterion("ENGINE_VERSION_ not like", value, "engineVersion");
            return (Criteria) this;
        }

        public Criteria andEngineVersionIn(List<String> values) {
            addCriterion("ENGINE_VERSION_ in", values, "engineVersion");
            return (Criteria) this;
        }

        public Criteria andEngineVersionNotIn(List<String> values) {
            addCriterion("ENGINE_VERSION_ not in", values, "engineVersion");
            return (Criteria) this;
        }

        public Criteria andEngineVersionBetween(String value1, String value2) {
            addCriterion("ENGINE_VERSION_ between", value1, value2, "engineVersion");
            return (Criteria) this;
        }

        public Criteria andEngineVersionNotBetween(String value1, String value2) {
            addCriterion("ENGINE_VERSION_ not between", value1, value2, "engineVersion");
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