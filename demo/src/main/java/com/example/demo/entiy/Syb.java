package com.example.demo.entiy;

import java.io.Serializable;
import java.util.Date;

/**
 * @Auther: sunmingyao
 * @Date: 2018/12/12 14 25
 * @Description:
 */
public class Syb implements Serializable {

    private Integer id;
    private String code;
    private String name;
    private String sybTypeCode;
    private String sybTypeName;
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

    public String getSybTypeCode() {
        return sybTypeCode;
    }

    public String getSybTypeName() {
        return sybTypeName;
    }

    public void setSybTypeName(String sybTypeName) {
        this.sybTypeName = sybTypeName;
    }

    public void setSybTypeCode(String sybTypeCode) {
        this.sybTypeCode = sybTypeCode;
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
