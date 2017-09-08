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
import javax.persistence.Lob;
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
@Table(name = "LOOKUP_MEETING")
@NamedQueries({
    @NamedQuery(name = "LookupMeeting.findAll", query = "SELECT l FROM LookupMeeting l")})
public class LookupMeeting implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    private Long dbid;
    private String code;
    @Basic(optional = false)
    @Column(name = "MEETING_NAME")
    private String meetingName;
    @Basic(optional = false)
    @Column(name = "MEETING_NAME_EN")
    private String meetingNameEn;
    private Short deleted;
    private Short locked;
    @Lob
    private String description;
    @Column(name = "MEETING_MANAGER")
    private BigInteger meetingManager;
    @Column(name = "FATHER_MANAGER1")
    private BigInteger fatherManager1;
    @Column(name = "FATHER_MANAGER2")
    private BigInteger fatherManager2;
    @Column(name = "LAST_UPDATED")
    @Temporal(TemporalType.TIMESTAMP)
    private Date lastUpdated;
    @Column(name = "PER_MONTHLY")
    private Character perMonthly;
    @Column(name = "PER_WEEK")
    private Character perWeek;
    @Column(name = "NO_WORK_PER_UNIT")
    private Short noWorkPerUnit;
    @Column(name = "EXPECTED_NO_ATTEND_IN_SUMMER")
    private BigInteger expectedNoAttendInSummer;
    @Column(name = "EXPECTED_NO_ATTEND_IN_WINTER")
    private BigInteger expectedNoAttendInWinter;
    @Column(name = "FACEBOOK_ACCOUNT")
    private String facebookAccount;
    @Column(name = "MEETING_MOBILE1")
    private String meetingMobile1;
    @Column(name = "MEETING_MOBILE2")
    private String meetingMobile2;
    @Column(name = "PLACE_FIXED")
    private Short placeFixed;
    @Column(name = "IGNORE_ATTENDACE_AFTER_NO_LATE")
    private BigInteger ignoreAttendaceAfterNoLate;
    @OneToMany(mappedBy = "lookupMeetingDbid", fetch = FetchType.LAZY)
    private Set<MemberDetail> memberDetailSet;
    @OneToMany(mappedBy = "lookupMeetingDbid", fetch = FetchType.LAZY)
    private Set<TimeSegmentRules> timeSegmentRulesSet;
    @JoinColumn(name = "LOOKUP_HALL_DBID_FIXED", referencedColumnName = "DBID")
    @ManyToOne(fetch = FetchType.LAZY)
    private LookupHall lookupHallDbidFixed;

    public LookupMeeting() {
    }

    public LookupMeeting(Long dbid) {
        this.dbid = dbid;
    }

    public LookupMeeting(Long dbid, String meetingName, String meetingNameEn) {
        this.dbid = dbid;
        this.meetingName = meetingName;
        this.meetingNameEn = meetingNameEn;
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

    public String getMeetingName() {
        return meetingName;
    }

    public void setMeetingName(String meetingName) {
        this.meetingName = meetingName;
    }

    public String getMeetingNameEn() {
        return meetingNameEn;
    }

    public void setMeetingNameEn(String meetingNameEn) {
        this.meetingNameEn = meetingNameEn;
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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public BigInteger getMeetingManager() {
        return meetingManager;
    }

    public void setMeetingManager(BigInteger meetingManager) {
        this.meetingManager = meetingManager;
    }

    public BigInteger getFatherManager1() {
        return fatherManager1;
    }

    public void setFatherManager1(BigInteger fatherManager1) {
        this.fatherManager1 = fatherManager1;
    }

    public BigInteger getFatherManager2() {
        return fatherManager2;
    }

    public void setFatherManager2(BigInteger fatherManager2) {
        this.fatherManager2 = fatherManager2;
    }

    public Date getLastUpdated() {
        return lastUpdated;
    }

    public void setLastUpdated(Date lastUpdated) {
        this.lastUpdated = lastUpdated;
    }

    public Character getPerMonthly() {
        return perMonthly;
    }

    public void setPerMonthly(Character perMonthly) {
        this.perMonthly = perMonthly;
    }

    public Character getPerWeek() {
        return perWeek;
    }

    public void setPerWeek(Character perWeek) {
        this.perWeek = perWeek;
    }

    public Short getNoWorkPerUnit() {
        return noWorkPerUnit;
    }

    public void setNoWorkPerUnit(Short noWorkPerUnit) {
        this.noWorkPerUnit = noWorkPerUnit;
    }

    public BigInteger getExpectedNoAttendInSummer() {
        return expectedNoAttendInSummer;
    }

    public void setExpectedNoAttendInSummer(BigInteger expectedNoAttendInSummer) {
        this.expectedNoAttendInSummer = expectedNoAttendInSummer;
    }

    public BigInteger getExpectedNoAttendInWinter() {
        return expectedNoAttendInWinter;
    }

    public void setExpectedNoAttendInWinter(BigInteger expectedNoAttendInWinter) {
        this.expectedNoAttendInWinter = expectedNoAttendInWinter;
    }

    public String getFacebookAccount() {
        return facebookAccount;
    }

    public void setFacebookAccount(String facebookAccount) {
        this.facebookAccount = facebookAccount;
    }

    public String getMeetingMobile1() {
        return meetingMobile1;
    }

    public void setMeetingMobile1(String meetingMobile1) {
        this.meetingMobile1 = meetingMobile1;
    }

    public String getMeetingMobile2() {
        return meetingMobile2;
    }

    public void setMeetingMobile2(String meetingMobile2) {
        this.meetingMobile2 = meetingMobile2;
    }

    public Short getPlaceFixed() {
        return placeFixed;
    }

    public void setPlaceFixed(Short placeFixed) {
        this.placeFixed = placeFixed;
    }

    public BigInteger getIgnoreAttendaceAfterNoLate() {
        return ignoreAttendaceAfterNoLate;
    }

    public void setIgnoreAttendaceAfterNoLate(BigInteger ignoreAttendaceAfterNoLate) {
        this.ignoreAttendaceAfterNoLate = ignoreAttendaceAfterNoLate;
    }

    public Set<MemberDetail> getMemberDetailSet() {
        return memberDetailSet;
    }

    public void setMemberDetailSet(Set<MemberDetail> memberDetailSet) {
        this.memberDetailSet = memberDetailSet;
    }

    public Set<TimeSegmentRules> getTimeSegmentRulesSet() {
        return timeSegmentRulesSet;
    }

    public void setTimeSegmentRulesSet(Set<TimeSegmentRules> timeSegmentRulesSet) {
        this.timeSegmentRulesSet = timeSegmentRulesSet;
    }

    public LookupHall getLookupHallDbidFixed() {
        return lookupHallDbidFixed;
    }

    public void setLookupHallDbidFixed(LookupHall lookupHallDbidFixed) {
        this.lookupHallDbidFixed = lookupHallDbidFixed;
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
        if (!(object instanceof LookupMeeting)) {
            return false;
        }
        LookupMeeting other = (LookupMeeting) object;
        if ((this.dbid == null && other.dbid != null) || (this.dbid != null && !this.dbid.equals(other.dbid))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.mms.Hibernate.Entity.LookupMeeting[ dbid=" + dbid + " ]";
    }
    
}
