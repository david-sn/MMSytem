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
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author David Shire
 */
@Entity
@Table(name = "MEMBER_DETAIL")
@NamedQueries({
    @NamedQuery(name = "MemberDetail.findAll", query = "SELECT m FROM MemberDetail m")})
public class MemberDetail implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long dbid;
    private String code;
    @Basic(optional = false)
    private String fname;
    @Basic(optional = false)
    private String lname;
    @Basic(optional = false)
    @Column(name = "FNAME_EN")
    private String fnameEn;
    @Basic(optional = false)
    @Column(name = "LNAME_EN")
    private String lnameEn;
    private String phone1;
    private String phone2;
    private String mobile1;
    private String mobile2;
    @Basic(optional = false)
    private String address1;
    private String address2;
    @Temporal(TemporalType.TIMESTAMP)
    private Date birthday;
    private Serializable photo1;
    private Serializable photo2;
    private Short deleted;
    @Column(name = "CREATE_DATE")
    @Temporal(TemporalType.TIMESTAMP)
    private Date createDate;
    private Short locked;
    @Column(name = "LAST_MODIFIED_DATE")
    @Temporal(TemporalType.TIMESTAMP)
    private Date lastModifiedDate;
    @Column(name = "EXPIRE_DATE")
    @Temporal(TemporalType.TIMESTAMP)
    private Date expireDate;
    @Lob
    private String notes;
    private Short gender;
    @Column(name = "WORKING_ON_TIME")
    private Short workingOnTime;
    @Column(name = "LIVE_LOCAL")
    private Short liveLocal;
    private Short helpful;
    @Column(name = "JOIN_IN_DEPARTMENT")
    private Short joinInDepartment;
    private Short supervised;
    private String mname;
    @Column(name = "MNAME_EN")
    private String mnameEn;
    @JoinColumn(name = "LOOKUP_MEETING_DBID", referencedColumnName = "DBID")
    @ManyToOne(fetch = FetchType.LAZY)
    private LookupMeeting lookupMeetingDbid;
    @OneToMany(mappedBy = "closeFromMember1", fetch = FetchType.LAZY)
    private Set<MemberDetail> memberDetailSet;
    @JoinColumn(name = "CLOSE_FROM_MEMBER1", referencedColumnName = "DBID")
    @ManyToOne(fetch = FetchType.LAZY)
    private MemberDetail closeFromMember1;
    @OneToMany(mappedBy = "inivitedByMember", fetch = FetchType.LAZY)
    private Set<MemberDetail> memberDetailSet1;
    @JoinColumn(name = "INIVITED_BY_MEMBER", referencedColumnName = "DBID")
    @ManyToOne(fetch = FetchType.LAZY)
    private MemberDetail inivitedByMember;
    @OneToMany(mappedBy = "closeFromMember2", fetch = FetchType.LAZY)
    private Set<MemberDetail> memberDetailSet2;
    @JoinColumn(name = "CLOSE_FROM_MEMBER2", referencedColumnName = "DBID")
    @ManyToOne(fetch = FetchType.LAZY)
    private MemberDetail closeFromMember2;
    @OneToOne(mappedBy = "memberDetailDbidSubervise", fetch = FetchType.LAZY)
    private FollowUp followUp;
    @OneToOne(mappedBy = "memberDetailDbidChild", fetch = FetchType.LAZY)
    private FollowUp followUp1;
    @OneToMany(mappedBy = "memberDetailDbid", fetch = FetchType.LAZY)
    private Set<UserAccount> userAccountSet;
    @OneToMany(mappedBy = "assignedToMemberDetailDbid", fetch = FetchType.LAZY)
    private Set<FollowUpSheet> followUpSheetSet;
    @OneToMany(mappedBy = "memberDetailDbidResponsible", fetch = FetchType.LAZY)
    private Set<BookStore> bookStoreSet;

    public MemberDetail() {
    }

    public MemberDetail(Long dbid) {
        this.dbid = dbid;
    }

    public MemberDetail(Long dbid, String fname, String lname, String fnameEn, String lnameEn, String address1) {
        this.dbid = dbid;
        this.fname = fname;
        this.lname = lname;
        this.fnameEn = fnameEn;
        this.lnameEn = lnameEn;
        this.address1 = address1;
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

    public String getFname() {
        return fname;
    }

    public void setFname(String fname) {
        this.fname = fname;
    }

    public String getLname() {
        return lname;
    }

    public void setLname(String lname) {
        this.lname = lname;
    }

    public String getFnameEn() {
        return fnameEn;
    }

    public void setFnameEn(String fnameEn) {
        this.fnameEn = fnameEn;
    }

    public String getLnameEn() {
        return lnameEn;
    }

    public void setLnameEn(String lnameEn) {
        this.lnameEn = lnameEn;
    }

    public String getPhone1() {
        return phone1;
    }

    public void setPhone1(String phone1) {
        this.phone1 = phone1;
    }

    public String getPhone2() {
        return phone2;
    }

    public void setPhone2(String phone2) {
        this.phone2 = phone2;
    }

    public String getMobile1() {
        return mobile1;
    }

    public void setMobile1(String mobile1) {
        this.mobile1 = mobile1;
    }

    public String getMobile2() {
        return mobile2;
    }

    public void setMobile2(String mobile2) {
        this.mobile2 = mobile2;
    }

    public String getAddress1() {
        return address1;
    }

    public void setAddress1(String address1) {
        this.address1 = address1;
    }

    public String getAddress2() {
        return address2;
    }

    public void setAddress2(String address2) {
        this.address2 = address2;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public Serializable getPhoto1() {
        return photo1;
    }

    public void setPhoto1(Serializable photo1) {
        this.photo1 = photo1;
    }

    public Serializable getPhoto2() {
        return photo2;
    }

    public void setPhoto2(Serializable photo2) {
        this.photo2 = photo2;
    }

    public Short getDeleted() {
        return deleted;
    }

    public void setDeleted(Short deleted) {
        this.deleted = deleted;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public Short getLocked() {
        return locked;
    }

    public void setLocked(Short locked) {
        this.locked = locked;
    }

    public Date getLastModifiedDate() {
        return lastModifiedDate;
    }

    public void setLastModifiedDate(Date lastModifiedDate) {
        this.lastModifiedDate = lastModifiedDate;
    }

    public Date getExpireDate() {
        return expireDate;
    }

    public void setExpireDate(Date expireDate) {
        this.expireDate = expireDate;
    }

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }

    public Short getGender() {
        return gender;
    }

    public void setGender(Short gender) {
        this.gender = gender;
    }

    public Short getWorkingOnTime() {
        return workingOnTime;
    }

    public void setWorkingOnTime(Short workingOnTime) {
        this.workingOnTime = workingOnTime;
    }

    public Short getLiveLocal() {
        return liveLocal;
    }

    public void setLiveLocal(Short liveLocal) {
        this.liveLocal = liveLocal;
    }

    public Short getHelpful() {
        return helpful;
    }

    public void setHelpful(Short helpful) {
        this.helpful = helpful;
    }

    public Short getJoinInDepartment() {
        return joinInDepartment;
    }

    public void setJoinInDepartment(Short joinInDepartment) {
        this.joinInDepartment = joinInDepartment;
    }

    public Short getSupervised() {
        return supervised;
    }

    public void setSupervised(Short supervised) {
        this.supervised = supervised;
    }

    public LookupMeeting getLookupMeetingDbid() {
        return lookupMeetingDbid;
    }

    public void setLookupMeetingDbid(LookupMeeting lookupMeetingDbid) {
        this.lookupMeetingDbid = lookupMeetingDbid;
    }

    public Set<MemberDetail> getMemberDetailSet() {
        return memberDetailSet;
    }

    public void setMemberDetailSet(Set<MemberDetail> memberDetailSet) {
        this.memberDetailSet = memberDetailSet;
    }

    public MemberDetail getCloseFromMember1() {
        return closeFromMember1;
    }

    public void setCloseFromMember1(MemberDetail closeFromMember1) {
        this.closeFromMember1 = closeFromMember1;
    }

    public Set<MemberDetail> getMemberDetailSet1() {
        return memberDetailSet1;
    }

    public void setMemberDetailSet1(Set<MemberDetail> memberDetailSet1) {
        this.memberDetailSet1 = memberDetailSet1;
    }

    public MemberDetail getInivitedByMember() {
        return inivitedByMember;
    }

    public void setInivitedByMember(MemberDetail inivitedByMember) {
        this.inivitedByMember = inivitedByMember;
    }

    public Set<MemberDetail> getMemberDetailSet2() {
        return memberDetailSet2;
    }

    public void setMemberDetailSet2(Set<MemberDetail> memberDetailSet2) {
        this.memberDetailSet2 = memberDetailSet2;
    }

    public MemberDetail getCloseFromMember2() {
        return closeFromMember2;
    }

    public void setCloseFromMember2(MemberDetail closeFromMember2) {
        this.closeFromMember2 = closeFromMember2;
    }

    public FollowUp getFollowUp() {
        return followUp;
    }

    public void setFollowUp(FollowUp followUp) {
        this.followUp = followUp;
    }

    public FollowUp getFollowUp1() {
        return followUp1;
    }

    public void setFollowUp1(FollowUp followUp1) {
        this.followUp1 = followUp1;
    }

    public Set<UserAccount> getUserAccountSet() {
        return userAccountSet;
    }

    public void setUserAccountSet(Set<UserAccount> userAccountSet) {
        this.userAccountSet = userAccountSet;
    }

    public Set<FollowUpSheet> getFollowUpSheetSet() {
        return followUpSheetSet;
    }

    public void setFollowUpSheetSet(Set<FollowUpSheet> followUpSheetSet) {
        this.followUpSheetSet = followUpSheetSet;
    }

    public Set<BookStore> getBookStoreSet() {
        return bookStoreSet;
    }

    public void setBookStoreSet(Set<BookStore> bookStoreSet) {
        this.bookStoreSet = bookStoreSet;
    }

    public String getMname() {
        return mname;
    }

    public void setMname(String mname) {
        this.mname = mname;
    }

    public String getMnameEn() {
        return mnameEn;
    }

    public void setMnameEn(String mnameEn) {
        this.mnameEn = mnameEn;
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
        if (!(object instanceof MemberDetail)) {
            return false;
        }
        MemberDetail other = (MemberDetail) object;
        if ((this.dbid == null && other.dbid != null) || (this.dbid != null && !this.dbid.equals(other.dbid))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.mms.Hibernate.Entity.MemberDetail[ dbid=" + dbid + " ]";
    }

}
