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
@Table(name = "LOOKUP_CITY")
@NamedQueries({
    @NamedQuery(name = "LookupCity.findAll", query = "SELECT l FROM LookupCity l")})
public class LookupCity implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    private Long dbid;
    @Basic(optional = false)
    @Column(name = "CITY_NAME")
    private String cityName;
    @Basic(optional = false)
    @Column(name = "CITY_NAME_EN")
    private String cityNameEn;
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
    @JoinColumn(name = "LOOKUP_COUNTRY_DBID", referencedColumnName = "DBID")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private LookupCountry lookupCountryDbid;

    public LookupCity() {
    }

    public LookupCity(Long dbid) {
        this.dbid = dbid;
    }

    public LookupCity(Long dbid, String cityName, String cityNameEn) {
        this.dbid = dbid;
        this.cityName = cityName;
        this.cityNameEn = cityNameEn;
    }

    public Long getDbid() {
        return dbid;
    }

    public void setDbid(Long dbid) {
        this.dbid = dbid;
    }

    public String getCityName() {
        return cityName;
    }

    public void setCityName(String cityName) {
        this.cityName = cityName;
    }

    public String getCityNameEn() {
        return cityNameEn;
    }

    public void setCityNameEn(String cityNameEn) {
        this.cityNameEn = cityNameEn;
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

    public LookupCountry getLookupCountryDbid() {
        return lookupCountryDbid;
    }

    public void setLookupCountryDbid(LookupCountry lookupCountryDbid) {
        this.lookupCountryDbid = lookupCountryDbid;
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
        if (!(object instanceof LookupCity)) {
            return false;
        }
        LookupCity other = (LookupCity) object;
        if ((this.dbid == null && other.dbid != null) || (this.dbid != null && !this.dbid.equals(other.dbid))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.mms.Hibernate.Entity.LookupCity[ dbid=" + dbid + " ]";
    }
    
}
