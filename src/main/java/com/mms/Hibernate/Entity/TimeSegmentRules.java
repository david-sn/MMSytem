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
@Table(name = "TIME_SEGMENT_RULES")
@NamedQueries({
    @NamedQuery(name = "TimeSegmentRules.findAll", query = "SELECT t FROM TimeSegmentRules t")})
public class TimeSegmentRules implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    private Long dbid;
    private String code;
    @Basic(optional = false)
    @Column(name = "SEGMENT_NAME")
    private String segmentName;
    @Basic(optional = false)
    @Column(name = "SEGMENT_NAME_EN")
    private String segmentNameEn;
    private Short deleted;
    private Short locked;
    @Column(name = "START_WORKIN_DATE")
    @Temporal(TemporalType.TIMESTAMP)
    private Date startWorkinDate;
    @Column(name = "END_WORKING_DATE")
    @Temporal(TemporalType.TIMESTAMP)
    private Date endWorkingDate;
    @Column(name = "START_DAY_INDEX")
    private Short startDayIndex;
    @Column(name = "EARLY_COME_MIN")
    private BigInteger earlyComeMin;
    @Column(name = "ACTUAL_START_TIME")
    @Temporal(TemporalType.TIMESTAMP)
    private Date actualStartTime;
    @Column(name = "LATE_COME")
    private BigInteger lateCome;
    @Column(name = "ACTUAL_FINISH_TIME")
    @Temporal(TemporalType.TIMESTAMP)
    private Date actualFinishTime;
    @Column(name = "IS_CURRENT")
    private Short isCurrent;
    @Column(name = "LAST_UPDATED")
    @Temporal(TemporalType.TIMESTAMP)
    private Date lastUpdated;
    @Column(name = "CREATED_DATE")
    @Temporal(TemporalType.TIMESTAMP)
    private Date createdDate;
    @JoinColumn(name = "LOOKUP_MEETING_DBID", referencedColumnName = "DBID")
    @ManyToOne(fetch = FetchType.LAZY)
    private LookupMeeting lookupMeetingDbid;

    public TimeSegmentRules() {
    }

    public TimeSegmentRules(Long dbid) {
        this.dbid = dbid;
    }

    public TimeSegmentRules(Long dbid, String segmentName, String segmentNameEn) {
        this.dbid = dbid;
        this.segmentName = segmentName;
        this.segmentNameEn = segmentNameEn;
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

    public String getSegmentName() {
        return segmentName;
    }

    public void setSegmentName(String segmentName) {
        this.segmentName = segmentName;
    }

    public String getSegmentNameEn() {
        return segmentNameEn;
    }

    public void setSegmentNameEn(String segmentNameEn) {
        this.segmentNameEn = segmentNameEn;
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

    public Date getStartWorkinDate() {
        return startWorkinDate;
    }

    public void setStartWorkinDate(Date startWorkinDate) {
        this.startWorkinDate = startWorkinDate;
    }

    public Date getEndWorkingDate() {
        return endWorkingDate;
    }

    public void setEndWorkingDate(Date endWorkingDate) {
        this.endWorkingDate = endWorkingDate;
    }

    public Short getStartDayIndex() {
        return startDayIndex;
    }

    public void setStartDayIndex(Short startDayIndex) {
        this.startDayIndex = startDayIndex;
    }

    public BigInteger getEarlyComeMin() {
        return earlyComeMin;
    }

    public void setEarlyComeMin(BigInteger earlyComeMin) {
        this.earlyComeMin = earlyComeMin;
    }

    public Date getActualStartTime() {
        return actualStartTime;
    }

    public void setActualStartTime(Date actualStartTime) {
        this.actualStartTime = actualStartTime;
    }

    public BigInteger getLateCome() {
        return lateCome;
    }

    public void setLateCome(BigInteger lateCome) {
        this.lateCome = lateCome;
    }

    public Date getActualFinishTime() {
        return actualFinishTime;
    }

    public void setActualFinishTime(Date actualFinishTime) {
        this.actualFinishTime = actualFinishTime;
    }

    public Short getIsCurrent() {
        return isCurrent;
    }

    public void setIsCurrent(Short isCurrent) {
        this.isCurrent = isCurrent;
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

    public LookupMeeting getLookupMeetingDbid() {
        return lookupMeetingDbid;
    }

    public void setLookupMeetingDbid(LookupMeeting lookupMeetingDbid) {
        this.lookupMeetingDbid = lookupMeetingDbid;
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
        if (!(object instanceof TimeSegmentRules)) {
            return false;
        }
        TimeSegmentRules other = (TimeSegmentRules) object;
        if ((this.dbid == null && other.dbid != null) || (this.dbid != null && !this.dbid.equals(other.dbid))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.mms.Hibernate.Entity.TimeSegmentRules[ dbid=" + dbid + " ]";
    }
    
}
