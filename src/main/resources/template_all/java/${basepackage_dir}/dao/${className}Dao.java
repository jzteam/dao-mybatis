<#include "/macro.include"/>
<#assign className = table.className>
package ${basepackage}.dao;

import cn.jzteam.swift.dao.BaseDao;
import ${basepackage}.dao.entity.${className}Entity;
import ${basepackage}.dao.query.${className}BaseQuery;

import org.springframework.stereotype.Repository;

@Repository
public interface ${className}Dao extends BaseDao<${className}Entity, ${className}BaseQuery, ${table.idColumn.simpleJavaType}>{

}