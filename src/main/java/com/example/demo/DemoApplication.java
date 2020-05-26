package com.example.demo;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import org.apache.http.auth.UsernamePasswordCredentials;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.example.demo.model.Auth;
import com.example.demo.model.SSHVM;
import com.example.demo.model.UserNamePasswordXredential;
import com.example.demo.service.Connection;
import com.example.demo.service.ConnectionToAgent;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;
import com.google.gson.JsonObject;

import net.minidev.json.parser.ParseException;

@SpringBootApplication
public class DemoApplication {

	public static void main(String[] args) throws URISyntaxException, ParseException, IOException {
		

		
		SpringApplication.run(DemoApplication.class, args);
		ConnectionToAgent  ct = new ConnectionToAgent() ;
	    Connection c = new Connection () ;
	    
	    UserNamePasswordXredential u = new UserNamePasswordXredential() ;
	     /*u.setCredentialId("tarek");
	     u.setDescription("mabrouka");
	       u.setUsername("yesser");*/
	   String s =u.getAllCredentialGroovyScript();
      // System.out.print(s);

	   ct.encodeFile(s);
	    URI uri = new URI ("http://localhost:8080/scriptText?script="+ct.encodeFile);  
     c.setHttpEntity(uri);
     String  convertedObject = new Gson().toJson(c.getResultRequest());
     ObjectMapper mapper = new ObjectMapper();
     mapper.configure(DeserializationFeature.ACCEPT_SINGLE_VALUE_AS_ARRAY, true);

     List<UsernamePasswordCredentials> ronaldo = Arrays.asList(mapper.readValue(convertedObject,UsernamePasswordCredentials[] .class));;
        System.out.print(ronaldo.get(0));
	 	

			
	    
	
		
	}

}
