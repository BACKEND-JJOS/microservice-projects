package com.jjos.msreportlistener.repositories;

import com.jjos.msreportlistener.documents.ReportDocument;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface ReportDocumentRepository extends MongoRepository<ReportDocument, String> {
}
