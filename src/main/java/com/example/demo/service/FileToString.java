package com.example.demo.service;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

import org.springframework.stereotype.Component;
@Component
public class FileToString {
	String fileAsString ;
	String path ;
	public String getFileAsString() {
		return fileAsString;
	}
	public void setFileAsString() {
		if (this.path != null )
		{
		try {
			this.fileAsString = Files.readString(Paths.get(path));
		} catch (IOException e) {
			e.printStackTrace();
		}
		}
	}
	public String getPath() {
		return path;
	}
	public void setPath(String path) {
		this.path = path;
	}
	
	

}
