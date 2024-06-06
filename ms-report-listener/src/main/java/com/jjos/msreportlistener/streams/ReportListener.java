package com.jjos.msreportlistener.streams;

import com.jjos.msreportlistener.documents.ReportDocument;
import com.jjos.msreportlistener.repositories.ReportDocumentRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.function.Consumer;

@Configuration
@Slf4j
@AllArgsConstructor
public class ReportListener {

    private final ReportDocumentRepository reportDocumentRepository;

    @Bean
    public Consumer<String> consumerReport(){

        return report -> {

            this.reportDocumentRepository.save(
                    ReportDocument
                            .builder()
                            .content(report)
                            .build());

            log.info("Saving report: {}", report);
        };
    }
}
