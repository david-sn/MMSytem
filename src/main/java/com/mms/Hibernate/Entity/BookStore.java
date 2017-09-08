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
@Table(name = "BOOK_STORE")
@NamedQueries({
    @NamedQuery(name = "BookStore.findAll", query = "SELECT b FROM BookStore b")})
public class BookStore implements Serializable {

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
    @Column(name = "STORE_NAME")
    private String storeName;
    @Column(name = "OPEN_TIME")
    @Temporal(TemporalType.TIMESTAMP)
    private Date openTime;
    @Column(name = "CLOSE_TIME")
    @Temporal(TemporalType.TIMESTAMP)
    private Date closeTime;
    @Column(name = "DAY_INDEX")
    private String dayIndex;
    @Column(name = "PLICY_RULE")
    private String plicyRule;
    private String phone;
    private String address;
    @Column(name = "MAX_NUMBER_TO_BORROW")
    private Short maxNumberToBorrow;
    @Column(name = "MAX_DAYS_TO_BORROW")
    private Short maxDaysToBorrow;
    @JoinColumn(name = "MEMBER_DETAIL_DBID_RESPONSIBLE", referencedColumnName = "DBID")
    @ManyToOne(fetch = FetchType.LAZY)
    private MemberDetail memberDetailDbidResponsible;
    @JoinColumn(name = "USER_ACCOUNT_DBID_RESPONSIBLE", referencedColumnName = "DBID")
    @ManyToOne(fetch = FetchType.LAZY)
    private UserAccount userAccountDbidResponsible;

    public BookStore() {
    }

    public BookStore(Long dbid) {
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

    public String getStoreName() {
        return storeName;
    }

    public void setStoreName(String storeName) {
        this.storeName = storeName;
    }

    public Date getOpenTime() {
        return openTime;
    }

    public void setOpenTime(Date openTime) {
        this.openTime = openTime;
    }

    public Date getCloseTime() {
        return closeTime;
    }

    public void setCloseTime(Date closeTime) {
        this.closeTime = closeTime;
    }

    public String getDayIndex() {
        return dayIndex;
    }

    public void setDayIndex(String dayIndex) {
        this.dayIndex = dayIndex;
    }

    public String getPlicyRule() {
        return plicyRule;
    }

    public void setPlicyRule(String plicyRule) {
        this.plicyRule = plicyRule;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Short getMaxNumberToBorrow() {
        return maxNumberToBorrow;
    }

    public void setMaxNumberToBorrow(Short maxNumberToBorrow) {
        this.maxNumberToBorrow = maxNumberToBorrow;
    }

    public Short getMaxDaysToBorrow() {
        return maxDaysToBorrow;
    }

    public void setMaxDaysToBorrow(Short maxDaysToBorrow) {
        this.maxDaysToBorrow = maxDaysToBorrow;
    }

    public MemberDetail getMemberDetailDbidResponsible() {
        return memberDetailDbidResponsible;
    }

    public void setMemberDetailDbidResponsible(MemberDetail memberDetailDbidResponsible) {
        this.memberDetailDbidResponsible = memberDetailDbidResponsible;
    }

    public UserAccount getUserAccountDbidResponsible() {
        return userAccountDbidResponsible;
    }

    public void setUserAccountDbidResponsible(UserAccount userAccountDbidResponsible) {
        this.userAccountDbidResponsible = userAccountDbidResponsible;
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
        if (!(object instanceof BookStore)) {
            return false;
        }
        BookStore other = (BookStore) object;
        if ((this.dbid == null && other.dbid != null) || (this.dbid != null && !this.dbid.equals(other.dbid))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.mms.Hibernate.Entity.BookStore[ dbid=" + dbid + " ]";
    }
    
}
