package com.example.demo.model;

public class Currency {

	private String from;
	private String to;
	private double amount;
	
	public Currency() {
		
	}

	public Currency(String from, String to, double amount) {
		this.from = from;
		this.to = to;
		this.amount = amount;
	}

	public String getFrom() {
		return from;
	}

	public void setFrom(String from) {
		this.from = from;
	}

	public String getTo() {
		return to;
	}

	public void setTo(String to) {
		this.to = to;
	}

	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}

	@Override
	public String toString() {
		return "Currency [from=" + from + ", to=" + to + ", amount=" + amount + "]";
	}
	
	
}
