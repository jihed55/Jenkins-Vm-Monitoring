package com.example.demo.model;

public abstract class Auth {
	private String credentialId ;
	private String username ;
	public String getCredentialId() {
		return credentialId;
	}
	
	public Auth(String credentialId, String username, String description) {
		super();
		this.credentialId = credentialId;
		this.username = username;
		this.description = description;
	}

	public Auth() {
		// TODO Auto-generated constructor stub
	}

	public void setCredentialId(String credentialId) {
		this.credentialId = credentialId;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	private String  description ;
	
	public abstract String CrdentialSaveGroovy ();

}
