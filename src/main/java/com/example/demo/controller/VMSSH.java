package com.example.demo.controller;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.SSHVM;
import com.example.demo.service.Connection;
import com.example.demo.service.ConnectionToAgent;

@RestController
@CrossOrigin(origins = "*")

public class VMSSH {
	@Autowired 
	private Connection connection ;
   @Autowired 
   private ConnectionToAgent connectionToAgent  ;
   @Autowired 
   private  SSHVM sshvm ;
   @PostMapping(
		   value = "/createAgent", consumes = "application/json", produces = "application/json")
   public void CreateAgent (@RequestBody SSHVM sv  ) throws IOException, URISyntaxException
   {
	  
	    connectionToAgent.encodeFile(sv.creatSSHVMgroovy());
	    System.out.print(sv.creatSSHVMgroovy());
	 URI uri = new URI ("http://localhost:8080/scriptText?script="+connectionToAgent.encodeFile);  
	    System.out.print("here2");

	 connection.setHttpEntity(uri);    
	    System.out.print("here3");


   }
   
   
	
	

}
