package com.jjos.mscompanies.controllers;

import com.jjos.mscompanies.entities.Company;
import com.jjos.mscompanies.services.CompanyService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.UnsupportedEncodingException;
import java.net.URI;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;

@RestController
@AllArgsConstructor
@RequestMapping(path = "/company")
@Slf4j
@Tag(name="Companies Resources")
public class CompanyController {

    private final CompanyService companyService;

    @Operation(summary = "get a company given a company name")
    @GetMapping(path = "{name}")
    public ResponseEntity<Company> get(@PathVariable  String name){
        log.info("GET: Company {}", name);
        return  ResponseEntity
                .ok(this.companyService.readByName(name));
    }

    @Operation(summary = "create a company")
    @PostMapping
    public ResponseEntity<Company> post(@RequestBody  Company company) {
        log.info("POST: Company {}", company.getName());
        Company createdCompany = this.companyService.crete(company);
        String encodedName = URLEncoder.encode(createdCompany.getName(), StandardCharsets.UTF_8);
        return ResponseEntity.created(URI.create(encodedName)).build();
    }

    @Operation(summary = "update a company")
    @PutMapping(path = "{name}")
    public ResponseEntity<Company> put(@PathVariable  String name, @RequestBody Company company){
        log.info("PUT: Company {}", name);
        return  ResponseEntity
                .ok(this.companyService.update(company, name));
    }

    @Operation(summary = "delete a company given a company name")
    @DeleteMapping(path = "{name}")
    public ResponseEntity<?> delete(@PathVariable  String name){
        log.info("DELETE: Company {}", name);
        this.companyService.delete(name);
        return  ResponseEntity
                .noContent()
                .build();
    }

}
