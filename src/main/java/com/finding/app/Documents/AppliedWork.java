package com.finding.app.Documents;

import java.io.Serializable;
import java.util.Date;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import com.finding.app.Enums.Status;

@Document(collection = "applied_work")
public class AppliedWork implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id
	private String id;

	@DBRef
	private Users user_me;

	@DBRef
	private Users user_to;

	@DBRef
	private Resumen cv;
	
	private Status status;
	
	@CreatedDate
	@Field(name = "create_at")
	private Date createAt;

	@LastModifiedDate
	@Field(name = "last_update")
	private Date lastUpdate;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public Users getUser_me() {
		return user_me;
	}

	public void setUser_me(Users user_me) {
		this.user_me = user_me;
	}

	public Users getUser_to() {
		return user_to;
	}

	public void setUser_to(Users user_to) {
		this.user_to = user_to;
	}

	public Resumen getCv() {
		return cv;
	}

	public void setCv(Resumen cv) {
		this.cv = cv;
	}

	public Status getStatus() {
		return status;
	}

	public void setStatus(Status status) {
		this.status = status;
	}

	public Date getCreateAt() {
		return createAt;
	}

	public void setCreateAt(Date createAt) {
		this.createAt = createAt;
	}

	public Date getLastUpdate() {
		return lastUpdate;
	}

	public void setLastUpdate(Date lastUpdate) {
		this.lastUpdate = lastUpdate;
	}	
}
