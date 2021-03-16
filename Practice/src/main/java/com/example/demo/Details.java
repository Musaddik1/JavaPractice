package com.example.demo;

public class Details {
	
	private int srNo;
	private String name;
	private boolean online;
	
	public Details() {
		
	}

	public Details(int srNo, String name, boolean online) {
		super();
		this.srNo = srNo;
		this.name = name;
		this.online = online;
	}

	public int getSrNo() {
		return srNo;
	}

	public void setSrNo(int srNo) {
		this.srNo = srNo;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public boolean isOnline() {
		return online;
	}

	public void setOnline(boolean online) {
		this.online = online;
	}
	

}
