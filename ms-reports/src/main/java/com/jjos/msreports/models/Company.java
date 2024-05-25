package com.jjos.msreports.models;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.*;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Company implements Serializable {

    private Long id;

    private String name;

    private String founder;

    private String logo;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy")
    private LocalDate foundationDate;

    private List<WebSite> webSites;
}
