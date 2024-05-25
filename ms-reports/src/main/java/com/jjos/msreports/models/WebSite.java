package com.jjos.msreports.models;

import lombok.*;

import java.io.Serializable;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Builder
public class WebSite implements Serializable {

    private String name;

}
