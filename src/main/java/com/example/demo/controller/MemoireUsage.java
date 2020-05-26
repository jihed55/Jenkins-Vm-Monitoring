package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.model.MemoryUsage;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class MemoireUsage {
	@Autowired 
 private MemoryUsage memoire ;
	@GetMapping("/Memoire/init")
	public String getAvailable() 
	{
		return memoire.getInit();
	}
	@GetMapping("/Memoire/committed")
	public String getCommitted() 
	{
		return memoire.getCommitted();
	}
	@GetMapping("/Memoire/max")
	public String getMax() 
	{
		return memoire.getMax();
	}
	@GetMapping("/Memoire/used")
	public String getUsed() 
	{
		return memoire.getUsed();
	}
	
	@GetMapping("/MemoireUsage")
	public String getAgentAdresseIp(@RequestParam(value = "unix") String name) throws JsonProcessingException 
	{

		ObjectMapper mapper = new ObjectMapper();
	     return mapper.writeValueAsString(memoire);
	}

}
