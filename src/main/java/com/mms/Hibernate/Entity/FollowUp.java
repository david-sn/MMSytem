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
import javax.persistence.JoinColumn;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author David Shire
 */
@Entity
@Table(name = "FOLLOW_UP")
@NamedQueries({
    @NamedQuery(name = "FollowUp.findAll", query = "SELECT f FROM FollowUp f")})
public class FollowUp implements Serializable {

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
    @JoinColumn(name = "MEMBER_DETAIL_DBID_SUBERVISE", referencedColumnName = "DBID")
    @OneToOne(fetch = FetchType.LAZY)
    private MemberDetail memberDetailDbidSubervise;
    @JoinColumn(name = "MEMBER_DETAIL_DBID_CHILD", referencedColumnName = "DBID")
    @OneToOne(fetch = FetchType.LAZY)
    private MemberDetail memberDetailDbidChild;
    @OneToMany(mappedBy = "followUpDbid", fetch = FetchType.LAZY)
    private Set<FollowUpSheetDetail> followUpSheetDetailSet;

    public FollowUp() {
    }

    public FollowUp(Long dbid) {
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

    public MemberDetail getMemberDetailDbidSubervise() {
        return memberDetailDbidSubervise;
    }

    public void setMemberDetailDbidSubervise(MemberDetail memberDetailDbidSubervise) {
        this.memberDetailDbidSubervise = memberDetailDbidSubervise;
    }

    public MemberDetail getMemberDetailDbidChild() {
        return memberDetailDbidChild;
    }

    public void setMemberDetailDbidChild(MemberDetail memberDetailDbidChild) {
        this.memberDetailDbidChild = memberDetailDbidChild;
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
        if (!(object instanceof FollowUp)) {
            return false;
        }
        FollowUp other = (FollowUp) object;
        if ((this.dbid == null && other.dbid != null) || (this.dbid != null && !this.dbid.equals(other.dbid))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.mms.Hibernate.Entity.FollowUp[ dbid=" + dbid + " ]";
    }
    
}
