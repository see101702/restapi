package com.example.hwapi;


public class Student {
	int sid;
	String name;
	String Email;
	String Degree;
	int graduation;
	
	public Student(int sid, String name, String email, String degree, int graduation) {
		this.sid = sid;
		this.name = name;
		this.graduation = graduation;
		Email = email;
		Degree = degree;
	}
	
	public int getSid() {
		return sid;
	}
	
	public void setSid(int sid) {
		this.sid = sid;
	}
	
	public int getGraduation() {
		return graduation;
	}
	
	public void setGraduation(int graduation) {
		this.graduation = graduation;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public String getEmail() {
		return Email;
	}
	
	public void setEmail(String email) {
		Email = email;
	}
	
	public String getDegree() {
		return Degree;
	}
	
	public void setDegree(String degree) {
		Degree = degree;
	}
}