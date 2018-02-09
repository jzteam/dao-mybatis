<#include "/macro.include"/>
<#assign className = table.className>
package ${basepackage}.dao;

import cn.jzteam.swift.dao.BaseDao;
import ${basepackage}.dao.entity.${className}Entity;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;

@Component
@Mapper
public interface ${className}Dao extends BaseDao<${className}Entity, ${table.idColumn.simpleJavaType}>{

}