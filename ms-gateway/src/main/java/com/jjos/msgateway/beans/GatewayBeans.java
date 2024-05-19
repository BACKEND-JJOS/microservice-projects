package com.jjos.msgateway.beans;

import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

@Configuration
public class GatewayBeans {

    @Bean
    @Profile(value = "eureka-off")
    public RouteLocator routerLocatorEurekaOff(RouteLocatorBuilder builder){
        return builder
                .routes()
                .route(
                        route -> route
                                .path("/ms-companies/**")
                                .uri("http://localhost:8081")
                )
                .route(
                        route -> route
                                .path("/ms-reports/**")
                                .uri("http://localhost7070")
                )
                .build();
    }

    @Bean
    @Profile(value = "eureka-on")
    public RouteLocator routerLocatorEurekaOn(RouteLocatorBuilder builder){
        return builder
                .routes()
                .route(
                        route -> route
                                .path("/ms-companies/**")
                                .uri("lb://ms-companies")
                )
                .route(
                        route -> route
                                .path("/ms-reports/**")
                                .uri("lb://ms-reports")
                )
                .build();
    }
}
