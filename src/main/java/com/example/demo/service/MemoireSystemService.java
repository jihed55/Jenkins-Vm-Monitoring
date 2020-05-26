package com.example.demo.service;

public class MemoireSystemService 
{
	private String Memoire ;
	private String memoireParsing ;
	public String getMemoire() {
		return Memoire;
	}
	public void setMemoire(String memoire) {

	}
	public String getMemoireParsing() {
		return memoireParsing;
	}
	public void setMemoireParsing() 
	{
		if (this.Memoire == null)
		{
		 
		}
	}
	@Override
	public String toString() {
		return "MemoireSystemService [Memoire=" + Memoire + ", memoireParsing=" + memoireParsing + "]";
	}
	
	
	
	
	
}
