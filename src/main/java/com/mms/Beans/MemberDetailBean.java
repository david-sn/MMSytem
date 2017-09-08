/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mms.Beans;

import com.mms.Hibernate.Entity.MemberDetail;
import com.mms.Service.MemberDetailSerivce;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;

/**
 * @author David Shire
 */
public class MemberDetailBean implements Serializable {

    MemberDetailSerivce memberDetailSerivce;

    List<MemberDetail> allMember;
    List<MemberDetail> filterMember;
    MemberDetail selectedMember;

    @PostConstruct
    public void loadAllMember() {
        allMember = memberDetailSerivce.getAllRecord();
    }

    public MemberDetailSerivce getMemberDetailSerivce() {
        return memberDetailSerivce;
    }

    public void setMemberDetailSerivce(MemberDetailSerivce memberDetailSerivce) {
        this.memberDetailSerivce = memberDetailSerivce;
    }

    public List<MemberDetail> getAllMember() {
        return allMember;
    }

    public void setAllMember(List<MemberDetail> allMember) {
        this.allMember = allMember;
    }

    public MemberDetail getSelectedMember() {
        return selectedMember;
    }

    public void setSelectedMember(MemberDetail selectedMember) {
        this.selectedMember = selectedMember;
    }

    public List<MemberDetail> getFilterMember() {
        return filterMember;
    }

    public void setFilterMember(List<MemberDetail> filterMember) {
        this.filterMember = filterMember;
    }

}
