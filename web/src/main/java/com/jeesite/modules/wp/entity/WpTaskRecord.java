package com.jeesite.modules.wp.entity;

import com.jeesite.common.entity.DataEntity;

import java.util.Date;

/**
 * 任务信息记录表实体类
 * author：czz
 */
public class WpTaskRecord extends DataEntity<WpTaskRecord> {
    /**
     * 主键ID
     */
    private String wpTaskRecordId;

    /**
     * 任务信息ID
     */
    private String wpTaskId;

    /**
     * 执行操作
     */
    private String exeOperation;

    /**
     * 操作平台
     */
    private String opePlatform;

    /**
     * 操作记录数
     */
    private Integer opeNumber;

    /**
     * 任务状态
     */
    private String taskStatus;

    /**
     * 完成时间
     */
    private Date doneTime;

    /**
     * 任务执行人
     */
    private String taskExecutor;

    /**
     * 用户ID
     */
    private String userCode;

    /**
     * 备注
     */
    private String remarks;

    /**
     * 创建人
     */
    private String createBy;

    /**
     * 创建时间
     */
    private Date createDate;

    /**
     * 更新人
     */
    private String updateBy;

    /**
     * 更新时间
     */
    private Date updateDate;

    private static final long serialVersionUID = 1L;

    public String getWpTaskRecordId() {
        return wpTaskRecordId;
    }

    public void setWpTaskRecordId(String wpTaskRecordId) {
        this.wpTaskRecordId = wpTaskRecordId;
    }

    public String getWpTaskId() {
        return wpTaskId;
    }

    public void setWpTaskId(String wpTaskId) {
        this.wpTaskId = wpTaskId;
    }

    public String getExeOperation() {
        return exeOperation;
    }

    public void setExeOperation(String exeOperation) {
        this.exeOperation = exeOperation;
    }

    public String getOpePlatform() {
        return opePlatform;
    }

    public void setOpePlatform(String opePlatform) {
        this.opePlatform = opePlatform;
    }

    public Integer getOpeNumber() {
        return opeNumber;
    }

    public void setOpeNumber(Integer opeNumber) {
        this.opeNumber = opeNumber;
    }

    public String getTaskStatus() {
        return taskStatus;
    }

    public void setTaskStatus(String taskStatus) {
        this.taskStatus = taskStatus;
    }

    public Date getDoneTime() {
        return doneTime;
    }

    public void setDoneTime(Date doneTime) {
        this.doneTime = doneTime;
    }

    public String getTaskExecutor() {
        return taskExecutor;
    }

    public void setTaskExecutor(String taskExecutor) {
        this.taskExecutor = taskExecutor;
    }

    public String getUserCode() {
        return userCode;
    }

    public void setUserCode(String userCode) {
        this.userCode = userCode;
    }

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }

    public String getCreateBy() {
        return createBy;
    }

    public void setCreateBy(String createBy) {
        this.createBy = createBy;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public String getUpdateBy() {
        return updateBy;
    }

    public void setUpdateBy(String updateBy) {
        this.updateBy = updateBy;
    }

    public Date getUpdateDate() {
        return updateDate;
    }

    public void setUpdateDate(Date updateDate) {
        this.updateDate = updateDate;
    }

}
