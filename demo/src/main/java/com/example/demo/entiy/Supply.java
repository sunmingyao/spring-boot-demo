package com.example.demo.entiy;

import java.io.Serializable;
import java.util.Date;

/**
 * @Auther: sunmingyao
 * @Date: 2018/11/7 10 47
 * @Description:
 */
public class Supply implements Serializable {
    private static final long serialVersionUID = 1L;

    private Long id;
    private String suppCode;
    private String suppName;
    private String linkMan;
    private String tellNum;
    private String email;
    private String remark;
    private Integer suppType;
    private Integer isActived;
    private String createUser;
    private Date createDate;
    private String lastUpdateUser;
    private Date lastUpdateDate;
    private Date contractDate;
    private Date licenceDate;
    private Date healthAllowDate;
    private String documentId;
    private Integer auditFlag;
    private String auditOption;
    private Date auditDate;
    private String mdmCode;
    private Integer isUnify;
    private String bank;
    private String bankAccount;
    private Long disableAppler;
    private Date disableApplyDate;
    private Long disableChecker;
    private String disableApply;
    private String disableReason;
    private Date disableCheckDate;
    private Long mdmId;
    private Long serId;
    private String serName;
    private Integer disableFlag;
    private Long synDate;
    private String qualifyName;
    private String isDeduCash;
    private String conNo;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getSuppCode() {
        return suppCode;
    }

    public void setSuppCode(String suppCode) {
        this.suppCode = suppCode;
    }

    public String getSuppName() {
        return suppName;
    }

    public void setSuppName(String suppName) {
        this.suppName = suppName;
    }

    public String getLinkMan() {
        return linkMan;
    }

    public void setLinkMan(String linkMan) {
        this.linkMan = linkMan;
    }

    public String getTellNum() {
        return tellNum;
    }

    public void setTellNum(String tellNum) {
        this.tellNum = tellNum;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public Integer getSuppType() {
        return suppType;
    }

    public void setSuppType(Integer suppType) {
        this.suppType = suppType;
    }

    public Integer getIsActived() {
        return isActived;
    }

    public void setIsActived(Integer isActived) {
        this.isActived = isActived;
    }

    public String getCreateUser() {
        return createUser;
    }

    public void setCreateUser(String createUser) {
        this.createUser = createUser;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public String getLastUpdateUser() {
        return lastUpdateUser;
    }

    public void setLastUpdateUser(String lastUpdateUser) {
        this.lastUpdateUser = lastUpdateUser;
    }

    public Date getLastUpdateDate() {
        return lastUpdateDate;
    }

    public void setLastUpdateDate(Date lastUpdateDate) {
        this.lastUpdateDate = lastUpdateDate;
    }

    public Date getContractDate() {
        return contractDate;
    }

    public void setContractDate(Date contractDate) {
        this.contractDate = contractDate;
    }

    public Date getLicenceDate() {
        return licenceDate;
    }

    public void setLicenceDate(Date licenceDate) {
        this.licenceDate = licenceDate;
    }

    public Date getHealthAllowDate() {
        return healthAllowDate;
    }

    public void setHealthAllowDate(Date healthAllowDate) {
        this.healthAllowDate = healthAllowDate;
    }

    public String getDocumentId() {
        return documentId;
    }

    public void setDocumentId(String documentId) {
        this.documentId = documentId;
    }

    public Integer getAuditFlag() {
        return auditFlag;
    }

    public void setAuditFlag(Integer auditFlag) {
        this.auditFlag = auditFlag;
    }

    public String getAuditOption() {
        return auditOption;
    }

    public void setAuditOption(String auditOption) {
        this.auditOption = auditOption;
    }

    public Date getAuditDate() {
        return auditDate;
    }

    public void setAuditDate(Date auditDate) {
        this.auditDate = auditDate;
    }

    public String getMdmCode() {
        return mdmCode;
    }

    public void setMdmCode(String mdmCode) {
        this.mdmCode = mdmCode;
    }

    public Integer getIsUnify() {
        return isUnify;
    }

    public void setIsUnify(Integer isUnify) {
        this.isUnify = isUnify;
    }

    public String getBank() {
        return bank;
    }

    public void setBank(String bank) {
        this.bank = bank;
    }

    public String getBankAccount() {
        return bankAccount;
    }

    public void setBankAccount(String bankAccount) {
        this.bankAccount = bankAccount;
    }

    public Long getDisableAppler() {
        return disableAppler;
    }

    public void setDisableAppler(Long disableAppler) {
        this.disableAppler = disableAppler;
    }

    public Date getDisableApplyDate() {
        return disableApplyDate;
    }

    public void setDisableApplyDate(Date disableApplyDate) {
        this.disableApplyDate = disableApplyDate;
    }

    public Long getDisableChecker() {
        return disableChecker;
    }

    public void setDisableChecker(Long disableChecker) {
        this.disableChecker = disableChecker;
    }

    public String getDisableApply() {
        return disableApply;
    }

    public void setDisableApply(String disableApply) {
        this.disableApply = disableApply;
    }

    public String getDisableReason() {
        return disableReason;
    }

    public void setDisableReason(String disableReason) {
        this.disableReason = disableReason;
    }

    public Date getDisableCheckDate() {
        return disableCheckDate;
    }

    public void setDisableCheckDate(Date disableCheckDate) {
        this.disableCheckDate = disableCheckDate;
    }

    public Long getMdmId() {
        return mdmId;
    }

    public void setMdmId(Long mdmId) {
        this.mdmId = mdmId;
    }

    public Long getSerId() {
        return serId;
    }

    public void setSerId(Long serId) {
        this.serId = serId;
    }

    public String getSerName() {
        return serName;
    }

    public void setSerName(String serName) {
        this.serName = serName;
    }

    public Integer getDisableFlag() {
        return disableFlag;
    }

    public void setDisableFlag(Integer disableFlag) {
        this.disableFlag = disableFlag;
    }

    public Long getSynDate() {
        return synDate;
    }

    public void setSynDate(Long synDate) {
        this.synDate = synDate;
    }

    public String getQualifyName() {
        return qualifyName;
    }

    public void setQualifyName(String qualifyName) {
        this.qualifyName = qualifyName;
    }

    public String getIsDeduCash() {
        return isDeduCash;
    }

    public void setIsDeduCash(String isDeduCash) {
        this.isDeduCash = isDeduCash;
    }

    public String getConNo() {
        return conNo;
    }

    public void setConNo(String conNo) {
        this.conNo = conNo;
    }
}
