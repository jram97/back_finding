package com.finding.app.Repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.finding.app.Documents.Countries;

@Repository
public interface CountriesRepository extends MongoRepository<Countries, String> {

}
