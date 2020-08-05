/**
 * Copyright (c) 2013-Now http://jeesite.com All rights reserved.
 */
package com.jeesite.modules.wp.entity;

import org.hibernate.validator.constraints.Length;
import java.util.Date;
import com.jeesite.common.mybatis.annotation.JoinTable;
import com.jeesite.common.mybatis.annotation.JoinTable.Type;
import com.fasterxml.jackson.annotation.JsonFormat;

import com.jeesite.common.entity.DataEntity;
import com.jeesite.common.mybatis.annotation.Column;
import com.jeesite.common.mybatis.annotation.Table;
import com.jeesite.common.mybatis.mapper.query.QueryType;

/**
 * 任务团队管理Entity
 * @author 程柱柱
 * @version 2020-07-31
 */
@Table(name="wp_team", alias="a", columns={
		@Column(name="wp_team_id", attrName="wpTeamId", label="主键ID", isPK=true),
		@Column(name="team_name", attrName="teamName", label="团队名称", queryType=QueryType.LIKE),
		@Column(name="team_no", attrName="teamNo", label="团队编号", isQuery=false),
		@Column(name="area_name", attrName="areaName", label="所属区域名称", isQuery=false),
		@Column(name="area_code", attrName="areaCode", label="所属区域"),
		@Column(name="begin_time", attrName="beginTime", label="团队有效期开始时间"),
		@Column(name="end_time", attrName="endTime", label="团队有效期结束时间"),
		@Column(name="team_label", attrName="teamLabel", label="团队标签", queryType=QueryType.LIKE),
		@Column(name="team_status", attrName="teamStatus", label="状态", comment="状态(1:启用2：禁用)"),
		@Column(name="member_number", attrName="memberNumber", label="成员数量", isQuery=false),
		@Column(name="remarks", attrName="remarks", label="备注", isQuery=false),
		@Column(name="create_by", attrName="createBy", label="创建人", isUpdate=false, isQuery=false),
		@Column(name="create_date", attrName="createDate", label="创建时间", isUpdate=false, isQuery=false),
		@Column(name="update_by", attrName="updateBy", label="更新人", isQuery=false),
		@Column(name="update_date", attrName="updateDate", label="更新时间", isQuery=false),
	}, orderBy="a.update_date DESC"
)
public class WpTeam extends DataEntity<WpTeam> {
	
	private static final long serialVersionUID = 1L;
	private String wpTeamId;		// 主键ID
	private String teamName;		// 团队名称
	private String teamNo;		// 团队编号
	private String areaName;		// 所属区域名称
	private String areaCode;		// 所属区域
	private Date beginTime;		// 团队有效期开始时间
	private Date endTime;		// 团队有效期结束时间
	private String teamLabel;		// 团队标签
	private String dataJson;		// 数据json
	private String teamStatus;		// 状态(1:启用2：禁用)
	private Long memberNumber;		// 成员数量

	public String getDataJson() {
		return dataJson;
	}

	public void setDataJson(String dataJson) {
		this.dataJson = dataJson;
	}

	public WpTeam() {
		this(null);
	}

	public WpTeam(String id){
		super(id);
	}
	
	public String getWpTeamId() {
		return wpTeamId;
	}

	public void setWpTeamId(String wpTeamId) {
		this.wpTeamId = wpTeamId;
	}
	
	@Length(min=0, max=64, message="团队名称长度不能超过 64 个字符")
	public String getTeamName() {
		return teamName;
	}

	public void setTeamName(String teamName) {
		this.teamName = teamName;
	}
	
	@Length(min=0, max=64, message="团队编号长度不能超过 64 个字符")
	public String getTeamNo() {
		return teamNo;
	}

	public void setTeamNo(String teamNo) {
		this.teamNo = teamNo;
	}
	
	@Length(min=0, max=64, message="所属区域名称长度不能超过 64 个字符")
	public String getAreaName() {
		return areaName;
	}

	public void setAreaName(String areaName) {
		this.areaName = areaName;
	}
	
	@Length(min=0, max=64, message="所属区域长度不能超过 64 个字符")
	public String getAreaCode() {
		return areaCode;
	}

	public void setAreaCode(String areaCode) {
		this.areaCode = areaCode;
	}
	
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	public Date getBeginTime() {
		return beginTime;
	}

	public void setBeginTime(Date beginTime) {
		this.beginTime = beginTime;
	}
	
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	public Date getEndTime() {
		return endTime;
	}

	public void setEndTime(Date endTime) {
		this.endTime = endTime;
	}
	
	@Length(min=0, max=64, message="团队标签长度不能超过 64 个字符")
	public String getTeamLabel() {
		return teamLabel;
	}

	public void setTeamLabel(String teamLabel) {
		this.teamLabel = teamLabel;
	}
	
	@Length(min=0, max=1, message="状态长度不能超过 1 个字符")
	public String getTeamStatus() {
		return teamStatus;
	}

	public void setTeamStatus(String teamStatus) {
		this.teamStatus = teamStatus;
	}
	
	public Long getMemberNumber() {
		return memberNumber;
	}

	public void setMemberNumber(Long memberNumber) {
		this.memberNumber = memberNumber;
	}
	
}