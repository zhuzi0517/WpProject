/**
 * Copyright (c) 2013-Now http://jeesite.com All rights reserved.
 */
package com.jeesite.modules.wp.dao;

import com.jeesite.common.dao.CrudDao;
import com.jeesite.common.mybatis.annotation.MyBatisDao;
import com.jeesite.modules.wp.entity.WpTask;
import com.jeesite.modules.wp.entity.WpTaskSub;

import java.util.List;

/**
 * 任务信息管理DAO接口
 * @author czz
 * @version 2020-08-04
 */
@MyBatisDao
public interface WpTaskDao extends CrudDao<WpTask> {
	List<WpTaskSub> getTeamList();
	void addWpTaskSub(WpTaskSub wpTaskSub);
	void delWpTaskSub(String wpTaskId);
}