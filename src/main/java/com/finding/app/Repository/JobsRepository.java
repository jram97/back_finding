package com.finding.app.Repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.finding.app.Documents.Jobs;

@Repository
public interface JobsRepository extends MongoRepository<Jobs, String> {
	
}
