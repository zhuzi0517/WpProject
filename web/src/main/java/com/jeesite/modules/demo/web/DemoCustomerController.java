/**
 * Copyright (c) 2013-Now http://jeesite.com All rights reserved.
 */
package com.jeesite.modules.demo.web;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.jeesite.common.config.Global;
import com.jeesite.common.entity.Page;
import com.jeesite.common.web.BaseController;
import com.jeesite.modules.demo.entity.DemoCustomer;
import com.jeesite.modules.demo.service.DemoCustomerService;

/**
 * demo_customerController
 * @author czz
 * @version 2020-07-28
 */
@Controller
@RequestMapping(value = "${adminPath}/demo/demoCustomer")
public class DemoCustomerController extends BaseController {

	@Autowired
	private DemoCustomerService demoCustomerService;
	
	/**
	 * 获取数据
	 */
	@ModelAttribute
	public DemoCustomer get(String id, boolean isNewRecord) {
		return demoCustomerService.get(id, isNewRecord);
	}
	
	/**
	 * 查询列表
	 */
	@RequiresPermissions("demo:demoCustomer:view")
	@RequestMapping(value = {"list", ""})
	public String list(DemoCustomer demoCustomer, Model model) {
		model.addAttribute("demoCustomer", demoCustomer);
		return "modules/demo/demoCustomerList";
	}
	
	/**
	 * 查询列表数据
	 */
	@RequiresPermissions("demo:demoCustomer:view")
	@RequestMapping(value = "listData")
	@ResponseBody
	public Page<DemoCustomer> listData(DemoCustomer demoCustomer, HttpServletRequest request, HttpServletResponse response) {
		demoCustomer.setPage(new Page<>(request, response));
		Page<DemoCustomer> page = demoCustomerService.findPage(demoCustomer);
		return page;
	}

	/**
	 * 查看编辑表单
	 */
	@RequiresPermissions("demo:demoCustomer:view")
	@RequestMapping(value = "form")
	public String form(DemoCustomer demoCustomer, Model model) {
		model.addAttribute("demoCustomer", demoCustomer);
		return "modules/demo/demoCustomerForm";
	}

	/**
	 * 保存数据
	 */
	@RequiresPermissions("demo:demoCustomer:edit")
	@PostMapping(value = "save")
	@ResponseBody
	public String save(@Validated DemoCustomer demoCustomer) {
		demoCustomerService.save(demoCustomer);
		return renderResult(Global.TRUE, text("保存demo_customer成功！"));
	}
	
	/**
	 * 删除数据
	 */
	@RequiresPermissions("demo:demoCustomer:edit")
	@RequestMapping(value = "delete")
	@ResponseBody
	public String delete(DemoCustomer demoCustomer) {
		demoCustomerService.delete(demoCustomer);
		return renderResult(Global.TRUE, text("删除demo_customer成功！"));
	}
	
}