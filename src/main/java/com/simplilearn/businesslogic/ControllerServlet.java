package com.simplilearn.businesslogic;

import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.ServletException;
import java.io.IOException;
import java.util.List;

import javax.sql.DataSource;

import com.simplilearn.portal.Classes;
import com.simplilearn.portal.Students;
import com.simplilearn.portal.Subject;
import com.simplilearn.portal.Teacher;

import jakarta.annotation.Resource;
import jakarta.servlet.RequestDispatcher;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;


/**
 * Servlet implementation class ControllerServlet
 */
@WebServlet("/ControllerServlet")
public class ControllerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    


	private DbConnection dbConnection;
	
	@Resource(name = "jdbc_database")
	private DataSource datasource;

	@Override
	public void init() throws ServletException {

		super.init();

		// create instance of db util, to pass in conn pool object
		try {
			dbConnection = new DbConnection(datasource);

		} catch (Exception e) {
			throw new ServletException(e);
		}

	}
	

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ControllerServlet() {
		super();
		
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		doGet(req, resp);
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		try {

			// read the "command" parameter
			String command = request.getParameter("command");

			if (command == null) {
				command = "CLASSES";
			}
			
			// if no cookeies
			if (!getCookies(request, response) && (!command.equals("LOGIN"))) {

				response.sendRedirect("/Administrative-Portal/login.jsp");
			}

			else {

				// if there is no command, how to handle

				// route the data to the appropriate method
				switch (command) {

				case "STUDENTS":
					studentsList(request, response);
					break;

				case "TEACHERS":
					teachersList(request, response);
					break;

				case "SUBJECTS":
					subjectList(request, response);
					break;

				case "CLASSES":
					classestList(request, response);
					break;

				case "ST_LIST":
					classStudentsList(request, response);
					break;

				case "LOGIN":
					login(request, response);
					break;

				default:
					classestList(request, response);

				}
			}
		} catch (Exception e) {
			e.printStackTrace();
			throw new ServletException(e);
		}
		// response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	private void studentsList(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// get students from db util
		List<Students> students = dbConnection.getStudents();

		// add students to the request
		request.setAttribute("STUDENT_LIST", students);

		// send it to the jsp view page
		RequestDispatcher dispatcher = request.getRequestDispatcher("/list-students.jsp");
		dispatcher.forward(request, response);

	}

	private void teachersList(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// get students from db util
		List<Teacher> teachers = dbConnection.getTeachers();

		// add students to the request
		request.setAttribute("TEACHERS_LIST", teachers);

		// send it to the jSP view page
		RequestDispatcher dispatcher = request.getRequestDispatcher("/teachers-list.jsp");
		dispatcher.forward(request, response);

	}

	private void subjectList(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// get subjects from db util
		List<Subject> subjects = dbConnection.getSubjects();

		// add subjects to the request
		request.setAttribute("SUBJECTS_LIST", subjects);

		// send it to the jSP view page
		RequestDispatcher dispatcher = request.getRequestDispatcher("/subjects-list.jsp");
		dispatcher.forward(request, response);

	}

	private void classestList(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// get subjects from db util
		List<Classes> classes = dbConnection.getClasses();

		// add subjects to the request
		request.setAttribute("CLASSES_LIST", classes);

		// send it to the jSP view page
		RequestDispatcher dispatcher = request.getRequestDispatcher("/classes-list.jsp");
		dispatcher.forward(request, response);

	}

	private void login(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String username = request.getParameter("username");
		String password = request.getParameter("password");

		if (username.toLowerCase().equals("admin") && password.toLowerCase().equals("admin")) {

			Cookie cookie = new Cookie(username, password);

			// Setting the maximum age to 1 day
			cookie.setMaxAge(86400); // 86400 seconds in a day

			// Send the cookie to the client
			response.addCookie(cookie);
			classestList(request, response);
		} else {
			RequestDispatcher dispatcher = request.getRequestDispatcher("/login.jsp");
			dispatcher.forward(request, response);
		}

	}

	private void classStudentsList(HttpServletRequest request, HttpServletResponse response) throws Exception {

		int classId = Integer.parseInt(request.getParameter("classId"));
		String cname = request.getParameter("cname");
		String subject = request.getParameter("subject");

		// get subjects from db util
		List<Students> students = dbConnection.loadClassStudents(classId);

		// add subjects to the request
		request.setAttribute("STUDENTS_LIST", students);
		request.setAttribute("CNAME", cname);
		request.setAttribute("SUBJECT", subject);

		// send it to the jSP view page
		RequestDispatcher dispatcher = request.getRequestDispatcher("/class-students.jsp");
		dispatcher.forward(request, response);

	}

	private boolean getCookies(HttpServletRequest request, HttpServletResponse response) throws Exception {

		boolean check = false;
		Cookie[] cookies = request.getCookies();
		// Find the cookie of interest in arrays of cookies
		for (Cookie cookie : cookies) {
			 
			if (cookie.getName().equals("admin") && cookie.getValue().equals("admin")) {
				check = true;
				break;
			} 

		}
		
		
		return check;

	}

}
