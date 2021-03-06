package com.finding.app.Repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.finding.app.Documents.Resumen;

@Repository
public interface ResumenRepository extends MongoRepository<Resumen, String> {

	public Resumen findByPublicId(String publicId);
	
}
