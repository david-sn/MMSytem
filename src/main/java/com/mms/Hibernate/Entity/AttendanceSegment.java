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
import javax.persistence.Id;
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
@Table(name = "ATTENDANCE_SEGMENT")
@NamedQueries({
    @NamedQuery(name = "AttendanceSegment.findAll", query = "SELECT a FROM AttendanceSegment a")})
public class AttendanceSegment implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    private Long dbid;
    private String code;
    private Short deleted;
    private Short locked;
    @Column(name = "CHECK_IN_DATE")
    @Temporal(TemporalType.TIMESTAMP)
    private Date checkInDate;
    @Column(name = "MEMBER_DETAIL_DBID")
    private BigInteger memberDetailDbid;
    @Column(name = "TIME_SEGMENT_RULES_DBID")
    private BigInteger timeSegmentRulesDbid;
    @Column(name = "LAST_UPDATED")
    @Temporal(TemporalType.TIMESTAMP)
    private Date lastUpdated;
    @Column(name = "CREATED_DATE")
    @Temporal(TemporalType.TIMESTAMP)
    private Date createdDate;

    public AttendanceSegment() {
    }

    public AttendanceSegment(Long dbid) {
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

    public Date getCheckInDate() {
        return checkInDate;
    }

    public void setCheckInDate(Date checkInDate) {
        this.checkInDate = checkInDate;
    }

    public BigInteger getMemberDetailDbid() {
        return memberDetailDbid;
    }

    public void setMemberDetailDbid(BigInteger memberDetailDbid) {
        this.memberDetailDbid = memberDetailDbid;
    }

    public BigInteger getTimeSegmentRulesDbid() {
        return timeSegmentRulesDbid;
    }

    public void setTimeSegmentRulesDbid(BigInteger timeSegmentRulesDbid) {
        this.timeSegmentRulesDbid = timeSegmentRulesDbid;
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

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (dbid != null ? dbid.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof AttendanceSegment)) {
            return false;
        }
        AttendanceSegment other = (AttendanceSegment) object;
        if ((this.dbid == null && other.dbid != null) || (this.dbid != null && !this.dbid.equals(other.dbid))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.mms.Hibernate.Entity.AttendanceSegment[ dbid=" + dbid + " ]";
    }
    
}
