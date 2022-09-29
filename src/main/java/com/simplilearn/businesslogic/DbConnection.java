package com.simplilearn.businesslogic;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;


import com.simplilearn.portal.Classes;
import com.simplilearn.portal.Students;
import com.simplilearn.portal.Subject;
import com.simplilearn.portal.Teacher;

public class DbConnection {

	

	private DataSource dataSource;

	public DbConnection(DataSource dataSource) {
		this.dataSource = dataSource;
	}

	public List<Students> getStudents() {

		List<Students> students = new ArrayList<>();

		Connection con=null;
		Statement stmt = null;
		ResultSet rs = null;

		try {

			// get a connection
			con	=dataSource.getConnection();
			
			// create sql stmt
			String sql = "SELECT * FROM students";
			stmt = con.createStatement();

			// execute query
			rs = stmt.executeQuery(sql);

			// process result
			while (rs.next()) {

				// retrieve data from result set row
				int id = rs.getInt("id");
				String firstName = rs.getString("fname");
				String lastName =rs.getString("lname");
				int age = rs.getInt("age");
				int aclass = rs.getInt("class");

				// create new student object
				Students tempStudent = new Students(id, firstName, lastName, age, aclass);

				// add it to the list of students
				students.add(tempStudent);

			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			// close JDBC objects
			close(con,stmt,rs);
		}
		return students;

	}

	public List<Teacher> getTeachers() {

		List<Teacher> teachers = new ArrayList<>();

		Connection con=null;
		Statement stmt = null;
		ResultSet rs = null;
		try {

			// get a connection
			con	=dataSource.getConnection();
			
			// create sql stmt
			String sql = "SELECT * FROM teachers";
			stmt = con.createStatement();
			// execute query
			rs = stmt.executeQuery(sql);

			// process result
			while (rs.next()) {

				// retrieve data from result set row
				int id = rs.getInt("id");
				String firstName = rs.getString("fname");
				String lastName = rs.getString("lname");
				String qualification = rs.getString("qualification");

				// create new student object
				Teacher temp = new Teacher(id, firstName, lastName, qualification);

				// add it to the list of students
				teachers.add(temp);

			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			// close JDBC objects
			close(con,stmt,rs);
		}
		return teachers;

	}

	public List<Subject> getSubjects() {

		List<Subject> subjects = new ArrayList<>();

		Connection con=null;
		Statement stmt = null;
		ResultSet rs = null;
		try {

			// get a connection
			con	=dataSource.getConnection();
			

			// create sql stmt
			String sql = "SELECT * FROM subjects";
			stmt = con.createStatement();

			// execute query
			rs = stmt.executeQuery(sql);

			// process result
			while (rs.next()) {

				// retrieve data from result set row
				int id = rs.getInt("id");
				String name =rs.getString("sname");
				

				// create new student object
				Subject temp = new Subject(id, name);

				// add it to the list of students
				subjects.add(temp);

			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			// close JDBC objects
			close(con,stmt,rs);
		}
		return subjects;

	}

	public List<Classes> getClasses() {

		List<Classes> classes = new ArrayList<>();

		Connection con=null;
		Statement stmt = null;
		ResultSet rs = null;

		try {

			// get a connection
			con	=dataSource.getConnection();
			

			// create sql stmt
			String sql = "SELECT * FROM classes";
			stmt = con.createStatement();

			// execute query
			rs = stmt.executeQuery(sql);

			// process result
			while (rs.next()) {

				// retrieve data from result set row
				int id = rs.getInt("id");
				int cname = rs.getInt("cname");
				int subject = rs.getInt("subject");
				int teacher = rs.getInt("teacher");
				

				Teacher tempTeacher = loadTeacher(teacher);
				Subject tempSubject = loadSubject(subject);

				String teacher_name = tempTeacher.getFname() + " " + tempTeacher.getLname();
				String subject_name = tempSubject.getSname() ;

				// create new student object
				Classes temp = new Classes(id, cname, teacher_name, subject_name);

				// add it to the list of students
				classes.add(temp);

			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			// close JDBC objects
			close(con,stmt,rs);
		}
		return classes;

	}

	public Teacher loadTeacher(int teacherId) {

		Teacher theTeacher = null;

		Connection con=null;
		Statement stmt = null;
		ResultSet rs = null;

		try {

			// get a connection
			con	=dataSource.getConnection();
			

			// create sql stmt
			String sql = "SELECT * FROM teachers WHERE id = " + teacherId;
			stmt = con.createStatement();

			// execute query
			rs = stmt.executeQuery(sql);

			// process result
			while (rs.next()) {

				// retrieve data from result set row
				int id = rs.getInt("id");
				String fname = rs.getString("fname");
				String lname = rs.getString("lname");
				String qualification = rs.getString("qualification");
				theTeacher = new Teacher(id, fname, lname, qualification);

			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			// close JDBC objects
			close(con,stmt,rs);
		}
		return theTeacher;

	}

	
	public Subject loadSubject(int subjectId) {

		Subject theSubject = null;

		Connection con=null;
		Statement stmt = null;
		ResultSet rs = null;

		try {

			// get a connection
			con	=dataSource.getConnection();
			

			// create sql stmt
			String sql = "SELECT * FROM subjects WHERE id = " + subjectId;
			stmt = con.createStatement();
			// execute query
			rs = stmt.executeQuery(sql);

			// process result
			while (rs.next()) {

				// retrieve data from result set row
				int id =rs.getInt("id");
				String sname = rs.getString("sname");
				
				theSubject = new Subject(id, sname);

			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			// close JDBC objects
			close(con,stmt,rs);
		}
		return theSubject;

	}

	public Classes loadClass(int classId) {

		Classes theClass = null;

		Connection con=null;
		Statement stmt = null;
		ResultSet rs = null;

		try {

			// get a connection
			con	=dataSource.getConnection();
			

			// create sql stmt
			String sql = "SELECT * FROM clasess WHERE id = " + classId;
			stmt = con.createStatement();

			// execute query
			rs = stmt.executeQuery(sql);

			// process result
			while (rs.next()) {

				// retrieve data from result set row
				int id = rs.getInt("id");
				int cname = rs.getInt("cname");
				int subject = rs.getInt("subject");
				int teacher = rs.getInt("teacher");
				

				Teacher tempTeacher = loadTeacher(teacher);
				Subject tempSubject = loadSubject(subject);

				String teacher_name = tempTeacher.getFname() + " " + tempTeacher.getLname();
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			// close JDBC objects
			close(con,stmt,rs);
		}
		return theClass;

	}

	public List<Students> loadClassStudents(int classId) {

		List<Students> students = new ArrayList<>();

		Connection con=null;
		Statement stmt = null;
		ResultSet rs = null;
		try {

			// get a connection
			con	=dataSource.getConnection();
			

			// create sql stmt
			String sql = "SELECT * FROM students WHERE class = " + classId;
			stmt = con.createStatement();
			// execute query
			rs = stmt.executeQuery(sql);

			// process result
			while (rs.next()) {

				// retrieve data from result set row
				int id = rs.getInt("id");
				String firstName = rs.getString("fname");
				String lastName = rs.getString("lname");
				int age = rs.getInt("age");
				int aclass = rs.getInt("class");

				// create new student object
				Students tempStudent = new Students(id, firstName, lastName, age, aclass);
				students.add(tempStudent);

			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			// close JDBC objects
			close(con,stmt,rs);
		}
		return students;

	}

	private void close(Connection con, Statement stmt, ResultSet rs) {

		try {
			if (rs != null) {
				rs.close();
			}
			if (stmt != null) {
				stmt.close();
			}
			if (con != null) {
				con.close();
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	
}
