package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.UserNamePasswordXredential;

@Service
public class ManageAuth  implements AuthCrud {
	@Autowired 
	private UserNamePasswordXredential usernamePasswordCredential ;

	@Override
	public List<UserNamePasswordXredential> getAllCredntials() {
		
		return null;
	}

	@Override
	public void deleteCredentialById() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public String getUsernameByIdCredential(String CredentialId) {
		// TODO Auto-generated method stub
		return null;
	}
	
	
	

}
