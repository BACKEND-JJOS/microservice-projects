package com.jjos.mscompanies.repositories;

import com.jjos.mscompanies.entities.Company;
import com.jjos.mscompanies.entities.WebSite;
import org.springframework.data.jpa.repository.JpaRepository;

public interface WebSiteRepository extends JpaRepository<WebSite, Long> {
}
