package com.jdbcproj;

public class Mca {

	private int rollno;
	private String name;
	private String city;
	private String subject;
	private long phone;
	public void setRollno(int rollno) {
		this.rollno = rollno;
	}
	public int getRollno() {
		return this.rollno;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getSubject() {
		return subject;
	}
	public void setSubject(String subject) {
		this.subject = subject;
	}
	public long getPhone() {
		return phone;
	}
	public void setPhone(long phone) {
		this.phone = phone;
	}
	@Override
	public String toString() {
		return "Mca [rollno=" + rollno + ", name=" + name + ", city=" + city + ", subject=" + subject + ", phone="
				+ phone + "]";
	}
	
}
