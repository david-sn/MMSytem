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
import javax.persistence.ManyToOne;
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
@Table(name = "LOOKUP_DEPARTMENT")
@NamedQueries({
    @NamedQuery(name = "LookupDepartment.findAll", query = "SELECT l FROM LookupDepartment l")})
public class LookupDepartment implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    private Long dbid;
    private String code;
    @Basic(optional = false)
    @Column(name = "DEPARTMENT_NAME")
    private String departmentName;
    @Basic(optional = false)
    @Column(name = "DEPARTMENT_NAME_EN")
    private String departmentNameEn;
    private Short deleted;
    private Short locked;
    @Column(name = "LAST_UPDATED")
    @Temporal(TemporalType.TIMESTAMP)
    private Date lastUpdated;
    private Short root;
    @Column(name = "AT_LEVEL")
    private Integer atLevel;
    @Basic(optional = false)
    @Column(name = "DIRECT_MANAGER")
    private long directManager;
    @Column(name = "START_DATE")
    @Temporal(TemporalType.TIMESTAMP)
    private Date startDate;
    @Column(name = "EXPIRE_DATE")
    @Temporal(TemporalType.TIMESTAMP)
    private Date expireDate;
    @Column(name = "START_JOIN_POSITION_DATE")
    @Temporal(TemporalType.TIMESTAMP)
    private Date startJoinPositionDate;
    @Column(name = "PRIVATE_DEPARTMENT")
    private Short privateDepartment;
    @OneToMany(mappedBy = "lookupDepartment", fetch = FetchType.LAZY)
    private Set<DepartmentPosition> departmentPositionSet;
    @OneToMany(mappedBy = "parentDepartment", fetch = FetchType.LAZY)
    private Set<LookupDepartment> lookupDepartmentSet;
    @JoinColumn(name = "PARENT_DEPARTMENT", referencedColumnName = "DBID")
    @ManyToOne(fetch = FetchType.LAZY)
    private LookupDepartment parentDepartment;

    public LookupDepartment() {
    }

    public LookupDepartment(Long dbid) {
        this.dbid = dbid;
    }

    public LookupDepartment(Long dbid, String departmentName, String departmentNameEn, long directManager) {
        this.dbid = dbid;
        this.departmentName = departmentName;
        this.departmentNameEn = departmentNameEn;
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

    public String getDepartmentName() {
        return departmentName;
    }

    public void setDepartmentName(String departmentName) {
        this.departmentName = departmentName;
    }

    public String getDepartmentNameEn() {
        return departmentNameEn;
    }

    public void setDepartmentNameEn(String departmentNameEn) {
        this.departmentNameEn = departmentNameEn;
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

    public Short getRoot() {
        return root;
    }

    public void setRoot(Short root) {
        this.root = root;
    }

    public Integer getAtLevel() {
        return atLevel;
    }

    public void setAtLevel(Integer atLevel) {
        this.atLevel = atLevel;
    }

    public long getDirectManager() {
        return directManager;
    }

    public void setDirectManager(long directManager) {
        this.directManager = directManager;
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

    public Date getStartJoinPositionDate() {
        return startJoinPositionDate;
    }

    public void setStartJoinPositionDate(Date startJoinPositionDate) {
        this.startJoinPositionDate = startJoinPositionDate;
    }

    public Short getPrivateDepartment() {
        return privateDepartment;
    }

    public void setPrivateDepartment(Short privateDepartment) {
        this.privateDepartment = privateDepartment;
    }

    public Set<DepartmentPosition> getDepartmentPositionSet() {
        return departmentPositionSet;
    }

    public void setDepartmentPositionSet(Set<DepartmentPosition> departmentPositionSet) {
        this.departmentPositionSet = departmentPositionSet;
    }

    public Set<LookupDepartment> getLookupDepartmentSet() {
        return lookupDepartmentSet;
    }

    public void setLookupDepartmentSet(Set<LookupDepartment> lookupDepartmentSet) {
        this.lookupDepartmentSet = lookupDepartmentSet;
    }

    public LookupDepartment getParentDepartment() {
        return parentDepartment;
    }

    public void setParentDepartment(LookupDepartment parentDepartment) {
        this.parentDepartment = parentDepartment;
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
        if (!(object instanceof LookupDepartment)) {
            return false;
        }
        LookupDepartment other = (LookupDepartment) object;
        if ((this.dbid == null && other.dbid != null) || (this.dbid != null && !this.dbid.equals(other.dbid))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.mms.Hibernate.Entity.LookupDepartment[ dbid=" + dbid + " ]";
    }
    
}
