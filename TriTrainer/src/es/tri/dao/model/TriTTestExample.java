package es.tri.dao.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

public class TriTTestExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public TriTTestExample() {
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

        public Criteria andIdTestIsNull() {
            addCriterion("idTest is null");
            return (Criteria) this;
        }

        public Criteria andIdTestIsNotNull() {
            addCriterion("idTest is not null");
            return (Criteria) this;
        }

        public Criteria andIdTestEqualTo(Integer value) {
            addCriterion("idTest =", value, "idTest");
            return (Criteria) this;
        }

        public Criteria andIdTestNotEqualTo(Integer value) {
            addCriterion("idTest <>", value, "idTest");
            return (Criteria) this;
        }

        public Criteria andIdTestGreaterThan(Integer value) {
            addCriterion("idTest >", value, "idTest");
            return (Criteria) this;
        }

        public Criteria andIdTestGreaterThanOrEqualTo(Integer value) {
            addCriterion("idTest >=", value, "idTest");
            return (Criteria) this;
        }

        public Criteria andIdTestLessThan(Integer value) {
            addCriterion("idTest <", value, "idTest");
            return (Criteria) this;
        }

        public Criteria andIdTestLessThanOrEqualTo(Integer value) {
            addCriterion("idTest <=", value, "idTest");
            return (Criteria) this;
        }

        public Criteria andIdTestIn(List<Integer> values) {
            addCriterion("idTest in", values, "idTest");
            return (Criteria) this;
        }

        public Criteria andIdTestNotIn(List<Integer> values) {
            addCriterion("idTest not in", values, "idTest");
            return (Criteria) this;
        }

        public Criteria andIdTestBetween(Integer value1, Integer value2) {
            addCriterion("idTest between", value1, value2, "idTest");
            return (Criteria) this;
        }

        public Criteria andIdTestNotBetween(Integer value1, Integer value2) {
            addCriterion("idTest not between", value1, value2, "idTest");
            return (Criteria) this;
        }

        public Criteria andIdEntrenoIsNull() {
            addCriterion("idEntreno is null");
            return (Criteria) this;
        }

        public Criteria andIdEntrenoIsNotNull() {
            addCriterion("idEntreno is not null");
            return (Criteria) this;
        }

        public Criteria andIdEntrenoEqualTo(Integer value) {
            addCriterion("idEntreno =", value, "idEntreno");
            return (Criteria) this;
        }

        public Criteria andIdEntrenoNotEqualTo(Integer value) {
            addCriterion("idEntreno <>", value, "idEntreno");
            return (Criteria) this;
        }

        public Criteria andIdEntrenoGreaterThan(Integer value) {
            addCriterion("idEntreno >", value, "idEntreno");
            return (Criteria) this;
        }

        public Criteria andIdEntrenoGreaterThanOrEqualTo(Integer value) {
            addCriterion("idEntreno >=", value, "idEntreno");
            return (Criteria) this;
        }

        public Criteria andIdEntrenoLessThan(Integer value) {
            addCriterion("idEntreno <", value, "idEntreno");
            return (Criteria) this;
        }

        public Criteria andIdEntrenoLessThanOrEqualTo(Integer value) {
            addCriterion("idEntreno <=", value, "idEntreno");
            return (Criteria) this;
        }

        public Criteria andIdEntrenoIn(List<Integer> values) {
            addCriterion("idEntreno in", values, "idEntreno");
            return (Criteria) this;
        }

        public Criteria andIdEntrenoNotIn(List<Integer> values) {
            addCriterion("idEntreno not in", values, "idEntreno");
            return (Criteria) this;
        }

        public Criteria andIdEntrenoBetween(Integer value1, Integer value2) {
            addCriterion("idEntreno between", value1, value2, "idEntreno");
            return (Criteria) this;
        }

        public Criteria andIdEntrenoNotBetween(Integer value1, Integer value2) {
            addCriterion("idEntreno not between", value1, value2, "idEntreno");
            return (Criteria) this;
        }

        public Criteria andTiempoIsNull() {
            addCriterion("tiempo is null");
            return (Criteria) this;
        }

        public Criteria andTiempoIsNotNull() {
            addCriterion("tiempo is not null");
            return (Criteria) this;
        }

        public Criteria andTiempoEqualTo(Integer value) {
            addCriterion("tiempo =", value, "tiempo");
            return (Criteria) this;
        }

        public Criteria andTiempoNotEqualTo(Integer value) {
            addCriterion("tiempo <>", value, "tiempo");
            return (Criteria) this;
        }

