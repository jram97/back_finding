package com.finding.app.Repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.finding.app.Documents.Favorite;

@Repository
public interface FavoriteRepository extends MongoRepository<Favorite, String> {

}
