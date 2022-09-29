package com.simplilearn.portal;

public class Teacher {
 
	private int id;
	private String fname;
	private String lname;
	private String qualification;
	
	public Teacher(int id, String fname, String lname, String qualification) {
		super();
		this.id = id;
		this.fname = fname;
		this.lname = lname;
		this.qualification = qualification;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getFname() {
		return fname;
	}

	public void setFname(String fname) {
		this.fname = fname;
	}

	public String getLname() {
		return lname;
	}

	public void setLname(String lname) {
		this.lname = lname;
	}

	public String getQualification() {
		return qualification;
	}

	public void setQualification(String qualification) {
		this.qualification = qualification;
	}

	@Override
	public String toString() {
		return "Teacher [id=" + id + ", fname=" + fname + ", lname=" + lname + ", qualification=" + qualification + "]";
	}
	
	

}
