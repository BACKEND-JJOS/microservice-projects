package com.jjos.msreports.service;

import com.jjos.msreports.helper.ReportHelper;
import com.jjos.msreports.models.Company;
import com.jjos.msreports.models.WebSite;
import com.jjos.msreports.repositories.CompaniesRepository;
import com.jjos.msreports.streams.ReportPublisher;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

@Service
@AllArgsConstructor
@Slf4j
public class ReportServiceImpl implements  ReportService{

    private final CompaniesRepository companiesRepository;

    private final ReportHelper reportHelper;

    private final ReportPublisher reportPublisher;

    @Override
    public String makeReport(String name) {
        return this.reportHelper.readTemplate(companiesRepository.getByName(name).orElseThrow());
    }

    @Override
    public String saveReport(String report) {

        var format= DateTimeFormatter.ofPattern("dd/MM/yyyy");
        var placeholdersCompany  = this.reportHelper.getPlaceHoldersFromTemplate(report);

        var webSites = Arrays.stream(placeholdersCompany.get(3).split(","))
                .map
                        (
                                webSite -> WebSite
                                        .builder()
                                        .name(webSite)
                                        .build()
                        )
                .toList();

          var  company = Company.builder()
                .name(placeholdersCompany.get(0))
                .founder(placeholdersCompany.get(0))
                .foundationDate(LocalDate.parse(placeholdersCompany.get(1), format))
                .webSites(webSites)
                .build();

        this.companiesRepository.postByName(company);

        return "Saved";
    }

    @Override
    public void deleteReport(String name) {
        Company companyDetele =  this.companiesRepository.deleteByName(name);
    }
}
