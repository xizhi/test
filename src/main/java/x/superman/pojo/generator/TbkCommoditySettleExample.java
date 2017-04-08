package x.superman.pojo.generator;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

public class TbkCommoditySettleExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public TbkCommoditySettleExample() {
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

        protected void addCriterionForJDBCDate(String condition, Date value, String property) {
            if (value == null) {
                throw new RuntimeException("Value for " + property + " cannot be null");
            }
            addCriterion(condition, new java.sql.Date(value.getTime()), property);
        }

        protected void addCriterionForJDBCDate(String condition, List<Date> values, String property) {
            if (values == null || values.size() == 0) {
                throw new RuntimeException("Value list for " + property + " cannot be null or empty");
            }
            List<java.sql.Date> dateList = new ArrayList<java.sql.Date>();
            Iterator<Date> iter = values.iterator();
            while (iter.hasNext()) {
                dateList.add(new java.sql.Date(iter.next().getTime()));
            }
            addCriterion(condition, dateList, property);
        }

        protected void addCriterionForJDBCDate(String condition, Date value1, Date value2, String property) {
            if (value1 == null || value2 == null) {
                throw new RuntimeException("Between values for " + property + " cannot be null");
            }
            addCriterion(condition, new java.sql.Date(value1.getTime()), new java.sql.Date(value2.getTime()), property);
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

        public Criteria andMcIsNull() {
            addCriterion("mc is null");
            return (Criteria) this;
        }

        public Criteria andMcIsNotNull() {
            addCriterion("mc is not null");
            return (Criteria) this;
        }

        public Criteria andMcEqualTo(String value) {
            addCriterion("mc =", value, "mc");
            return (Criteria) this;
        }

        public Criteria andMcNotEqualTo(String value) {
            addCriterion("mc <>", value, "mc");
            return (Criteria) this;
        }

        public Criteria andMcGreaterThan(String value) {
            addCriterion("mc >", value, "mc");
            return (Criteria) this;
        }

        public Criteria andMcGreaterThanOrEqualTo(String value) {
            addCriterion("mc >=", value, "mc");
            return (Criteria) this;
        }

        public Criteria andMcLessThan(String value) {
            addCriterion("mc <", value, "mc");
            return (Criteria) this;
        }

        public Criteria andMcLessThanOrEqualTo(String value) {
            addCriterion("mc <=", value, "mc");
            return (Criteria) this;
        }

        public Criteria andMcLike(String value) {
            addCriterion("mc like", value, "mc");
            return (Criteria) this;
        }

        public Criteria andMcNotLike(String value) {
            addCriterion("mc not like", value, "mc");
            return (Criteria) this;
        }

        public Criteria andMcIn(List<String> values) {
            addCriterion("mc in", values, "mc");
            return (Criteria) this;
        }

        public Criteria andMcNotIn(List<String> values) {
            addCriterion("mc not in", values, "mc");
            return (Criteria) this;
        }

        public Criteria andMcBetween(String value1, String value2) {
            addCriterion("mc between", value1, value2, "mc");
            return (Criteria) this;
        }

        public Criteria andMcNotBetween(String value1, String value2) {
            addCriterion("mc not between", value1, value2, "mc");
            return (Criteria) this;
        }

        public Criteria andLmIsNull() {
            addCriterion("lm is null");
            return (Criteria) this;
        }

        public Criteria andLmIsNotNull() {
            addCriterion("lm is not null");
            return (Criteria) this;
        }

        public Criteria andLmEqualTo(String value) {
            addCriterion("lm =", value, "lm");
            return (Criteria) this;
        }

        public Criteria andLmNotEqualTo(String value) {
            addCriterion("lm <>", value, "lm");
            return (Criteria) this;
        }

        public Criteria andLmGreaterThan(String value) {
            addCriterion("lm >", value, "lm");
            return (Criteria) this;
        }

        public Criteria andLmGreaterThanOrEqualTo(String value) {
            addCriterion("lm >=", value, "lm");
            return (Criteria) this;
        }

        public Criteria andLmLessThan(String value) {
            addCriterion("lm <", value, "lm");
            return (Criteria) this;
        }

        public Criteria andLmLessThanOrEqualTo(String value) {
            addCriterion("lm <=", value, "lm");
            return (Criteria) this;
        }

        public Criteria andLmLike(String value) {
            addCriterion("lm like", value, "lm");
            return (Criteria) this;
        }

        public Criteria andLmNotLike(String value) {
            addCriterion("lm not like", value, "lm");
            return (Criteria) this;
        }

        public Criteria andLmIn(List<String> values) {
            addCriterion("lm in", values, "lm");
            return (Criteria) this;
        }

        public Criteria andLmNotIn(List<String> values) {
            addCriterion("lm not in", values, "lm");
            return (Criteria) this;
        }

        public Criteria andLmBetween(String value1, String value2) {
            addCriterion("lm between", value1, value2, "lm");
            return (Criteria) this;
        }

        public Criteria andLmNotBetween(String value1, String value2) {
            addCriterion("lm not between", value1, value2, "lm");
            return (Criteria) this;
        }

        public Criteria andZtIsNull() {
            addCriterion("zt is null");
            return (Criteria) this;
        }

        public Criteria andZtIsNotNull() {
            addCriterion("zt is not null");
            return (Criteria) this;
        }

        public Criteria andZtEqualTo(String value) {
            addCriterion("zt =", value, "zt");
            return (Criteria) this;
        }

        public Criteria andZtNotEqualTo(String value) {
            addCriterion("zt <>", value, "zt");
            return (Criteria) this;
        }

        public Criteria andZtGreaterThan(String value) {
            addCriterion("zt >", value, "zt");
            return (Criteria) this;
        }

        public Criteria andZtGreaterThanOrEqualTo(String value) {
            addCriterion("zt >=", value, "zt");
            return (Criteria) this;
        }

        public Criteria andZtLessThan(String value) {
            addCriterion("zt <", value, "zt");
            return (Criteria) this;
        }

        public Criteria andZtLessThanOrEqualTo(String value) {
            addCriterion("zt <=", value, "zt");
            return (Criteria) this;
        }

        public Criteria andZtLike(String value) {
            addCriterion("zt like", value, "zt");
            return (Criteria) this;
        }

        public Criteria andZtNotLike(String value) {
            addCriterion("zt not like", value, "zt");
            return (Criteria) this;
        }

        public Criteria andZtIn(List<String> values) {
            addCriterion("zt in", values, "zt");
            return (Criteria) this;
        }

        public Criteria andZtNotIn(List<String> values) {
            addCriterion("zt not in", values, "zt");
            return (Criteria) this;
        }

        public Criteria andZtBetween(String value1, String value2) {
            addCriterion("zt between", value1, value2, "zt");
            return (Criteria) this;
        }

        public Criteria andZtNotBetween(String value1, String value2) {
            addCriterion("zt not between", value1, value2, "zt");
            return (Criteria) this;
        }

        public Criteria andJgIsNull() {
            addCriterion("jg is null");
            return (Criteria) this;
        }

        public Criteria andJgIsNotNull() {
            addCriterion("jg is not null");
            return (Criteria) this;
        }

        public Criteria andJgEqualTo(Double value) {
            addCriterion("jg =", value, "jg");
            return (Criteria) this;
        }

        public Criteria andJgNotEqualTo(Double value) {
            addCriterion("jg <>", value, "jg");
            return (Criteria) this;
        }

        public Criteria andJgGreaterThan(Double value) {
            addCriterion("jg >", value, "jg");
            return (Criteria) this;
        }

        public Criteria andJgGreaterThanOrEqualTo(Double value) {
            addCriterion("jg >=", value, "jg");
            return (Criteria) this;
        }

        public Criteria andJgLessThan(Double value) {
            addCriterion("jg <", value, "jg");
            return (Criteria) this;
        }

        public Criteria andJgLessThanOrEqualTo(Double value) {
            addCriterion("jg <=", value, "jg");
            return (Criteria) this;
        }

        public Criteria andJgIn(List<Double> values) {
            addCriterion("jg in", values, "jg");
            return (Criteria) this;
        }

        public Criteria andJgNotIn(List<Double> values) {
            addCriterion("jg not in", values, "jg");
            return (Criteria) this;
        }

        public Criteria andJgBetween(Double value1, Double value2) {
            addCriterion("jg between", value1, value2, "jg");
            return (Criteria) this;
        }

        public Criteria andJgNotBetween(Double value1, Double value2) {
            addCriterion("jg not between", value1, value2, "jg");
            return (Criteria) this;
        }

        public Criteria andYxlIsNull() {
            addCriterion("yxl is null");
            return (Criteria) this;
        }

        public Criteria andYxlIsNotNull() {
            addCriterion("yxl is not null");
            return (Criteria) this;
        }

        public Criteria andYxlEqualTo(Double value) {
            addCriterion("yxl =", value, "yxl");
            return (Criteria) this;
        }

        public Criteria andYxlNotEqualTo(Double value) {
            addCriterion("yxl <>", value, "yxl");
            return (Criteria) this;
        }

        public Criteria andYxlGreaterThan(Double value) {
            addCriterion("yxl >", value, "yxl");
            return (Criteria) this;
        }

        public Criteria andYxlGreaterThanOrEqualTo(Double value) {
            addCriterion("yxl >=", value, "yxl");
            return (Criteria) this;
        }

        public Criteria andYxlLessThan(Double value) {
            addCriterion("yxl <", value, "yxl");
            return (Criteria) this;
        }

        public Criteria andYxlLessThanOrEqualTo(Double value) {
            addCriterion("yxl <=", value, "yxl");
            return (Criteria) this;
        }

        public Criteria andYxlIn(List<Double> values) {
            addCriterion("yxl in", values, "yxl");
            return (Criteria) this;
        }

        public Criteria andYxlNotIn(List<Double> values) {
            addCriterion("yxl not in", values, "yxl");
            return (Criteria) this;
        }

        public Criteria andYxlBetween(Double value1, Double value2) {
            addCriterion("yxl between", value1, value2, "yxl");
            return (Criteria) this;
        }

        public Criteria andYxlNotBetween(Double value1, Double value2) {
            addCriterion("yxl not between", value1, value2, "yxl");
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

        public Criteria andSrblEqualTo(Double value) {
            addCriterion("srbl =", value, "srbl");
            return (Criteria) this;
        }

        public Criteria andSrblNotEqualTo(Double value) {
            addCriterion("srbl <>", value, "srbl");
            return (Criteria) this;
        }

        public Criteria andSrblGreaterThan(Double value) {
            addCriterion("srbl >", value, "srbl");
            return (Criteria) this;
        }

        public Criteria andSrblGreaterThanOrEqualTo(Double value) {
            addCriterion("srbl >=", value, "srbl");
            return (Criteria) this;
        }

        public Criteria andSrblLessThan(Double value) {
            addCriterion("srbl <", value, "srbl");
            return (Criteria) this;
        }

        public Criteria andSrblLessThanOrEqualTo(Double value) {
            addCriterion("srbl <=", value, "srbl");
            return (Criteria) this;
        }

        public Criteria andSrblIn(List<Double> values) {
            addCriterion("srbl in", values, "srbl");
            return (Criteria) this;
        }

        public Criteria andSrblNotIn(List<Double> values) {
            addCriterion("srbl not in", values, "srbl");
            return (Criteria) this;
        }

        public Criteria andSrblBetween(Double value1, Double value2) {
            addCriterion("srbl between", value1, value2, "srbl");
            return (Criteria) this;
        }

        public Criteria andSrblNotBetween(Double value1, Double value2) {
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

        public Criteria andYjEqualTo(Double value) {
            addCriterion("yj =", value, "yj");
            return (Criteria) this;
        }

        public Criteria andYjNotEqualTo(Double value) {
            addCriterion("yj <>", value, "yj");
            return (Criteria) this;
        }

        public Criteria andYjGreaterThan(Double value) {
            addCriterion("yj >", value, "yj");
            return (Criteria) this;
        }

        public Criteria andYjGreaterThanOrEqualTo(Double value) {
            addCriterion("yj >=", value, "yj");
            return (Criteria) this;
        }

        public Criteria andYjLessThan(Double value) {
            addCriterion("yj <", value, "yj");
            return (Criteria) this;
        }

        public Criteria andYjLessThanOrEqualTo(Double value) {
            addCriterion("yj <=", value, "yj");
            return (Criteria) this;
        }

        public Criteria andYjIn(List<Double> values) {
            addCriterion("yj in", values, "yj");
            return (Criteria) this;
        }

        public Criteria andYjNotIn(List<Double> values) {
            addCriterion("yj not in", values, "yj");
            return (Criteria) this;
        }

        public Criteria andYjBetween(Double value1, Double value2) {
            addCriterion("yj between", value1, value2, "yj");
            return (Criteria) this;
        }

        public Criteria andYjNotBetween(Double value1, Double value2) {
            addCriterion("yj not between", value1, value2, "yj");
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

        public Criteria andYhqSlIsNull() {
            addCriterion("yhq_sl is null");
            return (Criteria) this;
        }

        public Criteria andYhqSlIsNotNull() {
            addCriterion("yhq_sl is not null");
            return (Criteria) this;
        }

        public Criteria andYhqSlEqualTo(Integer value) {
            addCriterion("yhq_sl =", value, "yhqSl");
            return (Criteria) this;
        }

        public Criteria andYhqSlNotEqualTo(Integer value) {
            addCriterion("yhq_sl <>", value, "yhqSl");
            return (Criteria) this;
        }

        public Criteria andYhqSlGreaterThan(Integer value) {
            addCriterion("yhq_sl >", value, "yhqSl");
            return (Criteria) this;
        }

        public Criteria andYhqSlGreaterThanOrEqualTo(Integer value) {
            addCriterion("yhq_sl >=", value, "yhqSl");
            return (Criteria) this;
        }

        public Criteria andYhqSlLessThan(Integer value) {
            addCriterion("yhq_sl <", value, "yhqSl");
            return (Criteria) this;
        }

        public Criteria andYhqSlLessThanOrEqualTo(Integer value) {
            addCriterion("yhq_sl <=", value, "yhqSl");
            return (Criteria) this;
        }

        public Criteria andYhqSlIn(List<Integer> values) {
            addCriterion("yhq_sl in", values, "yhqSl");
            return (Criteria) this;
        }

        public Criteria andYhqSlNotIn(List<Integer> values) {
            addCriterion("yhq_sl not in", values, "yhqSl");
            return (Criteria) this;
        }

        public Criteria andYhqSlBetween(Integer value1, Integer value2) {
            addCriterion("yhq_sl between", value1, value2, "yhqSl");
            return (Criteria) this;
        }

        public Criteria andYhqSlNotBetween(Integer value1, Integer value2) {
            addCriterion("yhq_sl not between", value1, value2, "yhqSl");
            return (Criteria) this;
        }

        public Criteria andYhqSyIsNull() {
            addCriterion("yhq_sy is null");
            return (Criteria) this;
        }

        public Criteria andYhqSyIsNotNull() {
            addCriterion("yhq_sy is not null");
            return (Criteria) this;
        }

        public Criteria andYhqSyEqualTo(Integer value) {
            addCriterion("yhq_sy =", value, "yhqSy");
            return (Criteria) this;
        }

        public Criteria andYhqSyNotEqualTo(Integer value) {
            addCriterion("yhq_sy <>", value, "yhqSy");
            return (Criteria) this;
        }

        public Criteria andYhqSyGreaterThan(Integer value) {
            addCriterion("yhq_sy >", value, "yhqSy");
            return (Criteria) this;
        }

        public Criteria andYhqSyGreaterThanOrEqualTo(Integer value) {
            addCriterion("yhq_sy >=", value, "yhqSy");
            return (Criteria) this;
        }

        public Criteria andYhqSyLessThan(Integer value) {
            addCriterion("yhq_sy <", value, "yhqSy");
            return (Criteria) this;
        }

        public Criteria andYhqSyLessThanOrEqualTo(Integer value) {
            addCriterion("yhq_sy <=", value, "yhqSy");
            return (Criteria) this;
        }

        public Criteria andYhqSyIn(List<Integer> values) {
            addCriterion("yhq_sy in", values, "yhqSy");
            return (Criteria) this;
        }

        public Criteria andYhqSyNotIn(List<Integer> values) {
            addCriterion("yhq_sy not in", values, "yhqSy");
            return (Criteria) this;
        }

        public Criteria andYhqSyBetween(Integer value1, Integer value2) {
            addCriterion("yhq_sy between", value1, value2, "yhqSy");
            return (Criteria) this;
        }

        public Criteria andYhqSyNotBetween(Integer value1, Integer value2) {
            addCriterion("yhq_sy not between", value1, value2, "yhqSy");
            return (Criteria) this;
        }

        public Criteria andYhqMeIsNull() {
            addCriterion("yhq_me is null");
            return (Criteria) this;
        }

        public Criteria andYhqMeIsNotNull() {
            addCriterion("yhq_me is not null");
            return (Criteria) this;
        }

        public Criteria andYhqMeEqualTo(String value) {
            addCriterion("yhq_me =", value, "yhqMe");
            return (Criteria) this;
        }

        public Criteria andYhqMeNotEqualTo(String value) {
            addCriterion("yhq_me <>", value, "yhqMe");
            return (Criteria) this;
        }

        public Criteria andYhqMeGreaterThan(String value) {
            addCriterion("yhq_me >", value, "yhqMe");
            return (Criteria) this;
        }

        public Criteria andYhqMeGreaterThanOrEqualTo(String value) {
            addCriterion("yhq_me >=", value, "yhqMe");
            return (Criteria) this;
        }

        public Criteria andYhqMeLessThan(String value) {
            addCriterion("yhq_me <", value, "yhqMe");
            return (Criteria) this;
        }

        public Criteria andYhqMeLessThanOrEqualTo(String value) {
            addCriterion("yhq_me <=", value, "yhqMe");
            return (Criteria) this;
        }

        public Criteria andYhqMeLike(String value) {
            addCriterion("yhq_me like", value, "yhqMe");
            return (Criteria) this;
        }

        public Criteria andYhqMeNotLike(String value) {
            addCriterion("yhq_me not like", value, "yhqMe");
            return (Criteria) this;
        }

        public Criteria andYhqMeIn(List<String> values) {
            addCriterion("yhq_me in", values, "yhqMe");
            return (Criteria) this;
        }

        public Criteria andYhqMeNotIn(List<String> values) {
            addCriterion("yhq_me not in", values, "yhqMe");
            return (Criteria) this;
        }

        public Criteria andYhqMeBetween(String value1, String value2) {
            addCriterion("yhq_me between", value1, value2, "yhqMe");
            return (Criteria) this;
        }

        public Criteria andYhqMeNotBetween(String value1, String value2) {
            addCriterion("yhq_me not between", value1, value2, "yhqMe");
            return (Criteria) this;
        }

        public Criteria andYhqJeIsNull() {
            addCriterion("yhq_je is null");
            return (Criteria) this;
        }

        public Criteria andYhqJeIsNotNull() {
            addCriterion("yhq_je is not null");
            return (Criteria) this;
        }

        public Criteria andYhqJeEqualTo(Double value) {
            addCriterion("yhq_je =", value, "yhqJe");
            return (Criteria) this;
        }

        public Criteria andYhqJeNotEqualTo(Double value) {
            addCriterion("yhq_je <>", value, "yhqJe");
            return (Criteria) this;
        }

        public Criteria andYhqJeGreaterThan(Double value) {
            addCriterion("yhq_je >", value, "yhqJe");
            return (Criteria) this;
        }

        public Criteria andYhqJeGreaterThanOrEqualTo(Double value) {
            addCriterion("yhq_je >=", value, "yhqJe");
            return (Criteria) this;
        }

        public Criteria andYhqJeLessThan(Double value) {
            addCriterion("yhq_je <", value, "yhqJe");
            return (Criteria) this;
        }

        public Criteria andYhqJeLessThanOrEqualTo(Double value) {
            addCriterion("yhq_je <=", value, "yhqJe");
            return (Criteria) this;
        }

        public Criteria andYhqJeIn(List<Double> values) {
            addCriterion("yhq_je in", values, "yhqJe");
            return (Criteria) this;
        }

        public Criteria andYhqJeNotIn(List<Double> values) {
            addCriterion("yhq_je not in", values, "yhqJe");
            return (Criteria) this;
        }

        public Criteria andYhqJeBetween(Double value1, Double value2) {
            addCriterion("yhq_je between", value1, value2, "yhqJe");
            return (Criteria) this;
        }

        public Criteria andYhqJeNotBetween(Double value1, Double value2) {
            addCriterion("yhq_je not between", value1, value2, "yhqJe");
            return (Criteria) this;
        }

        public Criteria andYhqSksjIsNull() {
            addCriterion("yhq_sksj is null");
            return (Criteria) this;
        }

        public Criteria andYhqSksjIsNotNull() {
            addCriterion("yhq_sksj is not null");
            return (Criteria) this;
        }

        public Criteria andYhqSksjEqualTo(Date value) {
            addCriterionForJDBCDate("yhq_sksj =", value, "yhqSksj");
            return (Criteria) this;
        }

        public Criteria andYhqSksjNotEqualTo(Date value) {
            addCriterionForJDBCDate("yhq_sksj <>", value, "yhqSksj");
            return (Criteria) this;
        }

        public Criteria andYhqSksjGreaterThan(Date value) {
            addCriterionForJDBCDate("yhq_sksj >", value, "yhqSksj");
            return (Criteria) this;
        }

        public Criteria andYhqSksjGreaterThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("yhq_sksj >=", value, "yhqSksj");
            return (Criteria) this;
        }

        public Criteria andYhqSksjLessThan(Date value) {
            addCriterionForJDBCDate("yhq_sksj <", value, "yhqSksj");
            return (Criteria) this;
        }

        public Criteria andYhqSksjLessThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("yhq_sksj <=", value, "yhqSksj");
            return (Criteria) this;
        }

        public Criteria andYhqSksjIn(List<Date> values) {
            addCriterionForJDBCDate("yhq_sksj in", values, "yhqSksj");
            return (Criteria) this;
        }

        public Criteria andYhqSksjNotIn(List<Date> values) {
            addCriterionForJDBCDate("yhq_sksj not in", values, "yhqSksj");
            return (Criteria) this;
        }

        public Criteria andYhqSksjBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("yhq_sksj between", value1, value2, "yhqSksj");
            return (Criteria) this;
        }

        public Criteria andYhqSksjNotBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("yhq_sksj not between", value1, value2, "yhqSksj");
            return (Criteria) this;
        }

