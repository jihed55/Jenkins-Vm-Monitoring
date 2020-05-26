package com.example.demo.model;

import org.springframework.stereotype.Component;

@Component
public class Memoire {
	public Memoire(String TypeMemoire ,long total, long used, long free, long shared, long buff_cache, long available) {
		super();
		this.type_Memoire = TypeMemoire ;
		this.total = total;
		this.used = used;
		this.free = free;
		this.shared = shared;
		this.buff_cache = buff_cache;
		this.available = available;
	}
	  public Memoire() {
		super();
		// TODO Auto-generated constructor stub
	}
	private String type_Memoire ;
	private long total ;
	private long used ; 
	private long free ;
	private long shared ;
	private long buff_cache ;
	private long available ;
	public long getTotal() {
		return total;
	}
	public void setTotal(long total) {
		this.total = total;
	}
	public long getUsed() {
		return used;
	}
	public void setUsed(long used) {
		this.used = used;
	}
	public long getFree() {
		return free;
	}
	public void setFree(long free) {
		this.free = free;
	}
	public long getShared() {
		return shared;
	}
	public void setShared(long shared) {
		this.shared = shared;
	}
	public long getBuff_cache() {
		return buff_cache;
	}
	public void setBuff_cache(long buff_cache) {
		this.buff_cache = buff_cache;
	}
	public long getAvailable() {
		return available;
	}
	public void setAvailable(long available) {
		this.available = available;
	}
	public String getType_Memoire() {
		return type_Memoire;
	}
	@Override
	public String toString() {
		return "Memoire [type_Memoire=" + type_Memoire + ", total=" + total + ", used=" + used + ", free=" + free
				+ ", shared=" + shared + ", buff_cache=" + buff_cache + ", available=" + available + "]";
	}
	
	
	
	
	
	

}
