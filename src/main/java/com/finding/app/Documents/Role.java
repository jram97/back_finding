package com.finding.app.Documents;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import com.finding.app.Enums.Roles;

@Document(collection = "roles")
public class Role {
	
	@Id
	private String id;

	private Roles name;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public Roles getName() {
		return name;
	}

	public void setName(Roles name) {
		this.name = name;
	}
}
