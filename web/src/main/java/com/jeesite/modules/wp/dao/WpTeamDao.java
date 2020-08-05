/**
 * Copyright (c) 2013-Now http://jeesite.com All rights reserved.
 */
package com.jeesite.modules.wp.dao;

import com.jeesite.common.dao.CrudDao;
import com.jeesite.common.mybatis.annotation.MyBatisDao;
import com.jeesite.modules.wp.entity.WpTeam;
import com.jeesite.modules.wp.entity.WpTeamUser;

import java.util.List;
import java.util.Map;

/**
 * 任务团队管理DAO接口
 * @author 程柱柱
 * @version 2020-07-31
 */
@MyBatisDao
public interface WpTeamDao extends CrudDao<WpTeam> {
	List<WpTeamUser> getUserList(WpTeamUser wpTeamUser)throws Exception;
	List<WpTeamUser> getUnselectList(WpTeamUser wpTeamUser)throws Exception;
	Integer getCountByNc()throws Exception;
	void addWpTeamMembers(WpTeamUser wpTeamUser);
	void delMembers(String wpTeamId);
}