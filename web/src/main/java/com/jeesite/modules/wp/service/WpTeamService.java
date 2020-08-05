/**
 * Copyright (c) 2013-Now http://jeesite.com All rights reserved.
 */
package com.jeesite.modules.wp.service;

import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.UUID;

import com.jeesite.common.lang.StringUtils;
import com.jeesite.modules.wp.entity.WpTeamUser;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.jeesite.common.entity.Page;
import com.jeesite.common.service.CrudService;
import com.jeesite.modules.wp.entity.WpTeam;
import com.jeesite.modules.wp.dao.WpTeamDao;

/**
 * 任务团队管理Service
 * @author 程柱柱
 * @version 2020-07-31
 */
@Service
@Transactional(readOnly=true)
public class WpTeamService extends CrudService<WpTeamDao, WpTeam> {

	/**
	 *
	 * @param page
	 * @param wpTeamUser
	 * @means 自定义分页数据，查询待选成员列表信息
	 * @return page
	 * @throws Exception
	 */
	public Page<WpTeamUser> getUserList(Page<WpTeamUser> page,WpTeamUser wpTeamUser)throws Exception{
		if (wpTeamUser.getRandNum()==1){
			//获取网评员的总数
			Integer count = getCountByNc();
			int num = (int)(Math.random()*count)+1;
			wpTeamUser.setRandNum(num);
		}
		List<WpTeamUser> list = dao.getUserList(wpTeamUser);
		wpTeamUser.setPage(page);
		page.setList(list);
		return page;
	}

	/**
	 * 待选成员列表
	 * @param page
	 * @param wpTeamUser
	 * @return
	 * @throws Exception
	 */
	public Page<WpTeamUser> getUnselectList(Page<WpTeamUser> page,WpTeamUser wpTeamUser)throws Exception{
		if (wpTeamUser.getRandNum()==1){
			//获取网评员的总数
			Integer count = getCountByNc();
			int num = (int)(Math.random()*count)+1;
			wpTeamUser.setRandNum(num);
		}
		List<WpTeamUser> list = dao.getUnselectList(wpTeamUser);
		wpTeamUser.setPage(page);
		page.setList(list);
		return page;
	}

	/**
	 * 获取网评员表的数据，方便产生随机数
	 * @return
	 * @throws Exception
	 */
	public Integer getCountByNc()throws Exception{
		return dao.getCountByNc();
	}
	/**
	 * 获取单条数据
	 * @param wpTeam
	 * @return
	 */
	@Override
	public WpTeam get(WpTeam wpTeam) {
		return super.get(wpTeam);
	}
	
	/**
	 * 查询分页数据
	 * @param wpTeam 查询条件
	 * @return
	 */
	@Override
	public Page<WpTeam> findPage(WpTeam wpTeam) {
		return super.findPage(wpTeam);
	}
	
	/**
	 * 保存数据（插入或更新）
	 * @param wpTeam
	 */
	@Override
	@Transactional(readOnly=false)
	public void save(WpTeam wpTeam) {
		super.save(wpTeam);
		WpTeamUser wpTeamUser = new WpTeamUser();
		wpTeamUser.setWpTeamId(wpTeam.getWpTeamId());
		wpTeamUser.setCreateBy(wpTeam.getCreateBy());
		wpTeamUser.setCreateDate(wpTeam.getCreateDate());
		wpTeamUser.setUpdateBy(wpTeam.getUpdateBy());
		wpTeamUser.setUpdateDate(wpTeam.getCreateDate());
		String dataJson = wpTeam.getDataJson();
		if (StringUtils.isNotBlank(dataJson)){
				dao.delMembers(wpTeam.getWpTeamId());
			String[] split = dataJson.split(",");
			for (String userCode:split){
				wpTeamUser.setWpTeamMembersId(UUID.randomUUID().toString());
				wpTeamUser.setUserCode(userCode);
					dao.addWpTeamMembers(wpTeamUser);
			}
		}
	}
	
	/**
	 * 更新状态
	 * @param wpTeam
	 */
	@Override
	@Transactional(readOnly=false)
	public void updateStatus(WpTeam wpTeam) {
		super.updateStatus(wpTeam);
	}
	
	/**
	 * 删除数据
	 * @param wpTeam
	 */
	@Override
	@Transactional(readOnly=false)
	public void delete(WpTeam wpTeam) {
		super.delete(wpTeam);
	}
	
}