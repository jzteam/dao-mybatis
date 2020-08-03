<#include "/macro.include"/>
<#assign className = table.className>
<#assign classNameLower = className?uncap_first> 
package ${basepackage}.domain;

<#include "/java_imports.include">

public class Enum${className} {
<#list table.columns as column>
	/**
	 * ${column.columnAlias}
	 */
	private ${column.simpleJavaType} ${column.columnNameLower};
</#list>

	private final int code;
	private final String msg;
	Enum${className}(final int code, final String msg) {
		this.code = code;
		this.msg = msg;
	}

	public int getCode() {
		return this.code;
	}

	public String getMsg() {
		return this.msg;
	}

	public static Enum${className} getEnum(Integer code) {
		return CODE_MAP.get(code);
	}

	private static final Map<Integer, Enum${className}> CODE_MAP = new HashMap<>();
	static {
		for (Enum${className} typeEnum : Enum${className}.values()) {
			CODE_MAP.put(typeEnum.getCode(), typeEnum);
		}
	}
}