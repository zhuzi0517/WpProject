package com.jeesite.modules.wp.entity;

import com.jeesite.common.entity.DataEntity;

/**
 * 团队成员类
 */
public class WpTeamUser extends DataEntity<WpTeamUser> {
    private static final long serialVersionUID = 1L;
    private String userName;
    private String raerCode;
    private String userCode;
    private String acName;
    private String age;
    private String userFlag;
    private int randNum;
    private String areaCode;
    private String wpTeamMembersId;
    private String wpTeamId;		// 主键ID



    public String getWpTeamId() {
        return wpTeamId;
    }

    public void setWpTeamId(String wpTeamId) {
        this.wpTeamId = wpTeamId;
    }

    public int getRandNum() {
        return randNum;
    }

    public void setRandNum(int randNum) {
        this.randNum = randNum;
    }

    public String getUserFlag() {
        return userFlag;
    }

    public void setUserFlag(String userFlag) {
        this.userFlag = userFlag;
    }

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public String getAcName() {
        return acName;
    }

    public void setAcName(String acName) {
        this.acName = acName;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public String getAreaCode() {
        return areaCode;
    }

    public void setAreaCode(String areaCode) {
        this.areaCode = areaCode;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getRaerCode() {
        return raerCode;
    }

    public void setRaerCode(String raerCode) {
        this.raerCode = raerCode;
    }

    public String getUserCode() {
        return userCode;
    }

    public void setUserCode(String userCode) {
        this.userCode = userCode;
    }

    public String getWpTeamMembersId() {
        return wpTeamMembersId;
    }

    public void setWpTeamMembersId(String wpTeamMembersId) {
        this.wpTeamMembersId = wpTeamMembersId;
    }
}
