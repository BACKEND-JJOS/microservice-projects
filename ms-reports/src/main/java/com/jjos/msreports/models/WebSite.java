package com.jjos.msreports.models;

import lombok.*;

import java.io.Serializable;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class WebSite implements Serializable {

    private Long id;

    private String name;

    private Category category;

    private String description;

}
