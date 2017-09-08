/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mms.Hibernate.Entity;

import java.io.Serializable;
import java.math.BigInteger;
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
@Table(name = "LOOKUP_CHURCH")
@NamedQueries({
    @NamedQuery(name = "LookupChurch.findAll", query = "SELECT l FROM LookupChurch l")})
public class LookupChurch implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    private Long dbid;
    @Basic(optional = false)
    @Column(name = "CHURCH_NAME")
    private String churchName;
    @Basic(optional = false)
    @Column(name = "CHURCH_NAME_EN")
    private String churchNameEn;
    private BigInteger lng;
    private BigInteger lat;
    private String code;
    private Short deleted;
    private Short locked;
    @Column(name = "LAST_UPDATED")
    @Temporal(TemporalType.TIMESTAMP)
    private Date lastUpdated;
    @Column(name = "CREATED_DATE")
    @Temporal(TemporalType.TIMESTAMP)
    private Date createdDate;
    @JoinColumn(name = "LOOKUP_CITY_DBID", referencedColumnName = "DBID")
    @ManyToOne(fetch = FetchType.LAZY)
    private LookupCountry lookupCityDbid;
    @OneToMany(mappedBy = "lookupChurchDbid", fetch = FetchType.LAZY)
    private Set<LookupFather> lookupFatherSet;
    @OneToMany(mappedBy = "lookupChurchDbid", fetch = FetchType.LAZY)
    private Set<LookupHall> lookupHallSet;

    public LookupChurch() {
    }

    public LookupChurch(Long dbid) {
        this.dbid = dbid;
    }

    public LookupChurch(Long dbid, String churchName, String churchNameEn) {
        this.dbid = dbid;
        this.churchName = churchName;
        this.churchNameEn = churchNameEn;
    }

    public Long getDbid() {
        return dbid;
    }

    public void setDbid(Long dbid) {
        this.dbid = dbid;
    }

    public String getChurchName() {
        return churchName;
    }

    public void setChurchName(String churchName) {
        this.churchName = churchName;
    }

    public String getChurchNameEn() {
        return churchNameEn;
    }

    public void setChurchNameEn(String churchNameEn) {
        this.churchNameEn = churchNameEn;
    }

    public BigInteger getLng() {
        return lng;
    }

    public void setLng(BigInteger lng) {
        this.lng = lng;
    }

    public BigInteger getLat() {
        return lat;
    }

    public void setLat(BigInteger lat) {
        this.lat = lat;
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

    public LookupCountry getLookupCityDbid() {
        return lookupCityDbid;
    }

    public void setLookupCityDbid(LookupCountry lookupCityDbid) {
        this.lookupCityDbid = lookupCityDbid;
    }

    public Set<LookupFather> getLookupFatherSet() {
        return lookupFatherSet;
    }

    public void setLookupFatherSet(Set<LookupFather> lookupFatherSet) {
        this.lookupFatherSet = lookupFatherSet;
    }

    public Set<LookupHall> getLookupHallSet() {
        return lookupHallSet;
    }

    public void setLookupHallSet(Set<LookupHall> lookupHallSet) {
        this.lookupHallSet = lookupHallSet;
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
        if (!(object instanceof LookupChurch)) {
            return false;
        }
        LookupChurch other = (LookupChurch) object;
        if ((this.dbid == null && other.dbid != null) || (this.dbid != null && !this.dbid.equals(other.dbid))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.mms.Hibernate.Entity.LookupChurch[ dbid=" + dbid + " ]";
    }
    
}
