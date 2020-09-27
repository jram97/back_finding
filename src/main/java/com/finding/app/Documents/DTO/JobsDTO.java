package com.finding.app.Documents.DTO;

import java.util.Date;

public class JobsDTO {

	private String id;

	private String name;

	private String externalUrl;

	private String description;

	private String salary;

	private String contractType;

	private String totalPositions;

	private String jobType;

	private String country;

	private String user;

	private String gender;

	private String experience;

	private Date lastDay;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getExternalUrl() {
		return externalUrl;
	}

	public void setExternalUrl(String externalUrl) {
		this.externalUrl = externalUrl;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getSalary() {
		return salary;
	}

	public void setSalary(String salary) {
		this.salary = salary;
	}

	public String getContractType() {
		return contractType;
	}

	public void setContractType(String contractType) {
		this.contractType = contractType;
	}

	public String getTotalPositions() {
		return totalPositions;
	}

	public void setTotalPositions(String totalPositions) {
		this.totalPositions = totalPositions;
	}

	public String getJobType() {
		return jobType;
	}

	public void setJobType(String jobType) {
		this.jobType = jobType;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getUser() {
		return user;
	}

	public void setUser(String user) {
		this.user = user;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getExperience() {
		return experience;
	}

	public void setExperience(String experience) {
		this.experience = experience;
	}

	public Date getLastDay() {
		return lastDay;
	}

	public void setLastDay(Date lastDay) {
		this.lastDay = lastDay;
	}

	@Override
	public String toString() {
		return "JobsDTO [id=" + id + ", name=" + name + ", externalUrl=" + externalUrl + ", description=" + description
				+ ", salary=" + salary + ", contractType=" + contractType + ", totalPositions=" + totalPositions
				+ ", jobType=" + jobType + ", country=" + country + ", user=" + user + ", gender=" + gender
				+ ", experience=" + experience + ", lastDay=" + lastDay + "]";
	}
	
	
	
}
