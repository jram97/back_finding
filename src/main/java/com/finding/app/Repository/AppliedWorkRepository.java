package com.finding.app.Repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.finding.app.Documents.AppliedWork;

@Repository
public interface AppliedWorkRepository extends MongoRepository<AppliedWork, String> {

}
