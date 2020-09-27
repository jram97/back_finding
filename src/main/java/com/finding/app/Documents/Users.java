package com.finding.app.Documents;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

@Document(collection = "users")
public class Users implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	private String id;

	@Indexed
	@Field(name = "name_complete")
	private String nameComplete;

	@Indexed
	private String username;
	
	private String email;

	private String password;

	private String available = "Disponible";
	
	private String direction;

	private String photo;

	@Field(name = "num_votes")
	private int numVotes = 0;

	@Field(name = "total_score")
	private double totalScore = 0;

	private double rating = 0;
	
	@DBRef
	private Countries country;

	@DBRef
	private List<Favorite> favorites;

	private boolean status = true;

	@DBRef
	private Set<Role> roles = new HashSet<>();

	@CreatedDate
	@Field(name = "create_at")
	private Date createAt;

	@LastModifiedDate
	@Field(name = "last_update")
	private Date lastUpdate;

	public Users() {
		this.favorites = new ArrayList<>();
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getNameComplete() {
		return nameComplete;
	}

	public void setNameComplete(String nameComplete) {
		this.nameComplete = nameComplete;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getPhoto() {
		return photo;
	}

	public void setPhoto(String photo) {
		this.photo = photo;
	}

	public int getNumVotes() {
		return numVotes;
	}

	public void setNumVotes(int numVotes) {
		this.numVotes = numVotes;
	}

	public double getTotalScore() {
		return totalScore;
	}

	public void setTotalScore(double totalScore) {
		this.totalScore = totalScore;
	}

	public String getDirection() {
		return direction;
	}

	public void setDirection(String direction) {
		this.direction = direction;
	}

	public String getAvailable() {
		return available;
	}

	public void setAvailable(String available) {
		this.available = available;
	}

	public double getRating() {
		return rating;
	}

	public void setRating(double rating) {
		this.rating = rating;
	}

	public Countries getCountry() {
		return country;
	}

	public void setCountry(Countries country) {
		this.country = country;
	}

	public List<Favorite> getFavorites() {
		return favorites;
	}

	public void setFavorites(List<Favorite> favorites) {
		this.favorites = favorites;
	}

	public boolean isStatus() {
		return status;
	}

	public void setStatus(boolean status) {
		this.status = status;
	}

	public Set<Role> getRoles() {
		return roles;
	}

	public void setRoles(Set<Role> roles) {
		this.roles = roles;
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

	/** Add Favorites */
	public boolean addFavorites(Favorite favorite) {
		if (!this.favorites.contains(favorite)) {
			this.favorites.add(favorite);
			return true;
		} else {
			return false;
		}
	}

	/** Delete Favorites */
	public void deleteFavorites(Favorite favorite) {
		this.favorites.remove(favorite);
	}

	@Override
	public String toString() {
		return "Users [nameComplete=" + nameComplete + ", username=" + username + ", email=" + email + "]";
	}

}