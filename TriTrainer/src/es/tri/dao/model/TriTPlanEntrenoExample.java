package es.tri.dao.model;

import java.util.ArrayList;
import java.util.List;

public class TriTPlanEntrenoExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public TriTPlanEntrenoExample() {
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

        public Criteria andId_planIsNull() {
            addCriterion("id_plan is null");
            return (Criteria) this;
        }

        public Criteria andId_planIsNotNull() {
            addCriterion("id_plan is not null");
            return (Criteria) this;
        }

        public Criteria andId_planEqualTo(Integer value) {
            addCriterion("id_plan =", value, "id_plan");
            return (Criteria) this;
        }

        public Criteria andId_planNotEqualTo(Integer value) {
            addCriterion("id_plan <>", value, "id_plan");
            return (Criteria) this;
        }

        public Criteria andId_planGreaterThan(Integer value) {
            addCriterion("id_plan >", value, "id_plan");
            return (Criteria) this;
        }

        public Criteria andId_planGreaterThanOrEqualTo(Integer value) {
            addCriterion("id_plan >=", value, "id_plan");
            return (Criteria) this;
        }

        public Criteria andId_planLessThan(Integer value) {
            addCriterion("id_plan <", value, "id_plan");
            return (Criteria) this;
        }

        public Criteria andId_planLessThanOrEqualTo(Integer value) {
            addCriterion("id_plan <=", value, "id_plan");
            return (Criteria) this;
        }

        public Criteria andId_planIn(List<Integer> values) {
            addCriterion("id_plan in", values, "id_plan");
            return (Criteria) this;
        }

        public Criteria andId_planNotIn(List<Integer> values) {
            addCriterion("id_plan not in", values, "id_plan");
            return (Criteria) this;
        }

        public Criteria andId_planBetween(Integer value1, Integer value2) {
            addCriterion("id_plan between", value1, value2, "id_plan");
            return (Criteria) this;
        }

        public Criteria andId_planNotBetween(Integer value1, Integer value2) {
            addCriterion("id_plan not between", value1, value2, "id_plan");
            return (Criteria) this;
        }

        public Criteria andId_tipo_entrenoIsNull() {
            addCriterion("id_tipo_entreno is null");
            return (Criteria) this;
        }

        public Criteria andId_tipo_entrenoIsNotNull() {
            addCriterion("id_tipo_entreno is not null");
            return (Criteria) this;
        }

        public Criteria andId_tipo_entrenoEqualTo(Integer value) {
            addCriterion("id_tipo_entreno =", value, "id_tipo_entreno");
            return (Criteria) this;
        }

        public Criteria andId_tipo_entrenoNotEqualTo(Integer value) {
            addCriterion("id_tipo_entreno <>", value, "id_tipo_entreno");
            return (Criteria) this;
        }

        public Criteria andId_tipo_entrenoGreaterThan(Integer value) {
            addCriterion("id_tipo_entreno >", value, "id_tipo_entreno");
            return (Criteria) this;
        }

        public Criteria andId_tipo_entrenoGreaterThanOrEqualTo(Integer value) {
            addCriterion("id_tipo_entreno >=", value, "id_tipo_entreno");
            return (Criteria) this;
        }

        public Criteria andId_tipo_entrenoLessThan(Integer value) {
            addCriterion("id_tipo_entreno <", value, "id_tipo_entreno");
            return (Criteria) this;
        }

        public Criteria andId_tipo_entrenoLessThanOrEqualTo(Integer value) {
            addCriterion("id_tipo_entreno <=", value, "id_tipo_entreno");
            return (Criteria) this;
        }

        public Criteria andId_tipo_entrenoIn(List<Integer> values) {
            addCriterion("id_tipo_entreno in", values, "id_tipo_entreno");
            return (Criteria) this;
        }

        public Criteria andId_tipo_entrenoNotIn(List<Integer> values) {
            addCriterion("id_tipo_entreno not in", values, "id_tipo_entreno");
            return (Criteria) this;
        }

        public Criteria andId_tipo_entrenoBetween(Integer value1, Integer value2) {
            addCriterion("id_tipo_entreno between", value1, value2, "id_tipo_entreno");
            return (Criteria) this;
        }

        public Criteria andId_tipo_entrenoNotBetween(Integer value1, Integer value2) {
            addCriterion("id_tipo_entreno not between", value1, value2, "id_tipo_entreno");
            return (Criteria) this;
        }

        public Criteria andFuerzaIsNull() {
            addCriterion("fuerza is null");
            return (Criteria) this;
        }

        public Criteria andFuerzaIsNotNull() {
            addCriterion("fuerza is not null");
            return (Criteria) this;
        }

