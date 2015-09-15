package es.tri.dao.model;

import java.util.ArrayList;
import java.util.List;

public class TriTModeloconocimientoExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public TriTModeloconocimientoExample() {
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

        public Criteria andIdInferenciaIsNull() {
            addCriterion("idInferencia is null");
            return (Criteria) this;
        }

        public Criteria andIdInferenciaIsNotNull() {
            addCriterion("idInferencia is not null");
            return (Criteria) this;
        }

        public Criteria andIdInferenciaEqualTo(Integer value) {
            addCriterion("idInferencia =", value, "idInferencia");
            return (Criteria) this;
        }

        public Criteria andIdInferenciaNotEqualTo(Integer value) {
            addCriterion("idInferencia <>", value, "idInferencia");
            return (Criteria) this;
        }

        public Criteria andIdInferenciaGreaterThan(Integer value) {
            addCriterion("idInferencia >", value, "idInferencia");
            return (Criteria) this;
        }

        public Criteria andIdInferenciaGreaterThanOrEqualTo(Integer value) {
            addCriterion("idInferencia >=", value, "idInferencia");
            return (Criteria) this;
        }

        public Criteria andIdInferenciaLessThan(Integer value) {
            addCriterion("idInferencia <", value, "idInferencia");
            return (Criteria) this;
        }

        public Criteria andIdInferenciaLessThanOrEqualTo(Integer value) {
            addCriterion("idInferencia <=", value, "idInferencia");
            return (Criteria) this;
        }

        public Criteria andIdInferenciaIn(List<Integer> values) {
            addCriterion("idInferencia in", values, "idInferencia");
            return (Criteria) this;
        }

        public Criteria andIdInferenciaNotIn(List<Integer> values) {
            addCriterion("idInferencia not in", values, "idInferencia");
            return (Criteria) this;
        }

        public Criteria andIdInferenciaBetween(Integer value1, Integer value2) {
            addCriterion("idInferencia between", value1, value2, "idInferencia");
            return (Criteria) this;
        }

        public Criteria andIdInferenciaNotBetween(Integer value1, Integer value2) {
            addCriterion("idInferencia not between", value1, value2, "idInferencia");
            return (Criteria) this;
        }

        public Criteria andBoolTiempoIsNull() {
            addCriterion("boolTiempo is null");
            return (Criteria) this;
        }

        public Criteria andBoolTiempoIsNotNull() {
            addCriterion("boolTiempo is not null");
            return (Criteria) this;
        }

        public Criteria andBoolTiempoEqualTo(Integer value) {
            addCriterion("boolTiempo =", value, "boolTiempo");
            return (Criteria) this;
        }

        public Criteria andBoolTiempoNotEqualTo(Integer value) {
            addCriterion("boolTiempo <>", value, "boolTiempo");
            return (Criteria) this;
        }

        public Criteria andBoolTiempoGreaterThan(Integer value) {
            addCriterion("boolTiempo >", value, "boolTiempo");
            return (Criteria) this;
        }

        public Criteria andBoolTiempoGreaterThanOrEqualTo(Integer value) {
            addCriterion("boolTiempo >=", value, "boolTiempo");
            return (Criteria) this;
        }

        public Criteria andBoolTiempoLessThan(Integer value) {
            addCriterion("boolTiempo <", value, "boolTiempo");
            return (Criteria) this;
        }

        public Criteria andBoolTiempoLessThanOrEqualTo(Integer value) {
            addCriterion("boolTiempo <=", value, "boolTiempo");
            return (Criteria) this;
        }

        public Criteria andBoolTiempoIn(List<Integer> values) {
            addCriterion("boolTiempo in", values, "boolTiempo");
            return (Criteria) this;
        }

        public Criteria andBoolTiempoNotIn(List<Integer> values) {
            addCriterion("boolTiempo not in", values, "boolTiempo");
            return (Criteria) this;
        }

        public Criteria andBoolTiempoBetween(Integer value1, Integer value2) {
            addCriterion("boolTiempo between", value1, value2, "boolTiempo");
            return (Criteria) this;
        }

        public Criteria andBoolTiempoNotBetween(Integer value1, Integer value2) {
            addCriterion("boolTiempo not between", value1, value2, "boolTiempo");
            return (Criteria) this;
        }

        public Criteria andBoolUmbralAerobioIsNull() {
            addCriterion("boolUmbralAerobio is null");
            return (Criteria) this;
        }

        public Criteria andBoolUmbralAerobioIsNotNull() {
            addCriterion("boolUmbralAerobio is not null");
            return (Criteria) this;
        }

        public Criteria andBoolUmbralAerobioEqualTo(Integer value) {
            addCriterion("boolUmbralAerobio =", value, "boolUmbralAerobio");
            return (Criteria) this;
        }

        public Criteria andBoolUmbralAerobioNotEqualTo(Integer value) {
            addCriterion("boolUmbralAerobio <>", value, "boolUmbralAerobio");
            return (Criteria) this;
        }

