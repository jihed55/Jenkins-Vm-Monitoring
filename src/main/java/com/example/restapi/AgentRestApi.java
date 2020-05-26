package com.example.restapi;

import java.net.URI;
import java.net.URISyntaxException;

import org.springframework.stereotype.Component;

import com.example.demo.service.Connection;
@Component
public class AgentRestApi {

private Connection con = new Connection () ;
private String agent ;
public Connection getCon() {
	return con;
}
public void setCon(Connection con) {
	this.con = con;
}
public String getAgent() {
	return agent;
}
public void setAgent() throws URISyntaxException {
	 con.setHttpEntity(new URI("http://localhost:8080/computer/unix/api/json?pretty=true"));
	 this.agent = con.getResultRequest() ;
}





}
