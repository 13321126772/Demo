package com.example.demo.pojo;

import java.util.Date;

public class CoreUser {

    private Integer id;
    private String code;
    private String name;
    private String password;
    private Date createTime;
    private Integer orgId;
    private String state;
    private String jobTyte1;
    private Integer delFlag;
    private Date updateTime;
    private String jobType0;
    private String attachmentId;

    public CoreUser(Integer id, String code, String name, String password, Date createTime, Integer orgId, String state, String jobTyte1, Integer delFlag, Date updateTime, String jobType0, String attachmentId) {
        this.id = id;
        this.code = code;
        this.name = name;
        this.password = password;
        this.createTime = createTime;
        this.orgId = orgId;
        this.state = state;
        this.jobTyte1 = jobTyte1;
        this.delFlag = delFlag;
        this.updateTime = updateTime;
        this.jobType0 = jobType0;
        this.attachmentId = attachmentId;
    }

    public CoreUser() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Integer getOrgId() {
        return orgId;
    }

    public void setOrgId(Integer orgId) {
        this.orgId = orgId;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getJobTyte1() {
        return jobTyte1;
    }

    public void setJobTyte1(String jobTyte1) {
        this.jobTyte1 = jobTyte1;
    }

    public Integer getDelFlag() {
        return delFlag;
    }

    public void setDelFlag(Integer delFlag) {
        this.delFlag = delFlag;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public String getJobType0() {
        return jobType0;
    }

    public void setJobType0(String jobType0) {
        this.jobType0 = jobType0;
    }

    public String getAttachmentId() {
        return attachmentId;
    }

    public void setAttachmentId(String attachmentId) {
        this.attachmentId = attachmentId;
    }

    @Override
    public String toString() {
        return "CoreUser{" +
                "id=" + id +
                ", code='" + code + '\'' +
                ", name='" + name + '\'' +
                ", password='" + password + '\'' +
                ", createTime=" + createTime +
                ", orgId=" + orgId +
                ", state='" + state + '\'' +
                ", jobTyte1='" + jobTyte1 + '\'' +
                ", delFlag=" + delFlag +
                ", updateTime=" + updateTime +
                ", jobType0='" + jobType0 + '\'' +
                ", attachmentId='" + attachmentId + '\'' +
                '}';
    }
}
