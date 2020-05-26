package com.example.demo.service;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;

import org.springframework.stereotype.Service;
@Service
public class AddToFile {
	
	
	public static void setMessage(String message,String path )  {
		
	
			RandomAccessFile f;
			try {
				f = new RandomAccessFile(new File(path), "rw");
				f.seek(0);
				f.write(message.getBytes());
				f.close();
			} catch (FileNotFoundException e) {
				System.out.print("verifier Path");
				e.printStackTrace();
			} catch (IOException e) {
				
				e.printStackTrace();
			}
			
		
	
	

}
}
