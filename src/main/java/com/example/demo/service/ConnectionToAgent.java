package com.example.demo.service;


import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URISyntaxException;
import java.net.URLEncoder;

import org.springframework.beans.factory.annotation.Autowired;

public class ConnectionToAgent {
	public String encodeUrl ;
	public String encodeFile ;
	@Autowired
	private FileToString fileToString ;
    public void setencodeUrl (String comandeSystem) throws URISyntaxException
    {
      this.encodeUrl = null;
		try 
		{
		  this.encodeUrl = URLEncoder.encode("println"+"\""+comandeSystem+"\".execute().text","UTF-8");
		} catch (UnsupportedEncodingException e)
		{
		  System.out.println(e.toString());
		}
    	
    }
    public String getEncodeUrl ()
    {
    	return this.encodeUrl ;
    }
    public void encodeFile (String fileAsString) throws IOException
    {
        this.encodeFile =URLEncoder.encode(fileAsString,"UTF-8");
    
    }
    public String getEncodeFile ()
    {
    	return this.encodeFile ;
    }
   //methode pour les codes liés au file   
    
    

}