package com.palmble.sp.manger.model;

public class AdminUser {
    private Integer id;

    private String loginiNo;

    private String mobile;

    private String pwd;

    private String qq;

    private String headImg;

    private String createByName;

    private String createDate;

    private Integer enableFlag;

    private Integer groupId;

    private String lastLoginIp;
    
    private String lastLoginTime;
    
    private String groupName;
    private Integer loginCount;
    

    public Integer getLoginCount() {
		return loginCount;
	}

	public void setLoginCount(Integer loginCount) {
		this.loginCount = loginCount;
	}

	public String getLastLoginTime() {
		return lastLoginTime;
	}

	public void setLastLoginTime(String lastLoginTime) {
		this.lastLoginTime = lastLoginTime;
	}

	public String getGroupName() {
		return groupName;
	}

	public void setGroupName(String groupName) {
		this.groupName = groupName;
	}

	public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getLoginiNo() {
        return loginiNo;
    }

    public void setLoginiNo(String loginiNo) {
        this.loginiNo = loginiNo == null ? null : loginiNo.trim();
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile == null ? null : mobile.trim();
    }

    public String getPwd() {
        return pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd == null ? null : pwd.trim();
    }

    public String getQq() {
        return qq;
    }

    public void setQq(String qq) {
        this.qq = qq == null ? null : qq.trim();
    }

    public String getHeadImg() {
        return headImg;
    }

    public void setHeadImg(String headImg) {
        this.headImg = headImg == null ? null : headImg.trim();
    }

    public String getCreateByName() {
        return createByName;
    }

    public void setCreateByName(String createByName) {
        this.createByName = createByName == null ? null : createByName.trim();
    }

    public String getCreateDate() {
        return createDate;
    }

    public void setCreateDate(String createDate) {
        this.createDate = createDate;
    }

    public Integer getEnableFlag() {
        return enableFlag;
    }

    public void setEnableFlag(Integer enableFlag) {
        this.enableFlag = enableFlag;
    }

    public Integer getGroupId() {
        return groupId;
    }

    public void setGroupId(Integer groupId) {
        this.groupId = groupId;
    }

    public String getLastLoginIp() {
        return lastLoginIp;
    }

    public void setLastLoginIp(String lastLoginIp) {
        this.lastLoginIp = lastLoginIp == null ? null : lastLoginIp.trim();
    }

	@Override
	public String toString() {
		return "AdminUser [id=" + id + ", loginiNo=" + loginiNo + ", mobile=" + mobile + ", pwd=" + pwd + ", qq=" + qq
				+ ", headImg=" + headImg + ", createByName=" + createByName + ", createDate=" + createDate
				+ ", enableFlag=" + enableFlag + ", groupId=" + groupId + ", lastLoginIp=" + lastLoginIp
				+ ", lastLoginTime=" + lastLoginTime + ", groupName=" + groupName + ", loginCount=" + loginCount + "]";
	}
    
}