        public Criteria andTiempoGreaterThan(Integer value) {
            addCriterion("tiempo >", value, "tiempo");
            return (Criteria) this;
        }

        public Criteria andTiempoGreaterThanOrEqualTo(Integer value) {
            addCriterion("tiempo >=", value, "tiempo");
            return (Criteria) this;
        }

        public Criteria andTiempoLessThan(Integer value) {
            addCriterion("tiempo <", value, "tiempo");
            return (Criteria) this;
        }

        public Criteria andTiempoLessThanOrEqualTo(Integer value) {
            addCriterion("tiempo <=", value, "tiempo");
            return (Criteria) this;
        }

        public Criteria andTiempoIn(List<Integer> values) {
            addCriterion("tiempo in", values, "tiempo");
            return (Criteria) this;
        }

        public Criteria andTiempoNotIn(List<Integer> values) {
            addCriterion("tiempo not in", values, "tiempo");
            return (Criteria) this;
        }

        public Criteria andTiempoBetween(Integer value1, Integer value2) {
            addCriterion("tiempo between", value1, value2, "tiempo");
            return (Criteria) this;
        }

        public Criteria andTiempoNotBetween(Integer value1, Integer value2) {
            addCriterion("tiempo not between", value1, value2, "tiempo");
            return (Criteria) this;
        }

        public Criteria andFCinicialIsNull() {
            addCriterion("FCinicial is null");
            return (Criteria) this;
        }

        public Criteria andFCinicialIsNotNull() {
            addCriterion("FCinicial is not null");
            return (Criteria) this;
        }

        public Criteria andFCinicialEqualTo(Integer value) {
            addCriterion("FCinicial =", value, "FCinicial");
            return (Criteria) this;
        }

        public Criteria andFCinicialNotEqualTo(Integer value) {
            addCriterion("FCinicial <>", value, "FCinicial");
            return (Criteria) this;
        }

        public Criteria andFCinicialGreaterThan(Integer value) {
            addCriterion("FCinicial >", value, "FCinicial");
            return (Criteria) this;
        }

        public Criteria andFCinicialGreaterThanOrEqualTo(Integer value) {
            addCriterion("FCinicial >=", value, "FCinicial");
            return (Criteria) this;
        }

        public Criteria andFCinicialLessThan(Integer value) {
            addCriterion("FCinicial <", value, "FCinicial");
            return (Criteria) this;
        }

        public Criteria andFCinicialLessThanOrEqualTo(Integer value) {
            addCriterion("FCinicial <=", value, "FCinicial");
            return (Criteria) this;
        }

        public Criteria andFCinicialIn(List<Integer> values) {
            addCriterion("FCinicial in", values, "FCinicial");
            return (Criteria) this;
        }

        public Criteria andFCinicialNotIn(List<Integer> values) {
            addCriterion("FCinicial not in", values, "FCinicial");
            return (Criteria) this;
        }

        public Criteria andFCinicialBetween(Integer value1, Integer value2) {
            addCriterion("FCinicial between", value1, value2, "FCinicial");
            return (Criteria) this;
        }

        public Criteria andFCinicialNotBetween(Integer value1, Integer value2) {
            addCriterion("FCinicial not between", value1, value2, "FCinicial");
            return (Criteria) this;
        }

        public Criteria andFCMaxIsNull() {
            addCriterion("FCMax is null");
            return (Criteria) this;
        }

        public Criteria andFCMaxIsNotNull() {
            addCriterion("FCMax is not null");
            return (Criteria) this;
        }

        public Criteria andFCMaxEqualTo(Integer value) {
            addCriterion("FCMax =", value, "FCMax");
            return (Criteria) this;
        }

        public Criteria andFCMaxNotEqualTo(Integer value) {
            addCriterion("FCMax <>", value, "FCMax");
            return (Criteria) this;
        }

        public Criteria andFCMaxGreaterThan(Integer value) {
            addCriterion("FCMax >", value, "FCMax");
            return (Criteria) this;
        }

        public Criteria andFCMaxGreaterThanOrEqualTo(Integer value) {
            addCriterion("FCMax >=", value, "FCMax");
            return (Criteria) this;
        }

        public Criteria andFCMaxLessThan(Integer value) {
            addCriterion("FCMax <", value, "FCMax");
            return (Criteria) this;
        }

        public Criteria andFCMaxLessThanOrEqualTo(Integer value) {
            addCriterion("FCMax <=", value, "FCMax");
            return (Criteria) this;
        }