        public Criteria andFuerzaEqualTo(Integer value) {
            addCriterion("fuerza =", value, "fuerza");
            return (Criteria) this;
        }

        public Criteria andFuerzaNotEqualTo(Integer value) {
            addCriterion("fuerza <>", value, "fuerza");
            return (Criteria) this;
        }

        public Criteria andFuerzaGreaterThan(Integer value) {
            addCriterion("fuerza >", value, "fuerza");
            return (Criteria) this;
        }

        public Criteria andFuerzaGreaterThanOrEqualTo(Integer value) {
            addCriterion("fuerza >=", value, "fuerza");
            return (Criteria) this;
        }

        public Criteria andFuerzaLessThan(Integer value) {
            addCriterion("fuerza <", value, "fuerza");
            return (Criteria) this;
        }

        public Criteria andFuerzaLessThanOrEqualTo(Integer value) {
            addCriterion("fuerza <=", value, "fuerza");
            return (Criteria) this;
        }

        public Criteria andFuerzaIn(List<Integer> values) {
            addCriterion("fuerza in", values, "fuerza");
            return (Criteria) this;
        }

        public Criteria andFuerzaNotIn(List<Integer> values) {
            addCriterion("fuerza not in", values, "fuerza");
            return (Criteria) this;
        }

        public Criteria andFuerzaBetween(Integer value1, Integer value2) {
            addCriterion("fuerza between", value1, value2, "fuerza");
            return (Criteria) this;
        }

        public Criteria andFuerzaNotBetween(Integer value1, Integer value2) {
            addCriterion("fuerza not between", value1, value2, "fuerza");
            return (Criteria) this;
        }

        public Criteria andVelocidadIsNull() {
            addCriterion("velocidad is null");
            return (Criteria) this;
        }

        public Criteria andVelocidadIsNotNull() {
            addCriterion("velocidad is not null");
            return (Criteria) this;
        }

        public Criteria andVelocidadEqualTo(Integer value) {
            addCriterion("velocidad =", value, "velocidad");
            return (Criteria) this;
        }

        public Criteria andVelocidadNotEqualTo(Integer value) {
            addCriterion("velocidad <>", value, "velocidad");
            return (Criteria) this;
        }

        public Criteria andVelocidadGreaterThan(Integer value) {
            addCriterion("velocidad >", value, "velocidad");
            return (Criteria) this;
        }

        public Criteria andVelocidadGreaterThanOrEqualTo(Integer value) {
            addCriterion("velocidad >=", value, "velocidad");
            return (Criteria) this;
        }

        public Criteria andVelocidadLessThan(Integer value) {
            addCriterion("velocidad <", value, "velocidad");
            return (Criteria) this;
        }

        public Criteria andVelocidadLessThanOrEqualTo(Integer value) {
            addCriterion("velocidad <=", value, "velocidad");
            return (Criteria) this;
        }

        public Criteria andVelocidadIn(List<Integer> values) {
            addCriterion("velocidad in", values, "velocidad");
            return (Criteria) this;
        }

        public Criteria andVelocidadNotIn(List<Integer> values) {
            addCriterion("velocidad not in", values, "velocidad");
            return (Criteria) this;
        }

        public Criteria andVelocidadBetween(Integer value1, Integer value2) {
            addCriterion("velocidad between", value1, value2, "velocidad");
            return (Criteria) this;
        }

        public Criteria andVelocidadNotBetween(Integer value1, Integer value2) {
            addCriterion("velocidad not between", value1, value2, "velocidad");
            return (Criteria) this;
        }

        public Criteria andTecnicaIsNull() {
            addCriterion("tecnica is null");
            return (Criteria) this;
        }

        public Criteria andTecnicaIsNotNull() {
            addCriterion("tecnica is not null");
            return (Criteria) this;
        }

        public Criteria andTecnicaEqualTo(Integer value) {
            addCriterion("tecnica =", value, "tecnica");
            return (Criteria) this;
        }

        public Criteria andTecnicaNotEqualTo(Integer value) {
            addCriterion("tecnica <>", value, "tecnica");
            return (Criteria) this;
        }

        public Criteria andTecnicaGreaterThan(Integer value) {
            addCriterion("tecnica >", value, "tecnica");
            return (Criteria) this;
        }

        public Criteria andTecnicaGreaterThanOrEqualTo(Integer value) {
            addCriterion("tecnica >=", value, "tecnica");
            return (Criteria) this;
        }

        public Criteria andTecnicaLessThan(Integer value) {
            addCriterion("tecnica <", value, "tecnica");
            return (Criteria) this;
        }

