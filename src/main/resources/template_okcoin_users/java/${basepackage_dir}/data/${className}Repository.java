<#include "/macro.include"/>
<#assign className = table.className>
package ${basepackage}.data;

import com.okcoin.commons.mybatis.data.CrudRepository;
import ${basepackage}.domain.${className};
import ${basepackage}.domain.example.${className}Example;
import org.springframework.stereotype.Repository;

/**
 *
 * @author ${author}
 */
@Repository
public interface ${className}Repository
        extends CrudRepository<${className}, ${className}Example, ${table.idColumn.simpleJavaType}> {

}