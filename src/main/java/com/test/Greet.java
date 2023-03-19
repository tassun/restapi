package com.test;

public class Greet {
	private String message;
	public Greet() {
		super();		
	}
	public Greet(String message) {
		setMessage(message);
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public String toString() {
		return super.toString()+"{message="+message+"}";
	}
}