        public Criteria andTecnicaLessThanOrEqualTo(Integer value) {
            addCriterion("tecnica <=", value, "tecnica");
            return (Criteria) this;
        }

        public Criteria andTecnicaIn(List<Integer> values) {
            addCriterion("tecnica in", values, "tecnica");
            return (Criteria) this;
        }

        public Criteria andTecnicaNotIn(List<Integer> values) {
            addCriterion("tecnica not in", values, "tecnica");
            return (Criteria) this;
        }

        public Criteria andTecnicaBetween(Integer value1, Integer value2) {
            addCriterion("tecnica between", value1, value2, "tecnica");
            return (Criteria) this;
        }

        public Criteria andTecnicaNotBetween(Integer value1, Integer value2) {
            addCriterion("tecnica not between", value1, value2, "tecnica");
            return (Criteria) this;
        }

        public Criteria andRitmoIsNull() {
            addCriterion("ritmo is null");
            return (Criteria) this;
        }

        public Criteria andRitmoIsNotNull() {
            addCriterion("ritmo is not null");
            return (Criteria) this;
        }

        public Criteria andRitmoEqualTo(Integer value) {
            addCriterion("ritmo =", value, "ritmo");
            return (Criteria) this;
        }

        public Criteria andRitmoNotEqualTo(Integer value) {
            addCriterion("ritmo <>", value, "ritmo");
            return (Criteria) this;
        }

        public Criteria andRitmoGreaterThan(Integer value) {
            addCriterion("ritmo >", value, "ritmo");
            return (Criteria) this;
        }

        public Criteria andRitmoGreaterThanOrEqualTo(Integer value) {
            addCriterion("ritmo >=", value, "ritmo");
            return (Criteria) this;
        }

        public Criteria andRitmoLessThan(Integer value) {
            addCriterion("ritmo <", value, "ritmo");
            return (Criteria) this;
        }

        public Criteria andRitmoLessThanOrEqualTo(Integer value) {
            addCriterion("ritmo <=", value, "ritmo");
            return (Criteria) this;
        }

        public Criteria andRitmoIn(List<Integer> values) {
            addCriterion("ritmo in", values, "ritmo");
            return (Criteria) this;
        }

        public Criteria andRitmoNotIn(List<Integer> values) {
            addCriterion("ritmo not in", values, "ritmo");
            return (Criteria) this;
        }

        public Criteria andRitmoBetween(Integer value1, Integer value2) {
            addCriterion("ritmo between", value1, value2, "ritmo");
            return (Criteria) this;
        }

        public Criteria andRitmoNotBetween(Integer value1, Integer value2) {
            addCriterion("ritmo not between", value1, value2, "ritmo");
            return (Criteria) this;
        }

        public Criteria andId_disciplinaIsNull() {
            addCriterion("id_disciplina is null");
            return (Criteria) this;
        }

        public Criteria andId_disciplinaIsNotNull() {
            addCriterion("id_disciplina is not null");
            return (Criteria) this;
        }

        public Criteria andId_disciplinaEqualTo(Integer value) {
            addCriterion("id_disciplina =", value, "id_disciplina");
            return (Criteria) this;
        }

        public Criteria andId_disciplinaNotEqualTo(Integer value) {
            addCriterion("id_disciplina <>", value, "id_disciplina");
            return (Criteria) this;
        }

        public Criteria andId_disciplinaGreaterThan(Integer value) {
            addCriterion("id_disciplina >", value, "id_disciplina");
            return (Criteria) this;
        }

        public Criteria andId_disciplinaGreaterThanOrEqualTo(Integer value) {
            addCriterion("id_disciplina >=", value, "id_disciplina");
            return (Criteria) this;
        }

        public Criteria andId_disciplinaLessThan(Integer value) {
            addCriterion("id_disciplina <", value, "id_disciplina");
            return (Criteria) this;
        }

        public Criteria andId_disciplinaLessThanOrEqualTo(Integer value) {
            addCriterion("id_disciplina <=", value, "id_disciplina");
            return (Criteria) this;
        }

        public Criteria andId_disciplinaIn(List<Integer> values) {
            addCriterion("id_disciplina in", values, "id_disciplina");
            return (Criteria) this;
        }

        public Criteria andId_disciplinaNotIn(List<Integer> values) {
            addCriterion("id_disciplina not in", values, "id_disciplina");
            return (Criteria) this;
        }

        public Criteria andId_disciplinaBetween(Integer value1, Integer value2) {
            addCriterion("id_disciplina between", value1, value2, "id_disciplina");
            return (Criteria) this;
        }

        public Criteria andId_disciplinaNotBetween(Integer value1, Integer value2) {
            addCriterion("id_disciplina not between", value1, value2, "id_disciplina");
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