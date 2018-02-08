<#include "/macro.include">
<#assign className = table.className>
<#assign classNameLower = className?uncap_first>

package ${basepackage}.service;
import ${basepackage}.dao.entity.${className}Entity;
import ${basepackage}.dao.query.${className}BaseQuery;

import cn.jzteam.swift.service.BaseService;

public interface ${className}Service extends BaseService<${className}Entity, ${table.idColumn.simpleJavaType}>{
    /**
     * 修改与保存
     */
    ${table.idColumn.simpleJavaType} saveForm(${className}Form form);

    /**
     * 删除
    */
    void delete(${table.idColumn.simpleJavaType} id);

    /**
     * 查询列表
     */
    List<${className}Form> selectFormByQuery(${className}BaseQuery query);

    /**
     * 查询单条
     */
    ${className}Form getFormById(${table.idColumn.simpleJavaType} id);


}
