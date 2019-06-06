package com.example.demo.entiy;

import java.io.Serializable;
import java.util.Date;

/**
 * @Auther: sunmingyao
 * @Date: 2018/11/23 15 38
 * @Description:
 */
public class Roal implements Serializable {

    private Integer id;
    private String roalName;
    private String creater;
    private Date createTime;
    private String modify;
    private Date modifyTime;
    private Integer isLock;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getRoalName() {
        return roalName;
    }

    public void setRoalName(String roalName) {
        this.roalName = roalName;
    }

    public String getCreater() {
        return creater;
    }

    public void setCreater(String creater) {
        this.creater = creater;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public String getModify() {
        return modify;
    }

    public void setModify(String modify) {
        this.modify = modify;
    }

    public Date getModifyTime() {
        return modifyTime;
    }

    public void setModifyTime(Date modifyTime) {
        this.modifyTime = modifyTime;
    }

    public Integer getIsLock() {
        return isLock;
    }

    public void setIsLock(Integer isLock) {
        this.isLock = isLock;
    }
}
