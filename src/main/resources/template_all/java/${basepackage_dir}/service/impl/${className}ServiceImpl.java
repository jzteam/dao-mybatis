<#include "/macro.include">
<#assign className = table.className>
<#assign classNameLower = className?uncap_first>

package ${basepackage}.service.impl;

import ${basepackage}.dao.entity.${className}Entity;
import ${basepackage}.dao.query.${className}BaseQuery;
import ${basepackage}.service.${className}Service;
import cn.jzteam.swift.service.impl.AbstractBaseServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ${className}ServiceImpl extends AbstractBaseServiceImpl<${className}Entity, ${className}BaseQuery, ${table.idColumn.simpleJavaType}>
	implements ${className}Service{


}
