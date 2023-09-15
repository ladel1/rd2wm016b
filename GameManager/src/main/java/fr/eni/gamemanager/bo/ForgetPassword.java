package fr.eni.gamemanager.bo;

import java.time.LocalDate;

public class ForgetPassword {

	private int id;
	private String code;
	private User user;
	private LocalDate dateCreated;
	
	public ForgetPassword() { }

	public ForgetPassword(String code, User user) {
		this.code = code;
		this.user = user;
	}

	public ForgetPassword(int id, String code, User user, LocalDate dateCreated) {
		this.id = id;
		this.code = code;
		this.user = user;
		this.dateCreated = dateCreated;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public LocalDate getDateCreated() {
		return dateCreated;
	}

	public void setDateCreated(LocalDate dateCreated) {
		this.dateCreated = dateCreated;
	}
	
	
	
	
	
}
