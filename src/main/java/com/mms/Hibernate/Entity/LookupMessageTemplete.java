/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mms.Hibernate.Entity;

import java.io.Serializable;
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
@Table(name = "LOOKUP_MESSAGE_TEMPLETE")
@NamedQueries({
    @NamedQuery(name = "LookupMessageTemplete.findAll", query = "SELECT l FROM LookupMessageTemplete l")})
public class LookupMessageTemplete implements Serializable {

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
    @Column(name = "MESSAGE_TITLE")
    private String messageTitle;
    @Column(name = "MESSAGE_TITLE_EN")
    private String messageTitleEn;
    @Basic(optional = false)
    @Column(name = "MESSAGE_BODY")
    private String messageBody;
    @Basic(optional = false)
    @Column(name = "MESSAGE_BODY_EN")
    private String messageBodyEn;
    @JoinColumn(name = "LOOKUP_CATEGORY_MESSAGE_DBID", referencedColumnName = "DBID")
    @ManyToOne(fetch = FetchType.LAZY)
    private LookupMessageCategory lookupCategoryMessageDbid;
    @JoinColumn(name = "LOOKUP_CATEGORY_MESSAGE_DBID_D", referencedColumnName = "DBID")
    @ManyToOne(fetch = FetchType.LAZY)
    private LookupMessageCategory lookupCategoryMessageDbidD;

    public LookupMessageTemplete() {
    }

    public LookupMessageTemplete(Long dbid) {
        this.dbid = dbid;
    }

    public LookupMessageTemplete(Long dbid, String messageBody, String messageBodyEn) {
        this.dbid = dbid;
        this.messageBody = messageBody;
        this.messageBodyEn = messageBodyEn;
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

    public String getMessageTitle() {
        return messageTitle;
    }

    public void setMessageTitle(String messageTitle) {
        this.messageTitle = messageTitle;
    }

    public String getMessageTitleEn() {
        return messageTitleEn;
    }

    public void setMessageTitleEn(String messageTitleEn) {
        this.messageTitleEn = messageTitleEn;
    }

    public String getMessageBody() {
        return messageBody;
    }

    public void setMessageBody(String messageBody) {
        this.messageBody = messageBody;
    }

    public String getMessageBodyEn() {
        return messageBodyEn;
    }

    public void setMessageBodyEn(String messageBodyEn) {
        this.messageBodyEn = messageBodyEn;
    }

    public LookupMessageCategory getLookupCategoryMessageDbid() {
        return lookupCategoryMessageDbid;
    }

    public void setLookupCategoryMessageDbid(LookupMessageCategory lookupCategoryMessageDbid) {
        this.lookupCategoryMessageDbid = lookupCategoryMessageDbid;
    }

    public LookupMessageCategory getLookupCategoryMessageDbidD() {
        return lookupCategoryMessageDbidD;
    }

    public void setLookupCategoryMessageDbidD(LookupMessageCategory lookupCategoryMessageDbidD) {
        this.lookupCategoryMessageDbidD = lookupCategoryMessageDbidD;
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
        if (!(object instanceof LookupMessageTemplete)) {
            return false;
        }
        LookupMessageTemplete other = (LookupMessageTemplete) object;
        if ((this.dbid == null && other.dbid != null) || (this.dbid != null && !this.dbid.equals(other.dbid))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.mms.Hibernate.Entity.LookupMessageTemplete[ dbid=" + dbid + " ]";
    }
    
}
