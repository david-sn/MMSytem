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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author David Shire
 */
@Entity
@NamedQueries({
    @NamedQuery(name = "Event.findAll", query = "SELECT e FROM Event e")})
public class Event implements Serializable {

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
    @Column(name = "FROM_DATE")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fromDate;
    @Column(name = "TO_DATE")
    @Temporal(TemporalType.TIMESTAMP)
    private Date toDate;
    @Column(name = "EVENT_TITLE")
    private String eventTitle;
    @Column(name = "EVENT_TITLE_EN")
    private String eventTitleEn;
    @Lob
    @Column(name = "EVENT_DESCRIPTION")
    private String eventDescription;
    @Lob
    @Column(name = "EVENT_DESCRIPTION_EN")
    private String eventDescriptionEn;
    @Column(name = "WARNINIG_TEXT")
    private String warninigText;
    @Column(name = "COVER_IMG")
    private Serializable coverImg;
    @Lob
    private Serializable img1;
    @Lob
    private Serializable img2;
    @Lob
    private Serializable img3;
    @Column(name = "LOCATION_DETAIL")
    private String locationDetail;
    @Column(name = "LOOKUP_CITY_DBID")
    private BigInteger lookupCityDbid;
    private BigInteger price;
    @Column(name = "RESPONSIBLE1_DBID")
    private BigInteger responsible1Dbid;
    @Column(name = "RESPONSIBLE2_DBID")
    private BigInteger responsible2Dbid;
    @Column(name = "RESPONSIBLE_NAME")
    private String responsibleName;
    @Column(name = "RESPONSIBLE_MOBILE")
    private String responsibleMobile;
    @Column(name = "PRIVATE_INVITATION")
    private Short privateInvitation;
    @JoinColumn(name = "LOOKUP_EVENT_TYPE", referencedColumnName = "DBID")
    @ManyToOne(fetch = FetchType.LAZY)
    private LookupEventType lookupEventType;

    public Event() {
    }

    public Event(Long dbid) {
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

    public Date getFromDate() {
        return fromDate;
    }

    public void setFromDate(Date fromDate) {
        this.fromDate = fromDate;
    }

    public Date getToDate() {
        return toDate;
    }

    public void setToDate(Date toDate) {
        this.toDate = toDate;
    }

    public String getEventTitle() {
        return eventTitle;
    }

    public void setEventTitle(String eventTitle) {
        this.eventTitle = eventTitle;
    }

    public String getEventTitleEn() {
        return eventTitleEn;
    }

    public void setEventTitleEn(String eventTitleEn) {
        this.eventTitleEn = eventTitleEn;
    }

    public String getEventDescription() {
        return eventDescription;
    }

    public void setEventDescription(String eventDescription) {
        this.eventDescription = eventDescription;
    }

    public String getEventDescriptionEn() {
        return eventDescriptionEn;
    }

    public void setEventDescriptionEn(String eventDescriptionEn) {
        this.eventDescriptionEn = eventDescriptionEn;
    }

    public String getWarninigText() {
        return warninigText;
    }

    public void setWarninigText(String warninigText) {
        this.warninigText = warninigText;
    }

    public Serializable getCoverImg() {
        return coverImg;
    }

    public void setCoverImg(Serializable coverImg) {
        this.coverImg = coverImg;
    }

    public Serializable getImg1() {
        return img1;
    }

    public void setImg1(Serializable img1) {
        this.img1 = img1;
    }

    public Serializable getImg2() {
        return img2;
    }

    public void setImg2(Serializable img2) {
        this.img2 = img2;
    }

    public Serializable getImg3() {
        return img3;
    }

    public void setImg3(Serializable img3) {
        this.img3 = img3;
    }

    public String getLocationDetail() {
        return locationDetail;
    }

    public void setLocationDetail(String locationDetail) {
        this.locationDetail = locationDetail;
    }

    public BigInteger getLookupCityDbid() {
        return lookupCityDbid;
    }

    public void setLookupCityDbid(BigInteger lookupCityDbid) {
        this.lookupCityDbid = lookupCityDbid;
    }

    public BigInteger getPrice() {
        return price;
    }

    public void setPrice(BigInteger price) {
        this.price = price;
    }

    public BigInteger getResponsible1Dbid() {
        return responsible1Dbid;
    }

    public void setResponsible1Dbid(BigInteger responsible1Dbid) {
        this.responsible1Dbid = responsible1Dbid;
    }

    public BigInteger getResponsible2Dbid() {
        return responsible2Dbid;
    }

    public void setResponsible2Dbid(BigInteger responsible2Dbid) {
        this.responsible2Dbid = responsible2Dbid;
    }

    public String getResponsibleName() {
        return responsibleName;
    }

    public void setResponsibleName(String responsibleName) {
        this.responsibleName = responsibleName;
    }

    public String getResponsibleMobile() {
        return responsibleMobile;
    }

    public void setResponsibleMobile(String responsibleMobile) {
        this.responsibleMobile = responsibleMobile;
    }

    public Short getPrivateInvitation() {
        return privateInvitation;
    }

    public void setPrivateInvitation(Short privateInvitation) {
        this.privateInvitation = privateInvitation;
    }

    public LookupEventType getLookupEventType() {
        return lookupEventType;
    }

    public void setLookupEventType(LookupEventType lookupEventType) {
        this.lookupEventType = lookupEventType;
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
        if (!(object instanceof Event)) {
            return false;
        }
        Event other = (Event) object;
        if ((this.dbid == null && other.dbid != null) || (this.dbid != null && !this.dbid.equals(other.dbid))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.mms.Hibernate.Entity.Event[ dbid=" + dbid + " ]";
    }
    
}
