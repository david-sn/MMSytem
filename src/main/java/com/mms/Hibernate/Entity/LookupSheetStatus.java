/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mms.Hibernate.Entity;

import java.io.Serializable;
import java.util.Date;
import java.util.Set;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author David Shire
 */
@Entity
@Table(name = "LOOKUP_SHEET_STATUS")
@NamedQueries({
    @NamedQuery(name = "LookupSheetStatus.findAll", query = "SELECT l FROM LookupSheetStatus l")})
public class LookupSheetStatus implements Serializable {

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
    @Column(name = "SHEET_STATUS_NAME")
    private String sheetStatusName;
    @Column(name = "SHEET_STATUS_NAME_EN")
    private String sheetStatusNameEn;
    @OneToMany(mappedBy = "lookupSheetStatusDbid", fetch = FetchType.LAZY)
    private Set<FollowUpSheetDetail> followUpSheetDetailSet;

    public LookupSheetStatus() {
    }

    public LookupSheetStatus(Long dbid) {
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

    public String getSheetStatusName() {
        return sheetStatusName;
    }

    public void setSheetStatusName(String sheetStatusName) {
        this.sheetStatusName = sheetStatusName;
    }

    public String getSheetStatusNameEn() {
        return sheetStatusNameEn;
    }

    public void setSheetStatusNameEn(String sheetStatusNameEn) {
        this.sheetStatusNameEn = sheetStatusNameEn;
    }

    public Set<FollowUpSheetDetail> getFollowUpSheetDetailSet() {
        return followUpSheetDetailSet;
    }

    public void setFollowUpSheetDetailSet(Set<FollowUpSheetDetail> followUpSheetDetailSet) {
        this.followUpSheetDetailSet = followUpSheetDetailSet;
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
        if (!(object instanceof LookupSheetStatus)) {
            return false;
        }
        LookupSheetStatus other = (LookupSheetStatus) object;
        if ((this.dbid == null && other.dbid != null) || (this.dbid != null && !this.dbid.equals(other.dbid))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.mms.Hibernate.Entity.LookupSheetStatus[ dbid=" + dbid + " ]";
    }
    
}
