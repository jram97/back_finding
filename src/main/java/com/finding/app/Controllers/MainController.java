package com.finding.app.Controllers;

import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.finding.app.Commons.Response;
import com.finding.app.Config.JwtUtils;
import com.finding.app.Documents.Countries;
import com.finding.app.Documents.Role;
import com.finding.app.Documents.Users;
import com.finding.app.Documents.DTO.JwtResponse;
import com.finding.app.Documents.DTO.LoginRequest;
import com.finding.app.Documents.DTO.UsersDTO;
import com.finding.app.Enums.Codes;
import com.finding.app.Enums.Roles;
import com.finding.app.Repository.RoleRepository;
import com.finding.app.Repository.UsersRepository;
import com.finding.app.Service.CountriesService;
import com.finding.app.Service.UserDetailsImpl;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/auth")
public class MainController {

	@Autowired
	private UsersRepository userRepository;

	@Autowired
	private CountriesService countryService;

	@Autowired
	private RoleRepository roleRepository;

	@Autowired
	PasswordEncoder encoder;

	@Autowired
	AuthenticationManager authenticationManager;

	@Autowired
	JwtUtils jwtUtils;

	@PostMapping("/signin")
	public ResponseEntity<?> authenticateUser(@RequestBody LoginRequest loginRequest) {

		try {
			Authentication authentication = authenticationManager.authenticate(
					new UsernamePasswordAuthenticationToken(loginRequest.getUsername(), loginRequest.getPassword()));

			SecurityContextHolder.getContext().setAuthentication(authentication);
			String jwt = jwtUtils.generateJwtToken(authentication);

			UserDetailsImpl userDetails = (UserDetailsImpl) authentication.getPrincipal();
			List<String> roles = userDetails.getAuthorities().stream().map(item -> item.getAuthority())
					.collect(Collectors.toList());

			return ResponseEntity.ok(new JwtResponse(jwt, userDetails.getId(), userDetails.getUsername(),
					userDetails.getEmail(), roles));

		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST)
					.body(new Response(Codes.BAD_REQUEST.getValue(), e.getMessage()));
		}
	}

	@PostMapping("/signup")
	public ResponseEntity<?> registerUser(@RequestBody UsersDTO signUpRequest) {

		try {

			if (userRepository.existsByUsername(signUpRequest.getUsername())) {
				return ResponseEntity.status(HttpStatus.BAD_REQUEST)
						.body(new Response(Codes.BAD_REQUEST.getValue(), "Username is already taken!"));
			}

			if (userRepository.existsByEmail(signUpRequest.getEmail())) {
				return ResponseEntity.status(HttpStatus.BAD_REQUEST)
						.body(new Response(Codes.BAD_REQUEST.getValue(), "Email is already in use!!"));
			}

			Optional<Countries> country = countryService.findById(signUpRequest.getCountry());
			Users entityNew = new Users();
			entityNew.setNameComplete(signUpRequest.getNameComplete());
			entityNew.setUsername(signUpRequest.getUsername());
			entityNew.setEmail(signUpRequest.getEmail());
			entityNew.setPassword(encoder.encode(signUpRequest.getPassword()));
			entityNew.setPhoto(signUpRequest.getPhoto());
			entityNew.setCountry(country.get());

			Set<String> strRoles = signUpRequest.getRoles();
			Set<Role> roles = new HashSet<>();

			if (strRoles == null) {
				Role userRole = roleRepository.findByName(Roles.ROLE_USER)
						.orElseThrow(() -> new RuntimeException("Error: Role USER is not found."));
				roles.add(userRole);
			} else {
				strRoles.forEach(role -> {
					switch (role) {
					case "adm":
						Role adminRole = roleRepository.findByName(Roles.ROLE_ADMIN)
								.orElseThrow(() -> new RuntimeException("Error: Role ADMIN is not found."));
						roles.add(adminRole);

						break;
					case "ent":
						Role modRole = roleRepository.findByName(Roles.ROLE_ENTERPRISE)
								.orElseThrow(() -> new RuntimeException("Error: Role ENTERPRISE is not found."));
						roles.add(modRole);

						break;
					default:
						Role userRole = roleRepository.findByName(Roles.ROLE_USER)
								.orElseThrow(() -> new RuntimeException("Error: Role USER is not found."));
						roles.add(userRole);
					}
				});
			}

			entityNew.setRoles(roles);
			userRepository.save(entityNew);

			return ResponseEntity.status(HttpStatus.CREATED)
					.body(new Response(Codes.CREATED.getValue(), "User registered successfully!"));

		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST)
					.body(new Response(Codes.BAD_REQUEST.getValue(), e.getMessage()));
		}
	}
}
