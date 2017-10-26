<#include "/macro.include">
<#assign className = table.className>
<#assign classNameLower = className?uncap_first>

package ${basepackage}.service;
import ${basepackage}.dao.entity.${className}Entity;
import ${basepackage}.dao.query.${className}BaseQuery;

import cn.jzteam.swift.service.BaseService;

public interface ${className}Service extends BaseService<${className}Entity, ${className}BaseQuery, ${table.idColumn.simpleJavaType}>{

}
