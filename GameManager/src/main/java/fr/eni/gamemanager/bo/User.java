package fr.eni.gamemanager.bo;

import java.time.LocalDate;

public class User {

	private int id;
	private String username;
	private String password;
	private String email;
	private LocalDate dateCreated;
	
	
	public User() { }


	public User(int id, String username, String password, String email, LocalDate dateCreated) {
		super();
		this.id = id;
		this.username = username;
		this.password = password;
		this.email = email;
		this.dateCreated = dateCreated;
	}


	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public String getUsername() {
		return username;
	}


	public void setUsername(String username) {
		this.username = username;
	}


	public String getPassword() {
		return password;
	}


	public void setPassword(String password) {
		this.password = password;
	}


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}


	public LocalDate getDateCreated() {
		return dateCreated;
	}


	public void setDateCreated(LocalDate dateCreated) {
		this.dateCreated = dateCreated;
	}
	
	
	
}
