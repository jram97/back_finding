package com.finding.app.Controllers;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.finding.app.Commons.CommonController;
import com.finding.app.Commons.Response;
import com.finding.app.Config.JwtUtils;
import com.finding.app.Documents.Countries;
import com.finding.app.Documents.Jobs;
import com.finding.app.Documents.Users;
import com.finding.app.Documents.DTO.JobsDTO;
import com.finding.app.Enums.Codes;
import com.finding.app.Enums.Messages;
import com.finding.app.Service.CountriesService;
import com.finding.app.Service.JobsService;
import com.finding.app.Service.UsersService;

@PreAuthorize("hasRole('USER') or hasRole('ENTERPRISE') or hasRole('ADMIN')")
@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/v1/jobs")
public class JobsController extends CommonController<Jobs, JobsService> {

	@Autowired
	private UsersService usersService;

	@Autowired
	private CountriesService countryService;
	
	@Autowired
	private JwtUtils jwtProvider;	
	
	@PostMapping("/save")
	public ResponseEntity<?> createNew(@RequestBody JobsDTO jobsDto, @RequestHeader("Authorization") String token){
		
		String alias = jwtProvider.getUserNameFromJwtToken(token.split(" ")[1]);
		Optional<Users> user = usersService.findByUsername(alias);

		Optional<Countries> country = countryService.findById(jobsDto.getCountry());
		
		Jobs jobsNew = new Jobs();
		jobsNew.setName(jobsDto.getName());
		jobsNew.setDescription(jobsDto.getDescription());
		jobsNew.setExperience(jobsDto.getExperience());
		jobsNew.setExternalUrl(jobsDto.getExternalUrl());
		jobsNew.setSalary(jobsDto.getSalary());
		jobsNew.setTotalPositions(jobsDto.getTotalPositions());
		jobsNew.setJobType(jobsDto.getJobType());
		jobsNew.setContractType(jobsDto.getContractType());
		jobsNew.setGender(jobsDto.getGender());
		jobsNew.setLastDay(jobsDto.getLastDay());
		
		jobsNew.setUser(user.get());
		jobsNew.setCountry(country.get());
		
		service.save(jobsNew);
		
		return ResponseEntity.status(HttpStatus.CREATED).body(new Response(Codes.CREATED.getValue(), Messages.SAVE.getValue()));
	}

	
	@PutMapping("/update")
	public ResponseEntity<?> updateJobs(@RequestBody JobsDTO jobsDto){		
		
		Optional<Jobs> jobsUpdate = service.findById(jobsDto.getId());
		Jobs updateJobs = jobsUpdate.get();
		updateJobs.setName(jobsDto.getName());
		updateJobs.setDescription(jobsDto.getDescription());
		updateJobs.setExperience(jobsDto.getExperience());
		updateJobs.setExternalUrl(jobsDto.getExternalUrl());
		updateJobs.setSalary(jobsDto.getSalary());
		updateJobs.setTotalPositions(jobsDto.getTotalPositions());
		updateJobs.setJobType(jobsDto.getJobType());
		updateJobs.setContractType(jobsDto.getContractType());
		updateJobs.setGender(jobsDto.getGender());
		updateJobs.setLastDay(jobsDto.getLastDay());
		
		service.save(updateJobs);
		
		return ResponseEntity.status(HttpStatus.CREATED).body(new Response(Codes.CREATED.getValue(), Messages.SAVE.getValue()));
	}
}