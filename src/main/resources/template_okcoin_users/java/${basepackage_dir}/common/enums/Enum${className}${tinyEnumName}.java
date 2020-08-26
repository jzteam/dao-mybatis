<#assign className = table.className>
<#assign classNameLower = className?uncap_first> 
package ${basepackage}.common.enums;

import java.util.HashMap;
import java.util.Map;

public class Enum${className}${tinyEnumName} {


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