        public Criteria andYhqJssjIsNull() {
            addCriterion("yhq_jssj is null");
            return (Criteria) this;
        }

        public Criteria andYhqJssjIsNotNull() {
            addCriterion("yhq_jssj is not null");
            return (Criteria) this;
        }

        public Criteria andYhqJssjEqualTo(Date value) {
            addCriterionForJDBCDate("yhq_jssj =", value, "yhqJssj");
            return (Criteria) this;
        }

        public Criteria andYhqJssjNotEqualTo(Date value) {
            addCriterionForJDBCDate("yhq_jssj <>", value, "yhqJssj");
            return (Criteria) this;
        }

        public Criteria andYhqJssjGreaterThan(Date value) {
            addCriterionForJDBCDate("yhq_jssj >", value, "yhqJssj");
            return (Criteria) this;
        }

        public Criteria andYhqJssjGreaterThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("yhq_jssj >=", value, "yhqJssj");
            return (Criteria) this;
        }

        public Criteria andYhqJssjLessThan(Date value) {
            addCriterionForJDBCDate("yhq_jssj <", value, "yhqJssj");
            return (Criteria) this;
        }

        public Criteria andYhqJssjLessThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("yhq_jssj <=", value, "yhqJssj");
            return (Criteria) this;
        }

        public Criteria andYhqJssjIn(List<Date> values) {
            addCriterionForJDBCDate("yhq_jssj in", values, "yhqJssj");
            return (Criteria) this;
        }

        public Criteria andYhqJssjNotIn(List<Date> values) {
            addCriterionForJDBCDate("yhq_jssj not in", values, "yhqJssj");
            return (Criteria) this;
        }

        public Criteria andYhqJssjBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("yhq_jssj between", value1, value2, "yhqJssj");
            return (Criteria) this;
        }

        public Criteria andYhqJssjNotBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("yhq_jssj not between", value1, value2, "yhqJssj");
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