package x.superman.pojo.generator;

import java.util.ArrayList;
import java.util.List;

public class TbkCommodityExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public TbkCommodityExample() {
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
            addCriterion("id is null");
            return (Criteria) this;
        }

        public Criteria andIdIsNotNull() {
            addCriterion("id is not null");
            return (Criteria) this;
        }

        public Criteria andIdEqualTo(String value) {
            addCriterion("id =", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotEqualTo(String value) {
            addCriterion("id <>", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThan(String value) {
            addCriterion("id >", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThanOrEqualTo(String value) {
            addCriterion("id >=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThan(String value) {
            addCriterion("id <", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThanOrEqualTo(String value) {
            addCriterion("id <=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLike(String value) {
            addCriterion("id like", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotLike(String value) {
            addCriterion("id not like", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdIn(List<String> values) {
            addCriterion("id in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotIn(List<String> values) {
            addCriterion("id not in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdBetween(String value1, String value2) {
            addCriterion("id between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotBetween(String value1, String value2) {
            addCriterion("id not between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andSpidIsNull() {
            addCriterion("spid is null");
            return (Criteria) this;
        }

        public Criteria andSpidIsNotNull() {
            addCriterion("spid is not null");
            return (Criteria) this;
        }

        public Criteria andSpidEqualTo(String value) {
            addCriterion("spid =", value, "spid");
            return (Criteria) this;
        }

        public Criteria andSpidNotEqualTo(String value) {
            addCriterion("spid <>", value, "spid");
            return (Criteria) this;
        }

        public Criteria andSpidGreaterThan(String value) {
            addCriterion("spid >", value, "spid");
            return (Criteria) this;
        }

        public Criteria andSpidGreaterThanOrEqualTo(String value) {
            addCriterion("spid >=", value, "spid");
            return (Criteria) this;
        }

        public Criteria andSpidLessThan(String value) {
            addCriterion("spid <", value, "spid");
            return (Criteria) this;
        }

        public Criteria andSpidLessThanOrEqualTo(String value) {
            addCriterion("spid <=", value, "spid");
            return (Criteria) this;
        }

        public Criteria andSpidLike(String value) {
            addCriterion("spid like", value, "spid");
            return (Criteria) this;
        }

        public Criteria andSpidNotLike(String value) {
            addCriterion("spid not like", value, "spid");
            return (Criteria) this;
        }

        public Criteria andSpidIn(List<String> values) {
            addCriterion("spid in", values, "spid");
            return (Criteria) this;
        }

        public Criteria andSpidNotIn(List<String> values) {
            addCriterion("spid not in", values, "spid");
            return (Criteria) this;
        }

        public Criteria andSpidBetween(String value1, String value2) {
            addCriterion("spid between", value1, value2, "spid");
            return (Criteria) this;
        }

        public Criteria andSpidNotBetween(String value1, String value2) {
            addCriterion("spid not between", value1, value2, "spid");
            return (Criteria) this;
        }

        public Criteria andSpmcIsNull() {
            addCriterion("spmc is null");
            return (Criteria) this;
        }

        public Criteria andSpmcIsNotNull() {
            addCriterion("spmc is not null");
            return (Criteria) this;
        }

        public Criteria andSpmcEqualTo(String value) {
            addCriterion("spmc =", value, "spmc");
            return (Criteria) this;
        }

        public Criteria andSpmcNotEqualTo(String value) {
            addCriterion("spmc <>", value, "spmc");
            return (Criteria) this;
        }

        public Criteria andSpmcGreaterThan(String value) {
            addCriterion("spmc >", value, "spmc");
            return (Criteria) this;
        }

        public Criteria andSpmcGreaterThanOrEqualTo(String value) {
            addCriterion("spmc >=", value, "spmc");
            return (Criteria) this;
        }

        public Criteria andSpmcLessThan(String value) {
            addCriterion("spmc <", value, "spmc");
            return (Criteria) this;
        }

        public Criteria andSpmcLessThanOrEqualTo(String value) {
            addCriterion("spmc <=", value, "spmc");
            return (Criteria) this;
        }

        public Criteria andSpmcLike(String value) {
            addCriterion("spmc like", value, "spmc");
            return (Criteria) this;
        }

        public Criteria andSpmcNotLike(String value) {
            addCriterion("spmc not like", value, "spmc");
            return (Criteria) this;
        }

        public Criteria andSpmcIn(List<String> values) {
            addCriterion("spmc in", values, "spmc");
            return (Criteria) this;
        }

        public Criteria andSpmcNotIn(List<String> values) {
            addCriterion("spmc not in", values, "spmc");
            return (Criteria) this;
        }

        public Criteria andSpmcBetween(String value1, String value2) {
            addCriterion("spmc between", value1, value2, "spmc");
            return (Criteria) this;
        }

        public Criteria andSpmcNotBetween(String value1, String value2) {
            addCriterion("spmc not between", value1, value2, "spmc");
            return (Criteria) this;
        }

        public Criteria andSpztIsNull() {
            addCriterion("spzt is null");
            return (Criteria) this;
        }

        public Criteria andSpztIsNotNull() {
            addCriterion("spzt is not null");
            return (Criteria) this;
        }

        public Criteria andSpztEqualTo(String value) {
            addCriterion("spzt =", value, "spzt");
            return (Criteria) this;
        }

        public Criteria andSpztNotEqualTo(String value) {
            addCriterion("spzt <>", value, "spzt");
            return (Criteria) this;
        }

        public Criteria andSpztGreaterThan(String value) {
            addCriterion("spzt >", value, "spzt");
            return (Criteria) this;
        }

        public Criteria andSpztGreaterThanOrEqualTo(String value) {
            addCriterion("spzt >=", value, "spzt");
            return (Criteria) this;
        }

        public Criteria andSpztLessThan(String value) {
            addCriterion("spzt <", value, "spzt");
            return (Criteria) this;
        }

        public Criteria andSpztLessThanOrEqualTo(String value) {
            addCriterion("spzt <=", value, "spzt");
            return (Criteria) this;
        }

        public Criteria andSpztLike(String value) {
            addCriterion("spzt like", value, "spzt");
            return (Criteria) this;
        }

        public Criteria andSpztNotLike(String value) {
            addCriterion("spzt not like", value, "spzt");
            return (Criteria) this;
        }

        public Criteria andSpztIn(List<String> values) {
            addCriterion("spzt in", values, "spzt");
            return (Criteria) this;
        }

        public Criteria andSpztNotIn(List<String> values) {
            addCriterion("spzt not in", values, "spzt");
            return (Criteria) this;
        }

        public Criteria andSpztBetween(String value1, String value2) {
            addCriterion("spzt between", value1, value2, "spzt");
            return (Criteria) this;
        }

        public Criteria andSpztNotBetween(String value1, String value2) {
            addCriterion("spzt not between", value1, value2, "spzt");
            return (Criteria) this;
        }

        public Criteria andSpxqyIsNull() {
            addCriterion("spxqy is null");
            return (Criteria) this;
        }

        public Criteria andSpxqyIsNotNull() {
            addCriterion("spxqy is not null");
            return (Criteria) this;
        }

        public Criteria andSpxqyEqualTo(String value) {
            addCriterion("spxqy =", value, "spxqy");
            return (Criteria) this;
        }

        public Criteria andSpxqyNotEqualTo(String value) {
            addCriterion("spxqy <>", value, "spxqy");
            return (Criteria) this;
        }

        public Criteria andSpxqyGreaterThan(String value) {
            addCriterion("spxqy >", value, "spxqy");
            return (Criteria) this;
        }

        public Criteria andSpxqyGreaterThanOrEqualTo(String value) {
            addCriterion("spxqy >=", value, "spxqy");
            return (Criteria) this;
        }

        public Criteria andSpxqyLessThan(String value) {
            addCriterion("spxqy <", value, "spxqy");
            return (Criteria) this;
        }

        public Criteria andSpxqyLessThanOrEqualTo(String value) {
            addCriterion("spxqy <=", value, "spxqy");
            return (Criteria) this;
        }

        public Criteria andSpxqyLike(String value) {
            addCriterion("spxqy like", value, "spxqy");
            return (Criteria) this;
        }

        public Criteria andSpxqyNotLike(String value) {
            addCriterion("spxqy not like", value, "spxqy");
            return (Criteria) this;
        }

        public Criteria andSpxqyIn(List<String> values) {
            addCriterion("spxqy in", values, "spxqy");
            return (Criteria) this;
        }

        public Criteria andSpxqyNotIn(List<String> values) {
            addCriterion("spxqy not in", values, "spxqy");
            return (Criteria) this;
        }

        public Criteria andSpxqyBetween(String value1, String value2) {
            addCriterion("spxqy between", value1, value2, "spxqy");
            return (Criteria) this;
        }

        public Criteria andSpxqyNotBetween(String value1, String value2) {
            addCriterion("spxqy not between", value1, value2, "spxqy");
            return (Criteria) this;
        }

        public Criteria andSmyjlmIsNull() {
            addCriterion("smyjlm is null");
            return (Criteria) this;
        }

        public Criteria andSmyjlmIsNotNull() {
            addCriterion("smyjlm is not null");
            return (Criteria) this;
        }

        public Criteria andSmyjlmEqualTo(String value) {
            addCriterion("smyjlm =", value, "smyjlm");
            return (Criteria) this;
        }

        public Criteria andSmyjlmNotEqualTo(String value) {
            addCriterion("smyjlm <>", value, "smyjlm");
            return (Criteria) this;
        }

        public Criteria andSmyjlmGreaterThan(String value) {
            addCriterion("smyjlm >", value, "smyjlm");
            return (Criteria) this;
        }

        public Criteria andSmyjlmGreaterThanOrEqualTo(String value) {
            addCriterion("smyjlm >=", value, "smyjlm");
            return (Criteria) this;
        }

        public Criteria andSmyjlmLessThan(String value) {
            addCriterion("smyjlm <", value, "smyjlm");
            return (Criteria) this;
        }

        public Criteria andSmyjlmLessThanOrEqualTo(String value) {
            addCriterion("smyjlm <=", value, "smyjlm");
            return (Criteria) this;
        }

        public Criteria andSmyjlmLike(String value) {
            addCriterion("smyjlm like", value, "smyjlm");
            return (Criteria) this;
        }

        public Criteria andSmyjlmNotLike(String value) {
            addCriterion("smyjlm not like", value, "smyjlm");
            return (Criteria) this;
        }

        public Criteria andSmyjlmIn(List<String> values) {
            addCriterion("smyjlm in", values, "smyjlm");
            return (Criteria) this;
        }

        public Criteria andSmyjlmNotIn(List<String> values) {
            addCriterion("smyjlm not in", values, "smyjlm");
            return (Criteria) this;
        }

        public Criteria andSmyjlmBetween(String value1, String value2) {
            addCriterion("smyjlm between", value1, value2, "smyjlm");
            return (Criteria) this;
        }

        public Criteria andSmyjlmNotBetween(String value1, String value2) {
            addCriterion("smyjlm not between", value1, value2, "smyjlm");
            return (Criteria) this;
        }

        public Criteria andTbkljIsNull() {
            addCriterion("tbklj is null");
            return (Criteria) this;
        }

        public Criteria andTbkljIsNotNull() {
            addCriterion("tbklj is not null");
            return (Criteria) this;
        }

        public Criteria andTbkljEqualTo(String value) {
            addCriterion("tbklj =", value, "tbklj");
            return (Criteria) this;
        }

        public Criteria andTbkljNotEqualTo(String value) {
            addCriterion("tbklj <>", value, "tbklj");
            return (Criteria) this;
        }

        public Criteria andTbkljGreaterThan(String value) {
            addCriterion("tbklj >", value, "tbklj");
            return (Criteria) this;
        }

        public Criteria andTbkljGreaterThanOrEqualTo(String value) {
            addCriterion("tbklj >=", value, "tbklj");
            return (Criteria) this;
        }

        public Criteria andTbkljLessThan(String value) {
            addCriterion("tbklj <", value, "tbklj");
            return (Criteria) this;
        }

        public Criteria andTbkljLessThanOrEqualTo(String value) {
            addCriterion("tbklj <=", value, "tbklj");
            return (Criteria) this;
        }

        public Criteria andTbkljLike(String value) {
            addCriterion("tbklj like", value, "tbklj");
            return (Criteria) this;
        }

        public Criteria andTbkljNotLike(String value) {
            addCriterion("tbklj not like", value, "tbklj");
            return (Criteria) this;
        }

        public Criteria andTbkljIn(List<String> values) {
            addCriterion("tbklj in", values, "tbklj");
            return (Criteria) this;
        }

        public Criteria andTbkljNotIn(List<String> values) {
            addCriterion("tbklj not in", values, "tbklj");
            return (Criteria) this;
        }

        public Criteria andTbkljBetween(String value1, String value2) {
            addCriterion("tbklj between", value1, value2, "tbklj");
            return (Criteria) this;
        }

        public Criteria andTbkljNotBetween(String value1, String value2) {
            addCriterion("tbklj not between", value1, value2, "tbklj");
            return (Criteria) this;
        }

        public Criteria andSpjgIsNull() {
            addCriterion("spjg is null");
            return (Criteria) this;
        }

        public Criteria andSpjgIsNotNull() {
            addCriterion("spjg is not null");
            return (Criteria) this;
        }

        public Criteria andSpjgEqualTo(String value) {
            addCriterion("spjg =", value, "spjg");
            return (Criteria) this;
        }

        public Criteria andSpjgNotEqualTo(String value) {
            addCriterion("spjg <>", value, "spjg");
            return (Criteria) this;
        }

        public Criteria andSpjgGreaterThan(String value) {
            addCriterion("spjg >", value, "spjg");
            return (Criteria) this;
        }

        public Criteria andSpjgGreaterThanOrEqualTo(String value) {
            addCriterion("spjg >=", value, "spjg");
            return (Criteria) this;
        }

        public Criteria andSpjgLessThan(String value) {
            addCriterion("spjg <", value, "spjg");
            return (Criteria) this;
        }

        public Criteria andSpjgLessThanOrEqualTo(String value) {
            addCriterion("spjg <=", value, "spjg");
            return (Criteria) this;
        }

        public Criteria andSpjgLike(String value) {
            addCriterion("spjg like", value, "spjg");
            return (Criteria) this;
        }

        public Criteria andSpjgNotLike(String value) {
            addCriterion("spjg not like", value, "spjg");
            return (Criteria) this;
        }

        public Criteria andSpjgIn(List<String> values) {
            addCriterion("spjg in", values, "spjg");
            return (Criteria) this;
        }

        public Criteria andSpjgNotIn(List<String> values) {
            addCriterion("spjg not in", values, "spjg");
            return (Criteria) this;
        }

        public Criteria andSpjgBetween(String value1, String value2) {
            addCriterion("spjg between", value1, value2, "spjg");
            return (Criteria) this;
        }

        public Criteria andSpjgNotBetween(String value1, String value2) {
            addCriterion("spjg not between", value1, value2, "spjg");
            return (Criteria) this;
        }

        public Criteria andSpyslIsNull() {
            addCriterion("spysl is null");
            return (Criteria) this;
        }

        public Criteria andSpyslIsNotNull() {
            addCriterion("spysl is not null");
            return (Criteria) this;
        }

        public Criteria andSpyslEqualTo(String value) {
            addCriterion("spysl =", value, "spysl");
            return (Criteria) this;
        }

        public Criteria andSpyslNotEqualTo(String value) {
            addCriterion("spysl <>", value, "spysl");
            return (Criteria) this;
        }

        public Criteria andSpyslGreaterThan(String value) {
            addCriterion("spysl >", value, "spysl");
            return (Criteria) this;
        }

        public Criteria andSpyslGreaterThanOrEqualTo(String value) {
            addCriterion("spysl >=", value, "spysl");
            return (Criteria) this;
        }

        public Criteria andSpyslLessThan(String value) {
            addCriterion("spysl <", value, "spysl");
            return (Criteria) this;
        }

        public Criteria andSpyslLessThanOrEqualTo(String value) {
            addCriterion("spysl <=", value, "spysl");
            return (Criteria) this;
        }

        public Criteria andSpyslLike(String value) {
            addCriterion("spysl like", value, "spysl");
            return (Criteria) this;
        }

        public Criteria andSpyslNotLike(String value) {
            addCriterion("spysl not like", value, "spysl");
            return (Criteria) this;
        }

        public Criteria andSpyslIn(List<String> values) {
            addCriterion("spysl in", values, "spysl");
            return (Criteria) this;
        }

        public Criteria andSpyslNotIn(List<String> values) {
            addCriterion("spysl not in", values, "spysl");
            return (Criteria) this;
        }

        public Criteria andSpyslBetween(String value1, String value2) {
            addCriterion("spysl between", value1, value2, "spysl");
            return (Criteria) this;
        }

        public Criteria andSpyslNotBetween(String value1, String value2) {
            addCriterion("spysl not between", value1, value2, "spysl");
            return (Criteria) this;
        }

        public Criteria andSrblIsNull() {
            addCriterion("srbl is null");
            return (Criteria) this;
        }

        public Criteria andSrblIsNotNull() {
            addCriterion("srbl is not null");
            return (Criteria) this;
        }

        public Criteria andSrblEqualTo(String value) {
            addCriterion("srbl =", value, "srbl");
            return (Criteria) this;
        }

        public Criteria andSrblNotEqualTo(String value) {
            addCriterion("srbl <>", value, "srbl");
            return (Criteria) this;
        }

        public Criteria andSrblGreaterThan(String value) {
            addCriterion("srbl >", value, "srbl");
            return (Criteria) this;
        }

        public Criteria andSrblGreaterThanOrEqualTo(String value) {
            addCriterion("srbl >=", value, "srbl");
            return (Criteria) this;
        }

        public Criteria andSrblLessThan(String value) {
            addCriterion("srbl <", value, "srbl");
            return (Criteria) this;
        }

        public Criteria andSrblLessThanOrEqualTo(String value) {
            addCriterion("srbl <=", value, "srbl");
            return (Criteria) this;
        }

        public Criteria andSrblLike(String value) {
            addCriterion("srbl like", value, "srbl");
            return (Criteria) this;
        }

        public Criteria andSrblNotLike(String value) {
            addCriterion("srbl not like", value, "srbl");
            return (Criteria) this;
        }

        public Criteria andSrblIn(List<String> values) {
            addCriterion("srbl in", values, "srbl");
            return (Criteria) this;
        }

        public Criteria andSrblNotIn(List<String> values) {
            addCriterion("srbl not in", values, "srbl");
            return (Criteria) this;
        }

        public Criteria andSrblBetween(String value1, String value2) {
            addCriterion("srbl between", value1, value2, "srbl");
            return (Criteria) this;
        }

        public Criteria andSrblNotBetween(String value1, String value2) {
            addCriterion("srbl not between", value1, value2, "srbl");
            return (Criteria) this;
        }

        public Criteria andYjIsNull() {
            addCriterion("yj is null");
            return (Criteria) this;
        }

        public Criteria andYjIsNotNull() {
            addCriterion("yj is not null");
            return (Criteria) this;
        }

        public Criteria andYjEqualTo(String value) {
            addCriterion("yj =", value, "yj");
            return (Criteria) this;
        }

        public Criteria andYjNotEqualTo(String value) {
            addCriterion("yj <>", value, "yj");
            return (Criteria) this;
        }

        public Criteria andYjGreaterThan(String value) {
            addCriterion("yj >", value, "yj");
            return (Criteria) this;
        }

        public Criteria andYjGreaterThanOrEqualTo(String value) {
            addCriterion("yj >=", value, "yj");
            return (Criteria) this;
        }

        public Criteria andYjLessThan(String value) {
            addCriterion("yj <", value, "yj");
            return (Criteria) this;
        }

        public Criteria andYjLessThanOrEqualTo(String value) {
            addCriterion("yj <=", value, "yj");
            return (Criteria) this;
        }

        public Criteria andYjLike(String value) {
            addCriterion("yj like", value, "yj");
            return (Criteria) this;
        }

        public Criteria andYjNotLike(String value) {
            addCriterion("yj not like", value, "yj");
            return (Criteria) this;
        }

        public Criteria andYjIn(List<String> values) {
            addCriterion("yj in", values, "yj");
            return (Criteria) this;
        }

        public Criteria andYjNotIn(List<String> values) {
            addCriterion("yj not in", values, "yj");
            return (Criteria) this;
        }

        public Criteria andYjBetween(String value1, String value2) {
            addCriterion("yj between", value1, value2, "yj");
            return (Criteria) this;
        }

        public Criteria andYjNotBetween(String value1, String value2) {
            addCriterion("yj not between", value1, value2, "yj");
            return (Criteria) this;
        }

        public Criteria andMjwwIsNull() {
            addCriterion("mjww is null");
            return (Criteria) this;
        }

        public Criteria andMjwwIsNotNull() {
            addCriterion("mjww is not null");
            return (Criteria) this;
        }

        public Criteria andMjwwEqualTo(String value) {
            addCriterion("mjww =", value, "mjww");
            return (Criteria) this;
        }

        public Criteria andMjwwNotEqualTo(String value) {
            addCriterion("mjww <>", value, "mjww");
            return (Criteria) this;
        }

        public Criteria andMjwwGreaterThan(String value) {
            addCriterion("mjww >", value, "mjww");
            return (Criteria) this;
        }

        public Criteria andMjwwGreaterThanOrEqualTo(String value) {
            addCriterion("mjww >=", value, "mjww");
            return (Criteria) this;
        }

        public Criteria andMjwwLessThan(String value) {
            addCriterion("mjww <", value, "mjww");
            return (Criteria) this;
        }

        public Criteria andMjwwLessThanOrEqualTo(String value) {
            addCriterion("mjww <=", value, "mjww");
            return (Criteria) this;
        }

        public Criteria andMjwwLike(String value) {
            addCriterion("mjww like", value, "mjww");
            return (Criteria) this;
        }

        public Criteria andMjwwNotLike(String value) {
            addCriterion("mjww not like", value, "mjww");
            return (Criteria) this;
        }

        public Criteria andMjwwIn(List<String> values) {
            addCriterion("mjww in", values, "mjww");
            return (Criteria) this;
        }

        public Criteria andMjwwNotIn(List<String> values) {
            addCriterion("mjww not in", values, "mjww");
            return (Criteria) this;
        }

        public Criteria andMjwwBetween(String value1, String value2) {
            addCriterion("mjww between", value1, value2, "mjww");
            return (Criteria) this;
        }

        public Criteria andMjwwNotBetween(String value1, String value2) {
            addCriterion("mjww not between", value1, value2, "mjww");
            return (Criteria) this;
        }

        public Criteria andMjidIsNull() {
            addCriterion("mjid is null");
            return (Criteria) this;
        }

        public Criteria andMjidIsNotNull() {
            addCriterion("mjid is not null");
            return (Criteria) this;
        }

        public Criteria andMjidEqualTo(String value) {
            addCriterion("mjid =", value, "mjid");
            return (Criteria) this;
        }

        public Criteria andMjidNotEqualTo(String value) {
            addCriterion("mjid <>", value, "mjid");
            return (Criteria) this;
        }

        public Criteria andMjidGreaterThan(String value) {
            addCriterion("mjid >", value, "mjid");
            return (Criteria) this;
        }

        public Criteria andMjidGreaterThanOrEqualTo(String value) {
            addCriterion("mjid >=", value, "mjid");
            return (Criteria) this;
        }

        public Criteria andMjidLessThan(String value) {
            addCriterion("mjid <", value, "mjid");
            return (Criteria) this;
        }

        public Criteria andMjidLessThanOrEqualTo(String value) {
            addCriterion("mjid <=", value, "mjid");
            return (Criteria) this;
        }

        public Criteria andMjidLike(String value) {
            addCriterion("mjid like", value, "mjid");
            return (Criteria) this;
        }

        public Criteria andMjidNotLike(String value) {
            addCriterion("mjid not like", value, "mjid");
            return (Criteria) this;
        }

        public Criteria andMjidIn(List<String> values) {
            addCriterion("mjid in", values, "mjid");
            return (Criteria) this;
        }

        public Criteria andMjidNotIn(List<String> values) {
            addCriterion("mjid not in", values, "mjid");
            return (Criteria) this;
        }

        public Criteria andMjidBetween(String value1, String value2) {
            addCriterion("mjid between", value1, value2, "mjid");
            return (Criteria) this;
        }

        public Criteria andMjidNotBetween(String value1, String value2) {
            addCriterion("mjid not between", value1, value2, "mjid");
            return (Criteria) this;
        }

        public Criteria andDpmcIsNull() {
            addCriterion("dpmc is null");
            return (Criteria) this;
        }

        public Criteria andDpmcIsNotNull() {
            addCriterion("dpmc is not null");
            return (Criteria) this;
        }

        public Criteria andDpmcEqualTo(String value) {
            addCriterion("dpmc =", value, "dpmc");
            return (Criteria) this;
        }

        public Criteria andDpmcNotEqualTo(String value) {
            addCriterion("dpmc <>", value, "dpmc");
            return (Criteria) this;
        }

        public Criteria andDpmcGreaterThan(String value) {
            addCriterion("dpmc >", value, "dpmc");
            return (Criteria) this;
        }

        public Criteria andDpmcGreaterThanOrEqualTo(String value) {
            addCriterion("dpmc >=", value, "dpmc");
            return (Criteria) this;
        }

        public Criteria andDpmcLessThan(String value) {
            addCriterion("dpmc <", value, "dpmc");
            return (Criteria) this;
        }

        public Criteria andDpmcLessThanOrEqualTo(String value) {
            addCriterion("dpmc <=", value, "dpmc");
            return (Criteria) this;
        }

        public Criteria andDpmcLike(String value) {
            addCriterion("dpmc like", value, "dpmc");
            return (Criteria) this;
        }

        public Criteria andDpmcNotLike(String value) {
            addCriterion("dpmc not like", value, "dpmc");
            return (Criteria) this;
        }

        public Criteria andDpmcIn(List<String> values) {
            addCriterion("dpmc in", values, "dpmc");
            return (Criteria) this;
        }

        public Criteria andDpmcNotIn(List<String> values) {
            addCriterion("dpmc not in", values, "dpmc");
            return (Criteria) this;
        }

        public Criteria andDpmcBetween(String value1, String value2) {
            addCriterion("dpmc between", value1, value2, "dpmc");
            return (Criteria) this;
        }

        public Criteria andDpmcNotBetween(String value1, String value2) {
            addCriterion("dpmc not between", value1, value2, "dpmc");
            return (Criteria) this;
        }

        public Criteria andPtlxIsNull() {
            addCriterion("ptlx is null");
            return (Criteria) this;
        }

        public Criteria andPtlxIsNotNull() {
            addCriterion("ptlx is not null");
            return (Criteria) this;
        }

        public Criteria andPtlxEqualTo(String value) {
            addCriterion("ptlx =", value, "ptlx");
            return (Criteria) this;
        }

        public Criteria andPtlxNotEqualTo(String value) {
            addCriterion("ptlx <>", value, "ptlx");
            return (Criteria) this;
        }

        public Criteria andPtlxGreaterThan(String value) {
            addCriterion("ptlx >", value, "ptlx");
            return (Criteria) this;
        }

        public Criteria andPtlxGreaterThanOrEqualTo(String value) {
            addCriterion("ptlx >=", value, "ptlx");
            return (Criteria) this;
        }

        public Criteria andPtlxLessThan(String value) {
            addCriterion("ptlx <", value, "ptlx");
            return (Criteria) this;
        }

        public Criteria andPtlxLessThanOrEqualTo(String value) {
            addCriterion("ptlx <=", value, "ptlx");
            return (Criteria) this;
        }

        public Criteria andPtlxLike(String value) {
            addCriterion("ptlx like", value, "ptlx");
            return (Criteria) this;
        }

        public Criteria andPtlxNotLike(String value) {
            addCriterion("ptlx not like", value, "ptlx");
            return (Criteria) this;
        }

        public Criteria andPtlxIn(List<String> values) {
            addCriterion("ptlx in", values, "ptlx");
            return (Criteria) this;
        }

        public Criteria andPtlxNotIn(List<String> values) {
            addCriterion("ptlx not in", values, "ptlx");
            return (Criteria) this;
        }

        public Criteria andPtlxBetween(String value1, String value2) {
            addCriterion("ptlx between", value1, value2, "ptlx");
            return (Criteria) this;
        }

        public Criteria andPtlxNotBetween(String value1, String value2) {
            addCriterion("ptlx not between", value1, value2, "ptlx");
            return (Criteria) this;
        }

        public Criteria andYhqidIsNull() {
            addCriterion("yhqid is null");
            return (Criteria) this;
        }

        public Criteria andYhqidIsNotNull() {
            addCriterion("yhqid is not null");
            return (Criteria) this;
        }

        public Criteria andYhqidEqualTo(String value) {
            addCriterion("yhqid =", value, "yhqid");
            return (Criteria) this;
        }

        public Criteria andYhqidNotEqualTo(String value) {
            addCriterion("yhqid <>", value, "yhqid");
            return (Criteria) this;
        }

        public Criteria andYhqidGreaterThan(String value) {
            addCriterion("yhqid >", value, "yhqid");
            return (Criteria) this;
        }

        public Criteria andYhqidGreaterThanOrEqualTo(String value) {
            addCriterion("yhqid >=", value, "yhqid");
            return (Criteria) this;
        }

        public Criteria andYhqidLessThan(String value) {
            addCriterion("yhqid <", value, "yhqid");
            return (Criteria) this;
        }

        public Criteria andYhqidLessThanOrEqualTo(String value) {
            addCriterion("yhqid <=", value, "yhqid");
            return (Criteria) this;
        }

        public Criteria andYhqidLike(String value) {
            addCriterion("yhqid like", value, "yhqid");
            return (Criteria) this;
        }

        public Criteria andYhqidNotLike(String value) {
            addCriterion("yhqid not like", value, "yhqid");
            return (Criteria) this;
        }

        public Criteria andYhqidIn(List<String> values) {
            addCriterion("yhqid in", values, "yhqid");
            return (Criteria) this;
        }

        public Criteria andYhqidNotIn(List<String> values) {
            addCriterion("yhqid not in", values, "yhqid");
            return (Criteria) this;
        }

        public Criteria andYhqidBetween(String value1, String value2) {
            addCriterion("yhqid between", value1, value2, "yhqid");
            return (Criteria) this;
        }

        public Criteria andYhqidNotBetween(String value1, String value2) {
            addCriterion("yhqid not between", value1, value2, "yhqid");
            return (Criteria) this;
        }

        public Criteria andYhqzlIsNull() {
            addCriterion("yhqzl is null");
            return (Criteria) this;
        }

        public Criteria andYhqzlIsNotNull() {
            addCriterion("yhqzl is not null");
            return (Criteria) this;
        }

        public Criteria andYhqzlEqualTo(String value) {
            addCriterion("yhqzl =", value, "yhqzl");
            return (Criteria) this;
        }

        public Criteria andYhqzlNotEqualTo(String value) {
            addCriterion("yhqzl <>", value, "yhqzl");
            return (Criteria) this;
        }

        public Criteria andYhqzlGreaterThan(String value) {
            addCriterion("yhqzl >", value, "yhqzl");
            return (Criteria) this;
        }

        public Criteria andYhqzlGreaterThanOrEqualTo(String value) {
            addCriterion("yhqzl >=", value, "yhqzl");
            return (Criteria) this;
        }

        public Criteria andYhqzlLessThan(String value) {
            addCriterion("yhqzl <", value, "yhqzl");
            return (Criteria) this;
        }

        public Criteria andYhqzlLessThanOrEqualTo(String value) {
            addCriterion("yhqzl <=", value, "yhqzl");
            return (Criteria) this;
        }

        public Criteria andYhqzlLike(String value) {
            addCriterion("yhqzl like", value, "yhqzl");
            return (Criteria) this;
        }

        public Criteria andYhqzlNotLike(String value) {
            addCriterion("yhqzl not like", value, "yhqzl");
            return (Criteria) this;
        }

        public Criteria andYhqzlIn(List<String> values) {
            addCriterion("yhqzl in", values, "yhqzl");
            return (Criteria) this;
        }

        public Criteria andYhqzlNotIn(List<String> values) {
            addCriterion("yhqzl not in", values, "yhqzl");
            return (Criteria) this;
        }

        public Criteria andYhqzlBetween(String value1, String value2) {
            addCriterion("yhqzl between", value1, value2, "yhqzl");
            return (Criteria) this;
        }

        public Criteria andYhqzlNotBetween(String value1, String value2) {
            addCriterion("yhqzl not between", value1, value2, "yhqzl");
            return (Criteria) this;
        }

        public Criteria andYhqsylIsNull() {
            addCriterion("yhqsyl is null");
            return (Criteria) this;
        }

        public Criteria andYhqsylIsNotNull() {
            addCriterion("yhqsyl is not null");
            return (Criteria) this;
        }

        public Criteria andYhqsylEqualTo(String value) {
            addCriterion("yhqsyl =", value, "yhqsyl");
            return (Criteria) this;
        }

        public Criteria andYhqsylNotEqualTo(String value) {
            addCriterion("yhqsyl <>", value, "yhqsyl");
            return (Criteria) this;
        }

        public Criteria andYhqsylGreaterThan(String value) {
            addCriterion("yhqsyl >", value, "yhqsyl");
            return (Criteria) this;
        }

        public Criteria andYhqsylGreaterThanOrEqualTo(String value) {
            addCriterion("yhqsyl >=", value, "yhqsyl");
            return (Criteria) this;
        }

        public Criteria andYhqsylLessThan(String value) {
            addCriterion("yhqsyl <", value, "yhqsyl");
            return (Criteria) this;
        }

        public Criteria andYhqsylLessThanOrEqualTo(String value) {
            addCriterion("yhqsyl <=", value, "yhqsyl");
            return (Criteria) this;
        }

        public Criteria andYhqsylLike(String value) {
            addCriterion("yhqsyl like", value, "yhqsyl");
            return (Criteria) this;
        }

        public Criteria andYhqsylNotLike(String value) {
            addCriterion("yhqsyl not like", value, "yhqsyl");
            return (Criteria) this;
        }

        public Criteria andYhqsylIn(List<String> values) {
            addCriterion("yhqsyl in", values, "yhqsyl");
            return (Criteria) this;
        }

        public Criteria andYhqsylNotIn(List<String> values) {
            addCriterion("yhqsyl not in", values, "yhqsyl");
            return (Criteria) this;
        }

        public Criteria andYhqsylBetween(String value1, String value2) {
            addCriterion("yhqsyl between", value1, value2, "yhqsyl");
            return (Criteria) this;
        }

        public Criteria andYhqsylNotBetween(String value1, String value2) {
            addCriterion("yhqsyl not between", value1, value2, "yhqsyl");
            return (Criteria) this;
        }

        public Criteria andYhqmeIsNull() {
            addCriterion("yhqme is null");
            return (Criteria) this;
        }

        public Criteria andYhqmeIsNotNull() {
            addCriterion("yhqme is not null");
            return (Criteria) this;
        }

        public Criteria andYhqmeEqualTo(String value) {
            addCriterion("yhqme =", value, "yhqme");
            return (Criteria) this;
        }

        public Criteria andYhqmeNotEqualTo(String value) {
            addCriterion("yhqme <>", value, "yhqme");
            return (Criteria) this;
        }

        public Criteria andYhqmeGreaterThan(String value) {
            addCriterion("yhqme >", value, "yhqme");
            return (Criteria) this;
        }

        public Criteria andYhqmeGreaterThanOrEqualTo(String value) {
            addCriterion("yhqme >=", value, "yhqme");
            return (Criteria) this;
        }

        public Criteria andYhqmeLessThan(String value) {
            addCriterion("yhqme <", value, "yhqme");
            return (Criteria) this;
        }

        public Criteria andYhqmeLessThanOrEqualTo(String value) {
            addCriterion("yhqme <=", value, "yhqme");
            return (Criteria) this;
        }

        public Criteria andYhqmeLike(String value) {
            addCriterion("yhqme like", value, "yhqme");
            return (Criteria) this;
        }

        public Criteria andYhqmeNotLike(String value) {
            addCriterion("yhqme not like", value, "yhqme");
            return (Criteria) this;
        }

        public Criteria andYhqmeIn(List<String> values) {
            addCriterion("yhqme in", values, "yhqme");
            return (Criteria) this;
        }

        public Criteria andYhqmeNotIn(List<String> values) {
            addCriterion("yhqme not in", values, "yhqme");
            return (Criteria) this;
        }

        public Criteria andYhqmeBetween(String value1, String value2) {
            addCriterion("yhqme between", value1, value2, "yhqme");
            return (Criteria) this;
        }

        public Criteria andYhqmeNotBetween(String value1, String value2) {
            addCriterion("yhqme not between", value1, value2, "yhqme");
            return (Criteria) this;
        }

        public Criteria andYhqkssjIsNull() {
            addCriterion("yhqkssj is null");
            return (Criteria) this;
        }

        public Criteria andYhqkssjIsNotNull() {
            addCriterion("yhqkssj is not null");
            return (Criteria) this;
        }

        public Criteria andYhqkssjEqualTo(String value) {
            addCriterion("yhqkssj =", value, "yhqkssj");
            return (Criteria) this;
        }

        public Criteria andYhqkssjNotEqualTo(String value) {
            addCriterion("yhqkssj <>", value, "yhqkssj");
            return (Criteria) this;
        }

        public Criteria andYhqkssjGreaterThan(String value) {
            addCriterion("yhqkssj >", value, "yhqkssj");
            return (Criteria) this;
        }

        public Criteria andYhqkssjGreaterThanOrEqualTo(String value) {
            addCriterion("yhqkssj >=", value, "yhqkssj");
            return (Criteria) this;
        }

        public Criteria andYhqkssjLessThan(String value) {
            addCriterion("yhqkssj <", value, "yhqkssj");
            return (Criteria) this;
        }

        public Criteria andYhqkssjLessThanOrEqualTo(String value) {
            addCriterion("yhqkssj <=", value, "yhqkssj");
            return (Criteria) this;
        }

        public Criteria andYhqkssjLike(String value) {
            addCriterion("yhqkssj like", value, "yhqkssj");
            return (Criteria) this;
        }

        public Criteria andYhqkssjNotLike(String value) {
            addCriterion("yhqkssj not like", value, "yhqkssj");
            return (Criteria) this;
        }

        public Criteria andYhqkssjIn(List<String> values) {
            addCriterion("yhqkssj in", values, "yhqkssj");
            return (Criteria) this;
        }

        public Criteria andYhqkssjNotIn(List<String> values) {
            addCriterion("yhqkssj not in", values, "yhqkssj");
            return (Criteria) this;
        }

        public Criteria andYhqkssjBetween(String value1, String value2) {
            addCriterion("yhqkssj between", value1, value2, "yhqkssj");
            return (Criteria) this;
        }

        public Criteria andYhqkssjNotBetween(String value1, String value2) {
            addCriterion("yhqkssj not between", value1, value2, "yhqkssj");
            return (Criteria) this;
        }

        public Criteria andYhqjssjIsNull() {
            addCriterion("yhqjssj is null");
            return (Criteria) this;
        }

        public Criteria andYhqjssjIsNotNull() {
            addCriterion("yhqjssj is not null");
            return (Criteria) this;
        }

        public Criteria andYhqjssjEqualTo(String value) {
            addCriterion("yhqjssj =", value, "yhqjssj");
            return (Criteria) this;
        }

        public Criteria andYhqjssjNotEqualTo(String value) {
            addCriterion("yhqjssj <>", value, "yhqjssj");
            return (Criteria) this;
        }

        public Criteria andYhqjssjGreaterThan(String value) {
            addCriterion("yhqjssj >", value, "yhqjssj");
            return (Criteria) this;
        }

        public Criteria andYhqjssjGreaterThanOrEqualTo(String value) {
            addCriterion("yhqjssj >=", value, "yhqjssj");
            return (Criteria) this;
        }

        public Criteria andYhqjssjLessThan(String value) {
            addCriterion("yhqjssj <", value, "yhqjssj");
            return (Criteria) this;
        }

        public Criteria andYhqjssjLessThanOrEqualTo(String value) {
            addCriterion("yhqjssj <=", value, "yhqjssj");
            return (Criteria) this;
        }

        public Criteria andYhqjssjLike(String value) {
            addCriterion("yhqjssj like", value, "yhqjssj");
            return (Criteria) this;
        }

        public Criteria andYhqjssjNotLike(String value) {
            addCriterion("yhqjssj not like", value, "yhqjssj");
            return (Criteria) this;
        }

        public Criteria andYhqjssjIn(List<String> values) {
            addCriterion("yhqjssj in", values, "yhqjssj");
            return (Criteria) this;
        }

        public Criteria andYhqjssjNotIn(List<String> values) {
            addCriterion("yhqjssj not in", values, "yhqjssj");
            return (Criteria) this;
        }

        public Criteria andYhqjssjBetween(String value1, String value2) {
            addCriterion("yhqjssj between", value1, value2, "yhqjssj");
            return (Criteria) this;
        }

        public Criteria andYhqjssjNotBetween(String value1, String value2) {
            addCriterion("yhqjssj not between", value1, value2, "yhqjssj");
            return (Criteria) this;
        }

        public Criteria andYhqljIsNull() {
            addCriterion("yhqlj is null");
            return (Criteria) this;
        }

        public Criteria andYhqljIsNotNull() {
            addCriterion("yhqlj is not null");
            return (Criteria) this;
        }

        public Criteria andYhqljEqualTo(String value) {
            addCriterion("yhqlj =", value, "yhqlj");
            return (Criteria) this;
        }

        public Criteria andYhqljNotEqualTo(String value) {
            addCriterion("yhqlj <>", value, "yhqlj");
            return (Criteria) this;
        }

        public Criteria andYhqljGreaterThan(String value) {
            addCriterion("yhqlj >", value, "yhqlj");
            return (Criteria) this;
        }

        public Criteria andYhqljGreaterThanOrEqualTo(String value) {
            addCriterion("yhqlj >=", value, "yhqlj");
            return (Criteria) this;
        }

        public Criteria andYhqljLessThan(String value) {
            addCriterion("yhqlj <", value, "yhqlj");
            return (Criteria) this;
        }

        public Criteria andYhqljLessThanOrEqualTo(String value) {
            addCriterion("yhqlj <=", value, "yhqlj");
            return (Criteria) this;
        }

        public Criteria andYhqljLike(String value) {
            addCriterion("yhqlj like", value, "yhqlj");
            return (Criteria) this;
        }

        public Criteria andYhqljNotLike(String value) {
            addCriterion("yhqlj not like", value, "yhqlj");
            return (Criteria) this;
        }

        public Criteria andYhqljIn(List<String> values) {
            addCriterion("yhqlj in", values, "yhqlj");
            return (Criteria) this;
        }

        public Criteria andYhqljNotIn(List<String> values) {
            addCriterion("yhqlj not in", values, "yhqlj");
            return (Criteria) this;
        }

        public Criteria andYhqljBetween(String value1, String value2) {
            addCriterion("yhqlj between", value1, value2, "yhqlj");
            return (Criteria) this;
        }

        public Criteria andYhqljNotBetween(String value1, String value2) {
            addCriterion("yhqlj not between", value1, value2, "yhqlj");
            return (Criteria) this;
        }

        public Criteria andSpyhqtgljIsNull() {
            addCriterion("spyhqtglj is null");
            return (Criteria) this;
        }

        public Criteria andSpyhqtgljIsNotNull() {
            addCriterion("spyhqtglj is not null");
            return (Criteria) this;
        }

        public Criteria andSpyhqtgljEqualTo(String value) {
            addCriterion("spyhqtglj =", value, "spyhqtglj");
            return (Criteria) this;
        }

        public Criteria andSpyhqtgljNotEqualTo(String value) {
            addCriterion("spyhqtglj <>", value, "spyhqtglj");
            return (Criteria) this;
        }

        public Criteria andSpyhqtgljGreaterThan(String value) {
            addCriterion("spyhqtglj >", value, "spyhqtglj");
            return (Criteria) this;
        }

        public Criteria andSpyhqtgljGreaterThanOrEqualTo(String value) {
            addCriterion("spyhqtglj >=", value, "spyhqtglj");
            return (Criteria) this;
        }

        public Criteria andSpyhqtgljLessThan(String value) {
            addCriterion("spyhqtglj <", value, "spyhqtglj");
            return (Criteria) this;
        }

        public Criteria andSpyhqtgljLessThanOrEqualTo(String value) {
            addCriterion("spyhqtglj <=", value, "spyhqtglj");
            return (Criteria) this;
        }

        public Criteria andSpyhqtgljLike(String value) {
            addCriterion("spyhqtglj like", value, "spyhqtglj");
            return (Criteria) this;
        }

        public Criteria andSpyhqtgljNotLike(String value) {
            addCriterion("spyhqtglj not like", value, "spyhqtglj");
            return (Criteria) this;
        }

        public Criteria andSpyhqtgljIn(List<String> values) {
            addCriterion("spyhqtglj in", values, "spyhqtglj");
            return (Criteria) this;
        }

        public Criteria andSpyhqtgljNotIn(List<String> values) {
            addCriterion("spyhqtglj not in", values, "spyhqtglj");
            return (Criteria) this;
        }

        public Criteria andSpyhqtgljBetween(String value1, String value2) {
            addCriterion("spyhqtglj between", value1, value2, "spyhqtglj");
            return (Criteria) this;
        }

        public Criteria andSpyhqtgljNotBetween(String value1, String value2) {
            addCriterion("spyhqtglj not between", value1, value2, "spyhqtglj");
            return (Criteria) this;
        }

        public Criteria andUploadIdIsNull() {
            addCriterion("upload_id is null");
            return (Criteria) this;
        }

        public Criteria andUploadIdIsNotNull() {
            addCriterion("upload_id is not null");
            return (Criteria) this;
        }

        public Criteria andUploadIdEqualTo(Integer value) {
            addCriterion("upload_id =", value, "uploadId");
            return (Criteria) this;
        }

        public Criteria andUploadIdNotEqualTo(Integer value) {
            addCriterion("upload_id <>", value, "uploadId");
            return (Criteria) this;
        }

        public Criteria andUploadIdGreaterThan(Integer value) {
            addCriterion("upload_id >", value, "uploadId");
            return (Criteria) this;
        }

        public Criteria andUploadIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("upload_id >=", value, "uploadId");
            return (Criteria) this;
        }

        public Criteria andUploadIdLessThan(Integer value) {
            addCriterion("upload_id <", value, "uploadId");
            return (Criteria) this;
        }

        public Criteria andUploadIdLessThanOrEqualTo(Integer value) {
            addCriterion("upload_id <=", value, "uploadId");
            return (Criteria) this;
        }

        public Criteria andUploadIdIn(List<Integer> values) {
            addCriterion("upload_id in", values, "uploadId");
            return (Criteria) this;
        }

        public Criteria andUploadIdNotIn(List<Integer> values) {
            addCriterion("upload_id not in", values, "uploadId");
            return (Criteria) this;
        }

        public Criteria andUploadIdBetween(Integer value1, Integer value2) {
            addCriterion("upload_id between", value1, value2, "uploadId");
            return (Criteria) this;
        }

        public Criteria andUploadIdNotBetween(Integer value1, Integer value2) {
            addCriterion("upload_id not between", value1, value2, "uploadId");
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