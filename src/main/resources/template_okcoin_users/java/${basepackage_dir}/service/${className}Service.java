<#include "/macro.include">
<#assign className = table.className>
<#assign classNameLower = className?uncap_first>
package ${basepackage}.service;

import ${basepackage}.domain.${className};
import ${basepackage}.domain.example.${className}Example;
import com.okcoin.commons.mybatis.service.CrudService;

/**
 *
 * @author ${author}
 */
public interface ${className}Service
        extends CrudService<${className}, ${className}Example, ${table.idColumn.simpleJavaType}>{

}
