<#include "/macro.include">
<#assign className = table.className>
<#assign classNameLower = className?uncap_first>
package ${basepackage}.controller;

import ${basepackage}.service.${className}Service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 *
 * @author ${author}
 */
@Slf4j
@RestController
@RequestMapping("/${classNameLower}")
public class ${className}Controller {
	
	@Autowired
	private ${className}Service ${classNameLower}Service;



}
