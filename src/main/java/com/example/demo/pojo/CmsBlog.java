package com.example.demo.pojo;

import java.util.Date;

public class CmsBlog {

    private  Integer id;
    private String title;
    private String content;
    private Date createTime;
    private Integer createUserId;
    private String type;

    public CmsBlog() {
    }

    public CmsBlog(Integer id, String title, String content, Date createTime, Integer createUserId, String type) {
        this.id = id;
        this.title = title;
        this.content = content;
        this.createTime = createTime;
        this.createUserId = createUserId;
        this.type = type;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Integer getCreateUserId() {
        return createUserId;
    }

    public void setCreateUserId(Integer createUserId) {
        this.createUserId = createUserId;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return "CmsBlog{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", content='" + content + '\'' +
                ", createTime=" + createTime +
                ", createUserId=" + createUserId +
                ", type='" + type + '\'' +
                '}';
    }
}
