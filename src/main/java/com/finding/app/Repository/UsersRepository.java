package com.finding.app.Repository;

import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.finding.app.Documents.Users;

@Repository
public interface UsersRepository extends MongoRepository<Users, String> {

	public Optional<Users> findByUsername(String username);

	public Boolean existsByUsername(String username);

	public Boolean existsByEmail(String email);
	
}
