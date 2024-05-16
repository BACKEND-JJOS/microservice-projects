package com.jjos.msreports.beans;

import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.loadbalancer.core.ServiceInstanceListSupplier;
import org.springframework.context.ConfigurableApplicationContext;

@Slf4j
public class LoadBalancerConfiguration {

    public ServiceInstanceListSupplier serviceInstanceListSupplier(ConfigurableApplicationContext context){
        log.info("Configuring load balancer");
        return  ServiceInstanceListSupplier
                .builder()
                .withBlockingDiscoveryClient()
                .build(context);
    }

}
