/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mms.Hibernate.Entity;

import java.io.Serializable;
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
@Table(name = "FOLLOW_UP_SHEET_DETAIL")
@NamedQueries({
    @NamedQuery(name = "FollowUpSheetDetail.findAll", query = "SELECT f FROM FollowUpSheetDetail f")})
public class FollowUpSheetDetail implements Serializable {

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
    @Lob
    private String notes;
    @Column(name = "TARGET_SUCCESS")
    private Character targetSuccess;
    @JoinColumn(name = "FOLLOW_UP_DBID", referencedColumnName = "DBID")
    @ManyToOne(fetch = FetchType.LAZY)
    private FollowUp followUpDbid;
    @JoinColumn(name = "FOLLOW_UP_SHEET_DBID", referencedColumnName = "DBID")
    @ManyToOne(fetch = FetchType.LAZY)
    private FollowUpSheet followUpSheetDbid;
    @JoinColumn(name = "LOOKUP_SHEET_STATUS_DBID", referencedColumnName = "DBID")
    @ManyToOne(fetch = FetchType.LAZY)
    private LookupSheetStatus lookupSheetStatusDbid;

    public FollowUpSheetDetail() {
    }

    public FollowUpSheetDetail(Long dbid) {
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

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }

    public Character getTargetSuccess() {
        return targetSuccess;
    }

    public void setTargetSuccess(Character targetSuccess) {
        this.targetSuccess = targetSuccess;
    }

    public FollowUp getFollowUpDbid() {
        return followUpDbid;
    }

    public void setFollowUpDbid(FollowUp followUpDbid) {
        this.followUpDbid = followUpDbid;
    }

    public FollowUpSheet getFollowUpSheetDbid() {
        return followUpSheetDbid;
    }

    public void setFollowUpSheetDbid(FollowUpSheet followUpSheetDbid) {
        this.followUpSheetDbid = followUpSheetDbid;
    }

    public LookupSheetStatus getLookupSheetStatusDbid() {
        return lookupSheetStatusDbid;
    }

    public void setLookupSheetStatusDbid(LookupSheetStatus lookupSheetStatusDbid) {
        this.lookupSheetStatusDbid = lookupSheetStatusDbid;
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
        if (!(object instanceof FollowUpSheetDetail)) {
            return false;
        }
        FollowUpSheetDetail other = (FollowUpSheetDetail) object;
        if ((this.dbid == null && other.dbid != null) || (this.dbid != null && !this.dbid.equals(other.dbid))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.mms.Hibernate.Entity.FollowUpSheetDetail[ dbid=" + dbid + " ]";
    }
    
}
