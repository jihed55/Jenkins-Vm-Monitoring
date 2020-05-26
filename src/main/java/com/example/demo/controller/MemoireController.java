package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.AgentConnected;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;


/*public class MemoireController 
{
	/*@Autowired 
	private AgentAdresseIp agent ;
	/*@Autowired
	private Memoire mem ;
	@Autowired
	private JSONObject json ;
	@GetMapping("/getJosn")
	public JSONObject getJson() 
	{
		return json ;
	}
	
	@GetMapping("/AvailableMemoire")
	public long getAvailable(@RequestParam(value = "vm") String name) 
	{
		return mem.getAvailable();
	}
	@GetMapping("/memoireSystem")
	public Memoire memoire() 
	{
		return mem;
	}	
	
	
	*//*
	@GetMapping("/status")
	public String getAvailable() 
	{
		return agent.getStatus();
	}
	@GetMapping("/agent/adresseIp")
	public String getAgentAdresseIp(@RequestParam(value = "unix") String name) 
	{
		return agent.getAgent_ip_adress();
	}
	
	@GetMapping("/agent")
	public String getAgent(@RequestParam(value = "unix") String name) throws JsonProcessingException 
	{
		ObjectMapper mapper = new ObjectMapper();
	     return mapper.writeValueAsString(agent);
	}
	
	
}*/
	
