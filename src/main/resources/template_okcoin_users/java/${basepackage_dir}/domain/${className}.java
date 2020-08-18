<#include "/macro.include"/>
<#assign className = table.className>
<#assign classNameLower = className?uncap_first> 
package ${basepackage}.domain;

<#include "/java_imports.include">
import lombok.*

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class ${className} {
<#list table.columns as column>
	/**
	 * ${column.columnAlias}
	 */
	private ${column.simpleJavaType} ${column.columnNameLower};
</#list>
}