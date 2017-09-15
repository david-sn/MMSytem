/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mms.Service;

import com.mms.Dao.SessionDAO;
import com.mms.Hibernate.Entity.LookupCity;
import com.mms.Hibernate.Entity.LookupCountry;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;

/**
 *
 * @author David Shire
 */
public class LookupService {

    @Autowired
    SessionDAO sessionDAO;

    public List<LookupCity> getAllCities() {
        return sessionDAO.fetchAll(LookupCity.class);
    }

    public List<LookupCountry> getAllCounteries() {
        return sessionDAO.fetchAll(LookupCountry.class);
    }

}
