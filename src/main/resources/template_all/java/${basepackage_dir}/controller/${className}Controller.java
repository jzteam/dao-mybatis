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

	/**
	 * 列表页
	 */
	@RequestMapping("/index")
	public String index(${className}BaseQuery query, HttpServletRequest request){
		// 查询数据列表
		List<${className}Form> formList = service.selectFormByQuery(query);
		request.addAttribute("formList", formList);
		return "${className}/index";
	}

	/**
	 * 查询单条
	 */
	@RequestMapping("/get/{id}")
	@ResponseBody
	public ${className} save(@PathVariable("id") ${table.idColumn.simpleJavaType} id, HttpServletRequest request){

		return service.getFormById(id);
	}

	/**
	 * 保存
	 */
	@RequestMapping("/save")
	public void save(${className}Form form, HttpServletRequest request){
		service.saveForm(form);
		return;
	}

	/**
	 * 删除
	 */
	@RequestMapping("/delete/{id}")
	public void save(@PathVariable("id") ${table.idColumn.simpleJavaType} id){
		service.delete(id);
		return;
	}

}
