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
@Table(name = "DEPARTMENT_POSITION")
@NamedQueries({
    @NamedQuery(name = "DepartmentPosition.findAll", query = "SELECT d FROM DepartmentPosition d")})
public class DepartmentPosition implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    private Long dbid;
    private String code;
    private Short deleted;
    private Short locked;
    @Column(name = "START_DATE")
    @Temporal(TemporalType.TIMESTAMP)
    private Date startDate;
    @Column(name = "EXPIRE_DATE")
    @Temporal(TemporalType.TIMESTAMP)
    private Date expireDate;
    @Column(name = "START_JOIN_DATE")
    @Temporal(TemporalType.TIMESTAMP)
    private Date startJoinDate;
    @Column(name = "NORMAL_CAPACITY_PARTICIPATION")
    private BigInteger normalCapacityParticipation;
    @Column(name = "MAX_CAPACITY_PARTICIPATION")
    private BigInteger maxCapacityParticipation;
    @Basic(optional = false)
    @Column(name = "DIRECT_MANAGER")
    private long directManager;
    @Column(name = "LAST_UPDATED")
    @Temporal(TemporalType.TIMESTAMP)
    private Date lastUpdated;
    @Column(name = "TEAM_LEADER")
    private BigInteger teamLeader;
    @Lob
    private String description;
    @Column(name = "NEED_CONFIRMATION_TO_JOIN")
    private Short needConfirmationToJoin;
    @Column(name = "FILE_ATTACHE1")
    private String fileAttache1;
    @Column(name = "FILE_ATTACHE2")
    private String fileAttache2;
    @Column(name = "MIN_EXPERIENEC")
    private BigInteger minExperienec;
    @JoinColumn(name = "LOOKUP_DEPARTMENT", referencedColumnName = "DBID")
    @ManyToOne(fetch = FetchType.LAZY)
    private LookupDepartment lookupDepartment;

    public DepartmentPosition() {
    }

    public DepartmentPosition(Long dbid) {
        this.dbid = dbid;
    }

    public DepartmentPosition(Long dbid, long directManager) {
        this.dbid = dbid;
        this.directManager = directManager;
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

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getExpireDate() {
        return expireDate;
    }

    public void setExpireDate(Date expireDate) {
        this.expireDate = expireDate;
    }

    public Date getStartJoinDate() {
        return startJoinDate;
    }

    public void setStartJoinDate(Date startJoinDate) {
        this.startJoinDate = startJoinDate;
    }

    public BigInteger getNormalCapacityParticipation() {
        return normalCapacityParticipation;
    }

    public void setNormalCapacityParticipation(BigInteger normalCapacityParticipation) {
        this.normalCapacityParticipation = normalCapacityParticipation;
    }

    public BigInteger getMaxCapacityParticipation() {
        return maxCapacityParticipation;
    }

    public void setMaxCapacityParticipation(BigInteger maxCapacityParticipation) {
        this.maxCapacityParticipation = maxCapacityParticipation;
    }

    public long getDirectManager() {
        return directManager;
    }

    public void setDirectManager(long directManager) {
        this.directManager = directManager;
    }

    public Date getLastUpdated() {
        return lastUpdated;
    }

    public void setLastUpdated(Date lastUpdated) {
        this.lastUpdated = lastUpdated;
    }

    public BigInteger getTeamLeader() {
        return teamLeader;
    }

    public void setTeamLeader(BigInteger teamLeader) {
        this.teamLeader = teamLeader;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Short getNeedConfirmationToJoin() {
        return needConfirmationToJoin;
    }

    public void setNeedConfirmationToJoin(Short needConfirmationToJoin) {
        this.needConfirmationToJoin = needConfirmationToJoin;
    }

    public String getFileAttache1() {
        return fileAttache1;
    }

    public void setFileAttache1(String fileAttache1) {
        this.fileAttache1 = fileAttache1;
    }

    public String getFileAttache2() {
        return fileAttache2;
    }

    public void setFileAttache2(String fileAttache2) {
        this.fileAttache2 = fileAttache2;
    }

    public BigInteger getMinExperienec() {
        return minExperienec;
    }

    public void setMinExperienec(BigInteger minExperienec) {
        this.minExperienec = minExperienec;
    }

    public LookupDepartment getLookupDepartment() {
        return lookupDepartment;
    }

    public void setLookupDepartment(LookupDepartment lookupDepartment) {
        this.lookupDepartment = lookupDepartment;
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
        if (!(object instanceof DepartmentPosition)) {
            return false;
        }
        DepartmentPosition other = (DepartmentPosition) object;
        if ((this.dbid == null && other.dbid != null) || (this.dbid != null && !this.dbid.equals(other.dbid))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.mms.Hibernate.Entity.DepartmentPosition[ dbid=" + dbid + " ]";
    }
    
}
