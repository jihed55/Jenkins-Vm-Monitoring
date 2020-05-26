package com.example.demo.service;

import java.util.List;

import com.example.demo.model.UserNamePasswordXredential;

public interface AuthCrud   {
	public List<UserNamePasswordXredential> getAllCredntials () ;
	public void deleteCredentialById ();
	public String getUsernameByIdCredential (String CredentialId);
	
	

}
