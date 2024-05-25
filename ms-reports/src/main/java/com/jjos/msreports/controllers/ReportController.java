package com.jjos.msreports.controllers;

import com.jjos.msreports.service.ReportService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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

    @PostMapping()
    public ResponseEntity<Map<String, String>> post(@RequestBody String report){
        var response = Map.of("report" ,this.reportService.saveReport(report));
        log.info("POST: Report {}", response );
        return  ResponseEntity
                .ok(response);
    }

    @DeleteMapping(path = "{name}")
    public ResponseEntity<Void> delete(@PathVariable String name){
        this.reportService.deleteReport(name);
        log.info("DELETE: Report {}", name);
        return ResponseEntity
                .noContent()
                .build();
    }
}
