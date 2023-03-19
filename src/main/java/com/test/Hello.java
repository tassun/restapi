package com.test;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name="hello")
public class Hello {
	private String message;
	public Hello() { super(); }
	public Hello(String message) {
		setMessage(message);
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}	
}
