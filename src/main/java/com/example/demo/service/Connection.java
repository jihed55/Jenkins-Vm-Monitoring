package com.example.demo.service;

import java.io.IOException;
import java.net.URI;

import org.apache.http.HttpEntity;
import org.apache.http.StatusLine;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.params.HttpParams;
import org.apache.http.util.EntityUtils;
import org.springframework.stereotype.Component;
@Component
public class Connection {
	private HttpEntity entity ;
	private String resultRequest ;
	public int status ;
	 public void setHttpEntity (URI uri )
	 {
		 HttpPost post = new HttpPost(uri);
			post.setHeader("content-type", "application/json");


			// Request parameters and other properties.     
			try (CloseableHttpClient httpClient = HttpClients.createDefault();
		             CloseableHttpResponse response = httpClient.execute(post)) 
			{ 
				    this.status = response.getStatusLine().getStatusCode();
				     
		        	this.entity = response.getEntity();
					this.resultRequest = EntityUtils.toString(this.entity);

	    } catch (IOException e) 
			{
		    System.out.println(e.toString());
	        }
	 }
	 
	 
	


	


		public HttpEntity getHttpEntity ()
	     {
		 return this.entity ;
	     }


		public String getResultRequest() {
			return resultRequest;
		}


		/*public  void setResultRequest() {
			if (this.entity != null ) 
			{
				
			
			
				try { 
					HttpEntity v = this.entity ;
					String s = EntityUtils.toString(v) ;
					
					this.resultRequest = s;
     } 
				catch 
				(ParseException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			
							
				

			}
			}*/
	
}
