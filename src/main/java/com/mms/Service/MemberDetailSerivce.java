package com.mms.Service;

import com.mms.Dao.SessionDAO;
import com.mms.Hibernate.Entity.MemberDetail;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author David Shiref
 */
public class MemberDetailSerivce {

    @Autowired
    SessionDAO sessionDAO;

    @Transactional
    public MemberDetail InsertRecord(String Fname, String Lname, String FnameEn, String LnameEn, String Address1) {
        MemberDetail memberDetail = new MemberDetail(null, Fname, Lname, FnameEn, LnameEn, Address1);
        return sessionDAO.Save(memberDetail);
    }

    public void DeleteRecord(long dbid) {
        sessionDAO.delete(dbid, MemberDetail.class);
    }

    public MemberDetail UpdateRecord(long dbid) {

        return null;
    }

    public List<MemberDetail> getAllRecord() {
        return sessionDAO.fetchAll(MemberDetail.class);
    }

    public MemberDetail GetRecord(long dbid) {
        return sessionDAO.fetchById(dbid, MemberDetail.class);
    }

    public List<MemberDetail> getByColumnName(String ColumnName, String ColumnValue) {
        return sessionDAO.getByName(ColumnName, ColumnValue, MemberDetail.class);
    }

}
