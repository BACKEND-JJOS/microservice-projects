package com.jjos.msreports.streams;

import lombok.AllArgsConstructor;
import org.springframework.cloud.stream.function.StreamBridge;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class ReportPublisher {

    private final StreamBridge streamBridge;

    /*
        TOPIC NAME -> consumerReport

     */
    public void publishReport(String report){
        //Se debe de crear siempre 3 topics
        this.streamBridge.send("consumerReport" ,report);
        this.streamBridge.send("consumerReport-in-0" ,report);
        this.streamBridge.send("consumerReport-out-0" ,report);
    }
}
