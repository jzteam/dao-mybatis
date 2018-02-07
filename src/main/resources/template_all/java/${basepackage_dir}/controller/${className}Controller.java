<#include "/macro.include">
<#assign className = table.className>
<#assign classNameLower = className?uncap_first>

package ${basepackage}.controller;

import org.springframework.beans.factory.annotation.Autowired;
import ${basepackage}.service.${className}Service;
import org.springframework.stereotype.Controller;

@Controller
@RequestMapping("/${className}")
public class ${className}Controller {
	
	@Autowired
	private ${className}Service service;

	@RequestMapping("/index")
	public String index(){
		return "${className}/index";
	}

}
