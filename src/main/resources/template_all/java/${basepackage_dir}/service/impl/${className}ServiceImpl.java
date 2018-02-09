<#include "/macro.include">
<#assign className = table.className>
<#assign classNameLower = className?uncap_first>
package ${basepackage}.service.impl;

import ${basepackage}.dao.entity.${className}Entity;
import ${basepackage}.dao.query.${className}BaseQuery;
import ${basepackage}.form.${className}Form;
import ${basepackage}.service.${className}Service;
import cn.jzteam.swift.service.impl.AbstractBaseServiceImpl;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.ArrayList;
import java.util.List;

@Service
public class ${className}ServiceImpl extends AbstractBaseServiceImpl<${className}Entity, ${table.idColumn.simpleJavaType}>
	implements ${className}Service{

	private ${className}Entity convertForm2entity(${className}Form form){
		if(form == null){
			return null;
		}
		${className}Entity entity = new ${className}Entity();
		<#list table.columns as column>
		entity.set${column.columnName}(form.get${column.columnName}());
		</#list>
		return entity;
	}

	private ${className}Form convertEntity2form(${className}Entity entity){
		if(entity == null){
			return null;
		}
		${className}Form form = new ${className}Form();
		<#list table.columns as column>
		form.set${column.columnName}(entity.get${column.columnName}());
		</#list>
		return form;
	}


	/**
	 * 修改与保存
	 */
	@Override
	public ${table.idColumn.simpleJavaType} saveForm(${className}Form form){
		// 条件判断

		// 转换
		${className}Entity entity = convertForm2entity(form);
		if(entity == null){
			return null;
		}

		// 插入返回
		return this.save(entity);

	}


	/**
	 * 查询列表
 	*/
	@Override
	public List<${className}Form> selectFormByQuery(${className}BaseQuery query){
		if(query == null){
			return null;
		}

		List<${className}Form> formList = new ArrayList<>();
		List<${className}Entity> entityList = this.selectList(query);
		if(CollectionUtils.isEmpty(entityList)){
			return formList;
		}

		entityList.forEach(x->{
			formList.add(convertEntity2form(x));
		});

		return formList;
	}

	/**
	 * 查询单条
	 */
	@Override
	public ${className}Form getFormById(${table.idColumn.simpleJavaType} id){
		if(id == null){
			return null;
		}
		${className}Entity entity = this.selectById(id);

		return convertEntity2form(entity);
	}

}
