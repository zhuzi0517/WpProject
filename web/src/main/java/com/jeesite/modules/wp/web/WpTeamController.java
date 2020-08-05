/**
 * Copyright (c) 2013-Now http://jeesite.com All rights reserved.
 */
package com.jeesite.modules.wp.web;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jeesite.modules.wp.entity.WpTeamUser;
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
import com.jeesite.modules.wp.entity.WpTeam;
import com.jeesite.modules.wp.service.WpTeamService;

/**
 * 任务团队管理Controller
 * @author 程柱柱
 * @version 2020-07-31
 */
@Controller
@RequestMapping(value = "${adminPath}/wp/wpTeam")
public class WpTeamController extends BaseController {

	@Autowired
	private WpTeamService wpTeamService;
	
	/**
	 * 获取数据
	 */
	@ModelAttribute
	public WpTeam get(String wpTeamId, boolean isNewRecord) {
		return wpTeamService.get(wpTeamId, isNewRecord);
	}
	
	/**
	 * 查询列表
	 */
	@RequiresPermissions("wp:wpTeam:view")
	@RequestMapping(value = {"list", ""})
	public String list(WpTeam wpTeam, Model model) {
		model.addAttribute("wpTeam", wpTeam);
		return "modules/wp/wpTeamList";
	}
	
	/**
	 * 查询列表数据
	 */
	@RequiresPermissions("wp:wpTeam:view")
	@RequestMapping(value = "listData")
	@ResponseBody
	public Page<WpTeam> listData(WpTeam wpTeam, HttpServletRequest request, HttpServletResponse response) {
		wpTeam.setPage(new Page<>(request, response));
		Page<WpTeam> page = wpTeamService.findPage(wpTeam);
		return page;
	}

	/**
	 * 待选成员列表信息
	 * @param page
	 * @param wpTeamUser
	 * @return
	 * @throws Exception
	 */
	@RequiresPermissions("wp:wpTeam:view")
	@RequestMapping(value = "getUserList")
	@ResponseBody
	public Page<WpTeamUser> getUserList(Page<WpTeamUser> page, WpTeamUser wpTeamUser)throws Exception{
		return wpTeamService.getUserList(page,wpTeamUser);
	}

	/**
	 * 待选人员列表信息
	 * @param page
	 * @param wpTeamUser
	 * @return
	 * @throws Exception
	 */
	@RequiresPermissions("wp:wpTeam:view")
	@RequestMapping(value = "getUnselectList")
	@ResponseBody
	public Page<WpTeamUser> getUnselectList(Page<WpTeamUser> page, WpTeamUser wpTeamUser)throws Exception{
		return wpTeamService.getUnselectList(page,wpTeamUser);
	}


		/**
         * 查看编辑表单
         */
	@RequiresPermissions("wp:wpTeam:view")
	@RequestMapping(value = "form")
	public String form(WpTeam wpTeam, Model model) {
		model.addAttribute("wpTeam", wpTeam);
		return "modules/wp/wpTeamForm";
	}

	/**
	 * 保存数据
	 */
	@RequiresPermissions("wp:wpTeam:edit")
	@PostMapping(value = "save")
	@ResponseBody
	public String save(@Validated WpTeam wpTeam) {
		wpTeamService.save(wpTeam);
		return renderResult(Global.TRUE, text("保存任务团队管理成功！"));
	}
	
	/**
	 * 删除数据
	 */
	@RequiresPermissions("wp:wpTeam:edit")
	@RequestMapping(value = "delete")
	@ResponseBody
	public String delete(WpTeam wpTeam) {
		wpTeamService.delete(wpTeam);
		return renderResult(Global.TRUE, text("删除任务团队管理成功！"));
	}
	
}