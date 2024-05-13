package com.jjos.mscompanies.services;

import com.jjos.mscompanies.entities.Company;

public interface CompanyService {
    Company readByName(String name);
    Company crete(Company company);
    Company update(Company company, String name);
    void delete(String name);
}
