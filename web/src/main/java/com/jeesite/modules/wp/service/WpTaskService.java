/**
 * Copyright (c) 2013-Now http://jeesite.com All rights reserved.
 */
package com.jeesite.modules.wp.service;

import java.util.List;
import java.util.Map;
import java.util.UUID;

import com.google.common.collect.Maps;
import com.jeesite.modules.wp.entity.WpTaskSub;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.jeesite.common.entity.Page;
import com.jeesite.common.service.CrudService;
import com.jeesite.modules.wp.entity.WpTask;
import com.jeesite.modules.wp.dao.WpTaskDao;
import com.jeesite.modules.file.utils.FileUploadUtils;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 任务信息管理Service
 * @author czz
 * @version 2020-08-04
 */
@Service
@Transactional(readOnly=true)
public class WpTaskService extends CrudService<WpTaskDao, WpTask> {
	
	/**
	 * 获取单条数据
	 * @param wpTask
	 * @return
	 */
	@Override
	public WpTask get(WpTask wpTask) {
		return super.get(wpTask);
	}
	
	/**
	 * 查询分页数据
	 * @param wpTask 查询条件
	 * @return
	 */
	@Override
	public Page<WpTask> findPage(WpTask wpTask) {
		return super.findPage(wpTask);
	}

	/**
	 * 获取团队下拉框
	 * @return
	 */
	public List<WpTaskSub> getTeamList(){
		return dao.getTeamList();
	}

	/**
	 * 保存数据（插入或更新）
	 * @param wpTask
	 */
	@Override
	@Transactional(readOnly=false)
	public void save(WpTask wpTask) {
		super.save(wpTask);
		// 保存上传附件
		FileUploadUtils.saveFileUpload(wpTask.getId(), "wpTask_file");
		//先删除子表中当前任务ID的所有信息，再添加进子表
		dao.delWpTaskSub(wpTask.getWpTaskId());
		WpTaskSub wpTaskSub = new WpTaskSub();
		wpTaskSub.setWpTaskSubId(UUID.randomUUID().toString());
		wpTaskSub.setWpTaskId(wpTask.getWpTaskId());
		wpTaskSub.setWpTeamId(wpTask.getTeamName());
		wpTaskSub.setRemarks(wpTask.getRemarks());
		dao.addWpTaskSub(wpTaskSub);
	}
	
	/**
	 * 更新状态
	 * @param wpTask
	 */
	@Override
	@Transactional(readOnly=false)
	public void updateStatus(WpTask wpTask) {
		super.updateStatus(wpTask);
	}
	
	/**
	 * 删除数据
	 * @param wpTask
	 */
	@Override
	@Transactional(readOnly=false)
	public void delete(WpTask wpTask) {
		super.delete(wpTask);
	}

	/**
	 * 任务执行信息列表sql
	 * @param wpTask
	 * @return
	 */
	public Page<WpTask> getTaskExecuteList(WpTask wpTask){
		Page<WpTask> page = new Page<WpTask>();
		wpTask.setPage(page);
		List<WpTask> list = dao.getTaskExecuteList(wpTask);
		page.setList(list);
		return page;
	}
}