        public Criteria andBoolUmbralAerobioGreaterThan(Integer value) {
            addCriterion("boolUmbralAerobio >", value, "boolUmbralAerobio");
            return (Criteria) this;
        }

        public Criteria andBoolUmbralAerobioGreaterThanOrEqualTo(Integer value) {
            addCriterion("boolUmbralAerobio >=", value, "boolUmbralAerobio");
            return (Criteria) this;
        }

        public Criteria andBoolUmbralAerobioLessThan(Integer value) {
            addCriterion("boolUmbralAerobio <", value, "boolUmbralAerobio");
            return (Criteria) this;
        }

        public Criteria andBoolUmbralAerobioLessThanOrEqualTo(Integer value) {
            addCriterion("boolUmbralAerobio <=", value, "boolUmbralAerobio");
            return (Criteria) this;
        }

        public Criteria andBoolUmbralAerobioIn(List<Integer> values) {
            addCriterion("boolUmbralAerobio in", values, "boolUmbralAerobio");
            return (Criteria) this;
        }

        public Criteria andBoolUmbralAerobioNotIn(List<Integer> values) {
            addCriterion("boolUmbralAerobio not in", values, "boolUmbralAerobio");
            return (Criteria) this;
        }

        public Criteria andBoolUmbralAerobioBetween(Integer value1, Integer value2) {
            addCriterion("boolUmbralAerobio between", value1, value2, "boolUmbralAerobio");
            return (Criteria) this;
        }

        public Criteria andBoolUmbralAerobioNotBetween(Integer value1, Integer value2) {
            addCriterion("boolUmbralAerobio not between", value1, value2, "boolUmbralAerobio");
            return (Criteria) this;
        }

        public Criteria andBoolFuerzaIsNull() {
            addCriterion("boolFuerza is null");
            return (Criteria) this;
        }

        public Criteria andBoolFuerzaIsNotNull() {
            addCriterion("boolFuerza is not null");
            return (Criteria) this;
        }

        public Criteria andBoolFuerzaEqualTo(Integer value) {
            addCriterion("boolFuerza =", value, "boolFuerza");
            return (Criteria) this;
        }

        public Criteria andBoolFuerzaNotEqualTo(Integer value) {
            addCriterion("boolFuerza <>", value, "boolFuerza");
            return (Criteria) this;
        }

        public Criteria andBoolFuerzaGreaterThan(Integer value) {
            addCriterion("boolFuerza >", value, "boolFuerza");
            return (Criteria) this;
        }

        public Criteria andBoolFuerzaGreaterThanOrEqualTo(Integer value) {
            addCriterion("boolFuerza >=", value, "boolFuerza");
            return (Criteria) this;
        }

        public Criteria andBoolFuerzaLessThan(Integer value) {
            addCriterion("boolFuerza <", value, "boolFuerza");
            return (Criteria) this;
        }

        public Criteria andBoolFuerzaLessThanOrEqualTo(Integer value) {
            addCriterion("boolFuerza <=", value, "boolFuerza");
            return (Criteria) this;
        }

        public Criteria andBoolFuerzaIn(List<Integer> values) {
            addCriterion("boolFuerza in", values, "boolFuerza");
            return (Criteria) this;
        }

        public Criteria andBoolFuerzaNotIn(List<Integer> values) {
            addCriterion("boolFuerza not in", values, "boolFuerza");
            return (Criteria) this;
        }

        public Criteria andBoolFuerzaBetween(Integer value1, Integer value2) {
            addCriterion("boolFuerza between", value1, value2, "boolFuerza");
            return (Criteria) this;
        }

        public Criteria andBoolFuerzaNotBetween(Integer value1, Integer value2) {
            addCriterion("boolFuerza not between", value1, value2, "boolFuerza");
            return (Criteria) this;
        }

        public Criteria andBoolTecnicaIsNull() {
            addCriterion("boolTecnica is null");
            return (Criteria) this;
        }

        public Criteria andBoolTecnicaIsNotNull() {
            addCriterion("boolTecnica is not null");
            return (Criteria) this;
        }

        public Criteria andBoolTecnicaEqualTo(Integer value) {
            addCriterion("boolTecnica =", value, "boolTecnica");
            return (Criteria) this;
        }

        public Criteria andBoolTecnicaNotEqualTo(Integer value) {
            addCriterion("boolTecnica <>", value, "boolTecnica");
            return (Criteria) this;
        }

        public Criteria andBoolTecnicaGreaterThan(Integer value) {
            addCriterion("boolTecnica >", value, "boolTecnica");
            return (Criteria) this;
        }

        public Criteria andBoolTecnicaGreaterThanOrEqualTo(Integer value) {
            addCriterion("boolTecnica >=", value, "boolTecnica");
            return (Criteria) this;
        }

        public Criteria andBoolTecnicaLessThan(Integer value) {
            addCriterion("boolTecnica <", value, "boolTecnica");
            return (Criteria) this;
        }

        public Criteria andBoolTecnicaLessThanOrEqualTo(Integer value) {
            addCriterion("boolTecnica <=", value, "boolTecnica");
            return (Criteria) this;
        }

