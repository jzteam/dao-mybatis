<#include "/macro.include"/>
<#assign className = table.className>
package ${basepackage};

import cn.jzteam.dao.mybatis.BaseDao;
import ${basepackage}.entity.${className}Entity;

import org.springframework.stereotype.Repository;

@Repository
public interface ${className}Dao extends BaseDao<${className}Entity, ${table.idColumn.simpleJavaType}>{

}