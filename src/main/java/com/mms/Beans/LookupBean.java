/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mms.Beans;

import com.mms.Hibernate.Entity.LookupCity;
import com.mms.Hibernate.Entity.LookupCountry;
import com.mms.Service.LookupService;
import java.io.Serializable;
import java.util.List;
import javax.annotation.PostConstruct;

public class LookupBean implements Serializable {

    private LookupService lookupService;

    private List<LookupCity> cities;
    private List<LookupCountry> countrys;

    private LookupCity selectedCity;
    private LookupCountry selectedCountery;

    @PostConstruct
    public void load() {
        cities = lookupService.getAllCities();
        countrys = lookupService.getAllCounteries();
    }

    public LookupService getLookupService() {
        return lookupService;
    }

    public void setLookupService(LookupService lookupService) {
        this.lookupService = lookupService;
    }

    public List<LookupCity> getCities() {
        return cities;
    }

    public void setCities(List<LookupCity> cities) {
        this.cities = cities;
    }

    public List<LookupCountry> getCountrys() {
        return countrys;
    }

    public void setCountrys(List<LookupCountry> countrys) {
        this.countrys = countrys;
    }

    public LookupCity getSelectedCity() {
        return selectedCity;
    }

    public void setSelectedCity(LookupCity selectedCity) {
        this.selectedCity = selectedCity;
    }

    public LookupCountry getSelectedCountery() {
        return selectedCountery;
    }

    public void setSelectedCountery(LookupCountry selectedCountery) {
        this.selectedCountery = selectedCountery;
    }

}
