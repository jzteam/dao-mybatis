<#assign className = table.className>
<#assign classNameLower = className?uncap_first>
package ${basepackage}.domain.example;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.math.BigDecimal;
<#include "/java_imports.include">

public class ${className}Example {

	protected String orderByClause;

	protected boolean distinct;

	protected List<Criteria> oredCriteria;

	public ${className}Example() {
		oredCriteria = new ArrayList<>();
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


		<@generateFields />

	}

	public static class Criteria extends GeneratedCriteria {

		protected Criteria() {
			super();
		}

		public Criteria andFieldLike(final String fieldName, final String keyword) {
			addCriterion(fieldName + " like ", keyword, fieldName);
			return this;
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

<#macro generateFields>
<#list table.columns as column>
	public Criteria and${column.columnName}IsNull() {
		addCriterion("${column.sqlName} is null");
		return (Criteria) this;
	}

	public Criteria and${column.columnName}IsNotNull() {
		addCriterion("${column.sqlName} is not null");
		return (Criteria) this;
	}

	public Criteria and${column.columnName}EqualTo(${column.simpleJavaType} value) {
		addCriterion("${column.sqlName} =", value, "${column.columnNameLower}");
		return (Criteria) this;
	}

	public Criteria and${column.columnName}NotEqualTo(${column.simpleJavaType} value) {
		addCriterion("${column.sqlName} <>", value, "${column.columnNameLower}");
		return (Criteria) this;
	}

	public Criteria and${column.columnName}In(List<${column.simpleJavaType}> values) {
		addCriterion("${column.sqlName} in", values, "${column.columnNameLower}");
		return (Criteria) this;
	}

	public Criteria and${column.columnName}NotIn(List<${column.simpleJavaType}> values) {
		addCriterion("${column.sqlName} not in", values, "${column.columnNameLower}");
		return (Criteria) this;
	}

	public Criteria and${column.columnName}Between(${column.simpleJavaType} value1, ${column.simpleJavaType} value2) {
		addCriterion("${column.sqlName} between", value1, value2, "${column.columnNameLower}");
		return (Criteria) this;
	}

	public Criteria and${column.columnName}NotBetween(${column.simpleJavaType} value1, ${column.simpleJavaType} value2) {
		addCriterion("${column.sqlName} not between", value1, value2, "${column.columnNameLower}");
		return (Criteria) this;
	}

	<#if column.simpleJavaType == "String">
	public Criteria and${column.columnName}Like(${column.simpleJavaType} value) {
		addCriterion("${column.sqlName} like", value, "${column.columnNameLower}");
		return (Criteria)this;
	}

	public Criteria and${column.columnName}NotLike(${column.simpleJavaType} value) {
		addCriterion("${column.sqlName} not like", value, "${column.columnNameLower}");
		return (Criteria)this;
	}
	<#else>
	public Criteria and${column.columnName}GreaterThan(${column.simpleJavaType} value) {
		addCriterion("${column.sqlName} >", value, "${column.columnNameLower}");
		return (Criteria)this;
	}

	public Criteria and${column.columnName}GreaterThanOrEqualTo(${column.simpleJavaType} value) {
		addCriterion("${column.sqlName} >=", value, "${column.columnNameLower}");
		return (Criteria)this;
	}

	public Criteria and${column.columnName}LessThan(${column.simpleJavaType} value) {
		addCriterion("${column.sqlName} <", value, "${column.columnNameLower}");
		return (Criteria)this;
	}

	public Criteria and${column.columnName}LessThanOrEqualTo(${column.simpleJavaType} value) {
		addCriterion("${column.sqlName} <=", value, "${column.columnNameLower}");
		return (Criteria)this;
	}
	</#if>
</#list>
</#macro>

