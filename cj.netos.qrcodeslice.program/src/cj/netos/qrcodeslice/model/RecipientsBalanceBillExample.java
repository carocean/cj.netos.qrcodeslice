package cj.netos.qrcodeslice.model;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class RecipientsBalanceBillExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    /**
     * @mbg.generated generated automatically, do not modify!
     */
    public RecipientsBalanceBillExample() {
        oredCriteria = new ArrayList<Criteria>();
    }

    /**
     * @mbg.generated generated automatically, do not modify!
     */
    public void setOrderByClause(String orderByClause) {
        this.orderByClause = orderByClause;
    }

    /**
     * @mbg.generated generated automatically, do not modify!
     */
    public String getOrderByClause() {
        return orderByClause;
    }

    /**
     * @mbg.generated generated automatically, do not modify!
     */
    public void setDistinct(boolean distinct) {
        this.distinct = distinct;
    }

    /**
     * @mbg.generated generated automatically, do not modify!
     */
    public boolean isDistinct() {
        return distinct;
    }

    /**
     * @mbg.generated generated automatically, do not modify!
     */
    public List<Criteria> getOredCriteria() {
        return oredCriteria;
    }

    /**
     * @mbg.generated generated automatically, do not modify!
     */
    public void or(Criteria criteria) {
        oredCriteria.add(criteria);
    }

    /**
     * @mbg.generated generated automatically, do not modify!
     */
    public Criteria or() {
        Criteria criteria = createCriteriaInternal();
        oredCriteria.add(criteria);
        return criteria;
    }

    /**
     * @mbg.generated generated automatically, do not modify!
     */
    public Criteria createCriteria() {
        Criteria criteria = createCriteriaInternal();
        if (oredCriteria.size() == 0) {
            oredCriteria.add(criteria);
        }
        return criteria;
    }

    /**
     * @mbg.generated generated automatically, do not modify!
     */
    protected Criteria createCriteriaInternal() {
        Criteria criteria = new Criteria();
        return criteria;
    }

    /**
     * @mbg.generated generated automatically, do not modify!
     */
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

        public Criteria andSnIsNull() {
            addCriterion("sn is null");
            return (Criteria) this;
        }

        public Criteria andSnIsNotNull() {
            addCriterion("sn is not null");
            return (Criteria) this;
        }

        public Criteria andSnEqualTo(String value) {
            addCriterion("sn =", value, "sn");
            return (Criteria) this;
        }

        public Criteria andSnNotEqualTo(String value) {
            addCriterion("sn <>", value, "sn");
            return (Criteria) this;
        }

        public Criteria andSnGreaterThan(String value) {
            addCriterion("sn >", value, "sn");
            return (Criteria) this;
        }

        public Criteria andSnGreaterThanOrEqualTo(String value) {
            addCriterion("sn >=", value, "sn");
            return (Criteria) this;
        }

        public Criteria andSnLessThan(String value) {
            addCriterion("sn <", value, "sn");
            return (Criteria) this;
        }

        public Criteria andSnLessThanOrEqualTo(String value) {
            addCriterion("sn <=", value, "sn");
            return (Criteria) this;
        }

        public Criteria andSnLike(String value) {
            addCriterion("sn like", value, "sn");
            return (Criteria) this;
        }

        public Criteria andSnNotLike(String value) {
            addCriterion("sn not like", value, "sn");
            return (Criteria) this;
        }

        public Criteria andSnIn(List<String> values) {
            addCriterion("sn in", values, "sn");
            return (Criteria) this;
        }

        public Criteria andSnNotIn(List<String> values) {
            addCriterion("sn not in", values, "sn");
            return (Criteria) this;
        }

        public Criteria andSnBetween(String value1, String value2) {
            addCriterion("sn between", value1, value2, "sn");
            return (Criteria) this;
        }

        public Criteria andSnNotBetween(String value1, String value2) {
            addCriterion("sn not between", value1, value2, "sn");
            return (Criteria) this;
        }

        public Criteria andTitleIsNull() {
            addCriterion("title is null");
            return (Criteria) this;
        }

        public Criteria andTitleIsNotNull() {
            addCriterion("title is not null");
            return (Criteria) this;
        }

        public Criteria andTitleEqualTo(String value) {
            addCriterion("title =", value, "title");
            return (Criteria) this;
        }

        public Criteria andTitleNotEqualTo(String value) {
            addCriterion("title <>", value, "title");
            return (Criteria) this;
        }

        public Criteria andTitleGreaterThan(String value) {
            addCriterion("title >", value, "title");
            return (Criteria) this;
        }

        public Criteria andTitleGreaterThanOrEqualTo(String value) {
            addCriterion("title >=", value, "title");
            return (Criteria) this;
        }

        public Criteria andTitleLessThan(String value) {
            addCriterion("title <", value, "title");
            return (Criteria) this;
        }

        public Criteria andTitleLessThanOrEqualTo(String value) {
            addCriterion("title <=", value, "title");
            return (Criteria) this;
        }

        public Criteria andTitleLike(String value) {
            addCriterion("title like", value, "title");
            return (Criteria) this;
        }

        public Criteria andTitleNotLike(String value) {
            addCriterion("title not like", value, "title");
            return (Criteria) this;
        }

        public Criteria andTitleIn(List<String> values) {
            addCriterion("title in", values, "title");
            return (Criteria) this;
        }

        public Criteria andTitleNotIn(List<String> values) {
            addCriterion("title not in", values, "title");
            return (Criteria) this;
        }

        public Criteria andTitleBetween(String value1, String value2) {
            addCriterion("title between", value1, value2, "title");
            return (Criteria) this;
        }

        public Criteria andTitleNotBetween(String value1, String value2) {
            addCriterion("title not between", value1, value2, "title");
            return (Criteria) this;
        }

        public Criteria andPersonIsNull() {
            addCriterion("person is null");
            return (Criteria) this;
        }

        public Criteria andPersonIsNotNull() {
            addCriterion("person is not null");
            return (Criteria) this;
        }

        public Criteria andPersonEqualTo(String value) {
            addCriterion("person =", value, "person");
            return (Criteria) this;
        }

        public Criteria andPersonNotEqualTo(String value) {
            addCriterion("person <>", value, "person");
            return (Criteria) this;
        }

        public Criteria andPersonGreaterThan(String value) {
            addCriterion("person >", value, "person");
            return (Criteria) this;
        }

        public Criteria andPersonGreaterThanOrEqualTo(String value) {
            addCriterion("person >=", value, "person");
            return (Criteria) this;
        }

        public Criteria andPersonLessThan(String value) {
            addCriterion("person <", value, "person");
            return (Criteria) this;
        }

        public Criteria andPersonLessThanOrEqualTo(String value) {
            addCriterion("person <=", value, "person");
            return (Criteria) this;
        }

        public Criteria andPersonLike(String value) {
            addCriterion("person like", value, "person");
            return (Criteria) this;
        }

        public Criteria andPersonNotLike(String value) {
            addCriterion("person not like", value, "person");
            return (Criteria) this;
        }

        public Criteria andPersonIn(List<String> values) {
            addCriterion("person in", values, "person");
            return (Criteria) this;
        }

        public Criteria andPersonNotIn(List<String> values) {
            addCriterion("person not in", values, "person");
            return (Criteria) this;
        }

        public Criteria andPersonBetween(String value1, String value2) {
            addCriterion("person between", value1, value2, "person");
            return (Criteria) this;
        }

        public Criteria andPersonNotBetween(String value1, String value2) {
            addCriterion("person not between", value1, value2, "person");
            return (Criteria) this;
        }

        public Criteria andPersonNameIsNull() {
            addCriterion("person_name is null");
            return (Criteria) this;
        }

        public Criteria andPersonNameIsNotNull() {
            addCriterion("person_name is not null");
            return (Criteria) this;
        }

        public Criteria andPersonNameEqualTo(String value) {
            addCriterion("person_name =", value, "personName");
            return (Criteria) this;
        }

        public Criteria andPersonNameNotEqualTo(String value) {
            addCriterion("person_name <>", value, "personName");
            return (Criteria) this;
        }

        public Criteria andPersonNameGreaterThan(String value) {
            addCriterion("person_name >", value, "personName");
            return (Criteria) this;
        }

        public Criteria andPersonNameGreaterThanOrEqualTo(String value) {
            addCriterion("person_name >=", value, "personName");
            return (Criteria) this;
        }

        public Criteria andPersonNameLessThan(String value) {
            addCriterion("person_name <", value, "personName");
            return (Criteria) this;
        }

        public Criteria andPersonNameLessThanOrEqualTo(String value) {
            addCriterion("person_name <=", value, "personName");
            return (Criteria) this;
        }

        public Criteria andPersonNameLike(String value) {
            addCriterion("person_name like", value, "personName");
            return (Criteria) this;
        }

        public Criteria andPersonNameNotLike(String value) {
            addCriterion("person_name not like", value, "personName");
            return (Criteria) this;
        }

        public Criteria andPersonNameIn(List<String> values) {
            addCriterion("person_name in", values, "personName");
            return (Criteria) this;
        }

        public Criteria andPersonNameNotIn(List<String> values) {
            addCriterion("person_name not in", values, "personName");
            return (Criteria) this;
        }

        public Criteria andPersonNameBetween(String value1, String value2) {
            addCriterion("person_name between", value1, value2, "personName");
            return (Criteria) this;
        }

        public Criteria andPersonNameNotBetween(String value1, String value2) {
            addCriterion("person_name not between", value1, value2, "personName");
            return (Criteria) this;
        }

        public Criteria andRecipientsIdIsNull() {
            addCriterion("recipients_id is null");
            return (Criteria) this;
        }

        public Criteria andRecipientsIdIsNotNull() {
            addCriterion("recipients_id is not null");
            return (Criteria) this;
        }

        public Criteria andRecipientsIdEqualTo(String value) {
            addCriterion("recipients_id =", value, "recipientsId");
            return (Criteria) this;
        }

        public Criteria andRecipientsIdNotEqualTo(String value) {
            addCriterion("recipients_id <>", value, "recipientsId");
            return (Criteria) this;
        }

        public Criteria andRecipientsIdGreaterThan(String value) {
            addCriterion("recipients_id >", value, "recipientsId");
            return (Criteria) this;
        }

        public Criteria andRecipientsIdGreaterThanOrEqualTo(String value) {
            addCriterion("recipients_id >=", value, "recipientsId");
            return (Criteria) this;
        }

        public Criteria andRecipientsIdLessThan(String value) {
            addCriterion("recipients_id <", value, "recipientsId");
            return (Criteria) this;
        }

        public Criteria andRecipientsIdLessThanOrEqualTo(String value) {
            addCriterion("recipients_id <=", value, "recipientsId");
            return (Criteria) this;
        }

        public Criteria andRecipientsIdLike(String value) {
            addCriterion("recipients_id like", value, "recipientsId");
            return (Criteria) this;
        }

        public Criteria andRecipientsIdNotLike(String value) {
            addCriterion("recipients_id not like", value, "recipientsId");
            return (Criteria) this;
        }

        public Criteria andRecipientsIdIn(List<String> values) {
            addCriterion("recipients_id in", values, "recipientsId");
            return (Criteria) this;
        }

        public Criteria andRecipientsIdNotIn(List<String> values) {
            addCriterion("recipients_id not in", values, "recipientsId");
            return (Criteria) this;
        }

        public Criteria andRecipientsIdBetween(String value1, String value2) {
            addCriterion("recipients_id between", value1, value2, "recipientsId");
            return (Criteria) this;
        }

        public Criteria andRecipientsIdNotBetween(String value1, String value2) {
            addCriterion("recipients_id not between", value1, value2, "recipientsId");
            return (Criteria) this;
        }

        public Criteria andQrcodeSliceIsNull() {
            addCriterion("qrcode_slice is null");
            return (Criteria) this;
        }

        public Criteria andQrcodeSliceIsNotNull() {
            addCriterion("qrcode_slice is not null");
            return (Criteria) this;
        }

        public Criteria andQrcodeSliceEqualTo(String value) {
            addCriterion("qrcode_slice =", value, "qrcodeSlice");
            return (Criteria) this;
        }

        public Criteria andQrcodeSliceNotEqualTo(String value) {
            addCriterion("qrcode_slice <>", value, "qrcodeSlice");
            return (Criteria) this;
        }

        public Criteria andQrcodeSliceGreaterThan(String value) {
            addCriterion("qrcode_slice >", value, "qrcodeSlice");
            return (Criteria) this;
        }

        public Criteria andQrcodeSliceGreaterThanOrEqualTo(String value) {
            addCriterion("qrcode_slice >=", value, "qrcodeSlice");
            return (Criteria) this;
        }

        public Criteria andQrcodeSliceLessThan(String value) {
            addCriterion("qrcode_slice <", value, "qrcodeSlice");
            return (Criteria) this;
        }

        public Criteria andQrcodeSliceLessThanOrEqualTo(String value) {
            addCriterion("qrcode_slice <=", value, "qrcodeSlice");
            return (Criteria) this;
        }

        public Criteria andQrcodeSliceLike(String value) {
            addCriterion("qrcode_slice like", value, "qrcodeSlice");
            return (Criteria) this;
        }

        public Criteria andQrcodeSliceNotLike(String value) {
            addCriterion("qrcode_slice not like", value, "qrcodeSlice");
            return (Criteria) this;
        }

        public Criteria andQrcodeSliceIn(List<String> values) {
            addCriterion("qrcode_slice in", values, "qrcodeSlice");
            return (Criteria) this;
        }

        public Criteria andQrcodeSliceNotIn(List<String> values) {
            addCriterion("qrcode_slice not in", values, "qrcodeSlice");
            return (Criteria) this;
        }

        public Criteria andQrcodeSliceBetween(String value1, String value2) {
            addCriterion("qrcode_slice between", value1, value2, "qrcodeSlice");
            return (Criteria) this;
        }

        public Criteria andQrcodeSliceNotBetween(String value1, String value2) {
            addCriterion("qrcode_slice not between", value1, value2, "qrcodeSlice");
            return (Criteria) this;
        }

        public Criteria andAbsorberIsNull() {
            addCriterion("absorber is null");
            return (Criteria) this;
        }

        public Criteria andAbsorberIsNotNull() {
            addCriterion("absorber is not null");
            return (Criteria) this;
        }

        public Criteria andAbsorberEqualTo(String value) {
            addCriterion("absorber =", value, "absorber");
            return (Criteria) this;
        }

        public Criteria andAbsorberNotEqualTo(String value) {
            addCriterion("absorber <>", value, "absorber");
            return (Criteria) this;
        }

        public Criteria andAbsorberGreaterThan(String value) {
            addCriterion("absorber >", value, "absorber");
            return (Criteria) this;
        }

        public Criteria andAbsorberGreaterThanOrEqualTo(String value) {
            addCriterion("absorber >=", value, "absorber");
            return (Criteria) this;
        }

        public Criteria andAbsorberLessThan(String value) {
            addCriterion("absorber <", value, "absorber");
            return (Criteria) this;
        }

        public Criteria andAbsorberLessThanOrEqualTo(String value) {
            addCriterion("absorber <=", value, "absorber");
            return (Criteria) this;
        }

        public Criteria andAbsorberLike(String value) {
            addCriterion("absorber like", value, "absorber");
            return (Criteria) this;
        }

        public Criteria andAbsorberNotLike(String value) {
            addCriterion("absorber not like", value, "absorber");
            return (Criteria) this;
        }

        public Criteria andAbsorberIn(List<String> values) {
            addCriterion("absorber in", values, "absorber");
            return (Criteria) this;
        }

        public Criteria andAbsorberNotIn(List<String> values) {
            addCriterion("absorber not in", values, "absorber");
            return (Criteria) this;
        }

        public Criteria andAbsorberBetween(String value1, String value2) {
            addCriterion("absorber between", value1, value2, "absorber");
            return (Criteria) this;
        }

        public Criteria andAbsorberNotBetween(String value1, String value2) {
            addCriterion("absorber not between", value1, value2, "absorber");
            return (Criteria) this;
        }

        public Criteria andAmountIsNull() {
            addCriterion("amount is null");
            return (Criteria) this;
        }

        public Criteria andAmountIsNotNull() {
            addCriterion("amount is not null");
            return (Criteria) this;
        }

        public Criteria andAmountEqualTo(BigDecimal value) {
            addCriterion("amount =", value, "amount");
            return (Criteria) this;
        }

        public Criteria andAmountNotEqualTo(BigDecimal value) {
            addCriterion("amount <>", value, "amount");
            return (Criteria) this;
        }

        public Criteria andAmountGreaterThan(BigDecimal value) {
            addCriterion("amount >", value, "amount");
            return (Criteria) this;
        }

        public Criteria andAmountGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("amount >=", value, "amount");
            return (Criteria) this;
        }

        public Criteria andAmountLessThan(BigDecimal value) {
            addCriterion("amount <", value, "amount");
            return (Criteria) this;
        }

        public Criteria andAmountLessThanOrEqualTo(BigDecimal value) {
            addCriterion("amount <=", value, "amount");
            return (Criteria) this;
        }

        public Criteria andAmountIn(List<BigDecimal> values) {
            addCriterion("amount in", values, "amount");
            return (Criteria) this;
        }

        public Criteria andAmountNotIn(List<BigDecimal> values) {
            addCriterion("amount not in", values, "amount");
            return (Criteria) this;
        }

        public Criteria andAmountBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("amount between", value1, value2, "amount");
            return (Criteria) this;
        }

        public Criteria andAmountNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("amount not between", value1, value2, "amount");
            return (Criteria) this;
        }

        public Criteria andBalanceIsNull() {
            addCriterion("balance is null");
            return (Criteria) this;
        }

        public Criteria andBalanceIsNotNull() {
            addCriterion("balance is not null");
            return (Criteria) this;
        }

        public Criteria andBalanceEqualTo(BigDecimal value) {
            addCriterion("balance =", value, "balance");
            return (Criteria) this;
        }

        public Criteria andBalanceNotEqualTo(BigDecimal value) {
            addCriterion("balance <>", value, "balance");
            return (Criteria) this;
        }

        public Criteria andBalanceGreaterThan(BigDecimal value) {
            addCriterion("balance >", value, "balance");
            return (Criteria) this;
        }

        public Criteria andBalanceGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("balance >=", value, "balance");
            return (Criteria) this;
        }

        public Criteria andBalanceLessThan(BigDecimal value) {
            addCriterion("balance <", value, "balance");
            return (Criteria) this;
        }

        public Criteria andBalanceLessThanOrEqualTo(BigDecimal value) {
            addCriterion("balance <=", value, "balance");
            return (Criteria) this;
        }

        public Criteria andBalanceIn(List<BigDecimal> values) {
            addCriterion("balance in", values, "balance");
            return (Criteria) this;
        }

        public Criteria andBalanceNotIn(List<BigDecimal> values) {
            addCriterion("balance not in", values, "balance");
            return (Criteria) this;
        }

        public Criteria andBalanceBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("balance between", value1, value2, "balance");
            return (Criteria) this;
        }

        public Criteria andBalanceNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("balance not between", value1, value2, "balance");
            return (Criteria) this;
        }

        public Criteria andOrderIsNull() {
            addCriterion("`order` is null");
            return (Criteria) this;
        }

        public Criteria andOrderIsNotNull() {
            addCriterion("`order` is not null");
            return (Criteria) this;
        }

        public Criteria andOrderEqualTo(Integer value) {
            addCriterion("`order` =", value, "order");
            return (Criteria) this;
        }

        public Criteria andOrderNotEqualTo(Integer value) {
            addCriterion("`order` <>", value, "order");
            return (Criteria) this;
        }

        public Criteria andOrderGreaterThan(Integer value) {
            addCriterion("`order` >", value, "order");
            return (Criteria) this;
        }

        public Criteria andOrderGreaterThanOrEqualTo(Integer value) {
            addCriterion("`order` >=", value, "order");
            return (Criteria) this;
        }

        public Criteria andOrderLessThan(Integer value) {
            addCriterion("`order` <", value, "order");
            return (Criteria) this;
        }

        public Criteria andOrderLessThanOrEqualTo(Integer value) {
            addCriterion("`order` <=", value, "order");
            return (Criteria) this;
        }

        public Criteria andOrderIn(List<Integer> values) {
            addCriterion("`order` in", values, "order");
            return (Criteria) this;
        }

        public Criteria andOrderNotIn(List<Integer> values) {
            addCriterion("`order` not in", values, "order");
            return (Criteria) this;
        }

        public Criteria andOrderBetween(Integer value1, Integer value2) {
            addCriterion("`order` between", value1, value2, "order");
            return (Criteria) this;
        }

        public Criteria andOrderNotBetween(Integer value1, Integer value2) {
            addCriterion("`order` not between", value1, value2, "order");
            return (Criteria) this;
        }

        public Criteria andRefSnIsNull() {
            addCriterion("ref_sn is null");
            return (Criteria) this;
        }

        public Criteria andRefSnIsNotNull() {
            addCriterion("ref_sn is not null");
            return (Criteria) this;
        }

        public Criteria andRefSnEqualTo(String value) {
            addCriterion("ref_sn =", value, "refSn");
            return (Criteria) this;
        }

        public Criteria andRefSnNotEqualTo(String value) {
            addCriterion("ref_sn <>", value, "refSn");
            return (Criteria) this;
        }

        public Criteria andRefSnGreaterThan(String value) {
            addCriterion("ref_sn >", value, "refSn");
            return (Criteria) this;
        }

        public Criteria andRefSnGreaterThanOrEqualTo(String value) {
            addCriterion("ref_sn >=", value, "refSn");
            return (Criteria) this;
        }

        public Criteria andRefSnLessThan(String value) {
            addCriterion("ref_sn <", value, "refSn");
            return (Criteria) this;
        }

        public Criteria andRefSnLessThanOrEqualTo(String value) {
            addCriterion("ref_sn <=", value, "refSn");
            return (Criteria) this;
        }

        public Criteria andRefSnLike(String value) {
            addCriterion("ref_sn like", value, "refSn");
            return (Criteria) this;
        }

        public Criteria andRefSnNotLike(String value) {
            addCriterion("ref_sn not like", value, "refSn");
            return (Criteria) this;
        }

        public Criteria andRefSnIn(List<String> values) {
            addCriterion("ref_sn in", values, "refSn");
            return (Criteria) this;
        }

        public Criteria andRefSnNotIn(List<String> values) {
            addCriterion("ref_sn not in", values, "refSn");
            return (Criteria) this;
        }

        public Criteria andRefSnBetween(String value1, String value2) {
            addCriterion("ref_sn between", value1, value2, "refSn");
            return (Criteria) this;
        }

        public Criteria andRefSnNotBetween(String value1, String value2) {
            addCriterion("ref_sn not between", value1, value2, "refSn");
            return (Criteria) this;
        }

        public Criteria andCtimeIsNull() {
            addCriterion("ctime is null");
            return (Criteria) this;
        }

        public Criteria andCtimeIsNotNull() {
            addCriterion("ctime is not null");
            return (Criteria) this;
        }

        public Criteria andCtimeEqualTo(String value) {
            addCriterion("ctime =", value, "ctime");
            return (Criteria) this;
        }

        public Criteria andCtimeNotEqualTo(String value) {
            addCriterion("ctime <>", value, "ctime");
            return (Criteria) this;
        }

        public Criteria andCtimeGreaterThan(String value) {
            addCriterion("ctime >", value, "ctime");
            return (Criteria) this;
        }

        public Criteria andCtimeGreaterThanOrEqualTo(String value) {
            addCriterion("ctime >=", value, "ctime");
            return (Criteria) this;
        }

        public Criteria andCtimeLessThan(String value) {
            addCriterion("ctime <", value, "ctime");
            return (Criteria) this;
        }

        public Criteria andCtimeLessThanOrEqualTo(String value) {
            addCriterion("ctime <=", value, "ctime");
            return (Criteria) this;
        }

        public Criteria andCtimeLike(String value) {
            addCriterion("ctime like", value, "ctime");
            return (Criteria) this;
        }

        public Criteria andCtimeNotLike(String value) {
            addCriterion("ctime not like", value, "ctime");
            return (Criteria) this;
        }

        public Criteria andCtimeIn(List<String> values) {
            addCriterion("ctime in", values, "ctime");
            return (Criteria) this;
        }

        public Criteria andCtimeNotIn(List<String> values) {
            addCriterion("ctime not in", values, "ctime");
            return (Criteria) this;
        }

        public Criteria andCtimeBetween(String value1, String value2) {
            addCriterion("ctime between", value1, value2, "ctime");
            return (Criteria) this;
        }

        public Criteria andCtimeNotBetween(String value1, String value2) {
            addCriterion("ctime not between", value1, value2, "ctime");
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