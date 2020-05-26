package com.example.restapi;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan()
public class Config2 {
	public AgentRestApi getAgentRestApi()
	{
		return new AgentRestApi();
	}

}
