package com.finding.app.Service;

import java.util.Optional;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.finding.app.Commons.CommonServiceImple;
import com.finding.app.Documents.Users;
import com.finding.app.Repository.UsersRepository;

@Service
public class UsersServiceImple extends CommonServiceImple<Users, UsersRepository>
		implements UsersService, UserDetailsService {

	@Override
	@Transactional
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Users user = repository.findByUsername(username)
				.orElseThrow(() -> new UsernameNotFoundException("User Not Found with username: " + username));

		return UserDetailsImpl.build(user);
	}

	@Override
	public Optional<Users> findByUsername(String username) {
		return repository.findByUsername(username);
	}

	@Override
	public Boolean existsByUsername(String username) {
		return repository.existsByUsername(username);
	}

	@Override
	public Boolean existsByEmail(String email) {
		return repository.existsByEmail(email);
	}
}