        public Criteria andFCMaxIn(List<Integer> values) {
            addCriterion("FCMax in", values, "FCMax");
            return (Criteria) this;
        }

        public Criteria andFCMaxNotIn(List<Integer> values) {
            addCriterion("FCMax not in", values, "FCMax");
            return (Criteria) this;
        }

        public Criteria andFCMaxBetween(Integer value1, Integer value2) {
            addCriterion("FCMax between", value1, value2, "FCMax");
            return (Criteria) this;
        }

        public Criteria andFCMaxNotBetween(Integer value1, Integer value2) {
            addCriterion("FCMax not between", value1, value2, "FCMax");
            return (Criteria) this;
        }

        public Criteria andFCMediaIsNull() {
            addCriterion("FCMedia is null");
            return (Criteria) this;
        }

        public Criteria andFCMediaIsNotNull() {
            addCriterion("FCMedia is not null");
            return (Criteria) this;
        }

        public Criteria andFCMediaEqualTo(Integer value) {
            addCriterion("FCMedia =", value, "FCMedia");
            return (Criteria) this;
        }

        public Criteria andFCMediaNotEqualTo(Integer value) {
            addCriterion("FCMedia <>", value, "FCMedia");
            return (Criteria) this;
        }

        public Criteria andFCMediaGreaterThan(Integer value) {
            addCriterion("FCMedia >", value, "FCMedia");
            return (Criteria) this;
        }

        public Criteria andFCMediaGreaterThanOrEqualTo(Integer value) {
            addCriterion("FCMedia >=", value, "FCMedia");
            return (Criteria) this;
        }

        public Criteria andFCMediaLessThan(Integer value) {
            addCriterion("FCMedia <", value, "FCMedia");
            return (Criteria) this;
        }

        public Criteria andFCMediaLessThanOrEqualTo(Integer value) {
            addCriterion("FCMedia <=", value, "FCMedia");
            return (Criteria) this;
        }

        public Criteria andFCMediaIn(List<Integer> values) {
            addCriterion("FCMedia in", values, "FCMedia");
            return (Criteria) this;
        }

        public Criteria andFCMediaNotIn(List<Integer> values) {
            addCriterion("FCMedia not in", values, "FCMedia");
            return (Criteria) this;
        }

        public Criteria andFCMediaBetween(Integer value1, Integer value2) {
            addCriterion("FCMedia between", value1, value2, "FCMedia");
            return (Criteria) this;
        }

        public Criteria andFCMediaNotBetween(Integer value1, Integer value2) {
            addCriterion("FCMedia not between", value1, value2, "FCMedia");
            return (Criteria) this;
        }

        public Criteria andFecha_bajaIsNull() {
            addCriterion("Fecha_baja is null");
            return (Criteria) this;
        }

        public Criteria andFecha_bajaIsNotNull() {
            addCriterion("Fecha_baja is not null");
            return (Criteria) this;
        }

        public Criteria andFecha_bajaEqualTo(Date value) {
            addCriterionForJDBCDate("Fecha_baja =", value, "fecha_baja");
            return (Criteria) this;
        }

        public Criteria andFecha_bajaNotEqualTo(Date value) {
            addCriterionForJDBCDate("Fecha_baja <>", value, "fecha_baja");
            return (Criteria) this;
        }

        public Criteria andFecha_bajaGreaterThan(Date value) {
            addCriterionForJDBCDate("Fecha_baja >", value, "fecha_baja");
            return (Criteria) this;
        }

