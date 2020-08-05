/**
 * Copyright (c) 2013-Now http://jeesite.com All rights reserved.
 */
package com.jeesite.modules.wp.web;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jeesite.modules.wp.entity.WpTaskSub;
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
import com.jeesite.modules.wp.entity.WpTask;
import com.jeesite.modules.wp.service.WpTaskService;

import java.util.List;

/**
 * 任务信息管理Controller
 * @author czz
 * @version 2020-08-04
 */
@Controller
@RequestMapping(value = "${adminPath}/wp/wpTask")
public class WpTaskController extends BaseController {

	@Autowired
	private WpTaskService wpTaskService;
	
	/**
	 * 获取数据
	 */
	@ModelAttribute
	public WpTask get(String wpTaskId, boolean isNewRecord) {
		return wpTaskService.get(wpTaskId, isNewRecord);
	}
	
	/**
	 * 查询列表
	 */
	@RequiresPermissions("wp:wpTask:view")
	@RequestMapping(value = {"list", ""})
	public String list(WpTask wpTask, Model model) {
		model.addAttribute("wpTask", wpTask);
		return "modules/wp/wpTaskList";
	}
	
	/**
	 * 查询列表数据
	 */
	@RequiresPermissions("wp:wpTask:view")
	@RequestMapping(value = "listData")
	@ResponseBody
	public Page<WpTask> listData(WpTask wpTask, HttpServletRequest request, HttpServletResponse response) {
		wpTask.setPage(new Page<>(request, response));
		Page<WpTask> page = wpTaskService.findPage(wpTask);
		return page;
	}

	/**
	 * 查看编辑表单
	 */
	@RequiresPermissions("wp:wpTask:view")
	@RequestMapping(value = "form")
	public String form(WpTask wpTask, Model model) {
		model.addAttribute("wpTask", wpTask);
		List<WpTaskSub> WpTaskSubList = wpTaskService.getTeamList();
		model.addAttribute("WpTaskSubList",WpTaskSubList);
		return "modules/wp/wpTaskForm";
	}

	/**
	 * 保存数据
	 */
	@RequiresPermissions("wp:wpTask:edit")
	@PostMapping(value = "save")
	@ResponseBody
	public String save(@Validated WpTask wpTask) {
		wpTaskService.save(wpTask);
		return renderResult(Global.TRUE, text("保存任务信息管理成功！"));
	}
	
	/**
	 * 删除数据
	 */
	@RequiresPermissions("wp:wpTask:edit")
	@RequestMapping(value = "delete")
	@ResponseBody
	public String delete(WpTask wpTask) {
		wpTaskService.delete(wpTask);
		return renderResult(Global.TRUE, text("删除任务信息管理成功！"));
	}
	
}