        public Criteria andBoolTecnicaIn(List<Integer> values) {
            addCriterion("boolTecnica in", values, "boolTecnica");
            return (Criteria) this;
        }

        public Criteria andBoolTecnicaNotIn(List<Integer> values) {
            addCriterion("boolTecnica not in", values, "boolTecnica");
            return (Criteria) this;
        }

        public Criteria andBoolTecnicaBetween(Integer value1, Integer value2) {
            addCriterion("boolTecnica between", value1, value2, "boolTecnica");
            return (Criteria) this;
        }

        public Criteria andBoolTecnicaNotBetween(Integer value1, Integer value2) {
            addCriterion("boolTecnica not between", value1, value2, "boolTecnica");
            return (Criteria) this;
        }

        public Criteria andBoolVelocidadIsNull() {
            addCriterion("boolVelocidad is null");
            return (Criteria) this;
        }

        public Criteria andBoolVelocidadIsNotNull() {
            addCriterion("boolVelocidad is not null");
            return (Criteria) this;
        }

        public Criteria andBoolVelocidadEqualTo(Integer value) {
            addCriterion("boolVelocidad =", value, "boolVelocidad");
            return (Criteria) this;
        }

        public Criteria andBoolVelocidadNotEqualTo(Integer value) {
            addCriterion("boolVelocidad <>", value, "boolVelocidad");
            return (Criteria) this;
        }

        public Criteria andBoolVelocidadGreaterThan(Integer value) {
            addCriterion("boolVelocidad >", value, "boolVelocidad");
            return (Criteria) this;
        }

        public Criteria andBoolVelocidadGreaterThanOrEqualTo(Integer value) {
            addCriterion("boolVelocidad >=", value, "boolVelocidad");
            return (Criteria) this;
        }

        public Criteria andBoolVelocidadLessThan(Integer value) {
            addCriterion("boolVelocidad <", value, "boolVelocidad");
            return (Criteria) this;
        }

        public Criteria andBoolVelocidadLessThanOrEqualTo(Integer value) {
            addCriterion("boolVelocidad <=", value, "boolVelocidad");
            return (Criteria) this;
        }

        public Criteria andBoolVelocidadIn(List<Integer> values) {
            addCriterion("boolVelocidad in", values, "boolVelocidad");
            return (Criteria) this;
        }

        public Criteria andBoolVelocidadNotIn(List<Integer> values) {
            addCriterion("boolVelocidad not in", values, "boolVelocidad");
            return (Criteria) this;
        }

        public Criteria andBoolVelocidadBetween(Integer value1, Integer value2) {
            addCriterion("boolVelocidad between", value1, value2, "boolVelocidad");
            return (Criteria) this;
        }

        public Criteria andBoolVelocidadNotBetween(Integer value1, Integer value2) {
            addCriterion("boolVelocidad not between", value1, value2, "boolVelocidad");
            return (Criteria) this;
        }

        public Criteria andBoolRitmoIsNull() {
            addCriterion("boolRitmo is null");
            return (Criteria) this;
        }

        public Criteria andBoolRitmoIsNotNull() {
            addCriterion("boolRitmo is not null");
            return (Criteria) this;
        }

        public Criteria andBoolRitmoEqualTo(Integer value) {
            addCriterion("boolRitmo =", value, "boolRitmo");
            return (Criteria) this;
        }

        public Criteria andBoolRitmoNotEqualTo(Integer value) {
            addCriterion("boolRitmo <>", value, "boolRitmo");
            return (Criteria) this;
        }

        public Criteria andBoolRitmoGreaterThan(Integer value) {
            addCriterion("boolRitmo >", value, "boolRitmo");
            return (Criteria) this;
        }

        public Criteria andBoolRitmoGreaterThanOrEqualTo(Integer value) {
            addCriterion("boolRitmo >=", value, "boolRitmo");
            return (Criteria) this;
        }

        public Criteria andBoolRitmoLessThan(Integer value) {
            addCriterion("boolRitmo <", value, "boolRitmo");
            return (Criteria) this;
        }

        public Criteria andBoolRitmoLessThanOrEqualTo(Integer value) {
            addCriterion("boolRitmo <=", value, "boolRitmo");
            return (Criteria) this;
        }

        public Criteria andBoolRitmoIn(List<Integer> values) {
            addCriterion("boolRitmo in", values, "boolRitmo");
            return (Criteria) this;
        }

        public Criteria andBoolRitmoNotIn(List<Integer> values) {
            addCriterion("boolRitmo not in", values, "boolRitmo");
            return (Criteria) this;
        }

        public Criteria andBoolRitmoBetween(Integer value1, Integer value2) {
            addCriterion("boolRitmo between", value1, value2, "boolRitmo");
            return (Criteria) this;
        }

        public Criteria andBoolRitmoNotBetween(Integer value1, Integer value2) {
            addCriterion("boolRitmo not between", value1, value2, "boolRitmo");
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