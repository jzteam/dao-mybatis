<#include "/macro.include"/>
<#assign className = table.className>
<#assign classNameLower = className?uncap_first> 
package ${basepackage}.entity;

import java.math.BigDecimal;
<#include "/java_imports.include">

public class ${className}Entity implements Serializable{

    private static final long serialVersionUID=-1L;

	<@generateFields />

	<@generateProperties />

}

<#macro generateFields>
	<#list table.columns as column>
	/** ${column.columnAlias} */
	private ${column.simpleJavaType} ${column.columnNameLower};
	</#list>
</#macro>

<#macro generateProperties>
<#list table.columns as column>
	public ${column.simpleJavaType} get${column.columnName}() {
		return this.${column.columnNameLower};
	}

	public void set${column.columnName}(${column.simpleJavaType} value) {
		this.${column.columnNameLower} = value;
	}
</#list>
</#macro>