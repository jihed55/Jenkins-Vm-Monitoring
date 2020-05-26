package com.example.demo.service;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;

import org.hibernate.validator.internal.util.privilegedactions.GetAnnotationAttribute;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.web.context.WebApplicationContext;

import com.example.demo.model.AgentConnected;
import com.example.demo.model.AvailableProcess;
import com.example.demo.model.Memoire;
import com.example.demo.model.MemoryUsage;
import com.example.demo.model.ProcessCpuLoad;
import com.example.demo.model.SSHVM;
import com.example.restapi.AgentRestApi;
import com.fasterxml.jackson.databind.ObjectMapper;

import net.minidev.json.JSONObject;
import net.minidev.json.parser.JSONParser;
import net.minidev.json.parser.ParseException;

@Configuration
@ComponentScan()
public class Config 
{ @Bean
	public ConnectionToAgent getConnectionToAgent()
	{    
	   System.out.println("ConnectionToAgent");
		return new ConnectionToAgent();
	}

@Bean
  public Memoire getMemoire () throws URISyntaxException, org.apache.http.ParseException, IOException
   
   {	
	   System.out.println("hhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhh1");

	  this.getConnectionToAgent().setencodeUrl("free -m");
		URI uri = new URI ("http://localhost:8080/computer/unix/scriptText?script="+this.getConnectionToAgent().getEncodeUrl());

		 this.getConnection().setHttpEntity(uri);
         
         MemoireResultReques.setResult(this.getConnection().getResultRequest());
         System.out.print(MemoireResultReques.result[8]);
         if (MemoireResultReques.result[7] == null)
         {
         return new Memoire (MemoireResultReques.result[7],Long.parseLong(MemoireResultReques.result[8]),Long.parseLong(MemoireResultReques.result[9]),Long.parseLong(MemoireResultReques.result[10]),Long.parseLong(MemoireResultReques.result[11]),Long.parseLong(MemoireResultReques.result[12]),Long.parseLong(MemoireResultReques.result[13]));
         }else {
        	 return null ;
         }
   }
   

@Bean

public MemoryUsage getMemoryUsage () throws IOException, URISyntaxException
{
	   System.out.print("MemoryUSAGE");

	this.getFileToString().setPath("C:\\Users\\jihed\\eclipse-workspace\\demo\\ressourceGroovy\\memoryUsage");
	this.getFileToString().setFileAsString();
	this.getConnectionToAgent().encodeFile(this.getFileToString().getFileAsString());
	URI uri = new URI ("http://localhost:8080/scriptText?script="+this.getConnectionToAgent().encodeFile);
	 this.getConnection().setHttpEntity(uri);
     MemoryUsage memory = new ObjectMapper().readValue( this.getConnection().getResultRequest(), MemoryUsage.class);
     return memory ;
}
@Bean 
public AgentConnected getAgentAdresseIp () throws IOException, URISyntaxException
{ 
	this.getFileToString().setPath("C:\\Users\\jihed\\eclipse-workspace\\demo\\ressourceGroovy\\ipAddr");
	this.getFileToString().setFileAsString();
	this.getConnectionToAgent().encodeFile(this.getFileToString().getFileAsString());
	   System.out.println("AgentAIP");

	URI uri = new URI ("http://localhost:8080/scriptText?script="+this.getConnectionToAgent().encodeFile);
	 this.getConnection().setHttpEntity(uri);
     AgentConnected agent = new ObjectMapper().readValue( this.getConnection().getResultRequest(), AgentConnected.class);
     return agent ;
}
@Bean 
ConnectDisconnect getAddfileToString () throws IOException, URISyntaxException
{    //AddToFile.setMessage("slaveName = 'unix'; action = 'disconnect' ;", "C:\\Users\\jihed\\eclipse-workspace\\demo\\ressourceGroovy\\connectioToAgent");
	this.getFileToString().setPath("C:\\Users\\jihed\\eclipse-workspace\\demo\\ressourceGroovy\\ConnectioToAgent");
	this.getFileToString().setFileAsString();
	this.getConnectionToAgent().encodeFile(this.getFileToString().getFileAsString());
	URI uri = new URI ("http://localhost:8080/scriptText?script="+this.getConnectionToAgent().encodeFile);
	 this.getConnection().setHttpEntity(uri);
	 System.out.println(this.getConnection().status+"yewwwwwwwwlknjnjn");
     return new ConnectDisconnect() ;
}
/*@Bean 
public AvailableProcess getAvailableProcessor () throws IOException, URISyntaxException
{ 
	this.getFileToString().setPath("C:\\Users\\jihed\\eclipse-workspace\\demo\\ressourceGroovy\\AvailableProcessors");
	this.getFileToString().setFileAsString();
	this.getConnectionToAgent().encodeFile(this.getFileToString().getFileAsString());
	URI uri = new URI ("http://localhost:8080/scriptText?script="+this.getConnectionToAgent().encodeFile);
	 this.getConnection().setHttpEntity(uri);
	 AvailableProcess availableProcess = new ObjectMapper().readValue( this.getConnection().getResultRequest(), AvailableProcess.class);
	System.out.print(availableProcess.toString());
     return availableProcess ;
}*/
/*@Bean 
public ProcessCpuLoad getProcessCpuLoad () throws IOException, URISyntaxException
{ 
	this.getFileToString().setPath("C:\\Users\\jihed\\eclipse-workspace\\demo\\ressourceGroovy\\ProcessCpuLoad");
	this.getFileToString().setFileAsString();
	this.getConnectionToAgent().encodeFile(this.getFileToString().getFileAsString());
	URI uri = new URI ("http://localhost:8080/scriptText?script="+this.getConnectionToAgent().encodeFile);
	 this.getConnection().setHttpEntity(uri);
	 ProcessCpuLoad processCpuLoad = new ObjectMapper().readValue( this.getConnection().getResultRequest(), ProcessCpuLoad.class);
	System.out.print(processCpuLoad.toString());
     return processCpuLoad ;
}*/
 @Bean
   public Connection getConnection ()
   {
	   return new Connection();
   }
  @Bean 
  public JSONObject getAgentJsonObject ()
  {	
	   System.out.print("yewwwwwww");

	  AgentRestApi agent = new AgentRestApi();
	  try {
		agent.setAgent();
	} catch (URISyntaxException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	  @SuppressWarnings("deprecation")
	JSONParser parser = new JSONParser();
	
	JSONObject json = null;
	try {
		json = (JSONObject) parser.parse(agent.getAgent());
	} catch (ParseException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	return json;
	}
@Bean
public FileToString getFileToString ()

{
return new FileToString() ;	
}
@Bean 

public SSHVM getVMSSH ()
{
	   System.out.println("hhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhh2lazyyyyyyyy");

return new SSHVM (); 
}
   
}
