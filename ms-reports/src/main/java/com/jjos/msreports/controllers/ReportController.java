package com.jjos.msreports.controllers;

import com.jjos.msreports.service.ReportService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@AllArgsConstructor
@RequestMapping(path = "/report")
@Slf4j
public class ReportController {

    private final ReportService reportService;

    @GetMapping(path = "{name}")
    public ResponseEntity<Map<String, String>> get(@PathVariable String name){
        var response = Map.of("report" ,this.reportService.makeReport(name));
        log.info("GET: Report {}", name);
        return  ResponseEntity
                .ok(response);
    }
}
