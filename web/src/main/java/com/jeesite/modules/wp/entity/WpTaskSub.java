package com.jeesite.modules.wp.entity;

import com.jeesite.common.entity.DataEntity;

public class WpTaskSub extends DataEntity<WpTaskSub> {
    private static final long serialVersionUID = 1L;
    private String wpTaskId;
    private String wpTeamId;
    private String wpTaskSubId;
    private String teamName;
    private String teamNo;

    public String getTeamNo() {
        return teamNo;
    }

    public void setTeamNo(String teamNo) {
        this.teamNo = teamNo;
    }

    public String getTeamName() {
        return teamName;
    }

    public void setTeamName(String teamName) {
        this.teamName = teamName;
    }

    public String getWpTaskId() {
        return wpTaskId;
    }

    public void setWpTaskId(String wpTaskId) {
        this.wpTaskId = wpTaskId;
    }

    public String getWpTeamId() {
        return wpTeamId;
    }

    public void setWpTeamId(String wpTeamId) {
        this.wpTeamId = wpTeamId;
    }

    public String getWpTaskSubId() {
        return wpTaskSubId;
    }

    public void setWpTaskSubId(String wpTaskSubId) {
        this.wpTaskSubId = wpTaskSubId;
    }
}
