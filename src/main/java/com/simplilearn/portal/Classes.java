package com.simplilearn.portal;

public class Classes {
	
	private int id;
	private int cname;
	private String teacher;
	private String subject;
	
	public Classes(int id, int cname, String teacher, String subject) {
		super();
		this.id = id;
		this.cname = cname;
		this.teacher = teacher;
		this.subject = subject;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getCname() {
		return cname;
	}

	public void setCname(int cname) {
		this.cname = cname;
	}

	public String getTeacher() {
		return teacher;
	}

	public void setTeacher(String teacher) {
		this.teacher = teacher;
	}

	public String getSubject() {
		return subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}

	@Override
	public String toString() {
		return "Classes [id=" + id + ", cname=" + cname + ", teacher=" + teacher + ", subject=" + subject + "]";
	}
	
	
}
