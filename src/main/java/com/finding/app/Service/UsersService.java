package com.finding.app.Service;

import java.util.Optional;

import com.finding.app.Commons.CommonService;
import com.finding.app.Documents.Users;

public interface UsersService extends CommonService<Users> {

	Optional<Users> findByUsername(String username);

	Boolean existsByUsername(String username);

	Boolean existsByEmail(String email);
	
}
