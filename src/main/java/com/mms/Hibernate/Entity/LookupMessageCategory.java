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
@Table(name = "LOOKUP_MESSAGE_CATEGORY")
@NamedQueries({
    @NamedQuery(name = "LookupMessageCategory.findAll", query = "SELECT l FROM LookupMessageCategory l")})
public class LookupMessageCategory implements Serializable {

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
    @Column(name = "CATEGORY_NAME")
    private String categoryName;
    @Column(name = "SEND_EVERY_DAY_INDEX")
    private Short sendEveryDayIndex;
    @Column(name = "SEND_EVERY_DATE")
    @Temporal(TemporalType.TIMESTAMP)
    private Date sendEveryDate;
    @Column(name = "LAST_SEND_DATE")
    @Temporal(TemporalType.TIMESTAMP)
    private Date lastSendDate;
    @OneToMany(mappedBy = "lookupCategoryMessageDbid", fetch = FetchType.LAZY)
    private Set<LookupMessageTemplete> lookupMessageTempleteSet;
    @OneToMany(mappedBy = "lookupCategoryMessageDbidD", fetch = FetchType.LAZY)
    private Set<LookupMessageTemplete> lookupMessageTempleteSet1;

    public LookupMessageCategory() {
    }

    public LookupMessageCategory(Long dbid) {
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

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    public Short getSendEveryDayIndex() {
        return sendEveryDayIndex;
    }

    public void setSendEveryDayIndex(Short sendEveryDayIndex) {
        this.sendEveryDayIndex = sendEveryDayIndex;
    }

    public Date getSendEveryDate() {
        return sendEveryDate;
    }

    public void setSendEveryDate(Date sendEveryDate) {
        this.sendEveryDate = sendEveryDate;
    }

    public Date getLastSendDate() {
        return lastSendDate;
    }

    public void setLastSendDate(Date lastSendDate) {
        this.lastSendDate = lastSendDate;
    }

    public Set<LookupMessageTemplete> getLookupMessageTempleteSet() {
        return lookupMessageTempleteSet;
    }

    public void setLookupMessageTempleteSet(Set<LookupMessageTemplete> lookupMessageTempleteSet) {
        this.lookupMessageTempleteSet = lookupMessageTempleteSet;
    }

    public Set<LookupMessageTemplete> getLookupMessageTempleteSet1() {
        return lookupMessageTempleteSet1;
    }

    public void setLookupMessageTempleteSet1(Set<LookupMessageTemplete> lookupMessageTempleteSet1) {
        this.lookupMessageTempleteSet1 = lookupMessageTempleteSet1;
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
        if (!(object instanceof LookupMessageCategory)) {
            return false;
        }
        LookupMessageCategory other = (LookupMessageCategory) object;
        if ((this.dbid == null && other.dbid != null) || (this.dbid != null && !this.dbid.equals(other.dbid))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.mms.Hibernate.Entity.LookupMessageCategory[ dbid=" + dbid + " ]";
    }
    
}
