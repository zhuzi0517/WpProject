/**
 * Copyright (c) 2013-Now http://jeesite.com All rights reserved.
 */
package com.jeesite.modules.wp.entity;

import org.hibernate.validator.constraints.Length;
import java.util.Date;
import java.util.List;

import com.jeesite.common.mybatis.annotation.JoinTable;
import com.jeesite.common.mybatis.annotation.JoinTable.Type;
import com.fasterxml.jackson.annotation.JsonFormat;

import com.jeesite.common.entity.DataEntity;
import com.jeesite.common.mybatis.annotation.Column;
import com.jeesite.common.mybatis.annotation.Table;
import com.jeesite.common.mybatis.mapper.query.QueryType;

/**
 * 任务信息管理Entity
 * @author czz
 * @version 2020-08-04
 */
@Table(name="wp_task", alias="a", columns={
		@Column(name="wp_task_id", attrName="wpTaskId", label="主键ID", isPK=true),
		@Column(name="task_no", attrName="taskNo", label="任务编号", isQuery=false),
		@Column(name="task_name", attrName="taskName", label="任务名称", queryType=QueryType.LIKE),
		@Column(name="task_level", attrName="taskLevel", label="任务等级"),
		@Column(name="task_category", attrName="taskCategory", label="任务类别"),
		@Column(name="end_time", attrName="endTime", label="结束时间", isQuery=false),
		@Column(name="begin_time", attrName="beginTime", label="开始时间", isQuery=false),
		@Column(name="task_indate", attrName="taskIndate", label="任务有效期", isQuery=false),
		@Column(name="task_address", attrName="taskAddress", label="任务地址", isQuery=false),
		@Column(name="task_description", attrName="taskDescription", label="任务描述", isQuery=false),
		@Column(name="remarks", attrName="remarks", label="备注", isQuery=false),
		@Column(name="create_by", attrName="createBy", label="创建人", isUpdate=false, isQuery=false),
		@Column(name="create_date", attrName="createDate", label="创建时间", isUpdate=false, isQuery=false),
		@Column(name="update_by", attrName="updateBy", label="更新人", isQuery=false),
		@Column(name="update_date", attrName="updateDate", label="更新时间", isQuery=false),
	}, orderBy="a.update_date DESC"
)
public class WpTask extends DataEntity<WpTask> {
	
	private static final long serialVersionUID = 1L;
	private String wpTaskId;		// 主键ID
	private String taskNo;		// 任务编号
	private String taskName;		// 任务名称
	private String taskLevel;		// 任务等级
	private String taskCategory;		// 任务类别
	private Date endTime;		// 结束时间
	private Date beginTime;		// 开始时间
	private String taskIndate;		// 任务有效期
	private String taskAddress;		// 任务地址
	private String taskDescription;		// 任务描述
	private String teamName;
	private List<WpTaskSub> wpTaskSubList;

	public String getTeamName() {
		return teamName;
	}

	public void setTeamName(String teamName) {
		this.teamName = teamName;
	}

	public List<WpTaskSub> getWpTaskSubList() {
		return wpTaskSubList;
	}

	public void setWpTaskSubList(List<WpTaskSub> wpTaskSubList) {
		this.wpTaskSubList = wpTaskSubList;
	}

	public WpTask() {
		this(null);
	}

	public WpTask(String id){
		super(id);
	}
	
	public String getWpTaskId() {
		return wpTaskId;
	}

	public void setWpTaskId(String wpTaskId) {
		this.wpTaskId = wpTaskId;
	}
	
	@Length(min=0, max=64, message="任务编号长度不能超过 64 个字符")
	public String getTaskNo() {
		return taskNo;
	}

	public void setTaskNo(String taskNo) {
		this.taskNo = taskNo;
	}
	
	@Length(min=0, max=64, message="任务名称长度不能超过 64 个字符")
	public String getTaskName() {
		return taskName;
	}

	public void setTaskName(String taskName) {
		this.taskName = taskName;
	}
	
	@Length(min=0, max=64, message="任务等级长度不能超过 64 个字符")
	public String getTaskLevel() {
		return taskLevel;
	}

	public void setTaskLevel(String taskLevel) {
		this.taskLevel = taskLevel;
	}
	
	@Length(min=0, max=64, message="任务类别长度不能超过 64 个字符")
	public String getTaskCategory() {
		return taskCategory;
	}

	public void setTaskCategory(String taskCategory) {
		this.taskCategory = taskCategory;
	}
	
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	public Date getEndTime() {
		return endTime;
	}

	public void setEndTime(Date endTime) {
		this.endTime = endTime;
	}
	
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	public Date getBeginTime() {
		return beginTime;
	}

	public void setBeginTime(Date beginTime) {
		this.beginTime = beginTime;
	}
	
	@Length(min=0, max=64, message="任务有效期长度不能超过 64 个字符")
	public String getTaskIndate() {
		return taskIndate;
	}

	public void setTaskIndate(String taskIndate) {
		this.taskIndate = taskIndate;
	}
	
	@Length(min=0, max=64, message="任务地址长度不能超过 64 个字符")
	public String getTaskAddress() {
		return taskAddress;
	}

	public void setTaskAddress(String taskAddress) {
		this.taskAddress = taskAddress;
	}
	
	@Length(min=0, max=64, message="任务描述长度不能超过 64 个字符")
	public String getTaskDescription() {
		return taskDescription;
	}

	public void setTaskDescription(String taskDescription) {
		this.taskDescription = taskDescription;
	}
	
}