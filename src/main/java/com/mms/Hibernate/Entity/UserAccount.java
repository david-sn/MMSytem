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
import javax.persistence.ManyToMany;
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
@Table(name = "USER_ACCOUNT")
@NamedQueries({
    @NamedQuery(name = "UserAccount.findAll", query = "SELECT u FROM UserAccount u")})
public class UserAccount implements Serializable {

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
    @Column(name = "FIRST_NAME")
    private String firstName;
    @Column(name = "LAST_NAME")
    private String lastName;
    private String email;
    private String password;
    private Serializable img;
    private String phone;
    private String address;
    @Column(name = "ALLOW_USER_CREATION")
    private Short allowUserCreation;
    @Column(name = "LAST_LOGIN_DATE")
    @Temporal(TemporalType.TIMESTAMP)
    private Date lastLoginDate;
    @Column(name = "MAC_ADDRESS_LOGIN")
    private String macAddressLogin;
    @Column(name = "IP_ADDRESS")
    private String ipAddress;
    @Column(name = "ACCESS_TOKEN")
    private String accessToken;
    @Column(name = "PASSWORD_EXPIRE_DURATION_DAYS")
    private Long passwordExpireDurationDays;
    @Column(name = "EXPIRE_DATE")
    @Temporal(TemporalType.TIMESTAMP)
    private Date expireDate;
    @Column(name = "LOGIN_START_TIME")
    @Temporal(TemporalType.TIMESTAMP)
    private Date loginStartTime;
    @Column(name = "LOGIN_END_TIME")
    @Temporal(TemporalType.TIMESTAMP)
    private Date loginEndTime;
    @ManyToMany(mappedBy = "userAccountSet", fetch = FetchType.LAZY)
    private Set<LookupRole> lookupRoleSet;
    @JoinColumn(name = "LOOKUP_USER_TYPE_DBID", referencedColumnName = "DBID")
    @ManyToOne(fetch = FetchType.LAZY)
    private LookupUserType lookupUserTypeDbid;
    @JoinColumn(name = "MEMBER_DETAIL_DBID", referencedColumnName = "DBID")
    @ManyToOne(fetch = FetchType.LAZY)
    private MemberDetail memberDetailDbid;
    @OneToMany(mappedBy = "userAccountDbidResponsible", fetch = FetchType.LAZY)
    private Set<BookStore> bookStoreSet;

    public UserAccount() {
    }

    public UserAccount(Long dbid) {
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

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Serializable getImg() {
        return img;
    }

    public void setImg(Serializable img) {
        this.img = img;
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

    public Short getAllowUserCreation() {
        return allowUserCreation;
    }

    public void setAllowUserCreation(Short allowUserCreation) {
        this.allowUserCreation = allowUserCreation;
    }

    public Date getLastLoginDate() {
        return lastLoginDate;
    }

    public void setLastLoginDate(Date lastLoginDate) {
        this.lastLoginDate = lastLoginDate;
    }

    public String getMacAddressLogin() {
        return macAddressLogin;
    }

    public void setMacAddressLogin(String macAddressLogin) {
        this.macAddressLogin = macAddressLogin;
    }

    public String getIpAddress() {
        return ipAddress;
    }

    public void setIpAddress(String ipAddress) {
        this.ipAddress = ipAddress;
    }

    public String getAccessToken() {
        return accessToken;
    }

    public void setAccessToken(String accessToken) {
        this.accessToken = accessToken;
    }

    public Long getPasswordExpireDurationDays() {
        return passwordExpireDurationDays;
    }

    public void setPasswordExpireDurationDays(Long passwordExpireDurationDays) {
        this.passwordExpireDurationDays = passwordExpireDurationDays;
    }

    public Date getExpireDate() {
        return expireDate;
    }

    public void setExpireDate(Date expireDate) {
        this.expireDate = expireDate;
    }

    public Date getLoginStartTime() {
        return loginStartTime;
    }

    public void setLoginStartTime(Date loginStartTime) {
        this.loginStartTime = loginStartTime;
    }

    public Date getLoginEndTime() {
        return loginEndTime;
    }

    public void setLoginEndTime(Date loginEndTime) {
        this.loginEndTime = loginEndTime;
    }

    public Set<LookupRole> getLookupRoleSet() {
        return lookupRoleSet;
    }

    public void setLookupRoleSet(Set<LookupRole> lookupRoleSet) {
        this.lookupRoleSet = lookupRoleSet;
    }

    public LookupUserType getLookupUserTypeDbid() {
        return lookupUserTypeDbid;
    }

    public void setLookupUserTypeDbid(LookupUserType lookupUserTypeDbid) {
        this.lookupUserTypeDbid = lookupUserTypeDbid;
    }

    public MemberDetail getMemberDetailDbid() {
        return memberDetailDbid;
    }

    public void setMemberDetailDbid(MemberDetail memberDetailDbid) {
        this.memberDetailDbid = memberDetailDbid;
    }

    public Set<BookStore> getBookStoreSet() {
        return bookStoreSet;
    }

    public void setBookStoreSet(Set<BookStore> bookStoreSet) {
        this.bookStoreSet = bookStoreSet;
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
        if (!(object instanceof UserAccount)) {
            return false;
        }
        UserAccount other = (UserAccount) object;
        if ((this.dbid == null && other.dbid != null) || (this.dbid != null && !this.dbid.equals(other.dbid))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.mms.Hibernate.Entity.UserAccount[ dbid=" + dbid + " ]";
    }
    
}
