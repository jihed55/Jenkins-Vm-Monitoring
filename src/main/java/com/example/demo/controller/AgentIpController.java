package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import com.example.demo.model.AgentConnected;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
@RestController
@CrossOrigin(origins = "*")
public class AgentIpController {
	@Autowired
	private AgentConnected agentIp ;
	@GetMapping("/AgentAdresseIp")
	public String getAgentAdresseIp() throws JsonProcessingException 
	{     
		ObjectMapper mapper = new ObjectMapper();
	     String k =  mapper.writeValueAsString(agentIp);
	     return k ;
	}
	@GetMapping("/status")
	public String getAvailable() 
	{
		return agentIp.getStatus();
	}
	

}
