package com.jjos.msgateway.beans;

import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

@Configuration
public class GatewayBeans {

    /**
     * Configuración de rutas para el perfil 'eureka-off'.
     * Utiliza direcciones URI directas cuando Eureka no está activo.
     *
     * @param builder Constructor de rutas.
     * @return Configuración de rutas.
     */
    @Bean
    @Profile(value = "eureka-off")
    public RouteLocator routerLocatorEurekaOff(RouteLocatorBuilder builder) {
        return builder
                .routes()
                .route(route -> route
                        .path("/ms-companies/**")
                        .uri("http://localhost:8081"))
                .route(route -> route
                        .path("/ms-reports/**")
                        .uri("http://localhost:7070"))
                .build();
    }

    /**
     * Configuración de rutas para el perfil 'eureka-on'.
     * Utiliza el balanceador de carga de Eureka cuando está activo.
     *
     * @param builder Constructor de rutas.
     * @return Configuración de rutas.
     */
    @Bean
    @Profile(value = "eureka-on")
    public RouteLocator routerLocatorEurekaOn(RouteLocatorBuilder builder) {
        return builder
                .routes()
                .route(route -> route
                        .path("/ms-companies/**")
                        .uri("lb://ms-companies"))
                .route(route -> route
                        .path("/ms-reports/**")
                        .uri("lb://ms-reports"))
                .build();
    }
}
