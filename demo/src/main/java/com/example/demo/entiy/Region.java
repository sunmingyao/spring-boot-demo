package com.example.demo.entiy;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
 * @Auther: sunmingyao
 * @Date: 2018/10/16 11 46
 * @Description:
 */
public class Region implements Serializable {

    private static final long serialVersionUID = 1L;

    private Long id;

    private String regionCode;

    private String regionName;

    private String isActived;

    private Long createUser;

    private Date createDate;

    private Long lastUpdUser;

    private Date lastUpdDate;

    private String isDeduCash;

    private Integer parentId;

    private Integer grade;

    private String isEndnote ;

    private String marketCode;

    private List<Region> regionItem;

    public List<Region> getRegionItem() {
        return regionItem;
    }

    public void setRegionItem(List<Region> regionItem) {
        this.regionItem = regionItem;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getRegionCode() {
        return regionCode;
    }

    public void setRegionCode(String regionCode) {
        this.regionCode = regionCode;
    }

    public String getRegionName() {
        return regionName;
    }

    public void setRegionName(String regionName) {
        this.regionName = regionName;
    }

    public String getIsActived() {
        return isActived;
    }

    public void setIsActived(String isActived) {
        this.isActived = isActived;
    }

    public Long getCreateUser() {
        return createUser;
    }

    public void setCreateUser(Long createUser) {
        this.createUser = createUser;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public Long getLastUpdUser() {
        return lastUpdUser;
    }

    public void setLastUpdUser(Long lastUpdUser) {
        this.lastUpdUser = lastUpdUser;
    }

    public Date getLastUpdDate() {
        return lastUpdDate;
    }

    public void setLastUpdDate(Date lastUpdDate) {
        this.lastUpdDate = lastUpdDate;
    }

    public String getIsDeduCash() {
        return isDeduCash;
    }

    public void setIsDeduCash(String isDeduCash) {
        this.isDeduCash = isDeduCash;
    }

    public Integer getParentId() {
        return parentId;
    }

    public void setParentId(Integer parentId) {
        this.parentId = parentId;
    }

    public Integer getGrade() {
        return grade;
    }

    public void setGrade(Integer grade) {
        this.grade = grade;
    }

    public String getIsEndnote() {
        return isEndnote;
    }

    public void setIsEndnote(String isEndnote) {
        this.isEndnote = isEndnote;
    }

    public String getMarketCode() {
        return marketCode;
    }

    public void setMarketCode(String marketCode) {
        this.marketCode = marketCode;
    }
}
