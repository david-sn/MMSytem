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
import javax.persistence.CascadeType;
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
@Table(name = "LOOKUP_COUNTRY")
@NamedQueries({
    @NamedQuery(name = "LookupCountry.findAll", query = "SELECT l FROM LookupCountry l")})
public class LookupCountry implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    private Long dbid;
    @Basic(optional = false)
    @Column(name = "COUNTRY_NAME")
    private String countryName;
    @Basic(optional = false)
    @Column(name = "COUNTRY_NAME_EN")
    private String countryNameEn;
    private String shortcut;
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
    @OneToMany(mappedBy = "lookupCityDbid", fetch = FetchType.LAZY)
    private Set<LookupChurch> lookupChurchSet;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "lookupCountryDbid", fetch = FetchType.LAZY)
    private Set<LookupCity> lookupCitySet;

    public LookupCountry() {
    }

    public LookupCountry(Long dbid) {
        this.dbid = dbid;
    }

    public LookupCountry(Long dbid, String countryName, String countryNameEn) {
        this.dbid = dbid;
        this.countryName = countryName;
        this.countryNameEn = countryNameEn;
    }

    public Long getDbid() {
        return dbid;
    }

    public void setDbid(Long dbid) {
        this.dbid = dbid;
    }

    public String getCountryName() {
        return countryName;
    }

    public void setCountryName(String countryName) {
        this.countryName = countryName;
    }

    public String getCountryNameEn() {
        return countryNameEn;
    }

    public void setCountryNameEn(String countryNameEn) {
        this.countryNameEn = countryNameEn;
    }

    public String getShortcut() {
        return shortcut;
    }

    public void setShortcut(String shortcut) {
        this.shortcut = shortcut;
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

    public Set<LookupChurch> getLookupChurchSet() {
        return lookupChurchSet;
    }

    public void setLookupChurchSet(Set<LookupChurch> lookupChurchSet) {
        this.lookupChurchSet = lookupChurchSet;
    }

    public Set<LookupCity> getLookupCitySet() {
        return lookupCitySet;
    }

    public void setLookupCitySet(Set<LookupCity> lookupCitySet) {
        this.lookupCitySet = lookupCitySet;
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
        if (!(object instanceof LookupCountry)) {
            return false;
        }
        LookupCountry other = (LookupCountry) object;
        if ((this.dbid == null && other.dbid != null) || (this.dbid != null && !this.dbid.equals(other.dbid))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.mms.Hibernate.Entity.LookupCountry[ dbid=" + dbid + " ]";
    }
    
}
