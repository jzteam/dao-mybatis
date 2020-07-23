<#assign className = table.className>
<#assign classNameLower = className?uncap_first>
package ${basepackage}.service.impl;

import ${basepackage}.domain.${className};
import ${basepackage}.domain.example.${className}Example;
import ${basepackage}.data.${className}Repository;
import ${basepackage}.service.${className}Service;
import com.okcoin.commons.mybatis.service.AbstractCrudService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Slf4j
@Service
public class ${className}ServiceImpl extends AbstractCrudService<${className}Repository, ${className}, ${className}Example, ${table.idColumn.simpleJavaType}>
	implements ${className}Service {

	@Autowired
	private ${className}Repository ${classNameLower}Repos;

	@Override
	protected ${className}Example getPageExample(final String fieldName, final String keyword) {
	final ${className}Example example = new ${className}Example();
		example.createCriteria().andFieldLike(fieldName, keyword);
		return example;
	}

}