        public Criteria andFecha_bajaGreaterThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("Fecha_baja >=", value, "fecha_baja");
            return (Criteria) this;
        }

        public Criteria andFecha_bajaLessThan(Date value) {
            addCriterionForJDBCDate("Fecha_baja <", value, "fecha_baja");
            return (Criteria) this;
        }

        public Criteria andFecha_bajaLessThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("Fecha_baja <=", value, "fecha_baja");
            return (Criteria) this;
        }

        public Criteria andFecha_bajaIn(List<Date> values) {
            addCriterionForJDBCDate("Fecha_baja in", values, "fecha_baja");
            return (Criteria) this;
        }

        public Criteria andFecha_bajaNotIn(List<Date> values) {
            addCriterionForJDBCDate("Fecha_baja not in", values, "fecha_baja");
            return (Criteria) this;
        }

        public Criteria andFecha_bajaBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("Fecha_baja between", value1, value2, "fecha_baja");
            return (Criteria) this;
        }

        public Criteria andFecha_bajaNotBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("Fecha_baja not between", value1, value2, "fecha_baja");
            return (Criteria) this;
        }

        public Criteria andId_tipo_testIsNull() {
            addCriterion("id_tipo_test is null");
            return (Criteria) this;
        }

        public Criteria andId_tipo_testIsNotNull() {
            addCriterion("id_tipo_test is not null");
            return (Criteria) this;
        }

        public Criteria andId_tipo_testEqualTo(Integer value) {
            addCriterion("id_tipo_test =", value, "id_tipo_test");
            return (Criteria) this;
        }

        public Criteria andId_tipo_testNotEqualTo(Integer value) {
            addCriterion("id_tipo_test <>", value, "id_tipo_test");
            return (Criteria) this;
        }

        public Criteria andId_tipo_testGreaterThan(Integer value) {
            addCriterion("id_tipo_test >", value, "id_tipo_test");
            return (Criteria) this;
        }

        public Criteria andId_tipo_testGreaterThanOrEqualTo(Integer value) {
            addCriterion("id_tipo_test >=", value, "id_tipo_test");
            return (Criteria) this;
        }

        public Criteria andId_tipo_testLessThan(Integer value) {
            addCriterion("id_tipo_test <", value, "id_tipo_test");
            return (Criteria) this;
        }

        public Criteria andId_tipo_testLessThanOrEqualTo(Integer value) {
            addCriterion("id_tipo_test <=", value, "id_tipo_test");
            return (Criteria) this;
        }

        public Criteria andId_tipo_testIn(List<Integer> values) {
            addCriterion("id_tipo_test in", values, "id_tipo_test");
            return (Criteria) this;
        }

        public Criteria andId_tipo_testNotIn(List<Integer> values) {
            addCriterion("id_tipo_test not in", values, "id_tipo_test");
            return (Criteria) this;
        }

        public Criteria andId_tipo_testBetween(Integer value1, Integer value2) {
            addCriterion("id_tipo_test between", value1, value2, "id_tipo_test");
            return (Criteria) this;
        }

        public Criteria andId_tipo_testNotBetween(Integer value1, Integer value2) {
            addCriterion("id_tipo_test not between", value1, value2, "id_tipo_test");
            return (Criteria) this;
        }

        public Criteria andId_entreno_ejercicioIsNull() {
            addCriterion("id_entreno_ejercicio is null");
            return (Criteria) this;
        }

        public Criteria andId_entreno_ejercicioIsNotNull() {
            addCriterion("id_entreno_ejercicio is not null");
            return (Criteria) this;
        }

        public Criteria andId_entreno_ejercicioEqualTo(Integer value) {
            addCriterion("id_entreno_ejercicio =", value, "id_entreno_ejercicio");
            return (Criteria) this;
        }

        public Criteria andId_entreno_ejercicioNotEqualTo(Integer value) {
            addCriterion("id_entreno_ejercicio <>", value, "id_entreno_ejercicio");
            return (Criteria) this;
        }

        public Criteria andId_entreno_ejercicioGreaterThan(Integer value) {
            addCriterion("id_entreno_ejercicio >", value, "id_entreno_ejercicio");
            return (Criteria) this;
        }

        public Criteria andId_entreno_ejercicioGreaterThanOrEqualTo(Integer value) {
            addCriterion("id_entreno_ejercicio >=", value, "id_entreno_ejercicio");
            return (Criteria) this;
        }

        public Criteria andId_entreno_ejercicioLessThan(Integer value) {
            addCriterion("id_entreno_ejercicio <", value, "id_entreno_ejercicio");
            return (Criteria) this;
        }

        public Criteria andId_entreno_ejercicioLessThanOrEqualTo(Integer value) {
            addCriterion("id_entreno_ejercicio <=", value, "id_entreno_ejercicio");
            return (Criteria) this;
        }

        public Criteria andId_entreno_ejercicioIn(List<Integer> values) {
            addCriterion("id_entreno_ejercicio in", values, "id_entreno_ejercicio");
            return (Criteria) this;
        }

        public Criteria andId_entreno_ejercicioNotIn(List<Integer> values) {
            addCriterion("id_entreno_ejercicio not in", values, "id_entreno_ejercicio");
            return (Criteria) this;
        }

        public Criteria andId_entreno_ejercicioBetween(Integer value1, Integer value2) {
            addCriterion("id_entreno_ejercicio between", value1, value2, "id_entreno_ejercicio");
            return (Criteria) this;
        }

        public Criteria andId_entreno_ejercicioNotBetween(Integer value1, Integer value2) {
            addCriterion("id_entreno_ejercicio not between", value1, value2, "id_entreno_ejercicio");
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