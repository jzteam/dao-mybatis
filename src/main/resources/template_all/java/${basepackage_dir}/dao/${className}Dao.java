<#include "/macro.include"/>
<#assign className = table.className>
package ${basepackage}.dao;

import cn.jzteam.dao.BaseDao;

import org.springframework.stereotype.Repository;

@Repository
public interface ${className}Dao extends BaseDao<${className}Entity, ${table.idColumn.simpleJavaType}>{

}