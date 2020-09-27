package com.finding.app.Documents;

import java.io.Serializable;
import java.util.Date;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

@Document(collection = "countries")
public class Countries implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	private String id;

	private String name;

	private String code;

	@CreatedDate
	@Field(name = "create_at")
	private Date createAt;

	@LastModifiedDate
	@Field(name = "last_update")
	private Date lastUpdate;

	public Countries() {
	}

	public Countries(String name) {
		this.name = name;
	}

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

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
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

	@Override
	public String toString() {
		return "Countries [id=" + id + ", name=" + name + ", createAt=" + createAt + ", lastUpdate=" + lastUpdate + "]";
	}

}