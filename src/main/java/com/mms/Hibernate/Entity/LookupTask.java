/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mms.Hibernate.Entity;

import java.io.Serializable;
import java.math.BigInteger;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author David Shire
 */
@Entity
@Table(name = "LOOKUP_TASK")
@NamedQueries({
    @NamedQuery(name = "LookupTask.findAll", query = "SELECT l FROM LookupTask l")})
public class LookupTask implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    private Long dbid;
    private String code;
    private Short deleted;
    private Short locked;
    @Column(name = "LAST_UPDATED")
    @Temporal(TemporalType.TIMESTAMP)
    private Date lastUpdated;
    @Column(name = "CREATED_DATE")
    @Temporal(TemporalType.TIMESTAMP)
    private Date createdDate;
    @Column(name = "TASK_TITLE")
    private String taskTitle;
    @Column(name = "TASK_TITLE_EN")
    private String taskTitleEn;
    @Column(name = "EXPIRE_DATE")
    @Temporal(TemporalType.TIMESTAMP)
    private Date expireDate;
    @Column(name = "ATTACH_FILE")
    private Serializable attachFile;
    @Column(name = "ATTACH_FILE2")
    private Serializable attachFile2;
    @Column(name = "ATTACH_FILE3")
    private Serializable attachFile3;
    @Lob
    private String description;
    @Column(name = "LOOKUP_DEPARTMENT_DBID_ASSIGN")
    private BigInteger lookupDepartmentDbidAssign;
    @Column(name = "MIN_DEGREE")
    private Short minDegree;
    @Column(name = "MAX_DEGREE")
    private Short maxDegree;
    @Column(name = "TOP_DELIVERED_FULL_MARK")
    private BigInteger topDeliveredFullMark;
    @JoinColumn(name = "LOOKUP_TASK_TYPE_DBID", referencedColumnName = "DBID")
    @ManyToOne(fetch = FetchType.LAZY)
    private LookupTaskType lookupTaskTypeDbid;

    public LookupTask() {
    }

    public LookupTask(Long dbid) {
        this.dbid = dbid;
    }

    public Long getDbid() {
        return dbid;
    }

    public void setDbid(Long dbid) {
        this.dbid = dbid;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public Short getDeleted() {
        return deleted;
    }

    public void setDeleted(Short deleted) {
        this.deleted = deleted;
    }

    public Short getLocked() {
        return locked;
    }

    public void setLocked(Short locked) {
        this.locked = locked;
    }

    public Date getLastUpdated() {
        return lastUpdated;
    }

    public void setLastUpdated(Date lastUpdated) {
        this.lastUpdated = lastUpdated;
    }

    public Date getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }

    public String getTaskTitle() {
        return taskTitle;
    }

    public void setTaskTitle(String taskTitle) {
        this.taskTitle = taskTitle;
    }

    public String getTaskTitleEn() {
        return taskTitleEn;
    }

    public void setTaskTitleEn(String taskTitleEn) {
        this.taskTitleEn = taskTitleEn;
    }

    public Date getExpireDate() {
        return expireDate;
    }

    public void setExpireDate(Date expireDate) {
        this.expireDate = expireDate;
    }

    public Serializable getAttachFile() {
        return attachFile;
    }

    public void setAttachFile(Serializable attachFile) {
        this.attachFile = attachFile;
    }

    public Serializable getAttachFile2() {
        return attachFile2;
    }

    public void setAttachFile2(Serializable attachFile2) {
        this.attachFile2 = attachFile2;
    }

    public Serializable getAttachFile3() {
        return attachFile3;
    }

    public void setAttachFile3(Serializable attachFile3) {
        this.attachFile3 = attachFile3;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public BigInteger getLookupDepartmentDbidAssign() {
        return lookupDepartmentDbidAssign;
    }

    public void setLookupDepartmentDbidAssign(BigInteger lookupDepartmentDbidAssign) {
        this.lookupDepartmentDbidAssign = lookupDepartmentDbidAssign;
    }

    public Short getMinDegree() {
        return minDegree;
    }

    public void setMinDegree(Short minDegree) {
        this.minDegree = minDegree;
    }

    public Short getMaxDegree() {
        return maxDegree;
    }

    public void setMaxDegree(Short maxDegree) {
        this.maxDegree = maxDegree;
    }

    public BigInteger getTopDeliveredFullMark() {
        return topDeliveredFullMark;
    }

    public void setTopDeliveredFullMark(BigInteger topDeliveredFullMark) {
        this.topDeliveredFullMark = topDeliveredFullMark;
    }

    public LookupTaskType getLookupTaskTypeDbid() {
        return lookupTaskTypeDbid;
    }

    public void setLookupTaskTypeDbid(LookupTaskType lookupTaskTypeDbid) {
        this.lookupTaskTypeDbid = lookupTaskTypeDbid;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (dbid != null ? dbid.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof LookupTask)) {
            return false;
        }
        LookupTask other = (LookupTask) object;
        if ((this.dbid == null && other.dbid != null) || (this.dbid != null && !this.dbid.equals(other.dbid))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.mms.Hibernate.Entity.LookupTask[ dbid=" + dbid + " ]";
    }
    
}
