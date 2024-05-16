package com.jjos.msreports.service;

import com.jjos.msreports.helper.ReportHelper;
import com.jjos.msreports.models.Company;
import com.jjos.msreports.repositories.CompaniesRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
@Slf4j
public class ReportServiceImpl implements  ReportService{

    private final CompaniesRepository companiesRepository;

    private final ReportHelper reportHelper;

    @Override
    public String makeReport(String name) {
        return reportHelper.readTemplate(companiesRepository.getByName(name).orElseThrow());
    }

    @Override
    public String saveReport(String nameReport) {
        return "";
    }

    @Override
    public void deleteReport(String name) {

    }
}
