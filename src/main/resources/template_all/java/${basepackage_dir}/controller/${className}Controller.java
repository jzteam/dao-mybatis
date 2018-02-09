<#include "/macro.include">
<#assign className = table.className>
<#assign classNameLower = className?uncap_first>
package ${basepackage}.controller;

import ${basepackage}.dao.query.${className}BaseQuery;
import ${basepackage}.form.${className}Form;
import ${basepackage}.service.${className}Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
@RequestMapping("/${classNameLower}")
public class ${className}Controller {
	
	@Autowired
	private ${className}Service service;

	/**
	 * 列表页
	 */
	@RequestMapping("/index")
	public String index(${className}BaseQuery query, HttpServletRequest request){
		// 查询数据列表
		request.setAttribute("formList", this.listByQuery(query));
		return "${className}/index";
	}

	/**
	 * 查询列表
	 */
	@RequestMapping("/list")
	@ResponseBody
	public List<${className}Form> listByQuery(${className}BaseQuery query){
		return service.selectFormByQuery(query);
	}

	/**
	 * 查询单条
	 */
	@RequestMapping("/get/{id}")
	@ResponseBody
	public ${className}Form getById(@PathVariable("id") ${table.idColumn.simpleJavaType} id, HttpServletRequest request){

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
