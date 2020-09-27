package com.finding.app.Repository;

import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.finding.app.Documents.Role;
import com.finding.app.Enums.Roles;

@Repository
public interface RoleRepository extends MongoRepository<Role, String> {

	Optional<Role> findByName(Roles name);
	
}
