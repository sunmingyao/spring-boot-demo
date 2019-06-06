package com.example.demo.entiy;

import java.io.Serializable;
import java.util.Date;

/**
 * @Auther: sunmingyao
 * @Date: 2018/12/25 09 40
 * @Description:
 */
public class Dept implements Serializable {
    private Integer id;
    private String code;
    private String name;
    private String sybCode;
    private String sybName;
    private Integer deleteFlag;
    private String operateUser;
    private Date operateTime;

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

    public String getSybCode() {
        return sybCode;
    }

    public void setSybCode(String sybCode) {
        this.sybCode = sybCode;
    }

    public String getSybName() {
        return sybName;
    }

    public void setSybName(String sybName) {
        this.sybName = sybName;
    }

    public Integer getDeleteFlag() {
        return deleteFlag;
    }

    public void setDeleteFlag(Integer deleteFlag) {
        this.deleteFlag = deleteFlag;
    }

    public String getOperateUser() {
        return operateUser;
    }

    public void setOperateUser(String operateUser) {
        this.operateUser = operateUser;
    }

    public Date getOperateTime() {
        return operateTime;
    }

    public void setOperateTime(Date operateTime) {
        this.operateTime = operateTime;
    }
}
