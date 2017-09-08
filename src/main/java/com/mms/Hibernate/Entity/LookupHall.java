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
@Table(name = "LOOKUP_HALL")
@NamedQueries({
    @NamedQuery(name = "LookupHall.findAll", query = "SELECT l FROM LookupHall l")})
public class LookupHall implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    private Long dbid;
    private String code;
    @Basic(optional = false)
    @Column(name = "HALL_NAME")
    private String hallName;
    @Basic(optional = false)
    @Column(name = "HALL_NAME_EN")
    private String hallNameEn;
    private Short deleted;
    private Short locked;
    @Column(name = "LAST_UPDATED")
    @Temporal(TemporalType.TIMESTAMP)
    private Date lastUpdated;
    @Column(name = "LOCATION_DETAIL")
    private String locationDetail;
    @Column(name = "LOCATION_DETAIL_EN")
    private String locationDetailEn;
    @Column(name = "NEAR_FROM_PLACE")
    private String nearFromPlace;
    @Column(name = "BEHIND_PLACE")
    private String behindPlace;
    @Column(name = "IN_FRONT_OF_PLACE")
    private String inFrontOfPlace;
    private Short capacity;
    @Column(name = "RESPONSIBLE1_NAME")
    private String responsible1Name;
    @Column(name = "RESPONSIBLE1_NAME_EN")
    private String responsible1NameEn;
    @Column(name = "RESPONSIBLE1_MOBILE1")
    private String responsible1Mobile1;
    @Column(name = "RESPONSIBLE1_MOBILE2")
    private String responsible1Mobile2;
    @Column(name = "RESPONSIBLE1_IMG")
    private String responsible1Img;
    @Column(name = "RESPONSIBLE2_NAME")
    private String responsible2Name;
    @Column(name = "RESPONSIBLE2_NAME_EN")
    private String responsible2NameEn;
    @Column(name = "RESPONSIBLE2_MOBILE1")
    private String responsible2Mobile1;
    @Column(name = "RESPONSIBLE2_MOBILE2")
    private String responsible2Mobile2;
    @Column(name = "RESPONSIBLE2_IMG")
    private String responsible2Img;
    @JoinColumn(name = "LOOKUP_CHURCH_DBID", referencedColumnName = "DBID")
    @ManyToOne(fetch = FetchType.LAZY)
    private LookupChurch lookupChurchDbid;
    @OneToMany(mappedBy = "lookupHallDbidFixed", fetch = FetchType.LAZY)
    private Set<LookupMeeting> lookupMeetingSet;

    public LookupHall() {
    }

    public LookupHall(Long dbid) {
        this.dbid = dbid;
    }

    public LookupHall(Long dbid, String hallName, String hallNameEn) {
        this.dbid = dbid;
        this.hallName = hallName;
        this.hallNameEn = hallNameEn;
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

    public String getHallName() {
        return hallName;
    }

    public void setHallName(String hallName) {
        this.hallName = hallName;
    }

    public String getHallNameEn() {
        return hallNameEn;
    }

    public void setHallNameEn(String hallNameEn) {
        this.hallNameEn = hallNameEn;
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

    public String getLocationDetail() {
        return locationDetail;
    }

    public void setLocationDetail(String locationDetail) {
        this.locationDetail = locationDetail;
    }

    public String getLocationDetailEn() {
        return locationDetailEn;
    }

    public void setLocationDetailEn(String locationDetailEn) {
        this.locationDetailEn = locationDetailEn;
    }

    public String getNearFromPlace() {
        return nearFromPlace;
    }

    public void setNearFromPlace(String nearFromPlace) {
        this.nearFromPlace = nearFromPlace;
    }

    public String getBehindPlace() {
        return behindPlace;
    }

    public void setBehindPlace(String behindPlace) {
        this.behindPlace = behindPlace;
    }

    public String getInFrontOfPlace() {
        return inFrontOfPlace;
    }

    public void setInFrontOfPlace(String inFrontOfPlace) {
        this.inFrontOfPlace = inFrontOfPlace;
    }

    public Short getCapacity() {
        return capacity;
    }

    public void setCapacity(Short capacity) {
        this.capacity = capacity;
    }

    public String getResponsible1Name() {
        return responsible1Name;
    }

    public void setResponsible1Name(String responsible1Name) {
        this.responsible1Name = responsible1Name;
    }

    public String getResponsible1NameEn() {
        return responsible1NameEn;
    }

    public void setResponsible1NameEn(String responsible1NameEn) {
        this.responsible1NameEn = responsible1NameEn;
    }

    public String getResponsible1Mobile1() {
        return responsible1Mobile1;
    }

    public void setResponsible1Mobile1(String responsible1Mobile1) {
        this.responsible1Mobile1 = responsible1Mobile1;
    }

    public String getResponsible1Mobile2() {
        return responsible1Mobile2;
    }

    public void setResponsible1Mobile2(String responsible1Mobile2) {
        this.responsible1Mobile2 = responsible1Mobile2;
    }

    public String getResponsible1Img() {
        return responsible1Img;
    }

    public void setResponsible1Img(String responsible1Img) {
        this.responsible1Img = responsible1Img;
    }

    public String getResponsible2Name() {
        return responsible2Name;
    }

    public void setResponsible2Name(String responsible2Name) {
        this.responsible2Name = responsible2Name;
    }

    public String getResponsible2NameEn() {
        return responsible2NameEn;
    }

    public void setResponsible2NameEn(String responsible2NameEn) {
        this.responsible2NameEn = responsible2NameEn;
    }

    public String getResponsible2Mobile1() {
        return responsible2Mobile1;
    }

    public void setResponsible2Mobile1(String responsible2Mobile1) {
        this.responsible2Mobile1 = responsible2Mobile1;
    }

    public String getResponsible2Mobile2() {
        return responsible2Mobile2;
    }

    public void setResponsible2Mobile2(String responsible2Mobile2) {
        this.responsible2Mobile2 = responsible2Mobile2;
    }

    public String getResponsible2Img() {
        return responsible2Img;
    }

    public void setResponsible2Img(String responsible2Img) {
        this.responsible2Img = responsible2Img;
    }

    public LookupChurch getLookupChurchDbid() {
        return lookupChurchDbid;
    }

    public void setLookupChurchDbid(LookupChurch lookupChurchDbid) {
        this.lookupChurchDbid = lookupChurchDbid;
    }

    public Set<LookupMeeting> getLookupMeetingSet() {
        return lookupMeetingSet;
    }

    public void setLookupMeetingSet(Set<LookupMeeting> lookupMeetingSet) {
        this.lookupMeetingSet = lookupMeetingSet;
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
        if (!(object instanceof LookupHall)) {
            return false;
        }
        LookupHall other = (LookupHall) object;
        if ((this.dbid == null && other.dbid != null) || (this.dbid != null && !this.dbid.equals(other.dbid))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.mms.Hibernate.Entity.LookupHall[ dbid=" + dbid + " ]";
    }
    
}
