package com.test;

public class Account {
	private String name;
	private String surname;
	public Account() {
		super();
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getSurname() {
		return surname;
	}
	public void setSurname(String surname) {
		this.surname = surname;
	}
	public String getFullName() {
		return name+" "+surname;
	}
	public String toString() {
		return super.toString()+"{name="+name+", surname="+surname+"}";
	}
}
