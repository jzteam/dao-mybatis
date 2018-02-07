import org.springframework.beans.factory.annotation.Autowired;

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

	@Autowired
	private ${className}Dao ${classNameLower}Dao;


	private ${className}Entity convertForm2entity(${className} form){
		if(form == null){
			return null;
		}
		${className}Entity entity = new ${className}Entity();
		<#list table.columns as column>
		entity.set${column.columnName}(form.get${column.columnName}());
		</#list>
		return entity;
	}

	private ${className} convertEntity2form(${className}Entity entity){
		if(entity == null){
			return null;
		}
		${className} form = new ${className}();
		<#list table.columns as column>
		form.set${column.columnName}(entity.get${column.columnName}());
		</#list>
		return form;
	}


}
